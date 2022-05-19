import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
    private boolean CmdValid = false;
    protected static String currentuser = "";

    public void runProgram() throws FileNotFoundException, InterruptedException {
        DataStorage a = new DataStorage();
        a.ReadUserData();
        boolean login = false; //user havent login yet
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Hello!
                Welcome to our Bug Tracking System !
                Kindly login to use our System !        
                     """);
        while (CmdValid == false) {
            String answer="";
            String useryesno="";

            do{
                System.out.println("Are you a new user (yes/no) : ");
                answer = sc.nextLine();
                boolean run=false;

                do{
                    System.out.println("x to continue, b to go back");
                    useryesno = sc.nextLine();
                    if( ! useryesno.equalsIgnoreCase("x") && ! useryesno.equalsIgnoreCase("b")){
                        run=true;
                    }
                    else{
                        run=false;
                    }
                }while(run==true);

            }while(useryesno.equalsIgnoreCase("b"));

            if (answer.equalsIgnoreCase("yes")) {
                CmdValid = true;
                a.register();
            } else if (answer.equalsIgnoreCase("no")) {
                CmdValid = true;
            } else {
                CmdValid = false;
                System.err.println("Invalid input ! ");
            }
        }
        while (login == false) {   //if the user didnt login successfully keep looping
            Scanner s = new Scanner(System.in);
            System.out.println("Enter Your Username : ");
            String username = s.nextLine();
            System.out.println("Enter Your password : ");
            String password = s.nextLine();
            if (a.UserExist(username, password) == true) {
                System.out.println("Login SuccessFully !");
                currentuser = username;
                login = true;   //login successfully
            }
            if (a.UserExist(username, password) == false) {
                System.out.println("Incorrect username or password ! ");
                login = false; //login fail
            }
            if (login == true) {
                a.ProjectDashboardJson();
            }
        }
    }

    Clip clip;
    public void playMusic(String musicLocation) {

        try {
            File musicPath = new File(musicLocation);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                System.out.println("Can't find file");
            }
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException ex) {
            ex.printStackTrace();
        }
    }

    public void close() {
        clip.close();
    }
}
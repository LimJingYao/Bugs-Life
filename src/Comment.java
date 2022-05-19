import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class Comment {
    static int number=1;
    protected int ID;
    protected String text, comment_user;
    protected String timestamp;
    protected ArrayList<Reaction> reaction;

    public Comment(int ID,  String comment_user, String text, Reaction reaction) {
        this.ID = number;
        this.text = text;
        this.comment_user = comment_user;
        this.reaction.add(reaction);
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        this.timestamp=(myDateObj.format(myFormatObj));
        number++;
    }

    public boolean addReaction;


}

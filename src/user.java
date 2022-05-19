public class user {
    static int number=1;
    int userid;
    String username;
    String password;

    public user(String username, String password) {
        this.userid=number;
        this.username = username;
        this.password = password;
        number++;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "user{" +
                "userid: " + userid +
                ", username: " + username + '\'' +
                ", password: " + password + '\'' +
                '}';
    }
}

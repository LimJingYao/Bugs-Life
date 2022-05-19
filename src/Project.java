import java.util.ArrayList;

public class Project {
    static int number = 0;
    int id;
    String project_name;
    ArrayList<Issues> issuesarr;

    public Project(String project_name) {
        this.id = number;
        this.project_name = project_name;
        this.issuesarr = null;
        number++;
    }

    public int getId() {
        return id;
    }

    public void setId(String id) {
        this.id = number;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public ArrayList<Issues> getIssuesarr() {
        return issuesarr;
    }

    public void setIssuesarr(ArrayList<Issues> issuesarr) {
        this.issuesarr = issuesarr;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "id='" + id + '\'' +
                ", project_name='" + project_name + '\'' +
                ", issuesarr=" + issuesarr +
                '}';
    }
}

import java.util.ArrayList;

public class ForumPost {

    String author;
    String text;
    int upVotes;
    ArrayList<String> replies = new ArrayList<>();

    public ForumPost(String author, String text, int upVotes) {
        this.author = author;
        this.text = text;
        this.upVotes = upVotes;
    }

    public ForumPost(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public String format() {
        if(replies.size()==0){
            return String.format("%s / by %s, %d votes. %n", text, author, upVotes );
        }
        else {

            return String.format("%s / by %s, %d votes. %n", text, author, upVotes) +
                    String.join("\n", replies) + "\n";
        }
    }
}



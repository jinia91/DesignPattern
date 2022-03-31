package decorator.ver2;

public class CommentLowerCaseService extends CommentService {

    public void doService(String comment){
        System.out.println("comment = " + comment.toLowerCase());
    }
}

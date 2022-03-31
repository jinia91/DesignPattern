package decorator.ver2;

public class CommentEditStarService extends CommentService {

    public void doService(String comment){
        System.out.println("comment = " + comment + "******");
    }
}

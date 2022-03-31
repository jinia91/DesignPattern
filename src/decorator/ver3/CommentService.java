package decorator.ver3;

public class CommentService implements CommentUseCase {

    @Override
    public void doService(String comment){
        System.out.println("comment = " + comment);
    }
}

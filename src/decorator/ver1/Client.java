package decorator.ver1;

public class Client {

    public static void main(String[] args) {
        CommentController commentController = new CommentController(new CommentService());
        commentController.doComment("HELLO WOLRD");
    }
}

package decorator.ver3;

public class Client {
    public static void main(String[] args) {

        boolean youWantLowerCase = true;
        boolean youWantEditStar = true;

        CommentUseCase commentService = new CommentService();
        if(youWantLowerCase) {
            commentService = new CommentLowerCaseDecorator(commentService);
        }
        if (youWantEditStar) {
            commentService = new CommentEditStarDecorator(commentService);
        }

        commentService.doService("HELLO WORLD");

    }
}

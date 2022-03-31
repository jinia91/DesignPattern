package decorator.ver3;

public class CommentLowerCaseDecorator extends CommentDecorator {

    public CommentLowerCaseDecorator(CommentUseCase commentUseCase) {
        super(commentUseCase);
    }

    @Override
    public void doService(String comment) {
        comment = comment.toLowerCase();
        super.doService(comment);
    }
}

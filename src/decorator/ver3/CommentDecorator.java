package decorator.ver3;

public abstract class CommentDecorator implements CommentUseCase{
    private CommentUseCase commentUseCase;

    public CommentDecorator(CommentUseCase commentUseCase) {
        this.commentUseCase = commentUseCase;
    }

    @Override
    public void doService(String comment) {
        commentUseCase.doService(comment);
    }
}

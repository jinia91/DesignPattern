package decorator.ver3;

public class CommentEditStarDecorator extends CommentDecorator {

    public CommentEditStarDecorator(CommentUseCase commentUseCase) {
        super(commentUseCase);
    }

    @Override
    public void doService(String comment) {
        comment = comment + "***";
        super.doService(comment);
    }
}

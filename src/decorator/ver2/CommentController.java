package decorator.ver2;

public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    public void doComment(String comment){
        commentService.doService(comment);
    }
}

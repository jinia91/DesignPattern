package decorator.ver2;

import java.util.Locale;

public class CommentComplexService extends CommentService{
    @Override
    public void doService(String comment) {
        comment = comment.toLowerCase() + "***";
        super.doService(comment);
    }
}

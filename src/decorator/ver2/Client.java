package decorator.ver2;

public class Client {
    public static void main(String[] args) {
        CommentController commentController = new CommentController(new CommentLowerCaseService());
        commentController.doComment("HELLO WORLD");

        CommentController commentController2 = new CommentController(new CommentEditStarService());
        commentController2.doComment("HELLO WORLD");

        // 만약 두가지 기능을 다 섞고 싶거나, 동적으로 두가지 기능중 하나를 선택하는등 유연하게 변경하고싶다면 ? 상속받은 새로운 객체 만들기
        CommentController commentController3 = new CommentController(new CommentComplexService());
        commentController3.doComment("HELLO WORLD");
    }
}

package builder;

public class Client {

    public static void main(String[] args) {

        //  private으로 막아놓았으므로 생성 불가
        //        Article article = new Article();

        Article article = Article
                .builder()
                .id(1L)
                .content("빌더패턴")
                .hit(1L)
                .title("빌더패턴")
                .build();
    }
}
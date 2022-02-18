package builder.withdirector;

public class Client {

    // 생성 프로세스가 반복적인경우 director를 통해 과정을 캡슐화하여 생성도 가능
    public static void main(String[] args) {
        ArticleDirector articleDirector = new ArticleDirector(new DefaultArticleBuilder());
        Article article = articleDirector.sampleArticle();
    }
}

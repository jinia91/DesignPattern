package builder.withdirector;

public class ArticleDirector {

    private ArticleBuilder articleBuilder;

    public ArticleDirector(ArticleBuilder articleBuilder) {
        this.articleBuilder = articleBuilder;
    }

    public Article sampleArticle() {
        return  articleBuilder
                        .id(1L)
                        .content("빌더패턴")
                        .hit(1L)
                        .title("빌더패턴제목")
                        .build();
    }
}

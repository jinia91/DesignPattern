package builder.withdirector;

public class DefaultArticleBuilder implements ArticleBuilder {

    private Long id;
    private String title;
    private String content;
    private Long hit;

    public ArticleBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public ArticleBuilder title(String title) {
        this.title = title;
        return this;
    }

    public ArticleBuilder content(String content) {
        this.content = content;
        return this;
    }

    public ArticleBuilder hit(Long hit) {
        this.hit = hit;
        return this;
    }

    public Article build(){
        return new Article(id,title, content, hit);
    }
}

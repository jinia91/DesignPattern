package builder.withdirector;

public interface ArticleBuilder {

    ArticleBuilder id(Long id);

    ArticleBuilder title(String title);

    ArticleBuilder content(String content);

    ArticleBuilder hit(Long hit);

    Article build();
}

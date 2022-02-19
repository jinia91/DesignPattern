package builder;

public class Article {

    private Long id;
    private String title;
    private String content;
    private Long hit;

    private Article() {
    }

    private Article(Long id, String title, String content, Long hit) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.hit = hit;
    }

    public static ArticleBuilder builder() {
        return new ArticleBuilder();
    }

    public static class ArticleBuilder {
        private Long id;
        private String title;
        private String content;
        private Long hit;

        private ArticleBuilder() {
        }

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
}

package chain_of_responsibility.ver_2;

public class Client {
    public static void main(String[] args) {
        // build App
        StartFilter filterChain = new StartFilter(new LogFilter(new AuthFilter(null)));
        ArticleController controller = new ArticleController();

        // set Request
        ArticlePostRequest request = new ArticlePostRequest(1L, "access", "title", "content");

        // do
        filterChain.filtering(request);
        controller.postArticle(request);
    }
}

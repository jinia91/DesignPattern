package chain_of_responsibility.ver_1;

public class Client {
    public static void main(String[] args) {
        // build App
        LogFilter logFilter = new LogFilter();
        AuthFilter authFilter = new AuthFilter();
        ArticleController controller = new ArticleController();

        // set Request
        ArticlePostRequest request = new ArticlePostRequest(1L, "access", "title", "content");

        // do
        authFilter.filtering(request);
        logFilter.filtering(request);
        controller.postArticle(request);
    }
}

package chain_of_responsibility.ver_0;

public class Client {
    public static void main(String[] args) {
        ArticleController controller = new ArticleController();
        ArticlePostRequest request = new ArticlePostRequest(1L, "access", "title", "content");
        if(request.getAccessToken() == null){
            throw new IllegalArgumentException("인증 통과 실패");
        }
        System.out.println("request.getMemberId() = " + request.getMemberId());
        System.out.println("request.getTitle() = " + request.getTitle());
        System.out.println("request.getContent() = " + request.getContent());
        controller.postArticle(request);
    }
}

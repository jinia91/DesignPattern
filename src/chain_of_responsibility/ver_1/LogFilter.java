package chain_of_responsibility.ver_1;

public class LogFilter {

    public void filtering(ArticlePostRequest request){
        System.out.println("request.getMemberId() = " + request.getMemberId());
        System.out.println("request.getTitle() = " + request.getTitle());
        System.out.println("request.getContent() = " + request.getContent());
    }
}

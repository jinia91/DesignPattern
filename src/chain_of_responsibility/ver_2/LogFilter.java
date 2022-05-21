package chain_of_responsibility.ver_2;

public class LogFilter extends Filter {

    public LogFilter(Filter nextFilter) {
        super(nextFilter);
    }

    @Override
    public void filtering(ArticlePostRequest request){
        System.out.println("request.getMemberId() = " + request.getMemberId());
        System.out.println("request.getTitle() = " + request.getTitle());
        System.out.println("request.getContent() = " + request.getContent());
        super.filtering(request);
    }
}

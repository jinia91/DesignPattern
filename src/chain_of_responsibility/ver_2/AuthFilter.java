package chain_of_responsibility.ver_2;

public class AuthFilter extends Filter {

    public AuthFilter(Filter nextFilter) {
        super(nextFilter);
    }

    @Override
    public void filtering(ArticlePostRequest request){
        if(request.getAccessToken() == null){
            throw new IllegalArgumentException("인증 통과 실패");
        }
        System.out.println("검증 통과");
        super.filtering(request);
    }
}

package chain_of_responsibility.ver_1;

public class AuthFilter {

    public void filtering(ArticlePostRequest request){
        if(request.getAccessToken() == null){
            throw new IllegalArgumentException("인증 통과 실패");
        }
    }
}

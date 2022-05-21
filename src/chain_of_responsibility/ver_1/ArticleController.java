package chain_of_responsibility.ver_1;

public class ArticleController {
    public ArticleController() {
    }

    public void postArticle(ArticlePostRequest request){
        System.out.println(request.getTitle() + "글을 업로드했습니다.");
    }
}

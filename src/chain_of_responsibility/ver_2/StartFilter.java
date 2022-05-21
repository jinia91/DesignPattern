package chain_of_responsibility.ver_2;

public class StartFilter extends Filter {

    public StartFilter(Filter nextFilter) {
        super(nextFilter);
    }

    @Override
    public void filtering(ArticlePostRequest request){
         super.filtering(request);
    }
}

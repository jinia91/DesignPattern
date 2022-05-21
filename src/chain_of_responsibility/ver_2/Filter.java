package chain_of_responsibility.ver_2;

public abstract class Filter {

    private Filter nextFilter;

    public Filter(Filter nextFilter) {
        this.nextFilter = nextFilter;
    }

    void filtering(ArticlePostRequest request){
        if (nextFilter != null){
            nextFilter.filtering(request);
        }
    }

}


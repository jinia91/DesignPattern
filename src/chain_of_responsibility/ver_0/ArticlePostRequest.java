package chain_of_responsibility.ver_0;

public class ArticlePostRequest {
    private final Long memberId;
    private final String accessToken;
    private final String title;
    private final String content;

    public ArticlePostRequest(Long memberId, String accessToken, String title, String content) {
        this.memberId = memberId;
        this.accessToken = accessToken;
        this.title = title;
        this.content = content;
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}

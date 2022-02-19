package prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Article implements Cloneable {

    private Long id;
    private String title;
    private String content;
    private Long hit;
    private List<String> list = new ArrayList<>();

    public Article() {
    }

    public Article(Long id, String title, String content, Long hit, List<String> list) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.hit = hit;
        this.list = list;
    }

    @Override
    public Article clone() {
        try {
            Article clone = (Article) super.clone();
            ArrayList<String> cloneList = new ArrayList<>(this.list);
            clone.list = cloneList;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Article)) {
            return false;
        }

        Article article = (Article) obj;
        // equals 처리시 null예외를 피하기 위한 유틸메서드 Objects.equals 사용
        return Objects.equals(this.id,article.id)
                && Objects.equals(this.title,article.title)
                && Objects.equals(this.content,article.content)
                && Objects.equals(this.hit,article.hit)
                && this.list.equals(article.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,title, content,hit,list);
    }
}

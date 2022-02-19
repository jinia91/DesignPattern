package prototype;

public class Client {

    public static void main(String[] args){
        Article article = new Article();
        Article clone = article.clone();

        System.out.println(article.equals(clone));
        System.out.println(article.hashCode() == clone.hashCode());
        System.out.println(article==clone);
    }
}

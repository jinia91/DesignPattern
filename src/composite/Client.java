package composite;

public class Client {

    public static void main(String[] args) {
        Document document = buildDocu();
        document.delete();
    }

    private static Document buildDocu() {

        Folder root = new Folder();
        Folder subNode1 = new Folder();
        Folder subNode2 = new Folder();
        root.addContents(subNode1);
        root.addContents(subNode2);
        subNode1.addContents(new File("컨텐츠1"));
        subNode1.addContents(new File("컨텐츠2"));
        subNode1.addContents(new File("컨텐츠3"));
        subNode2.addContents(new File("컨텐츠4"));

        Folder subNode3 = new Folder();
        subNode2.addContents(subNode3);
        subNode3.addContents(new File("컨텐츠5"));

        return root;
    }
}

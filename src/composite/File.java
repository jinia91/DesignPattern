package composite;

public class File implements Document {
    private String contents;

    public File(String contents) {
        this.contents = contents;
    }

    @Override
    public void delete() {
        System.out.println("delete contents : " + contents);
    }
}

package composite;

import java.util.ArrayList;
import java.util.List;

public class Folder implements Document {

    private List<Document> contents = new ArrayList<>();

    @Override
    public void delete() {
        for (Document content : contents) {
            content.delete();
        }
    }

    public void addContents(Document content){
        contents.add(content);
    }
}

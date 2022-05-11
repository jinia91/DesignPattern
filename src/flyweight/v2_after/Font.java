package flyweight.v2_after;

public class Font {
    private final String font;
    private final Integer size;

    public Font(String font, Integer size) {
        this.font = font;
        this.size = size;
    }

    public String getFont() {
        return font;
    }

    public Integer getSize() {
        return size;
    }
}

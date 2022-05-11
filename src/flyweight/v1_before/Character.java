package flyweight.v1_before;

public class Character {
    private final char value;
    private final String color;
    private final String font;
    private final Integer fontSize;

    public Character(char value, String color, String font, Integer fontSize) {
        this.value = value;
        this.color = color;
        this.font = font;
        this.fontSize = fontSize;
    }
}

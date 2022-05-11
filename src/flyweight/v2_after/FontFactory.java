package flyweight.v2_after;

import java.util.HashMap;
import java.util.Map;

public class FontFactory {
    private final Map<String ,Font> cache;

    public FontFactory() {
        cache = new HashMap<>();
        cache.put("나눔", new Font("나눔", 10));
        cache.put("굴림", new Font("굴림", 10));
        cache.put("궁서", new Font("궁서", 10));
    }

    public Font getFont(String font){
        return cache.get(font);
    }
}

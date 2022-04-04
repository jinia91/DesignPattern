package facade.after;

public class BitrateReader {
    public static VideoFile read(VideoFile file, Codec codec){
        System.out.println("video read with codec" + codec);
        return file;
    }
    public static VideoFile convert(VideoFile file, Codec codec) {
        System.out.println("convert to Write with codec" + codec);
        return file;
    }
}

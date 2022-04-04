package facade.before;

import composite.File;

public class Client2 {

    public static void main(String[] args) {
        VideoFile newVideo = new VideoFile("new Video");
        Codec codec = CodecFactory.extract(newVideo);
        VideoFile read = BitrateReader.read(newVideo, codec);
        VideoFile convert = BitrateReader.convert(read, codec);
        new File(convert.getName() + convert.getCodecType());
    }
}

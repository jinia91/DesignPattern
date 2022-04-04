package facade.after;

import java.io.File;

public class ConverterFacade {

    public File convertVideo(String  file){
        VideoFile newVideo = new VideoFile(file);
        Codec codec = CodecFactory.extract(newVideo);
        VideoFile read = BitrateReader.read(newVideo, codec);
        VideoFile convert = BitrateReader.convert(read, codec);
        return new File(convert.getName()+convert.getCodecType());
    }
}

package facade.after;

public class CodecFactory {
    public static Codec extract(VideoFile file){
        String codecType = file.getCodecType();
        if(codecType.equals("mpeg")){
            System.out.println("mpeg video");
            return new MpegCodec();
        }
        System.out.println("ogg video");
        return new OggCodec();
    }
}

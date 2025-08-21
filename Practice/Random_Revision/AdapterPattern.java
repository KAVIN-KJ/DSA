package Random_Revision;

interface MediaPlayer {

    void play(String s);
    
}

class LegacyMediaPlayer{
    void playSong(String n){
        System.out.println("The song "+n+" is being played");
    }
}

class MediaPlayerAdapter implements MediaPlayer{
    LegacyMediaPlayer lmp;
    MediaPlayerAdapter(LegacyMediaPlayer l){
        this.lmp = l;
    }
    public void play(String s){
        lmp.playSong(s);
    }

}

public class AdapterPattern {
    public static void main(String[] args) {
        MediaPlayer mp = new MediaPlayerAdapter(new LegacyMediaPlayer());
        mp.play("Rap God");
    }
}

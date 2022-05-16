package Speak;

import static Speak.QuickstartSample.synthesizeText;

public class Converter {
    public static void tts(String str){
        //mp3 생성 기능
        try {
            synthesizeText(str);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //mp3 재생 기능
        String filename = "output.mp3";
        MyMusicPlayer playMusic = new MyMusicPlayer(filename);
		playMusic.play();
    }

    public void stt(){

    }
}

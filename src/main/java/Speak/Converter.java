package Speak;

import static Speak.QuickstartSample.synthesizeText;

public class Converter {
    public static void tts(String str) throws RuntimeException {
        //mp3 ���� ���
        try {
            synthesizeText(str);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //mp3 ��� ���
        String filename = "output.mp3";
        MyMusicPlayer playMusic = new MyMusicPlayer(filename);
		playMusic.play();
    }

    public void stt(){

    }
}

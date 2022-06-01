package GUI;

import Console.ClassControl;
import Console.Menu;
import Speak.Converter;
import Speak.QuickstartSampleSTT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Speak.Converter.tts;

public class SwingManager extends JPanel implements ActionListener {
    JFrame frame;
    ClassControl data = new ClassControl();
    Menu MenuInfo = null;
    public static Thread thread;
    final Color brown = new Color(72,50,42);
    final Color blue = new Color(58,114,138);
    final Color vanilla = new Color(224,204,204);
    private static boolean isVoice;
    private static JButton submit= new JButton();



    public void initSubmit(){
        submit.setIcon(new ImageIcon("icon.png"));
        submit.setBorderPainted(false);
        submit.setContentAreaFilled(false);
        submit.setFocusPainted(false);
        submit.setOpaque(false);

    }
    public void setSubmit(){
        submit.setBounds(150, 10, 80, 80);
        add(submit);
        submit.addActionListener(this);
    }


    public void ChangeSubmit(boolean isSpeak){
        if(isSpeak)
            submit.setIcon(new ImageIcon("icon2.png"));
        else
            submit.setIcon(new ImageIcon("icon.png"));
    }
    public SwingManager(JFrame f) {
        frame = f;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        setLayout(null);            // 배치 컨트롤 제거, 절대 위치
        setBackground(Color.white);
    }

    void changerPanel(JPanel panel) {
        frame.remove(this);
        frame.add(panel);
        frame.revalidate();
        frame.repaint();
    }

    public static boolean getIsVoice() {
        return isVoice;
    }

    public static void setIsVoice(boolean isVoice) {
        SwingManager.isVoice = isVoice;
    }

    void setMenuName(Menu menu) {
        MenuInfo = menu;
    }

    public final Color getBrown() {
        return brown;
    }

    public final Color getBlue() {
        return blue;
    }

    public final Color getVanilla() {
        return vanilla;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public int voiceRecognition(String[] kewards){
        for(int i=0;i<5;i++){
            ChangeSubmit(true);
            int k = voiceCheck(kewards);
            if(k >= 0) {
                tts(kewards[k]+"를 선택하셨습니다.");
                ChangeSubmit(false);
                return k;
            }
            else {
                ChangeSubmit(false);
                tts("다시한번 말씀해주세요.");
                try {
                    Thread.sleep(2500);
                    ChangeSubmit(true);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        //test
        return 0;
    }
    public int voiceCheck(String[] kewards){
        //String text = "확인 버튼을 누르고 메뉴 이름을 말씀해주세요";
        //tts(text);
        //JOptionPane.showMessageDialog(null, text,"Message", JOptionPane.INFORMATION_MESSAGE);
        Converter.mic_start();
        QuickstartSampleSTT stt = new QuickstartSampleSTT();
        String str = stt.getVoice();    //효과음, 임시..., 팝업창이나
        System.out.printf("인식 : %s", str);
        if (str == null) {
            return -1;
        } else {
            for (int k = 0; k < kewards.length; k++) {
                if (kewards[k].contains(str))
                    return k;      //일치하는 키워드가 있는 경우
            }
            return -2;  //일치하는 키워드가 없는 경우
        }
    }
}

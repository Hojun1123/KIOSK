package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static Console.OrderList.od;
import static Speak.Converter.tts;

public class SetOption2 extends SwingManager implements SwingManageable{
    JButton[] buttons = new JButton[3];

    public SetOption2(JFrame f) {
        super(f);
        create();
        setPos();
        addAction();

        String[] kewards = {"예","아니요","이전","샷추가"};
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        tts("샷 추가 하시겠습니까?");
        thread = new Thread(){
            public void run(){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                buttons[voiceRecognition(kewards)%3].doClick();
            }
        };
        thread.start();
    }

    @Override
    public void create() {
        createButton();
    }

    @Override
    public void setPos() {
        setButtonPos();
    }

    @Override
    public void addAction() {
        addButtonAction();
    }

    void createButton() {
        String[] text = {"예(샷 추가)","아니요","이전"};
        int[] size = {36, 36, 24};
        Color[] backGrounds = { getBrown(), getBlue(), getBrown()};
        for(int i=0; i < buttons.length; ++i){
            buttons[i] = new JButton(text[i]);
            buttons[i].setForeground(Color.white);
            buttons[i].setBackground(backGrounds[i]);
            buttons[i].setFont(new Font("맑은 고딕", Font.BOLD, size[i]));
        }
    }

    void setButtonPos() {
        for(int i=0;i <2;++i) {
            buttons[i].setBounds(40, 50+(i*200), 300, 180);
        }
        buttons[2].setBounds(40, 450, 300, 40);
    }

    void addButtonAction() {
        for(JButton b : buttons) {
            add(b);
            b.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //이전
        if (e.getSource() == buttons[0]) {
            od.getShot(true);
            changerPanel(new SetOption3(frame));
        }
        else if(e.getSource() == buttons[1]){
            od.getShot(false);
            changerPanel(new SetOption3(frame));
        }
        else{
            changerPanel(new SetOption(frame));
        }
    }
}

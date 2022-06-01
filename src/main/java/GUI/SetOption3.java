package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static Console.OrderList.od;
import static Speak.Converter.tts;

public class SetOption3 extends SwingManager implements SwingManageable{
    JButton[] buttons = new JButton[3];


    public SetOption3(JFrame f) {
        super(f);
        create();
        setPos();

            addAction();

        if(getIsVoice()) {
            setSubmit();
            makeSubmit();
        }
    }
    @Override
    public void makeSubmit () {
        String[] kewards = {"예", "아니요", "이전", "시럽추가"};
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        tts("시럽을 추가하시겠습니까?");
        thread = new Thread() {
            public void run() {
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
                buttons[voiceRecognition(kewards)].doClick();
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
        String[] text = {"예(시럽 추가)","아니요","이전"};
        Color[] backGrounds = { getBrown(), getBlue(), getBrown()};
        int[] size = {36, 36, 24};

        for(int i=0; i < buttons.length; ++i){
            buttons[i] = new JButton(text[i]);
            buttons[i].setForeground(Color.white);
            buttons[i].setBackground(backGrounds[i]);
            buttons[i].setFont(new Font("맑은 고딕", Font.BOLD, size[i]));
        }
    }

    void setButtonPos() {
        int[] size = {150,150,40};
        for(int i=0;i < buttons.length;++i) {
            buttons[i].setBounds(40, 100+(i*200), 300, size[i]);
        }
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
            od.getSyrup(true);
            changerPanel(new ChoiceQuantity(frame));
        }
        else if(e.getSource() == buttons[1]){
            od.getSyrup(false);
            changerPanel(new ChoiceQuantity(frame));
        }
        else{
            changerPanel(new SetOption2(frame));
        }
    }
}

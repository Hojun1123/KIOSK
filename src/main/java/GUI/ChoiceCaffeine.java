package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static Console.OrderList.initializeOrder;
import static Console.OrderList.od;
import static Speak.Converter.tts;

public class ChoiceCaffeine extends SwingManager implements SwingManageable {
    JButton[] buttons = new JButton[3];


    public ChoiceCaffeine(JFrame f) {
        super(f);
        create();
        setPos();
        addAction();

        //새 스레드 생성성
       thread = new Thread(){
            public void run(){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                String[] kewards = {"커피", "논 커피", "이전"};
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
        String[] text = {"커피","논 커피", "이전"};
        String msg = "";
        int[] size = {36,36,24};
        Color[] colors = {getBrown(),getBlue(),getBrown()};
        for(int i=0;i < buttons.length;++i){
            msg += text[i]+ ", ";
            buttons[i] = new JButton(text[i]);
            buttons[i].setForeground(Color.white);
            buttons[i].setBackground(colors[i]);
            buttons[i].setFont(new Font("맑은 고딕", Font.BOLD, size[i]));
        }
        tts(msg);
    }

    void setButtonPos() {
        int[] size = {180,180,40};
        for(int i=0;i < buttons.length;++i) {
            buttons[i].setBounds(40, 50+(i*200), 300, size[i]);
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
        initializeOrder();
        if (e.getSource() == buttons[0]) {
            od.setCaffeine(true);
            changerPanel(new ChoiceMenu(frame, "coffee",0));
        } else if (e.getSource() == buttons[1]) {
            changerPanel(new ChoiceDrink(frame));
        } else {
            changerPanel(new OrderMain(frame));
        }
    }
}

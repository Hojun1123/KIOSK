package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static Console.OrderList.od;
import static Speak.Converter.tts;

public class ChoiceQuantity extends SwingManager implements SwingManageable{
    JButton[] buttons = new JButton[4];
    JLabel label;


    int quantity = 1;

    public ChoiceQuantity(JFrame f) {
        super(f);
        create();
        setPos();
        addAction();

        String[] kewards = {"한잔", "두잔", "세잔", "네잔", "다섯잔", "여섯잔", "일곱잔", "여덟잔", "아홉잔", "열잔", "이전"};
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        tts("몇잔 주문하시겠습니까?");
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
                int temp = voiceRecognition(kewards);
                if(temp >= 0 && temp < 10) {
                    quantity = temp+1;
                    buttons[2].doClick();
                }
                else if(temp == 10)
                    buttons[3].doClick();
                    //이전
            }
        };
        thread.start();
    }

    @Override
    public void create() {
        createButton();
        createLabel();
    }

    @Override
    public void setPos() {
        setButtonPos();
        setLabelPos();
    }

    @Override
    public void addAction() {
        addButtonAction();
    }

    void createButton() {
        String[] text = {"-1", "+1", "확인", "이전"};
        Color[] foreGrounds = {Color.black, Color.black, Color.white, Color.white};
        Color[] backGrounds = {getVanilla(), getVanilla(), getBrown(), getBrown()};
        for (int i = 0; i < buttons.length; ++i) {
            buttons[i] = new JButton(text[i]);
            buttons[i].setForeground(foreGrounds[i]);
            buttons[i].setBackground(backGrounds[i]);

            buttons[i].setFont(new Font("맑은 고딕", Font.BOLD, 24));
        }
    }

    void setButtonPos() {
        for(int i=0;i<2;++i){
            buttons[i].setBounds(40 + (i*220),100,80,80);
        }
        for(int i=2;i<4;++i){
            buttons[i].setBounds(40,350 + (i-2)*100,300,80);
        }
    }

    void addButtonAction() {
        add(label);
        for(JButton b : buttons) {
            add(b);
            b.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //-1
        if (e.getSource() == buttons[0] && quantity>1) {
            quantity -= 1;
            updateLabelValue();
        }
        //+1
        else if(e.getSource() == buttons[1] && quantity<10){
            quantity += 1;
            updateLabelValue();
        }
        //확인
        else if(e.getSource() == buttons[2]){
            //quantity값도 넘겨줘야함
            od.getQuantity(quantity);
            changerPanel(new OrderConfirm(frame));
        }
        //이전
        else if(e.getSource() == buttons[3]){
            if(!od.isCaffeine()){
                changerPanel(new SetOption(frame));
            }
            else{
                changerPanel(new SetOption3(frame));
            }
        }
    }

    void createLabel() {
        String text = quantity+"개";
        label = new JLabel(text, JLabel.CENTER);
        label.setBackground(getBrown());
        label.setForeground(Color.white);
        label.setFont(new Font("맑은 고딕", Font.BOLD, 36));
        label.setOpaque(true);
    }
    void setLabelPos() {
        label.setBounds(140,100,100,100);
    }
    void updateLabelValue(){
        label.setText(quantity+"개");
    }
}

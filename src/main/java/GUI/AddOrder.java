package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AddOrder extends SwingManager implements SwingManageable {
    String menuCode;
    JButton[] buttons = new JButton[2];
    JLabel label;
    Color c = new Color(72, 50, 42);
    public AddOrder(JFrame f) {
        super(f);
        create();
        setPos();
        addAction();
    }
    @Override
    public void makeSubmit() {

    }
    @Override
    public void create() {
        createButton();
        createLabel();
    }
    @Override
    public void setPos() {
        setButtonPos();
        setLabel();
    }
    @Override
    public void addAction() {
        addButtonAction();
        addLabel();
    }

    void createLabel(){
        String text = "<html><center>더 주문</center>하시겠습니까?<html>";
        label = new JLabel(text, SwingConstants.CENTER);
        label.setBackground(c);
        label.setForeground(Color.white);
        label.setFont(new Font("맑은 고딕", Font.BOLD, 36));
        label.setOpaque(true);
    }
    void setLabel(){
        label.setBounds(40,150,300,200);
    }
    void addLabel(){
        add(label);
    }
    void createButton() {
        String[] text = {"예", "아니오"};
        for(int i=0; i < buttons.length; ++i){
            buttons[i] = new JButton(text[i]);
            buttons[i].setBackground(c);
            buttons[i].setForeground(Color.white);
            buttons[i].setFont(new Font("맑은 고딕", Font.BOLD, 24));
        }
    }

    void setButtonPos() {
        for (int i = 0; i < buttons.length; ++i)
            buttons[i].setBounds(40 + (i * 160), 400, 140, 40);
    }

    void addButtonAction() {
        for(JButton b : buttons) {
            add(b);
            b.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //예
        if (e.getSource() == buttons[0]) {
            //추가주문할것인지(기존 흐름) 또는 결제화면 으로 넘어갈지
            changerPanel(new ChoiceCaffeine(frame));
        }
        //아니오, 결제
        else if (e.getSource() == buttons[1]) {
            changerPanel(new Payment(frame));
        }
    }
}

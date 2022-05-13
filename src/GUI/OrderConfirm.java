package GUI;

import Console.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static Console.OrderList.od;

public class OrderConfirm extends SwingManager implements SwingManageable {
    String menuCode;
    JButton[] buttons = new JButton[3];
    JLabel label;
    Color c = new Color(53, 39, 35);
    Color c2 = new Color(245, 245, 220);
    public OrderConfirm(JFrame f) {
        super(f);
        create();
        setPos();
        addAction();
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
        String text = od.toString();
        label = new JLabel(text, SwingConstants.CENTER);
        label.setBackground(c2);
        label.setForeground(Color.black);
        label.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        label.setOpaque(true);
    }
    void setLabel(){
        label.setBounds(40,100,300,200);
    }
    void addLabel(){
        add(label);
    }
    void createButton() {
        String[] text = {"예", "아니오", "처음으로"};
        for(int i=0; i < buttons.length; ++i){
            buttons[i] = new JButton(text[i]);
            buttons[i].setBackground(c);
            buttons[i].setForeground(Color.white);
            buttons[i].setFont(new Font("맑은 고딕", Font.BOLD, 24));
        }
    }

    void setButtonPos() {
        for (int i = 0; i < 2; ++i)
            buttons[i].setBounds(10 + (i * 190), 430, 170, 50);
        buttons[2].setBounds(40, 500, 300, 50);
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
            //test
            System.out.println(od.toString());
        }
        //아니오, 뒤로가기
        else if (e.getSource() == buttons[1]) {
            changerPanel(new ChoiceQuantity(frame));
        }
        //처음으로
        else{
            changerPanel(new OrderMain(frame));
        }
    }
}

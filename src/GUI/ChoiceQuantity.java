package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static Console.OrderList.od;

public class ChoiceQuantity extends SwingManager implements SwingManageable{
    JButton[] buttons = new JButton[4];
    JLabel[] labels = new JLabel[1];
    Color c = new Color(53, 39, 35);
    Color c2 = new Color(72, 50, 42);
    Color c3 = new Color(224,204,204);
    int quantity = 1;

    public ChoiceQuantity(JFrame f) {
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
        setLabelPos();
    }

    @Override
    public void addAction() {
        addButtonAction();
    }

    void createButton() {
        String[] text = {"-1","+1","확인","이전"};
        for(int i=0; i < buttons.length; ++i){
            buttons[i] = new JButton(text[i]);
            if(i<2) {
                buttons[i].setForeground(Color.black);
                buttons[i].setBackground(c3);
            }
            else {
                buttons[i].setForeground(Color.white);
                buttons[i].setBackground(c2);
            }
            buttons[i].setFont(new Font("맑은 고딕", Font.BOLD, 24));
        }
    }

    void setButtonPos() {
        buttons[0].setBounds(40,100,80,80);
        buttons[1].setBounds(260,100,80,80);
        //buttons[2].setBounds(140,100,100,100);
        buttons[2].setBounds(40,400,300,40);
        buttons[3].setBounds(40, 450, 300, 40);
    }

    void addButtonAction() {
        add(labels[0]);
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
        labels[0] = new JLabel(text, JLabel.CENTER);
        labels[0].setBackground(c2);
        labels[0].setForeground(Color.white);
        labels[0].setFont(new Font("맑은 고딕", Font.BOLD, 36));
        labels[0].setOpaque(true);
    }
    void setLabelPos() {
        labels[0].setBounds(140,100,100,100);
    }
    void updateLabelValue(){
        labels[0].setText(quantity+"개");
    }
}

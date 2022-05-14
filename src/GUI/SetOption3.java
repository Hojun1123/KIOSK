package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static Console.OrderList.od;

public class SetOption3 extends SwingManager implements SwingManageable{
    JButton[] buttons = new JButton[3];
    Color c = new Color(72, 50, 42);
    Color c2 = new Color(58, 114, 138);

    public SetOption3(JFrame f) {
        super(f);
        create();
        setPos();
        addAction();
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
        String[] text = {"시럽추가","<html>시럽추가<br/>안함</html>","이전"};
        int[] size = {36, 36, 24};
        for(int i=0; i < buttons.length; ++i){
            buttons[i] = new JButton(text[i]);
            buttons[i].setForeground(Color.white);
            buttons[i].setFont(new Font("맑은 고딕", Font.BOLD, size[i]));
        }
        buttons[0].setBackground(c);
        buttons[1].setBackground(c2);
        buttons[2].setBackground(c);
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

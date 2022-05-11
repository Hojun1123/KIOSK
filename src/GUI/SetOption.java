package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SetOption extends SwingManager implements SwingManageable{
    JButton[] buttons = new JButton[3];
    Color c = new Color(53, 39, 35);


    public SetOption(JFrame f) {
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
        String[] text = {"HOT","ICE","이전"};
        for(int i=0; i < buttons.length; ++i){
            buttons[i] = new JButton(text[i]);
            buttons[i].setBackground(c);
            buttons[i].setForeground(Color.white);
            buttons[i].setFont(new Font("맑은 고딕", Font.BOLD, 36));
        }
    }

    void setButtonPos() {
        for(int i=0;i <2;++i) {
            buttons[i].setBounds(40, 50+(i*200), 300, 180);
        }
        buttons[2].setBounds(40, 450, 300, 50);
    }

    void addButtonAction() {
        for(JButton b : buttons) {
            add(b);
            b.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //HOT , ICE , 이전
        if (e.getSource() == buttons[0]) {
            setIce(false);
            changerPanel(new SetOption2(frame));
        }
        else if(e.getSource() == buttons[1]){
            setIce(true);
            changerPanel(new SetOption2(frame));
        }
        else{
            changerPanel(new ChoiceMenu(frame, "coffee",0));
        }
    }
}

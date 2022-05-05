package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ChoiceCaffeine extends SwingManager implements SwingManageable {
    JButton[] buttons = new JButton[3];
    Color c = new Color(53, 39, 35);

    public ChoiceCaffeine(JFrame f) {
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
        String[] text = {"커피","논 커피", "이전"};
        int[] size = {36,36,24};
        for(int i=0;i < buttons.length;++i){
            buttons[i] = new JButton(text[i]);
            buttons[i].setBackground(c);
            buttons[i].setForeground(Color.white);
            buttons[i].setFont(new Font("맑은 고딕", Font.BOLD, size[i]));
        }
    }

    void setButtonPos() {
        int[] size = {180,180, 80};
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
        if (e.getSource() == buttons[0]) {
            changerPanel(new ChoiceMenu(frame, "coffee",0));
        } else if (e.getSource() == buttons[1]) {
            changerPanel(new ChoiceDrink(frame));
        } else {
            changerPanel(new OrderMain(frame));
        }
    }
}

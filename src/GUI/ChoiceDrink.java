package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ChoiceDrink extends SwingManager implements SwingManageable{
    JButton[] buttons = new JButton[3];
    Color c = new Color(53, 39, 35);

    public ChoiceDrink(JFrame f) {
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
        String[] text = {"라떼","스무디", "차"};
        int[] size = {36,36,36};
        for(int i=0;i < buttons.length;++i){
            buttons[i] = new JButton(text[i]);
            buttons[i].setBackground(c);
            buttons[i].setForeground(Color.white);
            buttons[i].setFont(new Font("맑은 고딕", Font.BOLD, size[i]));
        }
    }

    void setButtonPos() {
        int[] size = {130,130, 130};
        for(int i=0;i < buttons.length;++i) {
            buttons[i].setBounds(40, 30+(i*170), 300, size[i]);
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
            changerPanel(new ChoiceMenu(frame, "latte",0));
        } else if (e.getSource() == buttons[1]) {
            changerPanel(new ChoiceMenu(frame, "smoothie",0));
        } else {
            changerPanel(new ChoiceMenu(frame, "tea",0));
        }
    }
}

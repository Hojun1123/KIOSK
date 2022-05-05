package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SetOption extends SwingManager implements SwingManageable{
    JButton[] buttons = new JButton[2];
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
        String[] text = {"HOT","ICE"};
        int[] size = {36,36};
        for(int i=0;i < buttons.length;++i){
            buttons[i] = new JButton(text[i]);
            buttons[i].setBackground(c);
            buttons[i].setForeground(Color.white);
            buttons[i].setFont(new Font("맑은 고딕", Font.BOLD, size[i]));
        }
    }

    void setButtonPos() {
        int[] size = {180, 180};
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
            JOptionPane.showMessageDialog(null, "관리자 모드로 실행합니다",
                    "Message", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == buttons[1]) {
            JOptionPane.showMessageDialog(null, "관리자 모드로 실행합니다",
                    "Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

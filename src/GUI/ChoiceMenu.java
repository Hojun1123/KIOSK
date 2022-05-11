package GUI;

import Console.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ChoiceMenu extends SwingManager implements SwingManageable {
    JButton b = null;
    String menuCode;
    JButton[] buttons = new JButton[3];
    Color c = new Color(53, 39, 35);
    Menu m;
    int listIdx;

    public ChoiceMenu(JFrame f, String menu, int idx) {
        super(f);
        data.setMenuList(menu);
        this.menuCode = menu;
        listIdx = idx;
        m = data.getMenuList().getList(listIdx);
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

        b = new JButton(m.getName());
        b.setFont(new Font("맑은 고딕", Font.BOLD, 36));
        b.setBackground(c);
        b.setForeground(Color.white);

        String[] text = {"이전", "다음", "처음으로"};
        for (int i = 0; i < buttons.length; ++i) {
            buttons[i] = new JButton(text[i]);
            buttons[i].setFont(new Font("맑은 고딕", Font.BOLD, 24));
            buttons[i].setBackground(c);
            buttons[i].setForeground(Color.white);
        }
    }

    void setButtonPos() {

        b.setBounds(40,100,300,300);

        for (int i = 0; i < 2; ++i)
            buttons[i].setBounds(10 + (i * 190), 430, 170, 50);
        buttons[2].setBounds(40, 500, 300, 50);
    }

    void addButtonAction() {

        add(b);
        b.addActionListener(this);

        for (int i = 0; i < buttons.length; ++i) {
            if (listIdx == 0 && i == 0 ||
            listIdx == data.getMenuList().getSize()-1 && i == 1) {
            }
            else {
                add(buttons[i]);
                buttons[i].addActionListener(this);
            }
        }
        add(b);
        b.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons[0]) {
            changerPanel(new ChoiceMenu(frame, menuCode, listIdx - 1));
        } else if (e.getSource() == buttons[1]) {
                changerPanel(new ChoiceMenu(frame, menuCode, listIdx + 1));
        } else if(e.getSource() == buttons[2]){
            changerPanel(new OrderMain(frame));
        } else {
            setMenuName(m);
            JOptionPane.showMessageDialog(null, getMenuName(),
                    "Message", JOptionPane.INFORMATION_MESSAGE);
            changerPanel(new SetOption(frame));
        }
    }
}

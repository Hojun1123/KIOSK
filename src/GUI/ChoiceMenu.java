package GUI;

import Console.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ChoiceMenu extends SwingManager implements SwingManageable {
    ArrayList<JButton> menuList = new ArrayList<>();
    String menu;
    JButton[] buttons = new JButton[3];
    Color c = new Color(53, 39, 35);
    int listIdx;

    public ChoiceMenu(JFrame f, String menu, int idx) {
        super(f);
        data.setMenuList(menu);
        this.menu = menu;
        listIdx = idx;
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

        for (Menu m : data.getMenuList().getmList()) {
            String str = m.getName();
            JButton b = new JButton(str);

            b.setFont(new Font("맑은 고딕", Font.BOLD, 36));
            b.setBackground(c);
            b.setForeground(Color.white);
            menuList.add(b);
        }


        String[] text = {"이전", "다음", "처음으로"};
        for (int i = 0; i < buttons.length; ++i) {
            buttons[i] = new JButton(text[i]);
            buttons[i].setFont(new Font("맑은 고딕", Font.BOLD, 24));
            buttons[i].setBackground(c);
            buttons[i].setForeground(Color.white);
        }
    }

    void setButtonPos() {
        int cnt = 0;
        int len = Math.min(listIdx + 2, menuList.size());
        for(int i= listIdx; i<len;++i){
            menuList.get(i).setBounds(40, 50+(cnt*180), 300, 150);
            ++cnt;
        }

        for (int i = 0; i < 2; ++i)
            buttons[i].setBounds(10 + (i * 190), 430, 170, 50);
        buttons[2].setBounds(40, 500, 300, 50);
    }

    void addButtonAction() {
        int len = Math.min(listIdx + 2, menuList.size());
        for (int i = listIdx; i < len; ++i) {
            add(menuList.get(i));
        }

        for(int i=0;i<buttons.length;++i) {
            if (listIdx == 0 && i == 0) {
            }
            else if (listIdx + 2 >= menuList.size() && i == 1) {
            }
            else {
                add(buttons[i]);
                buttons[i].addActionListener(this);
            }
        }

        for(JButton b :menuList){
            add(b);
            b.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons[0]) {
            changerPanel(new ChoiceMenu(frame, menu, listIdx - 2));
        } else if (e.getSource() == buttons[1]) {
                changerPanel(new ChoiceMenu(frame, menu, listIdx + 2));
        } else if(e.getSource() == buttons[2]){
            changerPanel(new OrderMain(frame));
        } else {
            int idx = menuList.indexOf(e.getSource());
            Menu menu = data.getMenuList().getList(idx);
            setMenuName(menu);
            menu.print();
            changerPanel(new SetOption(frame));
        }
    }
}

package GUI;

import Console.Menu;
import Console.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import static Console.OrderList.od;

public class ChoiceMenu extends SwingManager implements SwingManageable {
    JButton b = null;
    String menuCode;
    JButton[] buttons = new JButton[3];

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
        b = new JButton(m.memu());
        b.setFont(new Font("맑은 고딕", Font.BOLD, 36));
        b.setBackground(getBrown());
        b.setForeground(Color.white);

        String[] text = {"이전", "다음", "처음으로"};
        Color[] foreGround = {Color.black,  Color.black, Color.white};
        Color[] backGround = { getVanilla(),getVanilla(),getBrown()};
        for (int i = 0; i < buttons.length; ++i) {
            buttons[i] = new JButton(text[i]);
            buttons[i].setFont(new Font("맑은 고딕", Font.BOLD, 24));
            buttons[i].setForeground(foreGround[i]);
            buttons[i].setBackground(backGround[i]);
        }

    }

    void setButtonPos() {

        b.setBounds(40,40,300,300);

        for (int i = 0; i < 2; ++i)
            buttons[i].setBounds(40 + (i * 160), 355, 140, 80);
        buttons[2].setBounds(40, 450, 300, 80);
    }

    void addButtonAction() {

        add(b);
        b.addActionListener(this);

        for (int i = 0; i < buttons.length; ++i) {
            //처음이거나 맨마지막이면, 이전버튼 add안함
            if (listIdx == 0 && i == 0 || listIdx == data.getMenuList().getSize()-1 && i == 1) {
            }
            else {
                add(buttons[i]);
                buttons[i].addActionListener(this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //이전, 다음, 처음으로, 메뉴선택
        if (e.getSource() == buttons[0]) {
            changerPanel(new ChoiceMenu(frame, menuCode, listIdx - 1));
        } else if (e.getSource() == buttons[1]) {
                changerPanel(new ChoiceMenu(frame, menuCode, listIdx + 1));
        } else if(e.getSource() == buttons[2]){
            changerPanel(new OrderMain(frame));
        } else {
            setMenuName(m);
            od.getMenu(m);
            changerPanel(new SetOption(frame));
        }
    }
}

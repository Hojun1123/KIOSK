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
    Color c = new Color(72, 50, 42);
    Color c3 = new Color(224,204,204);
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
        b.setBackground(c);
        b.setForeground(Color.white);

        String[] text = {"이전", "다음", "처음으로"};
        for (int i = 0; i < buttons.length; ++i) {
            buttons[i] = new JButton(text[i]);
            buttons[i].setFont(new Font("맑은 고딕", Font.BOLD, 24));
        }
        buttons[0].setForeground(Color.black);
        buttons[1].setForeground(Color.black);
        buttons[2].setForeground(Color.white);

        buttons[0].setBackground(c3);
        buttons[1].setBackground(c3);
        buttons[2].setBackground(c);
    }

    void setButtonPos() {

        b.setBounds(40,40,300,300);

        for (int i = 0; i < 2; ++i)
            buttons[i].setBounds(40 + (i * 160), 400, 140, 40);
        buttons[2].setBounds(40, 450, 300, 40);
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
            //JOptionPane.showMessageDialog(null, getMenuName(), "Message", JOptionPane.INFORMATION_MESSAGE);
            changerPanel(new SetOption(frame));
        }
    }
}

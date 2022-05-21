package GUI;

import Console.Menu;
import Speak.QuickstartSampleSTT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static Console.OrderList.od;
import static Speak.Converter.tts;

public class ChoiceMenu extends SwingManager implements SwingManageable {
    JButton b = null;
    JButton submit = null;
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

        submit = new JButton("음성");
        submit.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        submit.setBackground(getBrown());
        submit.setForeground(Color.white);
        submit.setBounds(40, 10, 300, 50);

    }

    void setButtonPos() {
        b.setBounds(40,100,300,250);

        for (int i = 0; i < 2; ++i)
            buttons[i].setBounds(40 + (i * 160), 400, 140, 40);
        buttons[2].setBounds(40, 450, 300, 40);
    }

    void addButtonAction() {
        add(b);
        b.addActionListener(this);

        for (int i = 0; i < buttons.length; ++i) {
            //처음이거나 맨마지막이면, 이전버튼 add안함
            if (listIdx == 0 && i == 0 || listIdx == data.getMenuList().getSize() - 1 && i == 1) {
            } else {
                add(buttons[i]);
                buttons[i].addActionListener(this);
            }
        }

        add(submit);
        submit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //이전, 다음, 처음으로, 메뉴선택
        if (e.getSource() == buttons[0]) {
            changerPanel(new ChoiceMenu(frame, menuCode, listIdx - 1));
        } else if (e.getSource() == buttons[1]) {
            changerPanel(new ChoiceMenu(frame, menuCode, listIdx + 1));
        } else if (e.getSource() == buttons[2]) {
            changerPanel(new OrderMain(frame));
        }
        else if (e.getSource() == submit) {
            JOptionPane.showMessageDialog(null, "확인 버튼을 누르고 메뉴 이름을 말씀해주세요",
                    "Message", JOptionPane.INFORMATION_MESSAGE);
            QuickstartSampleSTT stt = new QuickstartSampleSTT();
            JOptionPane.showMessageDialog(null, stt.getVoice(),
                    "Message", JOptionPane.INFORMATION_MESSAGE);
            String str = stt.getVoice();
            int idx = data.getMenuList().findIdx(str);
            if(idx == -1){
                JOptionPane.showMessageDialog(null, "해당 메뉴는 없습니다",
                        "Message", JOptionPane.INFORMATION_MESSAGE);
                changerPanel(new ChoiceMenu(frame, menuCode, listIdx));
            }
            else {
                m = data.getMenuList().getList(idx);
                tts(m.getName());
                setMenuName(m);
                od.getMenu(m);
                changerPanel(new SetOption(frame));
            }

        }
        else {
            tts(m.getName());
            setMenuName(m);
            od.getMenu(m);
            // 스무디 메뉴면 ICE로 고정시키고 바로 개수 항목으로 넘어가게
            if (menuCode == "smoothie") {
                od.getIce(true);
                changerPanel(new ChoiceQuantity(frame));
            } else {
                changerPanel(new SetOption(frame));
            }
        }
    }
}

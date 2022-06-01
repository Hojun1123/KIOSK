package GUI;

import Console.OrderList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Payment extends SwingManager implements SwingManageable {
    String menuCode;
    JButton[] buttons = new JButton[3];
    JLabel label = null;
    JLabel insideLabel = null;
    JScrollPane scrollPane = null;
    Color c = new Color(72, 50, 42);
    Color c2 = new Color(245, 245, 220);
    public Payment(JFrame f) {
        super(f);
        create();
        setPos();
        addAction();
    }

    @Override
    public void makeSubmit () { }
    @Override
    public void create() {
        createButton();
        createLabel();
        createScrollPane();
    }

    @Override
    public void setPos() {
        setButtonPos();
        setLabel();
        setScrollPane();
    }

    @Override
    public void addAction() {
        addButtonAction();
        addLabel();
        addScrollPane();
    }
    private void createScrollPane() {
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(insideLabel);
        scrollPane.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        scrollPane.setForeground(Color.black);
        scrollPane.setBackground(c2);
        scrollPane.setOpaque(true);
    }
    private void setScrollPane() {
        scrollPane.setBounds(40,50,300,200);
    }
    private void addScrollPane() {
        add(scrollPane);
    }

    void createLabel(){
        String text = "총 "+ OrderList.totalPrice()+"원";
        label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        label.setForeground(Color.red);

        insideLabel = new JLabel(OrderList.toStringOrderList(), SwingConstants.CENTER);
        insideLabel.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        insideLabel.setForeground(Color.black);
    }
    void setLabel(){
        label.setBounds(40,250,300,200);
    }
    void addLabel(){
        add(label);
    }
    void createButton() {
        String[] text = {"현금결제", "카드결제", "처음으로"};
        for(int i=0; i < buttons.length; ++i){
            buttons[i] = new JButton(text[i]);
            buttons[i].setBackground(c);
            buttons[i].setForeground(Color.white);
            buttons[i].setFont(new Font("맑은 고딕", Font.BOLD, 24));
        }
    }

    void setButtonPos() {
        for (int i = 0; i < 2; ++i)
            buttons[i].setBounds(40 + (i * 160), 400, 140, 40);
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
        //카드결제
        if (e.getSource() == buttons[0]) {
            JOptionPane.showMessageDialog(null, "결제되었습니다",
                    "Message", JOptionPane.INFORMATION_MESSAGE);
            changerPanel(new OrderMain(frame));
        }
        //현금결제
        else if (e.getSource() == buttons[1]) {
            JOptionPane.showMessageDialog(null, "결제되었습니다",
                    "Message", JOptionPane.INFORMATION_MESSAGE);
            changerPanel(new OrderMain(frame));
        }
        else{
            changerPanel(new OrderMain(frame));
        }
    }
}

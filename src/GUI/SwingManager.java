package GUI;

import Console.*;
import Console.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SwingManager extends JPanel implements ActionListener {
    JFrame frame;
    ClassControl data = new ClassControl();
    Menu MenuInfo = null;
    public SwingManager(JFrame f) {
        frame = f;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        setLayout(null);            // 배치 컨트롤 제거, 절대 위치
        setBackground(Color.white);
    }

    void changerPanel(JPanel panel) {
        frame.remove(this);
        frame.add(panel);
        frame.revalidate();
        frame.repaint();
    }

    void setMenuName(Menu menu) {
        MenuInfo = menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}

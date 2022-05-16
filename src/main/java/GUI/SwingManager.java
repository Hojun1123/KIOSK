package GUI;

import Console.*;
import Console.Menu;
import Console.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingManager extends JPanel implements ActionListener {
    JFrame frame;
    ClassControl data = new ClassControl();
    Menu MenuInfo = null;
    final Color brown = new Color(72,50,42);
    final Color blue = new Color(58,114,138);
    final Color vanilla = new Color(224,204,204);

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

    public final Color getBrown() {
        return brown;
    }

    public final Color getBlue() {
        return blue;
    }

    public final Color getVanilla() {
        return vanilla;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

}

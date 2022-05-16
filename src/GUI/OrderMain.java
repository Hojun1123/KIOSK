package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class OrderMain extends SwingManager implements SwingManageable {
    JButton b = new JButton("주문하기");
    JLabel[] labels = new JLabel[2];
    Color c = new Color(72, 50, 42);
    String filename = "C:\\Users\\82102\\Documents\\GitHub\\KIOSK\\output.mp3";
    MyMusicPlayer playMusic = new MyMusicPlayer(filename);

    public OrderMain(JFrame f) {
        super(f);
        create();
        setPos();
        addAction();
    }

    @Override
    public void create() {
        createButton();
        createLabel();
    }

    @Override
    public void setPos() {
        setButtonPos();
        setLabelPos();
    }

    @Override
    public void addAction() {
        addButtonAction();
    }

    void createButton() {
        b.setBackground(c);
        b.setForeground(Color.white);
        b.setFont(new Font("맑은 고딕", Font.BOLD, 36));

    }
    void createLabel() {
        String[] text = {"어서오세요", "Voisk 카페입니다"};

        for (int i = 0; i < labels.length; ++i) {
            labels[i] = new JLabel(text[i], JLabel.CENTER);
            labels[i].setFont(new Font("맑은 고딕", Font.BOLD, 36));
        }

    }

    void setButtonPos() {
        b.setBounds(75, 200, 250, 100);
    }


    void setLabelPos() {
        for (int i = 0; i < labels.length; ++i) {
            labels[i].setBounds(50, 40 + (i * 60), 300, 100);
        }
    }

    void addButtonAction() {
        add(b);
        for(JLabel l : labels)
            add(l);
        b.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b) {
            changerPanel(new ChoiceCaffeine(frame));
            playMusic.play();
        }
    }
}

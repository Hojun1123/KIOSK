package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import static Speak.Converter.tts;

public class OrderMain extends SwingManager implements SwingManageable {
    JButton[] buttons =  new JButton[2];

    JLabel[] labels = new JLabel[2];
    Color c = getBrown();

    public OrderMain(JFrame f) {
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
        String[] str = {"음성 주문", "선택 주문"};
        for(int i=0;i<buttons.length;++i) {
            buttons[i] = new JButton(str[i]);
            buttons[i].setBackground(c);
            buttons[i].setForeground(Color.white);
            buttons[i].setFont(new Font("맑은 고딕", Font.BOLD, 36));
        }



    }
    void createLabel() {
        String[] text = {"어서오세요", "Voisk 카페입니다"};
        tts(text[0]+", "+text[1]);

        for (int i = 0; i < labels.length; ++i) {
            labels[i] = new JLabel(text[i], JLabel.CENTER);
            labels[i].setFont(new Font("맑은 고딕", Font.BOLD, 36));
        }
    }

    void setButtonPos() {
        for (int i = 0; i < buttons.length; ++i)
            buttons[i].setBounds(75, 200+(i*130), 250, 100);
    }


    void setLabelPos() {
        for (int i = 0; i < labels.length; ++i) {
            labels[i].setBounds(50, 40 + (i * 60), 300, 100);
        }
    }

    void addButtonAction() {
        for (JLabel l : labels)
            add(l);
        for (JButton b : buttons) {
            add(b);
            b.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons[0])
            setIsVoice(true);
        else
            setIsVoice(false);
        changerPanel(new ChoiceCaffeine(frame));
    }
}

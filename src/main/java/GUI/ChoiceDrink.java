package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static Speak.Converter.tts;

public class ChoiceDrink extends SwingManager implements SwingManageable{
    JButton[] buttons = new JButton[3];
    Color c = new Color(53, 39, 35);
    Color c2 = new Color(58,114,138);

    public ChoiceDrink(JFrame f) {
        super(f);
        create();
        setPos();
        addAction();

        String[] kewards = {"라떼","스무디", "차"};
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        tts("원하시는 메뉴를 골라주세요.");
        thread = new Thread(){
            public void run(){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                buttons[voiceRecognition(kewards)].doClick();
            }
        };
        thread.start();
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
        String[] text = {"라떼","스무디", "차"};
        int[] size = {36,36,36};
        for(int i=0;i < buttons.length;++i){
            buttons[i] = new JButton(text[i]);

            buttons[i].setForeground(Color.white);
            buttons[i].setFont(new Font("맑은 고딕", Font.BOLD, size[i]));
        }
        buttons[0].setBackground(c);
        buttons[1].setBackground(c2);
        buttons[2].setBackground(c);

    }

    void setButtonPos() {
        int[] size = {130,130, 130};
        for(int i=0;i < buttons.length;++i) {
            buttons[i].setBounds(40, 30+(i*170), 300, size[i]);
        }
    }

    void addButtonAction() {
        for(JButton b : buttons) {
            add(b);
            b.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons[0]) {
            changerPanel(new ChoiceMenu(frame, "latte",0));
        } else if (e.getSource() == buttons[1]) {
            changerPanel(new ChoiceMenu(frame, "smoothie",0));
        } else {
            changerPanel(new ChoiceMenu(frame, "tea",0));
        }
    }
}

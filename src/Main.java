import GUI.OrderMain;

import javax.swing.*;


public class Main {
	JFrame frame = new JFrame();

	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}
	void run() {
		menu();
	}

	void menu() {
		frame.setTitle("키오스크");
		frame.setSize(400, 600);
		frame.setLocationRelativeTo(null);
		JPanel title = new OrderMain(frame);
		frame.add(title);
	}


}

package Console;

import java.util.Scanner;

public class Menu implements Manageable{
	private String name;
	private int price;

	@Override
	public void read(Scanner scan) {
		name = scan.next();
		price = scan.nextInt();
	}

	@Override
	public void print() {
		System.out.printf("%s : %d \n", name, price);
	}

	@Override
	public boolean matches(String kwd) {
		return name.equals(kwd);
	}


	public String getName() {
		return name;
	}
	public int getPrice(){return price;}
}

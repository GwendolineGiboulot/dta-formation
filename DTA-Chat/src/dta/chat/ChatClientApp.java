package dta.chat;

import java.util.Scanner;

import dta.chat.view.console.ChatConsoleView;

public class ChatClientApp {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);

		new ChatConsoleView(read).print();
	}

}

package proxy;

import java.util.List;

import chat.model.socket.ChatSocketImpl;
import dta.chat.history.History;
import dta.chat.model.ChatMessage;

public class Proxy {

	ChatSocketImpl connection;

	public Proxy(String ip, int port) {
		connection = new ChatSocketImpl(ip, port);
	}

	public void sendMessage(ChatMessage message) {
		connection.sendMessage(message);

		History h = new History();

		h.saveMessage(message);

	}

	public ChatMessage readMessage() {
		ChatMessage msg = connection.readMessage();

		History h = new History();

		h.saveMessage(msg);

		return msg;
	}

	public void afficherHistorique() {

		History h = new History();

		List<ChatMessage> listeMessage = h.findLastMessages();

		for (ChatMessage chatMessage : listeMessage) {

			System.out.println(chatMessage.toString());

		}

	}

}

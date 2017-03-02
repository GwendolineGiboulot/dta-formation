package chat.model.socket;

import java.io.IOException;

import dta.chat.model.ChatMessage;

public class ChatSocketImpl implements ChatSocket {

	ClientSocket client;

	public ChatSocketImpl(String ip, int port) throws ChatClientException {

		try {
			client = new ClientSocket(ip, port);
		} catch (IOException e) {
			throw new ChatClientException("Probleme lors de la cr�ation de la connection", e);
		}
	}

	@Override
	public void close() throws Exception {
		client.close();
	}

	@Override
	public void sendMessage(ChatMessage msg) throws ChatClientException {
		try {
			client.sendObject(msg);
		} catch (IOException e) {
			throw new ChatClientException("Probleme lors de l'envoi du message", e);
		}
	}

	@Override
	public ChatMessage readMessage() throws ChatClientException {
		try {
			return (ChatMessage) client.readObject();
		} catch (ClassNotFoundException | IOException e) {
			throw new ChatClientException("Probleme lors de la lecture du message", e);
		}
	}

}

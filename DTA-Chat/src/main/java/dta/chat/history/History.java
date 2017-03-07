package dta.chat.history;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import chat.model.socket.ChatClientException;
import dta.chat.model.ChatMessage;

public class History {

	public List<ChatMessage> findLastMessages() throws ChatClientException {

		List<ChatMessage> listMessage = new ArrayList<ChatMessage>();

		List<String> lines;
		try {
			lines = Files.readAllLines(Paths.get("data\\historique.txt"));
		} catch (IOException e) {
			throw new ChatClientException("Probleme lors de la lecture du message", e);
		}

		for (String s : lines) {

			String[] items = s.split(":");

			ChatMessage msg = new ChatMessage(items[0], items.length <= 1 ? "" : items[1]);

			listMessage.add(msg);

		}

		return listMessage;

	}

	public void saveMessage(ChatMessage message) throws ChatClientException {

		List<String> lines = Arrays.asList(message.toString());

		try {
			Files.write(Paths.get("data\\historique.txt"), lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new ChatClientException("Probleme lors de l'enregistrement du message", e);
		}

	}

}

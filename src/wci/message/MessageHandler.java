package wci.message;

import java.util.ArrayList;
import java.util.List;

public class MessageHandler {

    private Message message;
    private List<MessageListener> listeners;

    public MessageHandler() {
        listeners = new ArrayList<>();
    }

    public void addListener(MessageListener listener) {
        listeners.add(listener);
    }

    public void removeListener(MessageListener listener) {
        listeners.remove(listener);
    }

    public void sendMessage(Message message) {
        this.message = message;
        notifyListeners();
    }

    private void notifyListeners() {
        for (MessageListener listener : listeners) {
            listener.messageReceived(message);
        }
    }

}

package wci.frontend;

import wci.message.*;

import java.io.BufferedReader;
import java.io.IOException;

public class Source implements MessageProducer {

    /**
     * The framework class that represents the source program.
     */

    public static final char EOL = '\n';
    public static final char EOF = (char) 0;
    protected static MessageHandler messageHandler;

    static {
        messageHandler = new MessageHandler();
    }

    private BufferedReader reader;
    private String line;

    private int lineNum;
    private int currentPos;

    public Source(BufferedReader reader) {
        this.reader = reader;
        this.lineNum = 0;
        this.currentPos = -2;
        this.reader = reader;
    }

    public char currentChar() throws IOException {

        if (currentPos == -2) {
            readLine();
            return nextChar();
        } else if (line == null) {
            return EOF;
        } else if ((currentPos == -1) || (currentPos == line.length())) {
            return EOL;
        } else if (currentPos > line.length()) {
            readLine();
            return nextChar();
        } else {
            return line.charAt(currentPos);
        }

    }

    public char nextChar() throws IOException {
        ++currentPos;
        return currentChar();
    }

    private void readLine() throws IOException {
        line = reader.readLine();
        currentPos = -1;

        if (line != null) {
            ++lineNum;
        }

        if (line != null)
            sendMessage(new Message(MessageType.SOURCE_LINE, new Object[]{lineNum, line}));

    }

    public char peekChar() throws IOException {
        currentChar();
        if (line == null) {
            return EOF;
        }
        int nextPos = currentPos + 1;
        return (nextPos < line.length() ? line.charAt(nextPos) : EOL);
    }

    public void close() throws IOException {

        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw e;
            }
        }

    }

    public int getLineNum() {
        return lineNum;
    }

    public int getCurrentPos() {

        return currentPos;
    }

    @Override
    public void addMessageListener(MessageListener listener) {
        messageHandler.addListener(listener);
    }

    @Override
    public void removeMessageListener(MessageListener listener) {
        messageHandler.removeListener(listener);
    }

    @Override
    public void sendMessage(Message message) {
        messageHandler.sendMessage(message);
    }
}

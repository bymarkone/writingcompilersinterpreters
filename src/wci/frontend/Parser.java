package wci.frontend;

import wci.intermediate.ICode;
import wci.intermediate.SymTab;
import wci.message.Message;
import wci.message.MessageHandler;
import wci.message.MessageListener;
import wci.message.MessageProducer;

import java.io.IOException;

/**
 * Parser
 * <p/>
 * A language-independent framework class. This abstract parser class
 * will be implemented by language-specific subclasses.
 */

public abstract class Parser implements MessageProducer {

    protected static SymTab symTab;
    protected static MessageHandler messageHandler;

    static {
        symTab = null;
        messageHandler = new MessageHandler();
    }

    protected Scanner scanner;
    protected ICode iCode;

    protected Parser(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Parse a source program and generate the intermediate code and the
     * symbol table.
     *
     * @throws Exception
     */
    public abstract void parse() throws Exception;

    public abstract int getErrorCount();

    public Token currentToken() {
        return scanner.currentToken();
    }

    public Token nextToken() throws IOException {
        return scanner.nextToken();
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

    public SymTab getSymTab() {
        return Parser.symTab;
    }

    public ICode getICode() {
        return iCode;
    }
}

package wci.backend.interpreter;

import wci.backend.Backend;
import wci.intermediate.ICode;
import wci.intermediate.SymTab;
import wci.message.Message;
import wci.message.MessageType;

public class Executor extends Backend {

    @Override
    public void process(ICode iCode, SymTab symTab) {
        long startTime = System.currentTimeMillis();
        float elapsedTime = (System.currentTimeMillis() - startTime) / 1000f;
        int executionCount = 0;
        int runtimeErrors = 0;

        sendMessage(new Message(MessageType.INTERPRETER_SUMMARY, new Number[]{executionCount, runtimeErrors, elapsedTime}));

    }

}

package wci.frontend;

import java.io.IOException;

public abstract class Scanner {

    protected Source source;
    private Token currentToken;

    public Scanner(Source source) {
        this.source = source;
    }

    public Token currentToken() {
        return currentToken;
    }

    public Token nextToken() throws IOException {
        currentToken = extractToken();
        return currentToken;
    }

    public char currentChar() throws IOException {
        return source.currentChar();
    }

    public char nextChar() throws IOException {
        return source.nextChar();
    }

    protected abstract Token extractToken() throws IOException;

}

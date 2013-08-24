package wci.frontend.pascal;

import wci.frontend.EofToken;
import wci.frontend.Scanner;
import wci.frontend.Source;
import wci.frontend.Token;

import java.io.IOException;

public class PascalScanner extends Scanner {

    public PascalScanner(Source source) {
        super(source);
    }

    @Override
    protected Token extractToken() throws IOException {

        Token token;
        char currentChar = currentChar();

        if (currentChar == Source.EOF) {
            token = new EofToken(source);
        } else {
            token = new Token(source);
        }

        return token;
    }

}

package wci.frontend;

import wci.frontend.pascal.PascalParserTD;
import wci.frontend.pascal.PascalScanner;

public class FrontendFactory {

    public static Parser createParser(String language, String type, Source source) throws Exception {

        if ("Pascal".equalsIgnoreCase(language) && "top-down".equalsIgnoreCase(type)) {
            Scanner scanner = new PascalScanner(source);
            return new PascalParserTD(scanner);
        } else if (!"Pascal".equalsIgnoreCase(language)) {
            throw new Exception("Parser Factory: Invalid language '" + language + "'");
        } else {
            throw new Exception("Parser Factory: Invalid type '" + type + "'");
        }

    }

}

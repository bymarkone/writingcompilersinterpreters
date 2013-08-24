package wci.backend;

import wci.backend.compiler.CodeGenerator;
import wci.backend.interpreter.Executor;

public class BackendFactory {

    public static Backend createBackend(String operation) throws Exception {

        if ("compile".equalsIgnoreCase(operation))
            return new CodeGenerator();
        else if ("execute".equalsIgnoreCase(operation))
           return new Executor();
        else
            throw new Exception("Backend factory: Invalid operation: '" + operation + "'");

    }

}

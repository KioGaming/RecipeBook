package exception;

import settings.Text;

public class ProgramException extends Exception {

    private static final int DATABASE_CONNECTION_ERROR = 1;

    private final int code;

    public ProgramException(int code) {
        this.code = code;
    }

    public String getMessage(){
        switch (code) {
            case DATABASE_CONNECTION_ERROR:
                return Text.get("");
            default:
                return "";
        }
    }
}





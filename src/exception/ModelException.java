package exception;

import settings.Text;

public class ModelException extends Exception {

    public static final int PROGRAM_ERROR = 1;
    public static final int ADDING_ERROR = 2;

    private final int code;

    public ModelException(int code){
        this.code = code;
    }

    public String getMessage(){
        switch (code){
            case PROGRAM_ERROR:
                return Text.get("PROGRAM_ERROR_TITLE");
            case  ADDING_ERROR:
                return  Text.get("ADDING_ERROR_TITLE");
        }
        return "";
    }
}





package pk;

import java.util.Objects;

public class ManageLogs {
    public static boolean log = false;

    public static boolean loggerCondition(String tracerInput) {
        if(Objects.equals(tracerInput, "trace")) log = true;
        else log = false;
        return log;
    }
}

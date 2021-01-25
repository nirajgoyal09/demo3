package utility;

import java.util.logging.Logger;

public class Log {
    private static Logger log = Logger.getLogger(Log.class.getName());

    public static void startTest(String testcasename) {
        log.info("****Starting Test****" + testcasename);
    }

    public static void endTest() {
        log.info("****Ending Test****");
    }

    public static void info(String message) {
        log.info(message);
    }
}

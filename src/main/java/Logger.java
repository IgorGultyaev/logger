import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {


    private static Logger logger = null;
    protected int num = 1;


    private Logger() {}

    public static Logger getInstance() {
        if (logger == null) logger = new Logger();
        return logger;
    }

    private String time(){
        return DateTimeFormatter
                .ofPattern("dd.MM.yy hh:mm:ss")
                .format(LocalDateTime.now());
    }

    public void log(String msg) {

        System.out.println("[" + time()+ " " + num++ + "] " + msg);
    }


}

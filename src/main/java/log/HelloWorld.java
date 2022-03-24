package log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintStream;

public class HelloWorld {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(HelloWorld.class);
        final Logger sys_user_logger = LoggerFactory.getLogger("sys-user");
        logger.info("Hello World");
        logger.error("22222222222");
        sys_user_logger.error("5555555");
//        logger.atInfo().addArgument(() -> t16()).log( "Temperature set to {}. Old temperature was {}.", 99);
//        logger.atDebug().addArgument(4).addArgument(7).log( "Temperature set to {}. Old temperature was {}.");

    }
    public static int t16(){
        return 90;
    }
}

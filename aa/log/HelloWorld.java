package log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintStream;

public class HelloWorld {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(HelloWorld.class);
        logger.info("Hello World");
        logger.debug("22222222222");
//        logger.atInfo().addArgument(() -> t16()).log( "Temperature set to {}. Old temperature was {}.", 99);
//        logger.atDebug().addArgument(4).addArgument(7).log( "Temperature set to {}. Old temperature was {}.");

    }
    public static int t16(){
        return 90;
    }
}

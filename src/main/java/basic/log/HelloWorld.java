package basic.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther d
 * @Date 2022/3/26 17:01
 * @Describe 日志框架的使用
 **/
public class HelloWorld {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(HelloWorld.class);
        final Logger sys_user_logger = LoggerFactory.getLogger("sys-user");
        logger.trace("=====trace=====");
        logger.debug("=====debug=====");
        logger.info("=====info=====");
        logger.warn("=====warn=====");
        logger.error("=====error=====");
        sys_user_logger.error("5555555");
//        logger.atInfo().addArgument(() -> t16()).log( "Temperature set to {}. Old temperature was {}.", 99);
//        logger.atDebug().addArgument(4).addArgument(7).log( "Temperature set to {}. Old temperature was {}.");

    }

    public static int t16() {
        return 90;
    }
}

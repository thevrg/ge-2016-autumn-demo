package hu.dpc.edu.logging;

import java.util.Date;
import java.util.logging.*;

/**
 * Created by vrg on 19/10/16.
 */
public class LoggerTest {
    public static void main(String[] args) {
        final Handler myHandler = new Handler() {

            @Override
            public void publish(LogRecord record) {

                final String formattedMessage = new SimpleFormatter().format(record);

                System.out.println(record.getLevel() + " szintu log uzenet: "  + formattedMessage);
            }

            @Override
            public void flush() {
            }

            @Override
            public void close() throws SecurityException {
            }
        };

        final Logger testLogger = Logger.getLogger(LoggerTest.class.getName());

        myHandler.setLevel(Level.ALL);

        final Logger bigyoLogger = Logger.getLogger("akarmi.bigyo");
        bigyoLogger.setLevel(Level.WARNING);

        bigyoLogger.addHandler(myHandler);
        //bigyoLogger.setUseParentHandlers(false);

        final Logger logger = Logger.getLogger("akarmi.bigyo.ize");

        logger.log(Level.INFO, "Hello world");

        logger.log(Level.WARNING, "Hello, dear {0} {1}!", new Object[]{"Bela", new Date()});

        if (bigyoLogger.isLoggable(Level.FINE)) {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 100000; i++) {
                sb.append(i).append(",");
            }
            logger.fine("Hello world, again" + sb);
        }

        bigyoLogger.fine("Ujabb fine probalkozas");
        logger.severe("Na ez nagyon komoly");




    }
}

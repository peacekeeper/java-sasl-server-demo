package demo.sasl.server.debug;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.sasl.Sasl;
import javax.security.sasl.SaslServerFactory;
import java.util.Collections;

public class SaslServerDebug {

    private static final Logger log = LogManager.getLogger(SaslServerDebug.class);

    public static void logSaslServerFactoriesAndMechanisms() {
        for (SaslServerFactory saslServerFactory : Collections.list(Sasl.getSaslServerFactories())) {
            for (String mechanismName : saslServerFactory.getMechanismNames(null)) {
                log.info("For SASL server factory {} found mechanism name {}", saslServerFactory, mechanismName);
            }
        }
    }
}
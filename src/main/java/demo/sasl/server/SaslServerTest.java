package demo.sasl.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.sasl.Sasl;
import javax.security.sasl.SaslException;
import javax.security.sasl.SaslServer;
import javax.security.sasl.SaslServerFactory;
import java.util.Collections;
import java.util.Map;

public class SaslServerTest {

    private static final String MECHANISM = "CRAM-MD5";
    private static final String PROTOCOL = "myproto";
    private static final String SERVER_NAME = "localhost";
    private static final Map<String, Object> PROPS = null;

    private static final Logger log = LogManager.getLogger(SaslServerTest.class);

    public static void main(String[] args) throws Exception {
        new SaslServerTest().run();
    }

    public void run() throws SaslException {
        SaslServer saslServer = createSaslServer();
    }

    public static void logSaslServerFactoriesAndMechanisms() {
        for (SaslServerFactory saslServerFactory : Collections.list(Sasl.getSaslServerFactories())) {
            for (String mechanismName : saslServerFactory.getMechanismNames(null)) {
                log.info("For SASL server factory {} found mechanism name {}", saslServerFactory, mechanismName);
            }
        }
    }

    public static SaslServer createSaslServer() throws SaslException {
        SaslServerCallbackHandler saslServerCallbackHandler = new SaslServerCallbackHandler();
        javax.security.sasl.SaslServer saslServer = Sasl.createSaslServer(
                MECHANISM,
                PROTOCOL,
                SERVER_NAME,
                PROPS,
                saslServerCallbackHandler);
        log.info("SASL server created: {}", saslServer);
        return saslServer;
    }
}
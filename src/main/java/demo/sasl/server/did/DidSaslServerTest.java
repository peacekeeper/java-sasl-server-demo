package demo.sasl.server.did;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.sasl.Sasl;
import javax.security.sasl.SaslException;
import javax.security.sasl.SaslServer;
import java.util.Map;

public class DidSaslServerTest {

    private static final String MECHANISM = "DID-CHALLENGE";
    private static final String PROTOCOL = "xmpp";
    private static final String SERVER_NAME = "localhost";
    private static final Map<String, Object> PROPS = null;

    private static final Logger log = LogManager.getLogger(DidSaslServerTest.class);

    public static void main(String[] args) throws Exception {
        new DidSaslServerTest().run();
    }

    public void run() throws SaslException {
        SaslServer saslServer = createSaslServer();
    }

    public static SaslServer createSaslServer() throws SaslException {
        DidSaslServerCallbackHandler didSaslServerCallbackHandler = new DidSaslServerCallbackHandler();
        SaslServer saslServer = Sasl.createSaslServer(
                MECHANISM,
                PROTOCOL,
                SERVER_NAME,
                PROPS,
                didSaslServerCallbackHandler);
        log.info("SASL server created: {}", saslServer);
        return saslServer;
    }
}
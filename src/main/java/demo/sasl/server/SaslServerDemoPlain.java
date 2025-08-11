package demo.sasl.server;

import demo.sasl.server.integration.BackendIntegrationSimple;

import javax.security.sasl.SaslException;
import javax.security.sasl.SaslServer;
import java.util.Map;

public class SaslServerDemoPlain extends SaslServerDemo {

    private static final String DEFAULT_MECHANISM = "PLAIN";
    private static final String DEFAULT_PROTOCOL = "xmpp";
    private static final String DEFAULT_SERVER_NAME = "localhost";
    private static final Map<String, Object> DEFAULT_PROPS = null;

    public SaslServerDemoPlain() {
        super(DEFAULT_MECHANISM, DEFAULT_PROTOCOL, DEFAULT_SERVER_NAME, DEFAULT_PROPS);
    }

    public static void main(String[] args) throws SaslException {
        SaslServer saslServer = new SaslServerDemoPlain().createSaslServer(new BackendIntegrationSimple());
        System.out.print(saslServer);
    }
}
package demo.sasl.server;

import demo.sasl.server.integration.BackendIntegrationDemoDID;

import javax.security.sasl.SaslException;
import javax.security.sasl.SaslServer;
import java.util.Map;

public class SaslServerDemoDIDChallenge extends SaslServerDemo {

    private static final String DEFAULT_MECHANISM = "DID-CHALLENGE";
    private static final String DEFAULT_PROTOCOL = "xmpp";
    private static final String DEFAULT_SERVER_NAME = "localhost";
    private static final Map<String, Object> DEFAULT_PROPS = null;

    public SaslServerDemoDIDChallenge() {
        super(DEFAULT_MECHANISM, DEFAULT_PROTOCOL, DEFAULT_SERVER_NAME, DEFAULT_PROPS);
    }

    public static void main(String[] args) throws SaslException {
        SaslServer saslServer = new SaslServerDemoDIDChallenge().createSaslServer(new BackendIntegrationDemoDID());
        System.out.print(saslServer);
    }
}
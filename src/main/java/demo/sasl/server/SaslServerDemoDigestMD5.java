package demo.sasl.server;

import demo.sasl.server.integration.BackendIntegrationWithPassword;

import javax.security.sasl.SaslException;
import javax.security.sasl.SaslServer;
import java.util.Map;

public class SaslServerDemoDigestMD5 extends SaslServerDemo {

    private static final String DEFAULT_MECHANISM = "DIGEST-MD5";
    private static final String DEFAULT_PROTOCOL = "xmpp";
    private static final String DEFAULT_SERVER_NAME = "localhost";
    private static final Map<String, Object> DEFAULT_PROPS = null;

    public SaslServerDemoDigestMD5() {
        super(DEFAULT_MECHANISM, DEFAULT_PROTOCOL, DEFAULT_SERVER_NAME, DEFAULT_PROPS);
    }

    public static void main(String[] args) throws SaslException {
        SaslServer saslServer = new SaslServerDemoDigestMD5().createSaslServer(new BackendIntegrationWithPassword());
        System.out.print(saslServer);
    }
}
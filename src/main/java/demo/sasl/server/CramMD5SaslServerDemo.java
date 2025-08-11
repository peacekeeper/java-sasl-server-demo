package demo.sasl.server;

import java.util.Map;

public class CramMD5SaslServerDemo extends SaslServerDemo {

    private static final String DEFAULT_MECHANISM = "CRAM-MD5";
    private static final String DEFAULT_PROTOCOL = "xmpp";
    private static final String DEFAULT_SERVER_NAME = "localhost";
    private static final Map<String, Object> DEFAULT_PROPS = null;

    public CramMD5SaslServerDemo() {
        super(DEFAULT_MECHANISM, DEFAULT_PROTOCOL, DEFAULT_SERVER_NAME, DEFAULT_PROPS);
    }
}
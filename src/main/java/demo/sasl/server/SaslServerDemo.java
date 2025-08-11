package demo.sasl.server;

import demo.sasl.server.integration.BackendIntegration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.sasl.Sasl;
import javax.security.sasl.SaslException;
import javax.security.sasl.SaslServer;
import java.util.Map;

public abstract class SaslServerDemo {

    private static final Logger log = LogManager.getLogger(SaslServerDemo.class);

    private String mechanism;
    private String protocol;
    private String serverName;
    private Map<String, Object> props;

    public SaslServerDemo(String mechanism, String protocol, String serverName, Map<String, Object> props) {
        this.mechanism = mechanism;
        this.protocol = protocol;
        this.serverName = serverName;
        this.props = props;
    }

    public SaslServer createSaslServer(BackendIntegration backendIntegration) throws SaslException {
        log.info("SASL server creating...");
        SaslServer saslServer = Sasl.createSaslServer(
                this.getMechanism(),
                this.getProtocol(),
                this.getServerName(),
                this.getProps(),
                new SaslServerCallbackHandler(backendIntegration));
        if (saslServer == null) throw new UnsupportedOperationException("SASL server mechanism " + this.getMechanism() + " not supported");
        log.info("SASL server created: {}", saslServer);
        return saslServer;
    }

    /*
     * Getters and setters
     */

    public String getMechanism() {
        return this.mechanism;
    }

    public void setMechanisms(String mechanism) {
        this.mechanism = mechanism;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getServerName() {
        return this.serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public Map<String, Object> getProps() {
        return this.props;
    }

    public void setProps(Map<String, Object> props) {
        this.props = props;
    }
}
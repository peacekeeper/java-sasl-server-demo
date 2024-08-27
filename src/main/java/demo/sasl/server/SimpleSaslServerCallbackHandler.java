package demo.sasl.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.auth.callback.*;
import javax.security.sasl.AuthorizeCallback;

public class SimpleSaslServerCallbackHandler implements CallbackHandler {

    private static final Logger log = LogManager.getLogger(SimpleSaslServerCallbackHandler.class);

    @Override
    public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
        for (Callback cb : callbacks) {
            log.debug("Callback: {}", cb);
            if (cb instanceof NameCallback nc) {
                log.info("prompt: {}, name: {}, defaultName: {}", nc.getPrompt(), nc.getName(), nc.getDefaultName());
            } else if (cb instanceof PasswordCallback pc) {
                log.info("prompt: {}, password: {}", pc.getPrompt(), pc.getPassword());
                pc.setPassword("password".toCharArray());
            } else if (cb instanceof AuthorizeCallback ac) {
                log.info("authenticationID: {}, authorizationID: {}, authorizedID: {}, isAuthorized: {}", ac.getAuthenticationID(), ac.getAuthorizationID(), ac.getAuthorizedID(), ac.isAuthorized());
                ac.setAuthorized(true);
            } else {
                throw new UnsupportedCallbackException(cb);
            }
        }
    }
}
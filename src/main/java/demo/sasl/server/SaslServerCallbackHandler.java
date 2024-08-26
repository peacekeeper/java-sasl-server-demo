package demo.sasl.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.auth.callback.*;
import javax.security.sasl.AuthorizeCallback;
import java.io.IOException;

public class SaslServerCallbackHandler implements CallbackHandler {

    private static final Logger log = LogManager.getLogger(SaslServerCallbackHandler.class);

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback cb : callbacks) {
            log.debug("Callback: {}", cb);
            switch (cb) {
                case NameCallback nc:
                    log.info("prompt: {}, name: {}, defaultName: {}", nc.getPrompt(), nc.getName(), nc.getDefaultName());
                    break;
                case PasswordCallback pc:
                    log.info("prompt: {}, password: {}", pc.getPrompt(), pc.getPassword());
                    pc.setPassword("password".toCharArray());
                    break;
                case AuthorizeCallback ac:
                    log.info("authenticationID: {}, authorizationID: {}, authorizedID: {}, isAuthorized: {}", ac.getAuthenticationID(), ac.getAuthorizationID(), ac.getAuthorizedID(), ac.isAuthorized());
                    ac.setAuthorized(true);
                    break;
                default: throw new UnsupportedCallbackException(cb);
            }
        }
    }
}
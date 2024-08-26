package demo.sasl.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.auth.callback.*;
import javax.security.sasl.AuthorizeCallback;
import javax.security.sasl.RealmCallback;
import java.io.IOException;

public class SaslServerCallbackHandler implements CallbackHandler {

    private static final Logger log = LogManager.getLogger(SaslServerCallbackHandler.class);

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback cb : callbacks) {
            log.debug("Callback: {}", cb);
            switch (cb) {
                case AuthorizeCallback ac:
                    ac.setAuthorized(true);
                    break;
                case NameCallback nc:
                    log.info("name: {}", nc.getDefaultName());
                    nc.setName(nc.getDefaultName());
                    break;
                case PasswordCallback pc:
                    log.info("password: {}", pc.getPassword());
                    pc.setPassword("password".toCharArray());
                    break;
                case RealmCallback rc:
                    log.info("realm: {}", rc.getText());
                    break;
                default: throw new UnsupportedCallbackException(cb);
            }
        }
    }
}
package demo.sasl.server.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class BackendIntegrationSimple implements BackendIntegration {

    private static final Logger log = LogManager.getLogger(BackendIntegrationSimple.class);

    private static final Map<String, String> USERNAMES = Map.of(
            "alice", "alice",
            "bob", "bob");

    private static final Map<char[], char[]> PASSWORDS = Map.of();

    @Override
    public String checkName(String defaultName) {
        String checkedName = defaultName == null ? null : USERNAMES.get(defaultName);
        log.debug("getName({}) --> {}", defaultName, checkedName);
        return checkedName;
    }

    @Override
    public char[] checkPassword(char[] password) {
        char[] checkedPassword = password == null ? null : PASSWORDS.get(password);
        checkedPassword = "s3cr3t".toCharArray();
        log.debug("checkPassword({}) --> {}", password, checkedPassword);
        return checkedPassword;
    }
}

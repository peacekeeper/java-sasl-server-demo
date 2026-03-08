package demo.sasl.server.integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackendIntegrationInteractive implements BackendIntegration {

    private static final Logger log = LogManager.getLogger(BackendIntegrationInteractive.class);

    private static final BufferedReader stdinReader = new BufferedReader(new InputStreamReader(System.in));

    private static String readLine(String prompt) {
        System.out.print(BackendIntegrationInteractive.class.getSimpleName() + " : " + prompt + " -> ");
        try {
            return stdinReader.readLine();
        } catch (IOException ex) {
            throw new RuntimeException("Cannot read " + prompt + ": " + ex.getMessage(), ex);
        }
    }

    @Override
    public String checkName(String defaultName) {
        String checkedName = readLine("checkName " + defaultName);
        log.debug("checkName() --> {}", checkedName);
        return checkedName;
    }

    @Override
    public char[] checkPassword(char[] password) {
        String checkedPassword = readLine("checkPassword " + (password == null ? null : new String(password)));
        log.debug("checkPassword() --> {}", checkedPassword);
        return checkedPassword == null ? null : checkedPassword.toCharArray();
    }

    @Override
    public String checkTextInput(String defaultText) {
        String checkedText = readLine("checkTextInput " + defaultText);
        log.debug("checkTextInput() --> {}", checkedText);
        return checkedText;
    }

    @Override
    public String checkTextInputRealm(String defaultText) {
        String checkedText = readLine("checkTextInputRealm " + defaultText);
        log.debug("checkTextInputRealm() --> {}", checkedText);
        return checkedText;
    }

    @Override
    public String checkTextInputJWK(String defaultText) {
        String checkedText = readLine("checkTextInputJWK " + defaultText);
        log.debug("checkTextInputJWK() --> {}", checkedText);
        return checkedText;
    }

    @Override
    public String checkTextInputVCS(String defaultText) {
        String checkedText = readLine("checkTextInputVCS " + defaultText);
        log.debug("checkTextInputVCS() --> {}", checkedText);
        return checkedText;
    }
}

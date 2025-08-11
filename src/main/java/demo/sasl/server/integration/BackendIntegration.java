package demo.sasl.server.integration;

public interface BackendIntegration {

    String checkName(String defaultName);
    char[] checkPassword(char[] password);
}

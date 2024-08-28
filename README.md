# java-sasl-server-demo

This repository is one component of the project "Securing Internet protocols with DIDs, using SASL",
see https://github.com/peacekeeper/did-based-sasl for an overview and list of all components.

## Description

This repository contains demonstration components to illustrate the use of the [Simple Authentication and Security Layer (SASL)](https://www.rfc-editor.org/rfc/rfc4422.html)
on the server side. It uses the Java SASL API and shows the use of two SASL authentication mechanisms:

- The more traditional `CRAM-MD5` mechanism, specified by [RFC2195](https://www.rfc-editor.org/rfc/rfc2195.html).
- The DID-based `DID-CHALLENGE` mechanism, described and implemented in https://github.com/peacekeeper/java-sasl-did-mechanism.

In both cases, an implementation of a callback handler is also provided, to simulate the interaction between SASL and
a host protocol:

- [SimpleSaslServerCallbackHandler.java](https://github.com/peacekeeper/java-sasl-server-demo/blob/main/src/main/java/demo/sasl/server/SimpleSaslServerCallbackHandler.java)
- [DidSaslServerCallbackHandler.java](https://github.com/peacekeeper/java-sasl-server-demo/blob/main/src/main/java/demo/sasl/server/did/DidSaslServerCallbackHandler.java)

This component is used as the server side in the SASL local "Hello World" demonstration,
see https://github.com/peacekeeper/java-sasl-local-demo.

## About

Markus Sabadello - https://github.com/peacekeeper/

<img align="left" height="40" src="https://github.com/peacekeeper/did-based-sasl/blob/main/docs/logo-ngi-assure.png?raw=true">

This project has received financial support from NLnet and the NGI Assure fund. NGI Assure was established with
financial support from the European Commission's Next Generation Internet programme, under the aegis of DG
Communications Networks, Content and Technology.

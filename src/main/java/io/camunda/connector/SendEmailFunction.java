package io.camunda.connector;

import io.camunda.connector.api.annotation.OutboundConnector;
import io.camunda.connector.api.outbound.OutboundConnectorContext;
import io.camunda.connector.api.outbound.OutboundConnectorFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@OutboundConnector(
    name = "MYCONNECTOR",
    inputVariables = {"recipient", "message", "subject", "authentication"},
    type = "io.camunda:sendmail:1")
public class SendEmailFunction implements OutboundConnectorFunction {

  private static final Logger LOGGER = LoggerFactory.getLogger(SendEmailFunction.class);

  @Override
  public Object execute(OutboundConnectorContext context) throws Exception {
    var connectorRequest = context.getVariablesAsType(SendEmailRequest.class);

    context.validate(connectorRequest);
    context.replaceSecrets(connectorRequest);

    return executeConnector(connectorRequest);
  }

  private SendEmailResult executeConnector(final SendEmailRequest connectorRequest) {
    LOGGER.info("Executing my connector with request {}", connectorRequest);

    EmailSender emailSender = new EmailSender();
    emailSender.send(connectorRequest.getAuthentication(), connectorRequest.getRecipient(), connectorRequest.getSubject(), connectorRequest.getMessage());

    var result = new SendEmailResult();
    result.setMyProperty("Message sent: " + connectorRequest.getMessage());
    return result;
  }
}

package io.camunda.connector;

import io.camunda.connector.api.annotation.Secret;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.Objects;

public class SendEmailRequest {

  @NotEmpty
  private String message;

  @NotEmpty
  private String recipient;

  @NotEmpty
  private String subject;

  @Valid
  @NotNull
  @Secret
  private Authentication authentication;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Authentication getAuthentication() {
    return authentication;
  }

  public void setAuthentication(Authentication authentication) {
    this.authentication = authentication;
  }

  public String getRecipient() {
    return recipient;
  }

  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SendEmailRequest that = (SendEmailRequest) o;
    return Objects.equals(message, that.message) && Objects.equals(recipient, that.recipient) && Objects.equals(subject, that.subject) && Objects.equals(authentication, that.authentication);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, recipient, subject, authentication);
  }

  @Override
  public String toString() {
    return "MyConnectorRequest{" +
            "message='" + message + '\'' +
            ", recipient='" + recipient + '\'' +
            ", subject='" + subject + '\'' +
            ", authentication=" + authentication +
            '}';
  }
}

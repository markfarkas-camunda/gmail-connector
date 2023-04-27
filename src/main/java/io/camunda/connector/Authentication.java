package io.camunda.connector;

import io.camunda.connector.api.annotation.Secret;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import java.util.Objects;

public class Authentication {

  @NotEmpty
  private String user;

  @NotEmpty
  @Secret
  private String password;

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public int hashCode() {
    return Objects.hash(password, user);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Authentication other = (Authentication) obj;
    return Objects.equals(password, other.password) && Objects.equals(user, other.user);
  }

  @Override
  public String toString() {
    return "Authentication [user=" + user + ", password=" + password + "]";
  }
}

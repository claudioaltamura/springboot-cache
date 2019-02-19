package de.claudioaltamura.spring.cache.entity;

import java.util.Objects;

public class Message {

  private long id;

  private String message;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, message);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Message other = (Message) obj;
    return id == other.id && Objects.equals(message, other.message);
  }

  @Override
  public String toString() {
    return "Message [id=" + id + ", message=" + message + "]";
  }

}

package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ChangePasswordObject
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-03T15:24:00.359Z[GMT]")
public class ChangePasswordObject   {
  @JsonProperty("previous_password")
  private String previousPassword = null;

  @JsonProperty("password")
  private String password = null;

  public ChangePasswordObject previousPassword(String previousPassword) {
    this.previousPassword = previousPassword;
    return this;
  }

  /**
   * Get previousPassword
   * @return previousPassword
  **/
  @ApiModelProperty(value = "")
  
  @Size(min=7)   public String getPreviousPassword() {
    return previousPassword;
  }

  public void setPreviousPassword(String previousPassword) {
    this.previousPassword = previousPassword;
  }

  public ChangePasswordObject password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

  @Size(min=7)   public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChangePasswordObject changePasswordObject = (ChangePasswordObject) o;
    return Objects.equals(this.previousPassword, changePasswordObject.previousPassword) &&
        Objects.equals(this.password, changePasswordObject.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(previousPassword, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChangePasswordObject {\n");
    
    sb.append("    previousPassword: ").append(toIndentedString(previousPassword)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

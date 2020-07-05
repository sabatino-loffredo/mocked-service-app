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
 * Claim aggiuntivo dell&#x27;utente
 */
@ApiModel(description = "Claim aggiuntivo dell'utente")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-03T15:24:00.359Z[GMT]")
public class AdditionalClaim   {
  @JsonProperty("uri")
  private String uri = null;

  @JsonProperty("value")
  private String value = null;

  public AdditionalClaim uri(String uri) {
    this.uri = uri;
    return this;
  }

  /**
   * Uri dell'attributo da richiedere
   * @return uri
  **/
  @ApiModelProperty(required = true, value = "Uri dell'attributo da richiedere")
      @NotNull

    public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public AdditionalClaim value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Valore del claim
   * @return value
  **/
  @ApiModelProperty(required = true, value = "Valore del claim")
      @NotNull

    public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdditionalClaim additionalClaim = (AdditionalClaim) o;
    return Objects.equals(this.uri, additionalClaim.uri) &&
        Objects.equals(this.value, additionalClaim.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uri, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdditionalClaim {\n");
    
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

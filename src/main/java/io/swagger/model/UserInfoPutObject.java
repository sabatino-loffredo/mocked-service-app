package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.AdditionalClaim;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserInfoPutObject
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-03T15:24:00.359Z[GMT]")
public class UserInfoPutObject   {
  @JsonProperty("email")
  private String email = null;

  @JsonProperty("phone_number")
  private String phoneNumber = null;

  @JsonProperty("given_name")
  private String givenName = null;

  @JsonProperty("family_name")
  private String familyName = null;

  @JsonProperty("additional_claims")
  @Valid
  private List<AdditionalClaim> additionalClaims = null;

  public UserInfoPutObject email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Email
   * @return email
  **/
  @ApiModelProperty(required = true, value = "Email")
      @NotNull

  @Size(min=1)   public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserInfoPutObject phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * Numero telefonico
   * @return phoneNumber
  **/
  @ApiModelProperty(value = "Numero telefonico")
  
  @Size(min=1)   public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public UserInfoPutObject givenName(String givenName) {
    this.givenName = givenName;
    return this;
  }

  /**
   * Nome
   * @return givenName
  **/
  @ApiModelProperty(required = true, value = "Nome")
      @NotNull

  @Size(min=1)   public String getGivenName() {
    return givenName;
  }

  public void setGivenName(String givenName) {
    this.givenName = givenName;
  }

  public UserInfoPutObject familyName(String familyName) {
    this.familyName = familyName;
    return this;
  }

  /**
   * Cognome
   * @return familyName
  **/
  @ApiModelProperty(required = true, value = "Cognome")
      @NotNull

  @Size(min=1)   public String getFamilyName() {
    return familyName;
  }

  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

  public UserInfoPutObject additionalClaims(List<AdditionalClaim> additionalClaims) {
    this.additionalClaims = additionalClaims;
    return this;
  }

  public UserInfoPutObject addAdditionalClaimsItem(AdditionalClaim additionalClaimsItem) {
    if (this.additionalClaims == null) {
      this.additionalClaims = new ArrayList<AdditionalClaim>();
    }
    this.additionalClaims.add(additionalClaimsItem);
    return this;
  }

  /**
   * Claim addizionali
   * @return additionalClaims
  **/
  @ApiModelProperty(value = "Claim addizionali")
      @Valid
    public List<AdditionalClaim> getAdditionalClaims() {
    return additionalClaims;
  }

  public void setAdditionalClaims(List<AdditionalClaim> additionalClaims) {
    this.additionalClaims = additionalClaims;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserInfoPutObject userInfoPutObject = (UserInfoPutObject) o;
    return Objects.equals(this.email, userInfoPutObject.email) &&
        Objects.equals(this.phoneNumber, userInfoPutObject.phoneNumber) &&
        Objects.equals(this.givenName, userInfoPutObject.givenName) &&
        Objects.equals(this.familyName, userInfoPutObject.familyName) &&
        Objects.equals(this.additionalClaims, userInfoPutObject.additionalClaims);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, phoneNumber, givenName, familyName, additionalClaims);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserInfoPutObject {\n");
    
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    givenName: ").append(toIndentedString(givenName)).append("\n");
    sb.append("    familyName: ").append(toIndentedString(familyName)).append("\n");
    sb.append("    additionalClaims: ").append(toIndentedString(additionalClaims)).append("\n");
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

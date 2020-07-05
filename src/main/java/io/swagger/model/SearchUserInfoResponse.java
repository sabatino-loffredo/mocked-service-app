package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.SearchUserInfoGetObject;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SearchUserInfoResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-03T15:24:00.359Z[GMT]")
public class SearchUserInfoResponse   {
  @JsonProperty("pages")
  private Integer pages = null;

  @JsonProperty("results")
  @Valid
  private List<SearchUserInfoGetObject> results = new ArrayList<SearchUserInfoGetObject>();

  public SearchUserInfoResponse pages(Integer pages) {
    this.pages = pages;
    return this;
  }

  /**
   * Numero pagine disponibili
   * @return pages
  **/
  @ApiModelProperty(required = true, value = "Numero pagine disponibili")
      @NotNull

    public Integer getPages() {
    return pages;
  }

  public void setPages(Integer pages) {
    this.pages = pages;
  }

  public SearchUserInfoResponse results(List<SearchUserInfoGetObject> results) {
    this.results = results;
    return this;
  }

  public SearchUserInfoResponse addResultsItem(SearchUserInfoGetObject resultsItem) {
    this.results.add(resultsItem);
    return this;
  }

  /**
   * Get results
   * @return results
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull
    @Valid
    public List<SearchUserInfoGetObject> getResults() {
    return results;
  }

  public void setResults(List<SearchUserInfoGetObject> results) {
    this.results = results;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchUserInfoResponse searchUserInfoResponse = (SearchUserInfoResponse) o;
    return Objects.equals(this.pages, searchUserInfoResponse.pages) &&
        Objects.equals(this.results, searchUserInfoResponse.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pages, results);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SearchUserInfoResponse {\n");
    
    sb.append("    pages: ").append(toIndentedString(pages)).append("\n");
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
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

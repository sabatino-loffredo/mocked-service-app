/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.20).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.ChangePasswordObject;
import io.swagger.model.Problem;
import io.swagger.model.SearchUserInfoResponse;
import io.swagger.model.UserInfoGetObject;
import io.swagger.model.UserInfoPutObject;
import io.swagger.model.UserRegistrationObject;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-03T15:24:00.359Z[GMT]")
@Api(value = "iam", description = "the iam API")
public interface IamApi {

    @ApiOperation(value = "Consente di verificare la presenza di un utente all'interno di IAM", nickname = "getFindUser", notes = "La risorsa consente di verificare la presenza di utente all'interno di IAM passando come parametro il nome utente; la ricerca **non** è case sensitive ", authorizations = {
        @Authorization(value = "BearerAuth")    }, tags={ "Utenti", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "L'utente è stato trovato"),
        @ApiResponse(code = 404, message = "L'utente non esiste in bancadati") })
    @RequestMapping(value = "/iam/users/{username}/exist",
        method = RequestMethod.GET)
    ResponseEntity<Void> getFindUser(@ApiParam(value = "",required=true) @PathVariable("username") String username
);


    @ApiOperation(value = "Acquisizione profilo utente", nickname = "getMeUserInfo", notes = "La risorsa consente di prendere i dati del profilo dell'utente autenticato ", response = UserInfoGetObject.class, authorizations = {
        @Authorization(value = "BearerAuth")    }, tags={ "Utenti", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "L'utente è stato trovato", response = UserInfoGetObject.class) })
    @RequestMapping(value = "/iam/users/me",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<UserInfoGetObject> getMeUserInfo();


    @ApiOperation(value = "Ricerca utenti", nickname = "getUsersInfo", notes = "La risorsa consente di ricercare tra gli utenti registrati ed i parametri sono esclusivi ovvero non è possibile usarli contemporaneamente. Se si vuole ricercare per un claim particolare si deve utilizzare il campo cn per indicare l'uri del claim e cv per il valore che può contenere il campo con wildcard ", response = SearchUserInfoResponse.class, authorizations = {
        @Authorization(value = "oAuth", scopes = { 
            @AuthorizationScope(scope = "iamapiadmin", description = "Scope necessario per accedere alle API dispositive in cui è presente il parametro utnte")
            })    }, tags={ "Utenti", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Elenco degli utenti che soddisfano i requisiti", response = SearchUserInfoResponse.class) })
    @RequestMapping(value = "/iam/users",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<SearchUserInfoResponse> getUsersInfo(@ApiParam(value = "Nome utente o parte inziale da ricercare") @Valid @RequestParam(value = "un", required = false) String un
,@ApiParam(value = "Indirizzo di posta elettronica o parte iniziale da ricercare") @Valid @RequestParam(value = "em", required = false) String em
,@ApiParam(value = "Cognome o parte iniziale da ricercare") @Valid @RequestParam(value = "fn", required = false) String fn
,@ApiParam(value = "URI del claim WSO2 per eseguire la ricerca") @Valid @RequestParam(value = "cn", required = false) String cn
,@ApiParam(value = "Valore del claim per eseguire la ricerca") @Valid @RequestParam(value = "cv", required = false) String cv
,@ApiParam(value = "Pagina di risultato da restituire. Se non indicato si assulme la prima pagia ovvero 1") @Valid @RequestParam(value = "page", required = false) Integer page
,@ApiParam(value = "Dimensione della pagina dei risultati. Se non indicato assume il valore di 10") @Valid @RequestParam(value = "size", required = false) Integer size
);


    @ApiOperation(value = "Modifica della password dell'utente", nickname = "patchUsersMePasswordChange", notes = "La risorsa consente di modificare la password utente. Se le password coincidono o la nuova non rispetta i vincoli di complessità l'api restituisce lo status http 400. ", authorizations = {
        @Authorization(value = "BearerAuth")    }, tags={ "Utenti", })
    @ApiResponses(value = { 
        @ApiResponse(code = 202, message = "Password modificata correttamente"),
        @ApiResponse(code = 400, message = "Errore durante la modifica della password", response = Problem.class) })
    @RequestMapping(value = "/iam/users/me/password/change",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PATCH)
    ResponseEntity<Void> patchUsersMePasswordChange(@ApiParam(value = "Parametri necessari per l'aggiornamento dei dati utente" ,required=true )  @Valid @RequestBody ChangePasswordObject body
);


    @ApiOperation(value = "Consente la creazione di utente", nickname = "postCreateUser", notes = "La risorsa consente di creare un utente all'interno di IAM; nel caso in cui lo username già esista o la password non rispetti i requisiti minimi di siicurezza l'API restituisce lo status http 400 con un oggetto contenente le informazioni di dettaglio che hanno causato  l'errore.  In caso di esito positivo il valore restituito è 201. ", authorizations = {
        @Authorization(value = "BearerAuth")    }, tags={ "Utenti", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "L'utente è stato correttamente creato"),
        @ApiResponse(code = 400, message = "Il nome utente già esiste o la password non rispetta i requisiti di sicurezza.", response = Problem.class) })
    @RequestMapping(value = "/iam/register",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> postCreateUser(@ApiParam(value = "Parametri necessari per la creazione dell'utente" ,required=true )  @Valid @RequestBody UserRegistrationObject body
);


    @ApiOperation(value = "Modifica della password dell'utente", nickname = "postUsersMePasswordReset", notes = "La risorsa consente di richiedere il reset della password ", authorizations = {
        @Authorization(value = "BearerAuth")    }, tags={ "Utenti", })
    @ApiResponses(value = { 
        @ApiResponse(code = 202, message = "Operazione completata con successo, l'utente riceverà una mail come da processo standard di IAM") })
    @RequestMapping(value = "/iam/users/me/password/reset",
        method = RequestMethod.POST)
    ResponseEntity<Void> postUsersMePasswordReset();


    @ApiOperation(value = "Modifica della password di uno specifico utente", nickname = "postUsersPasswordReset", notes = "La risorsa consente di richiedere il reset della password ", authorizations = {
        @Authorization(value = "oAuth", scopes = { 
            @AuthorizationScope(scope = "iamapiadmin", description = "Scope necessario per accedere alle API dispositive in cui è presente il parametro utnte")
            })    }, tags={ "Utenti", })
    @ApiResponses(value = { 
        @ApiResponse(code = 202, message = "Operazione completata con successo, l'utente riceverà una mail come da processo standard di IAM") })
    @RequestMapping(value = "/iam/users/{username}/password/reset",
        method = RequestMethod.POST)
    ResponseEntity<Void> postUsersPasswordReset(@ApiParam(value = "",required=true) @PathVariable("username") String username
);


    @ApiOperation(value = "Aggiorna profilo utente", nickname = "putMeUserInfo", notes = "La risorsa consente di modificare i dati del profilo utente. ", authorizations = {
        @Authorization(value = "BearerAuth")    }, tags={ "Utenti", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "L'utente è stato aggiornato correttamente") })
    @RequestMapping(value = "/iam/users/me",
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> putMeUserInfo(@ApiParam(value = "Parametri necessari per l'aggiornamento dei dati utente" ,required=true )  @Valid @RequestBody UserInfoPutObject body
);


    @ApiOperation(value = "Aggiorna profilo utente", nickname = "putUserInfo", notes = "La risorsa consente di modificare i dati del profilo di un utente   specifico ", authorizations = {
        @Authorization(value = "oAuth", scopes = { 
            @AuthorizationScope(scope = "iamapiadmin", description = "Scope necessario per accedere alle API dispositive in cui è presente il parametro utnte")
            })    }, tags={ "Utenti", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "L'utente è stato aggiornato correttamente") })
    @RequestMapping(value = "/iam/users/{username}",
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> putUserInfo(@ApiParam(value = "Parametri necessari per l'aggiornamento dei dati utente" ,required=true )  @Valid @RequestBody UserInfoPutObject body
,@ApiParam(value = "",required=true) @PathVariable("username") String username
);

}

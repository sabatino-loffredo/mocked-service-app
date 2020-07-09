package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.*;
import io.swagger.service.UserService;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-03T15:24:00.359Z[GMT]")
@Controller
public class IamApiController implements IamApi {

    private static final Logger log = LoggerFactory.getLogger(IamApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private UserService userService;

    @org.springframework.beans.factory.annotation.Autowired
    public IamApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> getFindUser(@ApiParam(value = "", required = true) @PathVariable("username") String username
    ) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<UserInfoGetObject> getMeUserInfo() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<UserInfoGetObject>(objectMapper.readValue("{\n  \"fiscal_number\" : \"FRSGLC72D05H501J\"\n}", UserInfoGetObject.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UserInfoGetObject>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<UserInfoGetObject>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<SearchUserInfoResponse> getUsersInfo(@ApiParam(value = "Nome utente o parte inziale da ricercare") @Valid @RequestParam(value = "un", required = false) String un
            , @ApiParam(value = "Indirizzo di posta elettronica o parte iniziale da ricercare") @Valid @RequestParam(value = "em", required = false) String em
            , @ApiParam(value = "Cognome o parte iniziale da ricercare") @Valid @RequestParam(value = "fn", required = false) String fn
            , @ApiParam(value = "URI del claim WSO2 per eseguire la ricerca") @Valid @RequestParam(value = "cn", required = false) String cn
            , @ApiParam(value = "Valore del claim per eseguire la ricerca") @Valid @RequestParam(value = "cv", required = false) String cv
            , @ApiParam(value = "Pagina di risultato da restituire. Se non indicato si assulme la prima pagia ovvero 1") @Valid @RequestParam(value = "page", required = false) Integer page
            , @ApiParam(value = "Dimensione della pagina dei risultati. Se non indicato assume il valore di 10") @Valid @RequestParam(value = "size", required = false) Integer size
    ) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {//Utilizzo em come codice Fiscale
                SearchUserInfoResponse searchUserInfoResponse = userService.getUsers(un, em, page, size);
                return new ResponseEntity<SearchUserInfoResponse>(searchUserInfoResponse, HttpStatus.OK);
            } catch (IOException | ParseException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SearchUserInfoResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SearchUserInfoResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> patchUsersMePasswordChange(@ApiParam(value = "Parametri necessari per l'aggiornamento dei dati utente", required = true) @Valid @RequestBody ChangePasswordObject body
    ) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> postCreateUser(@ApiParam(value = "Parametri necessari per la creazione dell'utente", required = true) @Valid @RequestBody UserRegistrationObject body
    ) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                userService.createUser(body);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (IOException | ParseException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> postUsersMePasswordReset() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> postUsersPasswordReset(@ApiParam(value = "", required = true) @PathVariable("username") String username
    ) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> putMeUserInfo(@ApiParam(value = "Parametri necessari per l'aggiornamento dei dati utente", required = true) @Valid @RequestBody UserInfoPutObject body
    ) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> putUserInfo(@ApiParam(value = "Parametri necessari per l'aggiornamento dei dati utente", required = true) @Valid @RequestBody UserInfoPutObject body
            , @ApiParam(value = "", required = true) @PathVariable("username") String username
    ) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                userService.updateUser(username, body);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (IOException | ParseException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}

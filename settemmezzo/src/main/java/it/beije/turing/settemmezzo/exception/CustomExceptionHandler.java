package it.beije.turing.settemmezzo.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/*	RIEPILOGO GESTIONE ECCEZIONI:
 *
 * IllegalHourException 				202
 * UpdateException 						202
 * NoContentException 					204
 * NotExistPcException 					204
 * InvalidArgumentException				400
 * IllegalDateException 				400
 * InvalidJSONException  				400
 * UsernameNotFoundException 			401
 * InvalidJwtAuthenticationException  	401
 * BadCredentialsException  			401
 * ForbiddenException					403
 * AlreadyExistException				406
 * DBException 							503
 * ServiceException  					503
 */


@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

//    private final SimpMessagingTemplate simpMessagingTemplate;

    @ExceptionHandler(value = {NoContentException.class})
    public ResponseEntity<ErrorMessage> ControllerExceptionHandler(NoContentException ex, WebRequest request) {
//		System.out.println("?????? NoContentException");
        int errorCode = 204;
//		ErrorMessage re = new ErrorMessage();
//		re.setMessage(ex.getLocalizedMessage());
//		re.setStatus(errorCode);
//		re.setTime(LocalDateTime.now());
//		log.error(re.getMessage());
        return ResponseEntity.status(errorCode).body(null);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        int errorCode = 400;
        ErrorMessage re = new ErrorMessage();
        re.setMessage("probabilmente il body � vuoto o non valido");
        re.setStatus(errorCode);
        re.setTime(LocalDateTime.now());
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);
        log.error(stringWriter.toString());
        log.error(re.getMessage());
        return ResponseEntity.status(errorCode).body(re);
    }

    @ExceptionHandler(value = {SettemmezzoException.class})
    public ResponseEntity<ErrorMessage> ControllerExceptionHandler(SettemmezzoException ex, WebRequest request) {
        int errorCode = 400;
        ErrorMessage re = new ErrorMessage();
        re.setMessage(ex.getLocalizedMessage());
        re.setStatus(errorCode);
        re.setTime(LocalDateTime.now());
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);
        log.error(stringWriter.toString());
        log.error(re.getMessage());
        return ResponseEntity.status(errorCode).body(re);
    }

    @ExceptionHandler(value = {ForbiddenException.class})
    public ResponseEntity<ErrorMessage> ControllerExceptionHandler(ForbiddenException ex, WebRequest request) {
        int errorCode = 400;
        ErrorMessage re = new ErrorMessage();
        re.setMessage(ex.getLocalizedMessage());
        re.setStatus(errorCode);
        re.setTime(LocalDateTime.now());
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);
        log.error(stringWriter.toString());
        log.error(re.getMessage());
        return ResponseEntity.status(errorCode).body(re);
    }

    @ExceptionHandler(value = {InvalidJSONException.class})
    public ResponseEntity<ErrorMessage> ControllerExceptionHandler(InvalidJSONException ex, WebRequest request) {
        int errorCode = 400;
        ErrorMessage re = new ErrorMessage();
        re.setMessage(ex.getLocalizedMessage());
        re.setStatus(errorCode);
        re.setTime(LocalDateTime.now());
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);
        log.error(stringWriter.toString());
        log.error(re.getMessage());
        return ResponseEntity.status(errorCode).body(re);
    }

    @ExceptionHandler(value = {InvalidArgumentException.class})
    public ResponseEntity<ErrorMessage> ControllerExceptionHandler(InvalidArgumentException ex, WebRequest request) {
        int errorCode = 400;
        ErrorMessage re = new ErrorMessage();
        re.setMessage(ex.getLocalizedMessage());
        re.setStatus(errorCode);
        re.setTime(LocalDateTime.now());
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);
        log.error(stringWriter.toString());
        log.error(re.getMessage());
        return ResponseEntity.status(errorCode).body(re);
    }

    @ExceptionHandler(value = {ExpiredTokenException.class})
    public ResponseEntity<ErrorMessage> ControllerExceptionHandler(ExpiredTokenException ex, WebRequest request) {
        int errorCode = 400;
        ErrorMessage re = new ErrorMessage();
        re.setMessage(ex.getLocalizedMessage());
        re.setStatus(errorCode);
        re.setTime(LocalDateTime.now());
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);
        log.error(stringWriter.toString());
        log.error(re.getMessage());
        return ResponseEntity.status(errorCode).body(re);
    }

    @ExceptionHandler(value = {BadCredentialsException.class})
    public ResponseEntity<ErrorMessage> ControllerExceptionHandler(BadCredentialsException ex, WebRequest request) {
        int errorCode = 401;
        ErrorMessage re = new ErrorMessage();
        re.setMessage(ex.getLocalizedMessage());
        re.setStatus(errorCode);
        re.setTime(LocalDateTime.now());
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);
        log.error(stringWriter.toString());
        log.error(re.getMessage());
        return ResponseEntity.status(errorCode).body(re);
    }

    @ExceptionHandler(value = {UsernameNotFoundException.class})
    public ResponseEntity<ErrorMessage> ControllerExceptionHandler(UsernameNotFoundException ex, WebRequest request) {
        int errorCode = 401;
        ErrorMessage re = new ErrorMessage();
        re.setMessage(ex.getLocalizedMessage());
        re.setStatus(errorCode);
        re.setTime(LocalDateTime.now());
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);
        log.error(stringWriter.toString());
        log.error(re.getMessage());
        return ResponseEntity.status(errorCode).body(re);
    }

    @ExceptionHandler(value = {UserDeactivatedException.class})
    public ResponseEntity<ErrorMessage> ControllerExceptionHandler(UserDeactivatedException ex, WebRequest request) {
        int errorCode = 401;
        ErrorMessage re = new ErrorMessage();
        re.setMessage(ex.getLocalizedMessage());
        re.setStatus(errorCode);
        re.setTime(LocalDateTime.now());
        log.error(re.getMessage());
        return ResponseEntity.status(errorCode).body(re);
    }

    @ExceptionHandler(value = {VerificationTokenException.class})
    public ResponseEntity<ErrorMessage> ControllerExceptionHandler(VerificationTokenException ex, WebRequest request) {
        int errorCode = 401;
        ErrorMessage re = new ErrorMessage();
        re.setMessage(ex.getLocalizedMessage());
        re.setStatus(errorCode);
        re.setTime(LocalDateTime.now());
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);
        log.error(stringWriter.toString());
        log.error(re.getMessage());
        return ResponseEntity.status(errorCode).body(re);
    }

    @ExceptionHandler(value = {GameActionException.class})
    public ResponseEntity<ErrorMessage> ControllerExceptionHandler(GameActionException ex, WebRequest request) {
        log.debug("ControllerExceptionHandler ");
        int errorCode = 406;
        ErrorMessage re = new ErrorMessage();
        String[] str = ex.getLocalizedMessage().split("%");
        re.setMessage(str[1]);
        re.setStatus(errorCode);
        re.setTime(LocalDateTime.now());
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);
        log.error(stringWriter.toString());
        log.error(re.getMessage());
        log.debug(str[0]);
        return ResponseEntity.status(errorCode).body(re);
    }

    @ExceptionHandler(value = {AlreadyExistException.class})
    public ResponseEntity<ErrorMessage> ControllerExceptionHandler(AlreadyExistException ex, WebRequest request) {
        int errorCode = 406;
        ErrorMessage re = new ErrorMessage();
        re.setMessage(ex.getLocalizedMessage());
        re.setStatus(errorCode);
        re.setTime(LocalDateTime.now());
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);
        log.error(stringWriter.toString());
        log.error(re.getMessage());
        return ResponseEntity.status(errorCode).body(re);
    }

    @ExceptionHandler(value = {DBException.class})
    public ResponseEntity<ErrorMessage> ControllerExceptionHandler(DBException ex, WebRequest request) {
        int errorCode = 503;
        ErrorMessage re = new ErrorMessage();
        re.setMessage(ex.getLocalizedMessage());
        re.setStatus(errorCode);
        re.setTime(LocalDateTime.now());
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);
        log.error(stringWriter.toString());
        log.error(re.getMessage());
        return ResponseEntity.status(errorCode).body(re);
    }

}
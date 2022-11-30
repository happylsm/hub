package hubSideProject.hubApi.common.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import hubSideProject.hubApi.common.dto.ErrorResDto;

@RestControllerAdvice(annotations = {RestController.class})
public class HubExceptionHandler extends ResponseEntityExceptionHandler{
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> validation(ConstraintViolationException e, WebRequest request) {
        return handleExceptionInternal(e, HubExceptionCode.BAD_REQUEST, request);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> general(HubException e, WebRequest request) {
        return handleExceptionInternal(e, e.getErrorCode(), request);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<Object> exception(Exception e, WebRequest request) {
        return handleExceptionInternal(e, HubExceptionCode.INTERNAL_ERROR, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
        HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, HubExceptionCode.valueOf(status), headers, status, request);
    }


    private ResponseEntity<Object> handleExceptionInternal(Exception e, HubExceptionCode errorCode,
        WebRequest request) {
        return handleExceptionInternal(e, errorCode, HttpHeaders.EMPTY, errorCode.getHttpStatus(),
            request);
    }

    private ResponseEntity<Object> handleExceptionInternal(Exception e, HubExceptionCode errorCode,
        HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleExceptionInternal(
            e,
            ErrorResDto.of(errorCode, errorCode.getMessage(e)),
            headers,
            status,
            request
        );
    }
}

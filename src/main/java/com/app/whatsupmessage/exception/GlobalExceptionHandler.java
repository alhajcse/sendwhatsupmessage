package com.app.whatsupmessage.exception;
import com.app.whatsupmessage.response.ResponseMessage;
import com.app.whatsupmessage.utils.ResponseBuilder;
import com.fasterxml.jackson.core.JsonParseException;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import static com.app.whatsupmessage.constant.ValidatorConstants.CUSTOM_MESSAGE;
import static com.app.whatsupmessage.constant.ValidatorConstants.RESOURCE_NOT_FOUND;


@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<JSONObject> handleNotFoundExceptions(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ResponseBuilder.error((ex.getMessage() + " " + RESOURCE_NOT_FOUND)).getJson(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(
            CustomMessagePresentException.class)
    public ResponseEntity<JSONObject> handleCustomMessagePresentExceptions(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ResponseBuilder.error(null, (ex.getMessage() + " " + CUSTOM_MESSAGE)).getJson(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ResponseMessage> handleMaxSizeException(MaxUploadSizeExceededException exc) {
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("File too large!"));
    }

    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<JSONObject> handleJsonParseException(JsonParseException exc) {
        return new ResponseEntity<>(ResponseBuilder.error(null, exc.getMessage()).getJson(), HttpStatus.BAD_REQUEST);
    }


}

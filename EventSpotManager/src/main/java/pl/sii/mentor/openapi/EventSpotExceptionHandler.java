package pl.sii.mentor.openapi;


import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.*;
import pl.sii.mentor.openapi.model.*;

@ControllerAdvice
public class EventSpotExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {EventSpotException.class})
    protected ResponseEntity<Object> handleEventSpotException(EventSpotException eventSpotException) {

        EventSpotError eventErrorResponse = new EventSpotError();
        eventErrorResponse.setMessage(eventSpotException.getMessage());
        return new ResponseEntity<>(eventErrorResponse, HttpStatus.NOT_FOUND);
    }
}

package gov.ma.apiseap.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MatriculaInvalidaException extends Throwable{
    public MatriculaInvalidaException(String message) {
        super(message);
    }
}

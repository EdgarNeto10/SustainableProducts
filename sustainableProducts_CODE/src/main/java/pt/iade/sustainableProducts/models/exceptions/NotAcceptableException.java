package pt.iade.sustainableProducts.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class NotAcceptableException extends RuntimeException {
    private static final long serialVersionUID = 5405519104069955535L;

    public NotAcceptableException(int id, String elemType, String idName) {
        super(elemType + ": " + idName + " with id " + id + " not accetable");
    }

}

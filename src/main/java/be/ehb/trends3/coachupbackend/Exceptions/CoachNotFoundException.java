package be.ehb.trends3.coachupbackend.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CoachNotFoundException extends RuntimeException {
}

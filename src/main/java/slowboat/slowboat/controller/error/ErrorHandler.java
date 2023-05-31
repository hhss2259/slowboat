package slowboat.slowboat.controller.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import slowboat.slowboat.error.LastBoatException;
import slowboat.slowboat.model.basic.DefaultRes;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(LastBoatException.class)
    public DefaultRes duplicateNickname(LastBoatException e) {
        return DefaultRes.res(40005, "마지막 Boat 입니다");
    }
}

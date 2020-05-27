package come.test.hplus.exceptions;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionsHandler {

    @ExceptionHandler(ApplicationException.class)
    public String handleException(){
        System.out.println("in global exception handler");
        return "error";
    }
}

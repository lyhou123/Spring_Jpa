package org.pratice.praticejpa.advisor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestControllerAdvice
public class ProductAdvicsor {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e){
     List<Map<String,Object>> result=
             e.getBindingResult().getFieldErrors().stream()
             .map(err->{
                 Map<String,Object> error = new HashMap<>();
                 error.put("field",err.getField());
                 error.put("message",err.getDefaultMessage());
                 error.put("objectName",err.getObjectName());
                 return error;
             }).toList();
             return Map.of("errors",result);
    }
}

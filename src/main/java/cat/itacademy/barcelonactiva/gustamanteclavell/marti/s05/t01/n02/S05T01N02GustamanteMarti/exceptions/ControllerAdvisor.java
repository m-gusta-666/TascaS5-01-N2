package cat.itacademy.barcelonactiva.gustamanteclavell.marti.s05.t01.n02.S05T01N02GustamanteMarti.exceptions;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler{

	@ExceptionHandler(FlorNoTrobadaException.class)
	public ResponseEntity<Object> gestioFlorNoTrobadaException(FlorNoTrobadaException e, WebRequest request) {
		Map<String,Object> body = new LinkedHashMap<>();
		body.put("timestamp",LocalDateTime.now());
		body.put("message","No s'ha trobat cap flor amb aquest Id");
		return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(SenseFlorsException.class)
	public ResponseEntity<Object> gestioSenseFlorsException(SenseFlorsException e, WebRequest request) {
		Map<String,Object> body = new LinkedHashMap<>();
		body.put("timestamp",LocalDateTime.now());
		body.put("message","No hi ha cap flor a la base de dades");
		return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> gestioException(Exception e, WebRequest request) {
		Map<String,Object> body = new LinkedHashMap<>();
		body.put("timestamp",LocalDateTime.now());
		body.put("message","Hi ha hagut algun error inesperat");
		return new ResponseEntity<>(body,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
        HttpMessageNotReadableException ex, HttpHeaders headers,
        HttpStatus status, WebRequest request) {
		Map<String,Object> body = new LinkedHashMap<>();
		body.put("timestamp",LocalDateTime.now());
		body.put("message","La petició no té cos");
		return new ResponseEntity<>(body,HttpStatus.BAD_REQUEST);
    }
	
}

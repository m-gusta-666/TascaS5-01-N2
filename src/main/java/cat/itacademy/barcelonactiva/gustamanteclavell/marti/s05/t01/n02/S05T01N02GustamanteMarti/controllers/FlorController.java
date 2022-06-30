package cat.itacademy.barcelonactiva.gustamanteclavell.marti.s05.t01.n02.S05T01N02GustamanteMarti.controllers;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.gustamanteclavell.marti.s05.t01.n02.S05T01N02GustamanteMarti.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.gustamanteclavell.marti.s05.t01.n02.S05T01N02GustamanteMarti.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.gustamanteclavell.marti.s05.t01.n02.S05T01N02GustamanteMarti.model.services.FlorEntityService;


@RequestMapping("/flor")
@RestController
public class FlorController {

	
	
	@Autowired
	FlorEntityService florService;
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<FlorDTO>> llistarFlors(){
		return new ResponseEntity<>(florService.getAll(),HttpStatus.OK);
	}
	
	
	@GetMapping("/getOne/{id}")
	public FlorDTO llistarFlor(@PathVariable("id") int id) {
		return florService.getOneDTO(id);
	}
	
	
	
	@PostMapping("/add")
	public ResponseEntity<Object> afegirFlor(@RequestBody FlorEntity flor) {
		
		FlorDTO novaFlor = florService.add(flor);
		
		Map<String,Object> body = new LinkedHashMap<>();
		body.put("timestamp",LocalDateTime.now());
		body.put("message","La següent flor s'ha guardat correctament");
		body.put("flor", novaFlor);
		return new ResponseEntity<>(body,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> modificarFlor(@PathVariable("id") int id, @RequestBody FlorEntity flor) {
		
		FlorDTO novaFlor = florService.updateOne(id, flor);
		
		Map<String,Object> body = new LinkedHashMap<>();
		body.put("timestamp",LocalDateTime.now());
		body.put("message","La següent flor s'ha guardat correctament");
		body.put("flor", novaFlor);
		return new ResponseEntity<>(body,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> eliminarFLor(@PathVariable("id") int id) {
		
		florService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}

package me.bgi.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.bgi.demo.exceptions.AngestellterNotFoundException;
import me.bgi.demo.models.Angestellter;
import me.bgi.demo.service.AngestellterService;

@RestController
@RequestMapping("/angestellter")
@CrossOrigin(origins = "http://localhost:4200")
public class AngestellterController {
	
	@Autowired
	private AngestellterService anService;
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Angestellter>> findAll() {
		return ResponseEntity.ok(anService.findAll());
	}
	
	@GetMapping("/findByVorname/{vorname}")
	public ResponseEntity<Angestellter> findByVorname(@PathVariable("vorname") String vorname) {
		try {
			Angestellter angestellter = anService.findByVorname(vorname);
			return new ResponseEntity<Angestellter>(angestellter, HttpStatus.OK);
		} catch(AngestellterNotFoundException e) {
			return new ResponseEntity<Angestellter>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/addAngestellter")
	public ResponseEntity<Angestellter> addAngestellter(@RequestBody Angestellter angestellter) {
		try {
			Angestellter newAngestellter = anService.addAngestellter(angestellter);
			return ResponseEntity.ok(newAngestellter);
		} catch(IllegalArgumentException e) {
			return new ResponseEntity<Angestellter>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteAngestellter/{id}")
	public ResponseEntity<?> deleteAngestellter(@PathVariable("id") Long id) {
		if(anService.deleteAngestellter(id)) {
			return ResponseEntity.ok().build();
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
}

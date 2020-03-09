package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PersonneRepository;
import com.example.demo.entite.Personne;

@RestController
@CrossOrigin("*")
@RequestMapping("/rest")
public class PersonneController {
	
	@Autowired
	private PersonneRepository personneRepository;
	
	@GetMapping(value = "/listPersonne")
	public List<Personne> listAll() {
		return personneRepository.findAll();
	}

	@GetMapping(value = "/show/{id}")
	public Personne listOne(@PathVariable(name = "id") Long id) {
		return personneRepository.findById(id).get();
	}

	@PutMapping(value = "/update")
	public Personne update(/*@PathVariable(name = "id") Long id,*/ @RequestBody Personne p) {
		/*p.setId(id);*/
		return personneRepository.save(p);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
	 personneRepository.deleteById(id);
		 	
	}

	@PostMapping(value = "/add")
	public Personne save(@RequestBody Personne p) {
		return personneRepository.save(p);
	}
	
	@GetMapping(value="/cherchermc")
	public List<Personne> serchParMC(@RequestParam(name="mc", defaultValue="") String mc){
		return personneRepository.chercher("%"+mc+"%");	
	}
	
	
}

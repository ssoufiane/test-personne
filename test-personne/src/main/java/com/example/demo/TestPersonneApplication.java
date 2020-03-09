package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.PersonneRepository;
import com.example.demo.entite.Personne;

@SpringBootApplication
public class TestPersonneApplication implements CommandLineRunner{
	@Autowired
	private PersonneRepository personneRepository;

	public static void main(String[] args) {
		SpringApplication.run(TestPersonneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		personneRepository.save(new Personne(null, "souf","souf"));
		personneRepository.save(new Personne(null, "sami","sami"));
		personneRepository.save(new Personne(null, "pierre","pierre"));
	}

}

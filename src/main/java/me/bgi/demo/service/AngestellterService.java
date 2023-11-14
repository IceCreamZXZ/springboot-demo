package me.bgi.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import me.bgi.demo.exceptions.AngestellterNotFoundException;
import me.bgi.demo.models.Angestellter;
import me.bgi.demo.repositorys.AngestellterRepository;

@Service
@Transactional
public class AngestellterService {
	
	@Autowired
	private AngestellterRepository anRepo;

	public Angestellter addAngestellter(Angestellter angestellter) throws IllegalArgumentException {
		return anRepo.save(angestellter);
	}
	
	public List<Angestellter> findAll() {
		return anRepo.findAll();
	}
	
	public Angestellter findByVorname(String vorname) throws AngestellterNotFoundException {
		return anRepo.findByVorname(vorname).orElseThrow(() -> new AngestellterNotFoundException("Could not find Angestellter with vorname " + vorname));
	}
	
	public boolean deleteAngestellter(Long id) {
		try {
			anRepo.deleteById(id);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
	
}

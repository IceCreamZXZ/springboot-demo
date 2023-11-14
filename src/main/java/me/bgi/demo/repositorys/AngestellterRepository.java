package me.bgi.demo.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.bgi.demo.models.Angestellter;

@Repository
public interface AngestellterRepository extends JpaRepository<Angestellter, Long> {
	
	Optional<Angestellter> findByVorname(String vorname);

}

package com.ranch.repos;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.ranch.model.Cattle;

@CrossOrigin()
public interface CattleRepo extends JpaRepository<Cattle, Long> {
	Page<Cattle> findByCattleId(@RequestParam long id, Pageable pageable);
	
	Page<Cattle> findByBirthday(@RequestParam Date bday, Pageable pageable);
}
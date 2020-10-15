package com.ranch.repos;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.ranch.model.Cattle;
import com.ranch.model.enums.CattleTypes;
import com.ranch.model.enums.SexType;

@CrossOrigin()
public interface CattleRepo extends JpaRepository<Cattle, Long> {
	Page<Cattle> findById(@RequestParam long id, Pageable pageable);
	
	Page<Cattle> findByBday(@RequestParam Date bday, Pageable pageable);
	
	Page<Cattle> findBySex(@RequestParam SexType sex, Pageable pageable);
	
	Page<Cattle> findByBreed(@RequestParam CattleTypes breed, Pageable pageable);
}
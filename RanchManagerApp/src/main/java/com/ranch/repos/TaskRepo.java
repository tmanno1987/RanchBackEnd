package com.ranch.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.ranch.model.Tasks;

@CrossOrigin
public interface TaskRepo extends JpaRepository<Tasks, Long> {
	Page<Tasks> findByCategoryId(@RequestParam("id") long id, Pageable pageable);
	
	Page<Tasks> findByTid(@RequestParam(name="tid") long id, Pageable pageable);

	Page<Tasks> findByName(@RequestParam(name="name") String name, Pageable pageable);

	Page<Tasks> findByNameContaining(@RequestParam(name="name") String name, Pageable pageable);
}
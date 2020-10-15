package com.ranch.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.ranch.model.Expense;

@CrossOrigin()
public interface ExpenseRepo extends JpaRepository<Expense, Long> {
	Page<Expense> findByAmount(@RequestParam double amount, Pageable pageable);
	
	Page<Expense> findByEid(@RequestParam long eid, Pageable pageable);
}
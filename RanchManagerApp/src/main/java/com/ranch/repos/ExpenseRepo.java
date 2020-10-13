package com.ranch.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ranch.model.Expense;

@CrossOrigin()
public interface ExpenseRepo extends JpaRepository<Expense, Long> {

}
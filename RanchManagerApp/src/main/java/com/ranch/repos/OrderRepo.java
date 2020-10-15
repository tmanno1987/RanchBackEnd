package com.ranch.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.ranch.model.Order;

@CrossOrigin()
public interface OrderRepo extends JpaRepository<Order, Long> {
	Page<Order> findByOid(@RequestParam(name="oid") long oid, Pageable pageable);
	
}
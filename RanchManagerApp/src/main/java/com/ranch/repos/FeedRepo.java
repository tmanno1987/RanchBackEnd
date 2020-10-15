package com.ranch.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.ranch.model.Feed;

@CrossOrigin()
public interface FeedRepo extends JpaRepository<Feed, Long> {
	Page<Feed> findByName(@RequestParam String name, Pageable pageable);
}
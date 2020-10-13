package com.ranch.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ranch.model.Feed;

@CrossOrigin()
public interface FeedRepo extends JpaRepository<Feed, Long> {

}
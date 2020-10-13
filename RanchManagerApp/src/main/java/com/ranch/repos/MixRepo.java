package com.ranch.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ranch.model.Mix;

@CrossOrigin()
public interface MixRepo extends JpaRepository<Mix, Long> {

}

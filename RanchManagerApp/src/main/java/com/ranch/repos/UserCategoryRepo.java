package com.ranch.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ranch.model.UserCategory;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel="userCategory", path="user-category")
public interface UserCategoryRepo extends JpaRepository<UserCategory, Long> {

}
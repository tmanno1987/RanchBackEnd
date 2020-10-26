package com.ranch.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ranch.model.CattleCategory;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel="cattleCategory", path="cattle-category")
public interface CattleCategoryRepo extends JpaRepository<CattleCategory, Long> {

}
package com.ranch.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class MyConfiguration implements RepositoryRestConfigurer {
	private EntityManager entityManager;

	@Autowired
	public MyConfiguration(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		exposeIds(config);
	}
	
	private void exposeIds(RepositoryRestConfiguration config) {

		Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
		@SuppressWarnings("rawtypes")
		List<Class> entityClasses = new ArrayList<>();
		// - get the entity types for the entities
		for (@SuppressWarnings("rawtypes") EntityType tempEntityType : entities) {

			entityClasses.add(tempEntityType.getJavaType());
			@SuppressWarnings("rawtypes")
			Class[] domainTypes = entityClasses.toArray(new Class[0]);
			config.exposeIdsFor(domainTypes);
		}

	}
}

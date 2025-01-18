package com.springboot.app.SpringBootApp.dao;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.springboot.app.SpringBootApp.model.EmployeeModel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Configuration
@EnableJpaRepositories(
    basePackages = {
        "com.springboot.app.SpringBootApp.dao"
    }
)
public class EmployeeRepository extends SimpleJpaRepository<EmployeeModel, Long>{

	public EmployeeRepository(EntityManager entityManager) {
		super(EmployeeModel.class, entityManager);
		
	}

	
		
	

}

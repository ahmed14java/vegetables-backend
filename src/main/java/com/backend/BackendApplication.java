package com.backend;

import com.backend.enums.RoleTypes;
import com.backend.model.Role;
import com.backend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner{

	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (roleRepository.findAll().size() == 0){
			Role role1 = new Role();
			role1.setName(RoleTypes.ROLE_USER);
			Role role2 = new Role();
			role2.setName(RoleTypes.ROLE_ADMIN);
			Role role3 = new Role();
			role3.setName(RoleTypes.ROLE_PM);
			roleRepository.save(role1);
			roleRepository.save(role2);
			roleRepository.save(role3);
		}
	}
}

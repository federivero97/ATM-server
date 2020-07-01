package com.federivero.atmserver;

import com.federivero.atmserver.entity.UserEntity;
import com.federivero.atmserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class AtmServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmServerApplication.class, args);
	}

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void initUsers() {
		List<UserEntity> users = Stream.of(
				new UserEntity("admin", "admin")
		).collect(Collectors.toList());
		repository.saveAll(users);
	}
}

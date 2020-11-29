package com.example.demo;

import com.example.demo.Model.AppRole;
import com.example.demo.Service.AccountService;
import com.example.demo.Service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Resource
	StorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);


	}
	@Bean
	BCryptPasswordEncoder getBCPE(){return  new BCryptPasswordEncoder();}


//	@Override
//	public void run(String... args) throws Exception {
//		storageService.deleteAll();
//		storageService.init();
//
//	}
	CommandLineRunner start(AccountService accountService){
		return args->{accountService.save(new AppRole("Admin"));
			accountService.save(new AppRole("Visiteur"));
			accountService.save(new AppRole("Association"));

	};

}

	@Override
	public void run(String... args) throws Exception {

	}
}
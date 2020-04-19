package com.edu.nbu.cn.hateoas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.edu.nbu.cn"})
public class HateoasApplication {

	public static void main(String[] args) {
		SpringApplication.run(HateoasApplication.class, args);
	}

}

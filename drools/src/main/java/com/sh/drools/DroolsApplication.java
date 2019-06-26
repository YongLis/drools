package com.sh.drools;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.sh.drools")
@MapperScan(basePackages = "com.sh.drools.dal.mapper")
//@EnableSpringHttpSession
public class DroolsApplication {

    public static void main(String[] args) {
		SpringApplication.run(DroolsApplication.class, args);
	}

}

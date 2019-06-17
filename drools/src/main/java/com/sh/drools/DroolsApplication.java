package com.sh.drools;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.sh.drools")
/*@MapperScan(basePackages = "com.sh.drools.dal.mapper")*/
public class DroolsApplication {
    public static void main(String[] args) {
		SpringApplication.run(DroolsApplication.class, args);
	}

}

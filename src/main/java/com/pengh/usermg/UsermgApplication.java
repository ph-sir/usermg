package com.pengh.usermg;

import com.didispace.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.pengh.usermg.dao")
@EnableTransactionManagement
//@EnableScheduling
@EnableCaching
@EnableSwagger2Doc
public class UsermgApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsermgApplication.class, args);
    }

}

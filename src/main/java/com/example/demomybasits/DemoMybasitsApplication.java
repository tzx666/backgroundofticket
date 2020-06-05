package com.example.demomybasits;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.example.demomybasits")
@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
public class DemoMybasitsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoMybasitsApplication.class, args);
    }

}

package cn.enjoy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.enjoy.mapper")
public class App {
	
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	
}

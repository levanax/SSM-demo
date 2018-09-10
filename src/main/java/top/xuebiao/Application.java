package top.xuebiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@ServletComponentScan
@PropertySource(value="classpath:application-private.properties",encoding="utf-8")
public class Application {
	
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
}

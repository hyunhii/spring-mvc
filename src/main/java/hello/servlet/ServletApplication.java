package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}

	//스프링부트가 application.properties에 저장한 설정정보를 가져와 아래와 같이 자동으로 등록한다.
	/*@Bean
	ViewResolver internalResourveViewResolver() {
		return new InternalResourceViewResolver("/WEB/INF/views/", "jsp");
	}*/
}

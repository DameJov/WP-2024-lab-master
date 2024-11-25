package mk.finki.ukim.mk.wp2024.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class Wp2024LabApplication {

	public static void main(String[] args) {
		SpringApplication.run(Wp2024LabApplication.class, args);
	}

}

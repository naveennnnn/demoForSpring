package com.example.demoForSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//cmd /c "set "JAVA_HOME=C:\Users\naveen.b\jdk\jdk-24.0.2" && mvnw.cmd clean compile -q"
// $env:JAVA_HOME = "C:\Users\naveen.b\jdk\jdk-24.0.2"
// .\mvnw.cmd clean spring-boot:run   
@SpringBootApplication(
	scanBasePackages={"com.example.demoForSpring","com.example.util"}
)// as a default the spring boot will scan the code for dependency inject only inside the DemoForSpringAppilication package, to extebd them we have to do this.
public class DemoForSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoForSpringApplication.class, args);
	}

}
// The default scope of a bean in springboot - Singleton

// ./mvnw clean package -DskipTests
// java -jar target/DemoForSpring.jar

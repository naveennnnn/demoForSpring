package com.example.demoForSpring;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demoForSpring.Models_entity.Student;
import com.example.demoForSpring.dao.StudentDAO;
import com.example.demoForSpring.dao.StudentDaoImpl;


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


	@Bean
	public CommandLineRunner commandLineApp(StudentDaoImpl studentDaoImpl){ // this function will be executed after the spring beans are loaded.
		return runner -> {
			// createAndSaveStudent(studentDaoImpl);
			// updateStudent(studentDaoImpl);

			// deleteStudent(studentDaoImpl);

			// deleteAllStudent(studentDaoImpl);
		};
	}


	private void deleteAllStudent(StudentDaoImpl studentDaoImpl) {
		int rows = studentDaoImpl.deleteAll();
		System.out.println("Number of rows deleted: "+rows);
	}


	private void deleteStudent(StudentDaoImpl studentDaoImpl) {
		studentDaoImpl.delete(1);
	}


	private void updateStudent(StudentDaoImpl studentDaoImpl) {
		Student student = studentDaoImpl.findById(2000);

		student.setFirstName("Hello");

		studentDaoImpl.update(student);
	}


	private void readStudent(StudentDAO studentDaoImpl) {
		System.out.println("Createing the student");
		Student student = new Student("Arun","Chermadurai","arun@gmail.com","url");

		System.out.println("Saving the student");
		studentDaoImpl.save(student);

		int id = student.getId();

		System.out.println("Student Saved with ID: "+id);

		Student myStudent = studentDaoImpl.findById(id);
		System.out.println("The retrieved student is : "+myStudent);
	}


	private void createAndSaveStudent(StudentDAO studentDaoImpl) {
		System.out.println("Createing the student");
		Student student = new Student("Naveen","Boopathy","naveen@gmail.com","url");

		System.out.println("Saving the student");
		studentDaoImpl.save(student);

		System.out.println("Student Saved with ID: "+student.getId());
	} 


	public void readAll(StudentDAO studentDaoImpl){
		List<Student> students = studentDaoImpl.findAll();

		for(Student student: students){
			System.out.println(student.getId()+" "+student.getFirstName());
		}
	}

}

// The default scope of a bean in springboot - Singleton

// ./mvnw clean package -DskipTests
// java -jar target/DemoForSpring.jar

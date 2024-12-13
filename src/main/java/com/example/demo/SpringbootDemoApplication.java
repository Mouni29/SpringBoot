package com.example.demo;

import com.example.demo.models.Address;
import com.example.demo.models.Gender;
import com.example.demo.models.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(StudentRepository repository,
//							 MongoTemplate mongoTemplate) {
//		return args -> {
//			Address address = new Address("India","Hyd");
//			Student student = new Student("Janu","G",
//					Gender.Female,address, List.of("Maths"),
//					BigDecimal.TEN, LocalDateTime.now());
//			repository.findStudentByFirstName("Janu")
//					.ifPresentOrElse(s ->{
//								System.out.println(s+ " already exist");
//					},()->{
//						repository.save(student);
//					});
//		};
//		};


	private void usingMongoTemplateAndQuery(StudentRepository repository,MongoTemplate mongoTemplate,Student student) {
		Query query = new Query();
		query.addCriteria(Criteria.where("firstName").is("Prag"));
		List<Student> students = mongoTemplate.find(query, Student.class);
		if (students.isEmpty()){
			repository.insert(student);
		}else{
			System.out.println(student+" already exists");
		}
	}

}

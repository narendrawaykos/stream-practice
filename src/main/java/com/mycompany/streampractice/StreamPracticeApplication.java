package com.mycompany.streampractice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mycompany.streampractice.entity.Employee;

@SpringBootApplication
public class StreamPracticeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StreamPracticeApplication.class, args);
	}

	List<Employee> employees = new ArrayList<Employee>();
	
	@Override
	public void run(String... args) throws Exception {

		employees.add(new Employee(1l, "Suraj", BigDecimal.valueOf(68000)));
		employees.add(new Employee(2l, "Akshay", BigDecimal.valueOf(56000)));
		employees.add(new Employee(3l, "Nilesh", BigDecimal.valueOf(44000)));
		employees.add(new Employee(4l, "Bob", BigDecimal.valueOf(23000)));
	}

	public void namesOfEmployee() {
		List<String> empNames = employees.stream().map(Employee::getName).collect(Collectors.toList());
		System.out.println(empNames);
	}

}

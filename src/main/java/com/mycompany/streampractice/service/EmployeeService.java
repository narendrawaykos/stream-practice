package com.mycompany.streampractice.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mycompany.streampractice.entity.Employee;

@Service
public class EmployeeService {
	
	static List<Employee> employees = new ArrayList<Employee>();
	
	public EmployeeService() {
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

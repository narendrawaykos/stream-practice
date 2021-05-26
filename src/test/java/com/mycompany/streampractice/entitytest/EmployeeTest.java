package com.mycompany.streampractice.entitytest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mycompany.streampractice.entity.Employee;

public class EmployeeTest {

	static List<Employee> employees = new ArrayList<Employee>();
	
	@BeforeAll
	static void beforeAll() {
		employees.add(new Employee(1l, "Suraj", BigDecimal.valueOf(68000)));
		employees.add(new Employee(2l, "Akshay", BigDecimal.valueOf(56000)));
		employees.add(new Employee(3l, "Nilesh", BigDecimal.valueOf(44000)));
		employees.add(new Employee(4l, "Bob", BigDecimal.valueOf(23000)));
	}
	
	@Test
	void minSalaryTest() {
		Optional<BigDecimal> maxSalary = employees.stream().map(Employee::getSalary).collect(Collectors.maxBy(BigDecimal::compareTo));
		assertEquals(BigDecimal.valueOf(68000), maxSalary.get());
	}
	
	@Test
	void maxSalaryTest() {
		Optional<BigDecimal> minSalary = employees.stream().map(Employee::getSalary).min(BigDecimal::compareTo);
		assertEquals(BigDecimal.valueOf(23000), minSalary.get());
	}
	
	@Test
	void sortEmployeeBySalaryTest() {
		List<Employee> ascendingBySalary= employees.stream().sorted((a, b) -> a.getSalary().compareTo(b.getSalary())).collect(Collectors.toList());
		List<Employee> emps = new ArrayList<Employee>();
		emps.add(new Employee(4l, "Bob", BigDecimal.valueOf(23000)));
		emps.add(new Employee(3l, "Nilesh", BigDecimal.valueOf(44000)));
		emps.add(new Employee(2l, "Akshay", BigDecimal.valueOf(56000)));
		emps.add(new Employee(1l, "Suraj", BigDecimal.valueOf(68000)));
		
		assertArrayEquals(emps.toArray(), ascendingBySalary.toArray());
		
		
		List<Employee> descendingBySalary= employees.stream().sorted((a, b) -> b.getSalary().compareTo(a.getSalary())).collect(Collectors.toList());
		List<Employee> emps2 = new ArrayList<Employee>();
		emps2.add(new Employee(1l, "Suraj", BigDecimal.valueOf(68000)));
		emps2.add(new Employee(2l, "Akshay", BigDecimal.valueOf(56000)));
		emps2.add(new Employee(3l, "Nilesh", BigDecimal.valueOf(44000)));
		emps2.add(new Employee(4l, "Bob", BigDecimal.valueOf(23000)));
		assertArrayEquals(emps2.toArray(), descendingBySalary.toArray());
	}
	
	
	@Test
	void averageSalary() {
		Optional<BigDecimal[]> totalSal = employees.stream().map(Employee::getSalary).filter(e -> e != null).map(s -> new BigDecimal[] {s, BigDecimal.ONE}).reduce((a, b) -> new BigDecimal[] {a[0].add(b[0]), a[1].add(b[1])});
		BigDecimal avgSal = totalSal.get()[0].divide(totalSal.get()[1]);
		// avg sal = 47750
		assertEquals(BigDecimal.valueOf(47750), avgSal);
	}
	
	
}

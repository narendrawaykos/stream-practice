package com.mycompany.streampractice.entitytest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mycompany.streampractice.entity.Gender;
import com.mycompany.streampractice.entity.Student;

public class StudentTest {

	static List<Student> students = new ArrayList<Student>();

	@BeforeAll
	static void beforeAll() {
		students.add(new Student(1l, "Aman", Gender.M));
		students.add(new Student(2l, "Rutuja", Gender.F));
		students.add(new Student(3l, "Mahesh", Gender.M));
		students.add(new Student(4l, "Priya", Gender.F));
	}
	
	@Test
	void groupByMaleFemale() {
		Map<Gender, List<Student>> maleFemale = students.stream().collect(Collectors.groupingBy(Student::getGender));
		assertEquals(2, maleFemale.get(Gender.M).size());
		assertEquals(2, maleFemale.get(Gender.F).size());
	}
	
	
}

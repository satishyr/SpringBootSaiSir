package com.sai;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sai.entities.Course;
import com.sai.entities.Student;
import com.sai.repositories.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDataApp6ApplicationTests {
	
	@Autowired
	private StudentRepository studentRepository;

	@Test
	@Transactional
	@Rollback(false)
	public void createStudent_withCourseEnrollment() {
		Student student=new Student();
		student.setName("kiran");
		student.setBranch("CSE");
		
		ArrayList<Student> studentList=new ArrayList<>();
		studentList.add(student);
		
		Course course1=new Course();
		course1.setName("corejava");
		course1.setDuration(40);
		course1.setFaculty("sai");
		course1.setStudentList(studentList);
		
		Course course2=new Course();
		course2.setName("spring boot");
		course2.setDuration(50);
		course2.setFaculty("sai");
		course2.setStudentList(studentList);
	
	    ArrayList<Course> courseList=new ArrayList<>();
	    courseList.add(course1);
	    courseList.add(course2);
	    
	    student.setCourseList(courseList);
	    
	    Student st=studentRepository.save(student);
	    
	    assertTrue(st != null);
	}

}

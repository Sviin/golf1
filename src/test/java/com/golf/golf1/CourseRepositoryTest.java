package com.golf.golf1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.golf.golf1.domain.Course;
import com.golf.golf1.domain.CourseRepository;



@RunWith(SpringRunner.class)
@DataJpaTest
public class CourseRepositoryTest {

	@Autowired 
	private CourseRepository crepository;
	

	
	@Test
	public void findByNameShouldReturnCourse() {
		List<Course> courses = crepository.findByName("Golf Talma Master");
		assertThat(courses).hasSize(1);
		assertThat(courses.get(0).getName()).isEqualTo("Golf Talma Master");
	}
	

	@Test 
	public void insertNewCourse() {
		 
		Course course = new Course("Master", 73);
		crepository.save(course);
		assertThat(course.getCourseid()).isNotNull();
	}

}

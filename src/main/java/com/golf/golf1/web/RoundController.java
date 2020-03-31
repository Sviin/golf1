package com.golf.golf1.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.golf.golf1.domain.Course;
import com.golf.golf1.domain.CourseRepository;
import com.golf.golf1.domain.Round;
import com.golf.golf1.domain.RoundRepository;


@Controller
public class RoundController {
	@Autowired
	private RoundRepository repository; 

	@Autowired
	private CourseRepository crepository; 
	

    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
	// Show all rounds
    @RequestMapping(value="/roundlist")
    public String roundList(Model model) {	
        model.addAttribute("rounds", repository.findAll());
        return "roundlist";
    }
  
	// RESTful service to get all rounds
    @RequestMapping(value="/rounds")
    public @ResponseBody List<Round> roundListRest() {	
        return (List<Round>) repository.findAll();
    }    
	// RESTful service to get all courses
    @RequestMapping(value="/courses")
    public @ResponseBody List<Course> courseListRest() {	
        return (List<Course>) crepository.findAll();
    } 

	// RESTful service to get round by id
    @RequestMapping(value="/round/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Round> findRoundRest(@PathVariable("id") Long roundId) {	
    	return repository.findById(roundId);
    }       
	// RESTful service to get course by id
    @RequestMapping(value="/course/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Course> findCourseRest(@PathVariable("courseid") Long courseId) {	
    	return crepository.findById(courseId);
    } 
    // Add new round
    @RequestMapping(value = "/add")
    public String addRound(Model model){
    	model.addAttribute("round", new Round());
    	model.addAttribute("courses", crepository.findAll());
        return "addround";
    }  
    // Add new course
    @RequestMapping(value = "/addCourse")
    public String addCourse(Model model){
    	model.addAttribute("course", new Course());
    	model.addAttribute("courses", crepository.findAll());
        return "addcourse";
    } 

    // Save new round
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Round round){
        repository.save(round);
        return "redirect:roundlist";
    } 
    // Save new course
    @RequestMapping(value = "/saveCourse", method = RequestMethod.POST)
    public String save(Course course){
        crepository.save(course);
        return "redirect:roundlist";
    }  

    // Delete round
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteRound(@PathVariable("id") Long roundId, Model model) {
    	repository.deleteById(roundId);
        return "redirect:../roundlist";
    }     
}

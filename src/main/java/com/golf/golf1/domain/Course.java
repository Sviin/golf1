package com.golf.golf1.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long courseid;
	private String name;
	private int par;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
	private List<Round> rounds;
	
	public Course() {}

	public Course(String name, int par) {
		super();
		this.name = name;
		this.par = par;
	}

	public Long getCourseid() {
		return courseid;
	}

	public void setCourseid(Long courseid) {
		this.courseid = courseid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Round> getRounds() {
		return rounds;
	}

	public void setRounds(List<Round> rounds) {
		this.rounds = rounds;
	}
	

	public int getPar() {
		return par;
	}

	public void setPar(int par) {
		this.par = par;
	}

	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", name=" + name + ", par=" + par + "]";
	}


	
}

package com.golf.golf1.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Round {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private int score;
    private int putts;
    private int gir;
    private int fh;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "courseid")
    private Course course;

    public Round() {}

	public Round(int score, int putts, int gir, int fh,Course course) {
		super();
		this.score = score;
		this.putts = putts;
		this.gir = gir;
		this.fh = fh;
		this.course = course;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getPutts() {
		return putts;
	}

	public void setPutts(int putts) {
		this.putts = putts;
	}

	public int getGir() {
		return gir;
	}

	public void setGir(int gir) {
		this.gir = gir;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	

	public int getFh() {
		return fh;
	}

	public void setFh(int fh) {
		this.fh = fh;
	}

	@Override
	public String toString() {
		if (this.course != null)
			return "Round [id=" + id + ", score=" + score + ", putts=" + putts + ", gir=" + gir + " , fh=" + fh + ", course =" + this.getCourse() + "]";		
		else
			return "Round [id=" + id + ", score=" + score + ", putts=" + putts + ", gir=" + gir + ", fh =" + fh + "]";
	}


    
}

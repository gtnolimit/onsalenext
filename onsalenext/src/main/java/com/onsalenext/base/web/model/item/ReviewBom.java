package com.onsalenext.base.web.model.item;

import java.util.Set;
import java.util.TreeSet;

public class ReviewBom implements Comparable<ReviewBom>{

	private Long id;
	private String description;
	private Set<ReviewConBom> reviewCons = new TreeSet <ReviewConBom> ();
	private Set<ReviewProBom> reviewPros = new TreeSet <ReviewProBom> ();
	
	public ReviewBom ( Long id, String description, Set<ReviewConBom> reviewCon, Set<ReviewProBom> reviewPro){
		this.id = id;
		this.description = description;
		this.reviewCons = reviewCon;
		this.reviewPros = reviewPro;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<ReviewConBom> getReviewCons() {
		return reviewCons;
	}
	public void setReviewCons(Set<ReviewConBom> reviewCons) {
		this.reviewCons = reviewCons;
	}
	public Set<ReviewProBom> getReviewPros() {
		return reviewPros;
	}
	public void setReviewPros(Set<ReviewProBom> reviewPros) {
		this.reviewPros = reviewPros;
	}

	public int compareTo(ReviewBom o) {
		return id.compareTo(o.id);
	}

	
}

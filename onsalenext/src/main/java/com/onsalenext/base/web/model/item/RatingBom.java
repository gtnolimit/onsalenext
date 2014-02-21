package com.onsalenext.base.web.model.item;

public class RatingBom implements Comparable<RatingBom>{

	private Long id;
	private Double rating;
	
	public RatingBom ( Long id, Double rating ){
		this.id = id;
		this.rating = rating;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getRating() {
		return rating;
	}
	public void setRating( double rating) {
		this.rating = rating;
	}

	public int compareTo(RatingBom o) {
		return rating.compareTo(o.rating);
	}

	
}

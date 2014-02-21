package com.onsalenext.base.domain.item;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.onsalenext.base.domain.DBBase;

@Entity
@Table(name = "REVIEW", schema="ONSALENEXT_ITEM")
public class Review extends DBBase{

	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@Column(name = "REVIEW_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "DESCRIPION", unique=false, nullable = false, length = 2000)
	private String description;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "REVIEW_CON_DETAIL_LINK", 
		joinColumns = { @JoinColumn(name = "REVIEW_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "CON_ID") })
	private Set<ReviewCon> reviewCons = new HashSet <ReviewCon> ();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "REVIEW_PRO_DETAIL_LINK", 
		joinColumns = { @JoinColumn(name = "REVIEW_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "PRO_ID") })
	private Set<ReviewPro> reviewPros = new HashSet <ReviewPro> ();

	public Review () {}
	
	public Review ( Long id, String description, Set<ReviewCon> reviewCon, Set<ReviewPro> reviewPro, Date upd, String user ){
		this.id = id;
		this.description = description;
		this.reviewCons = reviewCon;
		this.reviewPros = reviewPro;
		this.upd = upd;
		this.user = user;
	}

	public Review ( Long id, String description, Set<ReviewCon> reviewCon, Set<ReviewPro> reviewPro, Date cpd, Date upd, String user ){
		this.id = id;
		this.description = description;
		this.reviewCons = reviewCon;
		this.reviewPros = reviewPro;
		this.cpd = cpd;
		this.upd = upd;
		this.user = user;
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

	public Set<ReviewCon> getReviewCons() {
		return reviewCons;
	}

	public void setReviewCons(Set<ReviewCon> reviewCons) {
		this.reviewCons = reviewCons;
	}

	public Set<ReviewPro> getReviewPros() {
		return reviewPros;
	}

	public void setReviewPros(Set<ReviewPro> reviewPros) {
		this.reviewPros = reviewPros;
	}
}

package com.onsalenext.base.test;

import java.util.HashSet;
import java.util.Set;

import com.onsalenext.base.web.model.item.RatingBom;

public class CreateRatingTest {
	
	public CreateRatingTest (){}
	
	public Set<RatingBom> createRates (){
		Set <RatingBom> rs = new HashSet <RatingBom> ();
		Double [] rating = {0.0, 0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0}; 
		for ( Double r : rating ) rs.add( this.createRate ( r ));
		return rs;
	} 

	private RatingBom createRate ( Double o ){
		return new RatingBom ( null, o );
	}
}

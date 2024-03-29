package com.onsalenext.base.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.onsalenext.base.domain.lookup.StateTypeLookup;
import com.onsalenext.base.web.model.TaxBom;

public class CreateTaxTest {
	
	public CreateTaxTest () {}
	
	public Set<TaxBom> setTaxes ( List<StateTypeLookup> states){
		Set<TaxBom> ts = new HashSet <TaxBom> (); 
		String [] taxs = {"AK,0.00","AL,0.00","AR,0.00","AS,0.00","AZ,0.00","CA,0.00","CO,0.00","CT,0.00","DC,0.00",
				"DE,0.00","FL,0.00","FM,0.00","GA,0.00","GU,0.00","HI,0.00","IA,0.00","ID,0.00","IL,10.20","IN,0.00",
				"KS,0.00","KY,0.00","LA,0.00","MA,0.00","MD,0.00","ME,0.00","MH,0.00","MI,0.00","MN,0.00","MO,0.00",
				"MP,0.00","MS,0.00","MT,0.00","NC,0.00","ND,0.00","NE,0.00","NH,0.00","NJ,0.00","NM,0.00","NV,0.00",
				"NY,0.00","OH,0.00","OK,0.00","OR,0.00","PA,0.00","PR,0.00","PW,0.00","RI,0.00","SC,0.00","SD,0.00",
				"TN,0.00","TX,0.00","UT,0.00","VA,0.00","VI,0.00","VT,0.00","WA,0.00","WI,0.00","WV,0.00","WY,0.00"}; 

		for ( String t : taxs ) ts.add( this.createTax (states, t) );
		return ts;
	}

	private TaxBom createTax ( List<StateTypeLookup> states, String o ){
		String[] tokens = o.split(",");
		for ( StateTypeLookup s : states ){
			if ( s.getName().equals( tokens[0]) ) 
				return new TaxBom (null, Double.parseDouble(tokens[1]), true, s);
		}
		return null;
	}
}

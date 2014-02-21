package com.onsalenext.base.test;

import java.util.HashSet;
import java.util.Set;

import com.onsalenext.base.web.model.item.SizeBom;

public class CreateSizeTest {
	
	public CreateSizeTest () {}
	
	public Set <SizeBom> createSizes (){
		String [] size = {"X-Small", "Small", "Medium", "Large", "X-Large", "XX-Large"};
		Set<SizeBom> ss = new HashSet <SizeBom> ();
		for ( String s : size ) ss.add( this.createSize (s) );
		return ss;
	}
	
	private SizeBom createSize ( String o ){
		return new SizeBom ( null, o, true );
	}

}

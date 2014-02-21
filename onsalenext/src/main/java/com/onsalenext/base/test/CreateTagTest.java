package com.onsalenext.base.test;

import java.util.HashSet;
import java.util.Set;

import com.onsalenext.base.web.model.item.TagBom;

public class CreateTagTest {
	
	public CreateTagTest () {}
	
	public Set<TagBom> createTags (){
		String [] tags = {"Phone,Mobile Electornics", "Mobile,Mobile Electornics", "Samsung,Mobile Electornics", "Smart,Mobile Electornics",
				"Chair,Furniture", "Wood,Furniture", "Desk,Furniture", "Bed,Furniture",
				"Chep,Computers", "Memory,Computers", "Monitor,Computers", "Laptop,Computers",
				"Speaker,Audio", "In-Wall,Audio", "Mp3,Audio", "CD,Audio",
				"LED,TV & Video", "Palsma,TV & Video", "Flat Pannel,TV & Video", "Player,TV & Video"
				};
		Set<TagBom> ts = new HashSet<TagBom> ();
		for ( String t : tags ) ts.add( this.createTag ( t ) );
		return ts;
	}
	
	private TagBom createTag ( String o ){
		String[] tokens = o.split(",");
		return new TagBom ( null, tokens[0], tokens[1], true );
	}

}

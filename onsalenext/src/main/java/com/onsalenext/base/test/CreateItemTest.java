package com.onsalenext.base.test;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.onsalenext.base.domain.lookup.LengthTypeLookup;
import com.onsalenext.base.domain.lookup.WeightTypeLookup;
import com.onsalenext.base.web.model.PictureBom;
import com.onsalenext.base.web.model.item.AccessoriesBom;
import com.onsalenext.base.web.model.item.BrandBom;
import com.onsalenext.base.web.model.item.ColorBom;
import com.onsalenext.base.web.model.item.CustomerReviewBom;
import com.onsalenext.base.web.model.item.DimensionsBom;
import com.onsalenext.base.web.model.item.FeatureBom;
import com.onsalenext.base.web.model.item.FeatureDetailBom;
import com.onsalenext.base.web.model.item.ItemBom;
import com.onsalenext.base.web.model.item.RatingBom;
import com.onsalenext.base.web.model.item.ReviewBom;
import com.onsalenext.base.web.model.item.ReviewConBom;
import com.onsalenext.base.web.model.item.ReviewProBom;
import com.onsalenext.base.web.model.item.SizeBom;
import com.onsalenext.base.web.model.item.SpecificationBom;
import com.onsalenext.base.web.model.item.SpecificationDetailBom;
import com.onsalenext.base.web.model.item.TagBom;
import com.onsalenext.base.web.model.item.WarrantyBom;
import com.onsalenext.base.web.model.person.CustomerBom;

public class CreateItemTest {

	public CreateItemTest (){}
	
	public Set<ItemBom> setItems (BrandBom brand, CustomerBom customer, ItemBom item1, ItemBom item2,
			List<SizeBom> sizes, List<TagBom> tags, List<RatingBom> ratings, List<ColorBom> colors){
		Set<ItemBom> items = new HashSet<ItemBom> ();
		for ( int i = 0; i <= 3; i++){
			items.add(this.createItem(customer, brand,  item1, item2, sizes, tags, ratings, colors));
		}return items;
	}
	
	public ItemBom createItem (CustomerBom customer, BrandBom brand, ItemBom item1, ItemBom item2,
			List<SizeBom> sizes, List<TagBom> tags, List<RatingBom> ratings, List<ColorBom> colors){
		String subject = "Samsung Gold Brown Galaxy Tab 3 7.0\" 8GB Tablet With WiFi, Model SMT"  + new Random().nextInt(100000000);
		String shortDesc = "The Samsung Galaxy Tab 3 is packed with features designed to give you a chance to " +
				"relax, to connect and engage with family, to keep you entertained, and to offer new " +
				"conveniences in everyday life. It works a lot like your Galaxy smartphone, so there’s " +
				"nothing new to learn. Just start having fun.";
		String desc = "The Samsung Galaxy Tab 3 is packed with features designed to give you a chance to relax, " +
				"to connect and engage with family, to keep you entertained, and to offer new conveniences in everyday life. " +
				"It works a lot like your Galaxy smartphone, so there’s nothing new to learn. Just start having fun. " +
				"The Same Galaxy ExperienceYou love your Galaxy smartphone. Now enjoy the same Galaxy experience on a tablet. " +
				"You’re already a Galaxy Tab 3 expert. Getting started on a Galaxy Tab 3 is a breeze. " +
				"Comfortably switch back and forth from your Galaxy phone to your Galaxy Tab whenever. " +
				"Your content is automatically in sync — wireless, fast and for free. A Powerful Tablet Doesn\'t " +
				"Have To Be Complicated Enjoy your favorite tablet apps and activities on the Galaxy Tab 3. " +
				"Search, explore, and buy online with fast web-browsing. Stay connected with friends wherever you are. " +
				"Download apps, catch up on email, and more. It’s fun and easy for the whole family.";
		String [] warranties = {"30 Days Money Back Guearantee", "1 year manufacture warranty."};

		return new ItemBom ( null, subject, shortDesc, desc, true, 78.00, 56.00, 10, true, true, "FB56776-45",
				"MAN_" + new Random().nextInt(100000000), 50.00, false, 50.00, new Date (), new Date (), false, true, this.setBrands(brand), 
				this.setCustomerReviews(customer), this.setReview(), this.setDimension(), 
				this.setRating( ratings ), this.setWarranties(warranties), this.createSpecification(), 
				this.createFeature(), this.setPictures(), this.setAccessories(item1, item2), this.setColors ( colors ), 	
				this.setSizes(sizes), this.setTags(tags));

	}
	
	private Set<BrandBom> setBrands ( BrandBom brand ){
		Set<BrandBom> bs = new HashSet <BrandBom> ();
		bs.add( brand);
		return bs;
	}
	private Set<AccessoriesBom> setAccessories (ItemBom item1, ItemBom item2){
		if ( item1 == null ) return null;
		Set<AccessoriesBom> as = new HashSet <AccessoriesBom> ();
		as.add(this.setAccessory(item1));
		as.add(this.setAccessory(item2));
		return as;
	}
	
	private AccessoriesBom setAccessory(ItemBom item){
		return new AccessoriesBom ( null, true, item );
	}
	
	private Set<CustomerReviewBom> setCustomerReviews (CustomerBom customer){
		if ( customer == null ) return null;
		Set<CustomerReviewBom> crs = new HashSet <CustomerReviewBom> ();
		String [] rev = {"Great Tablet! Very easy to navigate and Has great features! I had the kindle fire before this Which was good but within 3 quarters of the year i had to replace it.. I know Samsungs products are quality with the latest updates! I would absolutely recommend to anyone thinking about a tablet!","It's a lot of fun and great for my buisiness. Thanks","Great design, features, and exceptional performance!"};
		for (String r: rev) crs.add(this.setCustomerReview(r, customer));
		return crs;
	}
	
	private CustomerReviewBom setCustomerReview (String review, CustomerBom customer){
		return new CustomerReviewBom (null, review, customer);
	}
	
	private ReviewBom setReview (){
		String [] pros = {"Built-in speakers","Lightweight","Bright display","Durable","Inexpensive"};
		String [] cons = {"Small wireless Range","Fragial glass"};
		Set<ReviewProBom> rp = new HashSet<ReviewProBom> ();
		for ( String p: pros) rp.add(this.setReviewPro(p));
		Set<ReviewConBom> rc = new HashSet<ReviewConBom> ();
		for ( String c: cons) rc.add(this.setReviewCon(c));
		return new ReviewBom (null, "This will be simple review for the item", rc, rp);
	}
	
	private ReviewProBom setReviewPro (String value){
		return new ReviewProBom(null, value);
	}
	
	private ReviewConBom setReviewCon (String value){
		return new ReviewConBom (null, value);
	}
	
	private Set<SpecificationBom> createSpecification (){
		Set<SpecificationBom> fs = new HashSet <SpecificationBom> ();
		
		String [] s1 = {"Rear-facing camera: 13MP autofocus with LED flash","Zoom: 4x digital","Live video capture and playback: 1080p HD","Front-facing camera: 2MP","Dual camera mode","Slow-motion video capture"};
		fs.add(this.setSpecification("Camera", s1));
		String [] s2= {"Music player: Google Play™ Music","Supported music formats: MP3, AMR-NB/WB, AAC, AAC+, eAAC+, WMA, Vorbis (OGG), FLAC, AC-3","Subscription music services: Google Play™ Music","Create music playlists"};
		fs.add(this.setSpecification("Music", s2));
		String [] s3= {"Text messaging: Insert pictures, video clips and sound clips easily (messaging charges apply) ","Instant Messaging (IM): Ch@tON, Hangouts™"};
		fs.add(this.setSpecification("Messaging", s3));
		String [] s4= {"Mobile email: POP3/IMAP, SMTP, Gmail™, Microsoft® Exchange ActiveSync®, Yahoo!®, Hotmail®","Microsoft Direct Push"};
		fs.add(this.setSpecification("Email", s4));
		String [] s5= {"Web browser: Google Chrome™, native Android™"};
		fs.add(this.setSpecification("Web", s5));
		String [] s6= {"Ringtones ","Cool Tools: Autodesk SketchBook, FlipboardSM, S Note, Samsung Apps, Samsung Hub, Group Play, Pennable, Polaris® Office 5, WatchON™, TripAdvisor, Scrapbook, S Health, Ch@tON, S Translator, S Voice, Samsung Link, Story Album","Games: WildTangent Games (available for download)","Preloaded apps from AT&T: AT&T Navigator®, AT&T Locker™, AT&T FamilyMap, AT&T Code Scanner, myAT&T, AT&T HotSpots, Mobile TV*, YPmobile®, AT&T Ready2Go, AT&T Smart Wi-Fi, AT&T Messages, AT&T DriveMode®, Lookout. Separate subscription may be required.","myAT&T: Provides fast, easy account access virtually anywhere, anytime** "};
		fs.add(this.setSpecification("Applications/Media", s6));
		String [] s7= {"Calendar","Alarm clock","Call waiting","Personal organizer","Personal organizer","Address book ","Conference calling","Call forwarding","Multitasking: Use voice and data simultaneously "};
		fs.add(this.setSpecification("Productivity", s7));
		String [] s8= {"Hands-free speakerphone","World phone: Tri-band","TTY/TTD compatible","AT&T Ready2Go: Offers easy online setup and personalization of your new smartphone. See Quickstart Guide included in box for details.","AT&T Device Help: Device Help provides easy access to step by step tutorials and videos about features, functions and AT&T services directly from the web browser on the device (data charges apply)"};
		fs.add(this.setSpecification("Extras", s8));

		return fs;
	}
	
	private SpecificationBom setSpecification (String att, String [] val){
		return new SpecificationBom ( null, att, this.setSpecificationDetail(val));
	}
	
	private Set<SpecificationDetailBom> setSpecificationDetail ( String [] vals ){
		Set<SpecificationDetailBom> fs = new HashSet <SpecificationDetailBom> ();
		for (String s: vals ) fs.add(this.setSpecificationDetail(s));
		return fs;
	}
	
	private SpecificationDetailBom setSpecificationDetail (String val){
		return new SpecificationDetailBom ( null, val);
	}
	
	private Set<FeatureBom> createFeature (){
		Set<FeatureBom> fs = new HashSet <FeatureBom> ();
		
		String [] s1 = {"Rear-facing camera: 13MP autofocus with LED flash","Zoom: 4x digital","Live video capture and playback: 1080p HD","Front-facing camera: 2MP","Dual camera mode","Slow-motion video capture"};
		fs.add(this.setFeature("Camera", s1));
		String [] s2= {"Music player: Google Play™ Music","Supported music formats: MP3, AMR-NB/WB, AAC, AAC+, eAAC+, WMA, Vorbis (OGG), FLAC, AC-3","Subscription music services: Google Play™ Music","Create music playlists"};
		fs.add(this.setFeature("Music", s2));
		String [] s3= {"Text messaging: Insert pictures, video clips and sound clips easily (messaging charges apply) ","Instant Messaging (IM): Ch@tON, Hangouts™"};
		fs.add(this.setFeature("Messaging", s3));
		String [] s4= {"Mobile email: POP3/IMAP, SMTP, Gmail™, Microsoft® Exchange ActiveSync®, Yahoo!®, Hotmail®","Microsoft Direct Push"};
		fs.add(this.setFeature("Email", s4));
		String [] s5= {"Web browser: Google Chrome™, native Android™"};
		fs.add(this.setFeature("Web", s5));
		String [] s6= {"Ringtones ","Cool Tools: Autodesk SketchBook, FlipboardSM, S Note, Samsung Apps, Samsung Hub, Group Play, Pennable, Polaris® Office 5, WatchON™, TripAdvisor, Scrapbook, S Health, Ch@tON, S Translator, S Voice, Samsung Link, Story Album","Games: WildTangent Games (available for download)","Preloaded apps from AT&T: AT&T Navigator®, AT&T Locker™, AT&T FamilyMap, AT&T Code Scanner, myAT&T, AT&T HotSpots, Mobile TV*, YPmobile®, AT&T Ready2Go, AT&T Smart Wi-Fi, AT&T Messages, AT&T DriveMode®, Lookout. Separate subscription may be required.","myAT&T: Provides fast, easy account access virtually anywhere, anytime** "};
		fs.add(this.setFeature("Applications/Media", s6));
		String [] s7= {"Calendar","Alarm clock","Call waiting","Personal organizer","Personal organizer","Address book ","Conference calling","Call forwarding","Multitasking: Use voice and data simultaneously "};
		fs.add(this.setFeature("Productivity", s7));
		String [] s8= {"Hands-free speakerphone","World phone: Tri-band","TTY/TTD compatible","AT&T Ready2Go: Offers easy online setup and personalization of your new smartphone. See Quickstart Guide included in box for details.","AT&T Device Help: Device Help provides easy access to step by step tutorials and videos about features, functions and AT&T services directly from the web browser on the device (data charges apply)"};
		fs.add(this.setFeature("Extras", s8));

		return fs;
	}
	
	private FeatureBom setFeature (String att, String [] val){
		return new FeatureBom (null, att, true, this.setFeatureDetail(val));
	}
	
	private Set<FeatureDetailBom> setFeatureDetail ( String [] vals ){
		Set<FeatureDetailBom> fs = new HashSet <FeatureDetailBom> ();
		for (String s: vals ) fs.add(this.setFeatureDetail(s));
		return fs;
	}
	
	private FeatureDetailBom setFeatureDetail (String val){
		return new FeatureDetailBom ( null, val);
	}
	
	private RatingBom setRating ( List<RatingBom> o ){
		int count = 0;
		for ( RatingBom r : o ){
			if ( (count % 2 ) == 0 )
				return r;
		}
		return null;
	}
	
	private Set<ColorBom> setColors ( List<ColorBom> o){
		Set<ColorBom> s = new HashSet <ColorBom> ();
		int count = 0;
		for (ColorBom t: o){
			if ( (count % 6) == 0)
				s.add ( t );
			count ++;
		}
		return s;
	}

	private Set<TagBom> setTags ( List<TagBom> o){
		Set<TagBom> s = new HashSet <TagBom> ();
		int count = 0;
		for (TagBom t: o){
			if ( (count % 2) == 0)
				s.add ( t );
			count ++;
		}
		return s;
	}
	
	private Set<SizeBom> setSizes ( List<SizeBom> o){
		Set<SizeBom> s = new HashSet <SizeBom> ();
		int count = 0;
		for (SizeBom t: o){
			if ( (count % 2) == 0)
				s.add ( t );
			count ++;
		}
		return s;
	}
	private DimensionsBom setDimension (){
		return new DimensionsBom ( null, 23.5, 30.5, 45.54, 45.00, 32.98, 34.33, 34.56, 56.00, 
				WeightTypeLookup.LB, LengthTypeLookup.IN);
	}
	
	private Set<WarrantyBom> setWarranties ( String [] warranties){
		Set<WarrantyBom> wars = new HashSet <WarrantyBom> ();
		for (String w: warranties) wars.add ( this.createWarranty ( w ) );
		return wars;
	}
	
	private WarrantyBom createWarranty (String warranty){
		return new WarrantyBom (null, warranty, true);
	}
	
	private Set<PictureBom> setPictures (){
		Set<PictureBom> pics = new HashSet <PictureBom> ();
		pics.add(this.createPicture(true));
		pics.add(this.createPicture(false));
		pics.add(this.createPicture(false));
		return pics;
	}
	
	private PictureBom createPicture (boolean o){
		return new PictureBom (null, "C:\\project\\onsalenext\\ui\\old\\onlineStore\\image\\", "android_vector.jpg",
				"Android Logo", true, true );
	}
}

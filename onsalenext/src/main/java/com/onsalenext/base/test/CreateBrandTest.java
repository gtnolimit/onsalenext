package com.onsalenext.base.test;


import com.onsalenext.base.web.model.PictureBom;
import com.onsalenext.base.web.model.item.BrandBom;

public class CreateBrandTest {

	public CreateBrandTest (){}
	

	
	public BrandBom createBrand (String brand){
		return new BrandBom ( null, brand, true, this.createPicture());
	}
	
	private PictureBom createPicture (){
		return new PictureBom (null, "C:\\project\\onsalenext\\ui\\old\\onlineStore\\image\\", "android_vector.jpg",
				"Android Logo", true, true );
	}
}

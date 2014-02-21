package com.onsalenext.base.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.onsalenext.base.domain.lookup.StateTypeLookup;
import com.onsalenext.base.web.model.IpBom;
import com.onsalenext.base.web.model.PictureBom;
import com.onsalenext.base.web.model.StoreBom;
import com.onsalenext.base.web.model.item.BrandBom;
import com.onsalenext.base.web.model.item.ColorBom;
import com.onsalenext.base.web.model.item.ItemBom;
import com.onsalenext.base.web.model.item.RatingBom;
import com.onsalenext.base.web.model.item.SizeBom;
import com.onsalenext.base.web.model.item.TagBom;
import com.onsalenext.base.web.model.menu.CategoryBom;
import com.onsalenext.base.web.model.menu.ProductBom;
import com.onsalenext.base.web.model.menu.SubCategoryBom;
import com.onsalenext.base.web.model.person.CustomerBom;

public class CreateStoreTest {
	
	private List<SizeBom> sizes;
	private List<TagBom> tags;
	private List<RatingBom> ratings; 
	private List<ColorBom> colors;

	public StoreBom createStore ( List<BrandBom> brands, ItemBom item1, ItemBom item2, CustomerBom customer, 
			List<SizeBom> sizes, List<TagBom> tags, List<RatingBom> ratings, List<ColorBom> colors){
		this.sizes = sizes;
		this.colors = colors;
		this.tags = tags;
		this.ratings = ratings;
		return new StoreBom (null, "On Sale Next", this.setIp("10.10.10.10"), "", "gtnolimit@yahoo.com", 
				StateTypeLookup.IL, "ozi97yng", "gtnolimit@yahoo.com", "smtp.gmail.com", "465", true, 
				this.setCategories( brands, item1, item2, customer ) );
	}
	
	private Set<CategoryBom> setCategories ( List<BrandBom> brands, ItemBom item1, ItemBom item2, CustomerBom customer ){
		Set <CategoryBom> cats = new HashSet < CategoryBom> ();
		cats.add( this.setCategorys("Appliences", brands, item1, item2, customer));
		cats.add( this.setCategorys("Audio", brands, item1, item2, customer));
		cats.add( this.setCategorys("Communication", brands, item1, item2, customer));
		cats.add( this.setCategorys("Computers", brands, item1, item2, customer));
		cats.add( this.setCategorys("Furniture", brands, item1, item2, customer));
		cats.add( this.setCategorys("Gourmet", brands, item1, item2, customer));
		cats.add( this.setCategorys("Mobile Electornics", brands, item1, item2, customer));
		cats.add( this.setCategorys("Outware", brands, item1, item2, customer));
		cats.add( this.setCategorys("TV & Video", brands, item1, item2, customer));
		return cats;
	}

	private CategoryBom setCategorys (String name, List<BrandBom> brands, ItemBom item1, ItemBom item2, CustomerBom customer){
		Set<SubCategoryBom> subCat = new HashSet <SubCategoryBom> ();
		Set<BrandBom> bb = new HashSet<BrandBom> ();
		switch ( name ){
		case "Appliences":
			String [] kitchen={"Appliance Packages","Cooking Products","Dishwashers","Garbage Disposals","Hoods","Ice Makers","Microwaves & Micro Hoods","Refrigerators & Freezers","Small Appliances","Trash Compactors","Laundry"};
			String [] laundry={"Laundry Packages","Washers","Dryers","Stack Washers and Dryers","Washer and Dryer Combo Units","Commercial Dryers","Commercial Washers","Laundry Accessories"};
			String [] homeComfort={"Air Conditioners","Air Purifiers","Dehumidifiers","Fans And Space Heaters","Humidifiers","Central Cooling and Heating","Vacuums","Water Dispensers","Water Heaters","Power Generators"};
			String [] outdoor = {"Outdoor Grills /BBQs","Mosquito Repellant","Outdoor Heaters"};
			String [] accessories = {"Appliance Accessories"};
			for ( BrandBom b: brands){
				if ( b.getAttribute().equals("Apple") ){
					subCat.add(this.setSubCategory("Kitchen", kitchen, b, item1, item2, customer));
					subCat.add(this.setSubCategory("Laundry", laundry, b, item1, item2, customer));
					bb.add(b);
				}
				if ( b.getAttribute().equals("HP")){
					subCat.add(this.setSubCategory("Home Comfort", homeComfort, b, item1, item2, customer));
					subCat.add(this.setSubCategory("Outdoor", outdoor, b, item1, item2, customer));
					bb.add(b);
				}
				if ( b.getAttribute().equals("Samsung") ){
					subCat.add(this.setSubCategory("Accessories", accessories, b, item1, item2, customer));
					bb.add(b);
				}
			}
			return this.setCategory(name, subCat, bb);
		case "Audio":
			String [] speakers = {"Bookshelf Speakers","Center Channel Speakers","Floor Standing Speakers","Home Theater Speaker Packages","In Wall Speakers","In Ceiling Speakers","Outdoor Speakers","Soundbar Speakers","Subwoofer Speakers","Portable Speakers","Satellite Speakers","Stereo Speaker Packages"};
			String [] homeTheater = {"Amplifiers","Home Theater Systems","Preamplifiers","Audio Receivers","Tuners"};
			String [] audioPlayers = {"iPods & MP3 Players","Mini Systems","Turntables","Boomboxes","Portable Satellite Radio","Clock Radios","Personal CD Players","CD Players and Recorders","Radios"};
			String [] audioAccessories ={"Audio Racks & Video Racks","Remote Controls","Speaker Stands","Audio Cables","Audio Carrying Cases","Subwoofer Cables","Digital Audio Cables"};
			for ( BrandBom b: brands){
				if ( b.getAttribute().equals("Apple") ){
					subCat.add(this.setSubCategory("Speakers", speakers, b, item1, item2, customer));
					subCat.add(this.setSubCategory("Home Theater", homeTheater, b, item1, item2, customer));
					bb.add(b);
				}
				if ( b.getAttribute().equals("Apple") ){
					subCat.add(this.setSubCategory("Audio Players", audioPlayers, b, item1, item2, customer));
					subCat.add(this.setSubCategory("Audio Accessories", audioAccessories, b, item1, item2, customer));
					bb.add(b);
				}
			}
			return this.setCategory(name, subCat, bb);
		case "Communication":
			String [] phones = {"Phones","Cellular Phones"};
			String [] accessor = {"Communication Accessories","Cellular Accessories","Cordless Phone Accessories","Fax Accessories","Batteries"};
			for ( BrandBom b: brands){
				if ( b.getAttribute().equals("Apple") ){
					subCat.add(this.setSubCategory("Phones",phones, b, item1, item2, customer));
					subCat.add(this.setSubCategory("Accessories",accessor, b, item1, item2, customer));
					bb.add(b);
				}
			}
			return this.setCategory(name, subCat, bb);
		case "Computers":
			String [] computers = {"iPad & Tablets","Laptop / Notebook Computers","Desktop Computers","E-Readers"};
			String [] printersScanners = {"Printers & Scanners","Cables & Connections","Printer Ink & Toner","Digital Photo Paper"};
			String [] computerAccessories = {"iPad Accessories","Mouse & Keyboards","Computer Monitors","External Hard Drives","Networking & Wireless","Cables & Connections","Laptop Accessories","Computer Hardware","Printers & Scanners","Software"};
			for ( BrandBom b: brands){
				if ( b.getAttribute().equals("Apple") ){
					subCat.add(this.setSubCategory("Computers", computers, b, item1, item2, customer));
					subCat.add(this.setSubCategory("Printers & Scanners", printersScanners, b, item1, item2, customer));
					bb.add(b);
				}
				if ( b.getAttribute().equals("HP") ){
					subCat.add(this.setSubCategory("Computer Accessories", computerAccessories, b, item1, item2, customer));
					bb.add(b);
				}
			}
			return this.setCategory(name, subCat, bb);
		case "Furniture":
			String [] homeTheaterFurniture = {"Audio Racks & Video Racks","TV Stands","Massage Chairs","Flat Screen TV Mounts","Ceiling Mounts","Leather Seating","Home Theater Seating"};
			String [] audioFurniture = {"Speaker Stands","Speaker Brackets"};
			String [] kitchenFurniture = {"Carts & Cutting Boards","Bar Stools & Counter Stools"};
			String [] officeFurniture = {"Computer Desks","Office Chairs"};
			String [] outdoorFurniture = {"Patio Sets"};
			for ( BrandBom b: brands){
				if ( b.getAttribute().equals("Apple") ){
					subCat.add(this.setSubCategory("Office Furniture",officeFurniture,b, item1, item2, customer));
					subCat.add(this.setSubCategory("Audio Furniture",audioFurniture, b, item1, item2, customer));
					subCat.add(this.setSubCategory("Home Theater Furniture",homeTheaterFurniture, b, item1, item2, customer));
					bb.add(b);
				}
				if ( b.getAttribute().equals("HP") ){
					subCat.add(this.setSubCategory("Audio Furniture",audioFurniture, b, item1, item2, customer));
					subCat.add(this.setSubCategory("Outdoor Furniture",outdoorFurniture, b, item1, item2, customer));
					subCat.add(this.setSubCategory("Kitchen Furniture",kitchenFurniture, b, item1, item2, customer));
					bb.add(b);
				}
			}
			return this.setCategory(name, subCat, bb);
		case "Gourmet":
			String [] smallAppliances = {"Blenders","Stand Mixers","Bread Machines","Coffee Grinders","Coffee & Espresso Machines","Food Processors","Toasters","Food Slicers","Juicers","Ice Cream Makers","Can Openers","Wafflers & Grills","Hand Mixers","Rice Cookers/Steamers","Water Kettles","Deep Fryers","Toaster Ovens","Hand Blenders","Irons","Miscellaneous Small Appliances","Slow Cookers"};
			String [] cooking = {"Carts & Cutting Boards","Cutlery & Cooking Utensils","Cookware","Knife Sharpeners","Stoneware","Books"};
			String [] gourmetFoodItems = {"Gourmet Food Items"};
			String [] gourmetShopAccessories = {"Coffee & Espresso Accessories","Stand Mixer Accessories","Wine Accessories","Kitchen Thermometers","Salt and Pepper Mills","Kitchen Scales","Food Processor Accessories","Gourmet Bags and Totes","Kitchen Textiles","Water Bottles"};
			for ( BrandBom b: brands){
				if ( b.getAttribute().equals("Apple") ){
					subCat.add(this.setSubCategory("Small Appliances", smallAppliances, b, item1, item2, customer));
					subCat.add(this.setSubCategory("Cooking", cooking, b, item1, item2, customer));
					bb.add(b);
				}
				if ( b.getAttribute().equals("HP") ){
					subCat.add(this.setSubCategory("Gourmet Food Items", gourmetFoodItems, b, item1, item2, customer));
					subCat.add(this.setSubCategory("Gourmet Shop Accessories", gourmetShopAccessories, b, item1, item2, customer));
					bb.add(b);
				}
			}
			return this.setCategory(name, subCat, bb);
		case "Mobile Electornics":
			String [] navigation = {"Car Navigation and GPS","Marine GPS","Motorcycle GPS","Hiking GPS","Mobile Audio","Car Audio Processors","Car Audio Amplifiers","Car Audio Speakers","Car Subwoofers","Car Stereos - Single Din","Car Stereos - Double Din","Satellite Radio","Vehicle Sub Enclosures"};
			String [] marineElectronics ={"Marine Radio","Marine Audio Speakers","Marine Amplifiers","Marine GPS","Marine Subwoofers"};
			String [] carElectronics = {"Mobile Video","Remote Starters & Car Alarm Systems","Radar Detectors","Accident Avoidance - Mitigation Systems"};
			String [] acce = {"Car Audio Cables & Connections","Car Navigation & GPS Accessories","Car Harness","Car Kits","Car Adapters","Car Alarm Accessories","Marine Audio Accessories","Mobile Power Accessories"};
			for ( BrandBom b: brands){
				if ( b.getAttribute().equals("Apple") ){
					subCat.add(this.setSubCategory("Navigation",navigation, b, item1, item2, customer));
					subCat.add(this.setSubCategory("Mobile Audio",navigation,b, item1, item2, customer));
					subCat.add(this.setSubCategory("Marine Electronics",marineElectronics, b, item1, item2, customer));
					bb.add(b);
				}
				if ( b.getAttribute().equals("HP") ){
					subCat.add(this.setSubCategory("Car Electronics",carElectronics, b, item1, item2, customer));
					subCat.add(this.setSubCategory("Accessories",acce, b, item1, item2, customer));
					bb.add(b);
				}
			}
			return this.setCategory(name, subCat, bb);
		case "Outware":
			String [] def ={"Jacket","Pants","Shoes","Shirt"};
			for ( BrandBom b: brands){
				if ( b.getAttribute().equals("Apple") ){
					subCat.add(this.setSubCategory("Men Clothing",def, b, item1, item2, customer));
					subCat.add(this.setSubCategory("Female Clothing",def, b, item1, item2, customer));
					bb.add(b);
				}
				if ( b.getAttribute().equals("HP") ){
					subCat.add(this.setSubCategory("Kids Clothing",def, b, item1, item2, customer));
					bb.add(b);
				}
			}
			return this.setCategory(name, subCat, bb);
		case "TV & Video":
			String [] televisions ={"All Flat Panel TVs","LED TV","LCD TV","Plasma TV","Projectors","TV Combos"};
			String [] videoPlayers ={"Blu-ray & DVD Players","Digital Media Devices","DVD/VCR Combos","DVD Recorders","Portable DVD Players"};
			String [] tivo ={"Digital Video (DVR) Recorders","Satellite / HDTV Receivers","Satellite Receivers","Digital Converters"};
			String [] videoAccessories ={"Flat Screen TV Mounts","Remote Controls","Audio & Video Cables","HDMI Cables","Surge Protectors","Antennas"};
			for ( BrandBom b: brands){
				if ( b.getAttribute().equals("Apple") ){
					subCat.add(this.setSubCategory("Televisions",televisions, b, item1, item2, customer));
					subCat.add(this.setSubCategory("Video Players",videoPlayers, b, item1, item2, customer));
					subCat.add(this.setSubCategory("DVR / Tivo",tivo, b, item1, item2, customer));
					bb.add(b);
				}
				if ( b.getAttribute().equals("HP") ){
					subCat.add(this.setSubCategory("Satellite / HDTV Receivers",videoAccessories, b, item1, item2, customer));
					subCat.add(this.setSubCategory("Video Accessories",videoAccessories, b, item1, item2, customer));
					bb.add(b);
				}
			}
			return this.setCategory(name, subCat, bb);
		}
		return null;
	}	
	
	private CategoryBom setCategory (String name, Set<SubCategoryBom> sub, Set<BrandBom> brands){
		return new CategoryBom ( null, name, true, sub, brands);
	}

	private SubCategoryBom setSubCategory ( String name, String [] names, BrandBom brand, ItemBom item1, ItemBom item2, CustomerBom customer ){
		return new SubCategoryBom (null, name, true, this.setProducts(names, brand, item1, item2, customer));
	}
	
	private Set <ProductBom> setProducts ( String [] names, BrandBom brand, ItemBom item1, ItemBom item2, CustomerBom customer){
		Set<ProductBom> prods = new HashSet <ProductBom> ();
		for (String n: names) prods.add(this.setProduct(n, brand, item1, item2, customer));
		return prods;
	}
	
	private ProductBom setProduct ( String name, BrandBom brand, ItemBom item1, ItemBom item2, CustomerBom customer){
		CreateItemTest cit = new CreateItemTest ();
		return new ProductBom (null, name, true, this.createPicture(true), cit.setItems(brand, customer, item1, item2, sizes, tags, ratings, colors));
	}	
	
	private PictureBom createPicture (boolean isMain){
		return new PictureBom (null, "C:\\project\\onsalenext\\ui\\old\\onlineStore\\image\\", "android_vector.jpg",
				"Android Logo", true, isMain );
	}

	private IpBom setIp ( String ip_p){
		return new IpBom (null, ip_p, UUID.randomUUID().toString());
	}
}

package com.onsalenext.base.test;

import java.util.HashSet;
import java.util.Set;

import com.onsalenext.base.web.model.item.ColorBom;

public class CreateColorTest {

	public CreateColorTest (){}
	
	public Set<ColorBom> createColors (){
		String [] colors = {"Pink,Pink,FC0CB", "Pink,LightPink,FFB6C1", "Pink,HotPink,FF69B4", "Pink,DeepPink,FF1493", "Pink,PaleVioletRed,DB7093", "Pink,MediumVioletRed,C71585", "Red,LightSalmon,FFA07A", "Red,Salmon,FA8072", "Red,DarkSalmon,E9967A", "Red,LightCoral,F08080", "Red,IndianRed,CD5C5C", "Red,Crimson,DC143C", "Red,FireBrick,B22222", "Red,DarkRed,8B0000", "Red,Red,FF0000", "Orange,OrangeRed,FF4500", "Orange,Tomato,FF6347", "Orange,Coral,FF7F50", "Orange,DarkOrange,FF8C00", "Orange,Orange,FFA500", "Orange,Gold,FFD700", "Yellow,Yellow,FFFF00", "Yellow,LightYellow,FFFFE0", "Yellow,Lemon,Chiffon,FFFACD", "Yellow,LightGoldenrodYellow,FAFAD2", "Yellow,PapayaWhip,FFEFD5", "Yellow,Moccasin,FFE4B5", "Yellow,PeachPuff,FFDAB9", "Yellow,PaleGoldenrod,EEE8AA", "Yellow,Khaki,F0E68C", "Yellow,DarkKhaki,BDB76B", "Brown,Cornsilk,FFF8DC", "Brown,BlanchedAlmond,FFEBCD", "Brown,Bisque,FFE4C4", "Brown,NavajoWhite,FFDEAD", "Brown,Wheat,F5DEB3", "Brown,BurlyWood,DEB887", "Brown,Tan,D2B48C", "Brown,RosyBrown,BC8F8F", "Brown,SandyBrown,F4A460", "Brown,Goldenrod,DAA520", "Brown,DarkGoldenrod,B8860B", "Brown,Peru,CD853F", "Brown,Chocolate,D2691E", "Brown,SaddleBrown,8B4513", "Brown,Sienna,A0522D", "Brown,Brown,A52A2A", "Brown,Maroon,800000", "Green,DarkOliveGreen,556B2F", "Green,Olive,808000", "Green,OliveDrab,6B8E23", "Green,YellowGreen,9ACD32", "Green,LimeGreen,32CD32", "Green,Lime,00FF00", "Green,LawnGreen,7CFC00", "Green,Chartreuse,7FFF00", "Green,GreenYellow,ADFF2F", "Green,SpringGreen,00FF7F", "Green,MediumSpringGreen,00FA9A", "Green,LightGreen,90EE90", "Green,PaleGreen,98FB98", "Green,DarkSeaGreen,8FBC8F", "Green,MediumSeaGreen,3CB371", "Green,SeaGreen,2E8B57", "Green,ForestGreen,228B22", "Green,Green,008000", "Green,DarkGreen,006400", "Cyan,MediumAquamarine,66CDAA", "Cyan,Aqua,00FFFF", "Cyan,Cyan,00FFFF", "Cyan,LightCyan,E0FFFF", "Cyan,PaleTurquoise,AFEEEE", "Cyan,Aquamarine,7FFFD4", "Cyan,Turquoise,40E0D0", "Cyan,MediumTurquoise,48D1CC", "Cyan,DarkTurquoise,00CED1", "Cyan,LightSeaGreen,20B2AA", "Cyan,CadetBlue,5F9EA0", "Cyan,DarkCyan,008B8B", "Cyan,Teal,008080", "Blue,LightSteelBlue,B0C4DE", "Blue,PowderBlue,B0E0E6", "Blue,LightBlue,ADD8E6", "Blue,SkyBlue,87CEEB", "Blue,LightSkyBlue,87CEFA", "Blue,DeepSkyBlue,00BFFF", "Blue,DodgerBlue,1E90FF", "Blue,CornflowerBlue,6495ED", "Blue,SteelBlue,4682B4", "Blue,RoyalBlue,4169E1", "Blue,Blue,0000FF", "Blue,MediumBlue,0000CD", "Blue,DarkBlue,00008B", "Blue,Navy,000080", "Blue,MidnightBlue,191970", "Purple,Lavender,E6E6FA", "Purple,Thistle,D8BFD8", "Purple,Plum,DDA0DD", "Purple,Violet,EE82EE", "Purple,Orchid,DA70D6", "Purple,Fuchsia,FF00FF", "Purple,Magenta,FF00FF", "Purple,MediumOrchid,BA55D3", "Purple,MediumPurple,9370DB", "Purple,BlueViolet,8A2BE2", "Purple,DarkViolet,9400D3", "Purple,DarkOrchid,9932CC", "Purple,DarkMagenta,8B008B", "Purple,Purple,800080", "Purple,Indigo,4B0082", "Purple,DarkSlateBlue,483D8B", "Purple,SlateBlue,6A5ACD", "Purple,MediumSlateBlue,7B68EE", "White,White,FFFFFF", "White,Snow,FFFAFA", "White,Honeydew,F0FFF0", "White,MintCream,F5FFFA", "White,Azure,F0FFFF", "White,AliceBlue,F0F8FF", "White,GhostWhite,F8F8FF", "White,WhiteSmoke,F5F5F5", "White,Seashell,FFF5EE", "White,Beige,F5F5DC", "White,OldLace,FDF5E6", "White,FloralWhite,FFFAF0", "White,Ivory,FFFFF0", "White,AntiqueWhite,FAEBD7", "White,Linen,FAF0E6", "White,LavenderBlush,FFF0F5", "White,MistyRose,FFE4E1", "Gray/Black,Gainsboro,DCDCDC", "Gray/Black,LightGray,D3D3D3", "Gray/Black,Silver,C0C0C0", "Gray/Black,DarkGray,A9A9A9", "Gray/Black,Gray,808080", "Gray/Black,DimGray,696969", "Gray/Black,LightSlateGray,778899", "Gray/Black,SlateGray,708090", "Gray/Black,DarkSlateGray,2F4F4F", "Gray/Black,Black,000000"};
		Set <ColorBom> cs = new HashSet <ColorBom> ();
		for ( String c : colors ) cs.add(this.createColor (c) );
		return cs;
	}
	private ColorBom createColor ( String o ){
		String[] tokens = o.split(",");
		return new ColorBom ( null, tokens[0], tokens[1], tokens[2], true );
	}
	
}

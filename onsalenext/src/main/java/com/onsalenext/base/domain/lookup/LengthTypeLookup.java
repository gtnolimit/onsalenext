package com.onsalenext.base.domain.lookup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LENGTH_TYPE", schema="ONSALENEXT_LOOKUP")
public class LengthTypeLookup extends AbstractLookupType  {

	private static final long serialVersionUID = 3212625355790851086L;
	
	public static final LengthTypeLookup IN = createConstant("IN", "INCH", LengthTypeLookup.class);
	public static final LengthTypeLookup FT = createConstant("FT", "FOOT", LengthTypeLookup.class);
	public static final LengthTypeLookup CM = createConstant("CM", "CENTIMETER", LengthTypeLookup.class);
	public static final LengthTypeLookup M = createConstant("M", "METER", LengthTypeLookup.class);
	
 	@Id
    @Column(name="CODE", unique=true, nullable=false, length=5)
    public String getCode() {
        return super.getCode();
    }

    @Column(name="DESCRIPTION", unique=false, nullable=false, length=20)
    public String getDescription() {
        return super.getDescription();
    }

}

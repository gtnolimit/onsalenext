package com.onsalenext.base.domain.lookup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WEIGHT_TYPE", schema="ONSALENEXT_LOOKUP")
public class WeightTypeLookup extends AbstractLookupType  {

	private static final long serialVersionUID = 3212625355790851086L;
	
	public static final WeightTypeLookup KG = createConstant("KG", "KILOGRAM", WeightTypeLookup.class);
	public static final WeightTypeLookup LB = createConstant("LB", "POUNDS", WeightTypeLookup.class);
	
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

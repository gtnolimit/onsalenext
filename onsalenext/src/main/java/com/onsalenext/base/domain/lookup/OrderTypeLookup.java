package com.onsalenext.base.domain.lookup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_TYPE", schema="ONSALENEXT_LOOKUP")
public class OrderTypeLookup extends AbstractLookupType  {

	private static final long serialVersionUID = 3212625355790851086L;
	
	public static final OrderTypeLookup C = createConstant("C", "CREATED", OrderTypeLookup.class);
	public static final OrderTypeLookup S = createConstant("S", "SHIPPED", OrderTypeLookup.class);
	public static final OrderTypeLookup P = createConstant("P", "PROCESSED", OrderTypeLookup.class);
	public static final OrderTypeLookup I = createConstant("I", "INPROGRESS", OrderTypeLookup.class);
	
	
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

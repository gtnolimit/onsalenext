package com.onsalenext.base.domain.lookup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE_TYPE", schema="ONSALENEXT_LOOKUP")
public class RoleTypeLookup  extends AbstractLookupType{

private static final long serialVersionUID = 3212625355790851086L;
	
	public static final RoleTypeLookup A = createConstant("A", "ADMINISTRATOR", RoleTypeLookup.class);
	public static final RoleTypeLookup C = createConstant("C", "CUSTOMER", RoleTypeLookup.class);
	public static final RoleTypeLookup M = createConstant("M", "MERCHANT", RoleTypeLookup.class);
	public static final RoleTypeLookup B = createConstant("B", "BOTH", RoleTypeLookup.class);
		
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

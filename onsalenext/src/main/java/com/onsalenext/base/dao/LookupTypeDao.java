package com.onsalenext.base.dao;

import java.util.List;

import com.onsalenext.base.domain.lookup.LookupType;

public interface LookupTypeDao {
	
	  /**
     * Returns a list of Reference Types for the specified Reference Type Class
     * @param The Reference Class Type
     * @return The list of reference types
     */
    public <T extends LookupType> List<T> findReferenceTypes(Class<T> type);

}

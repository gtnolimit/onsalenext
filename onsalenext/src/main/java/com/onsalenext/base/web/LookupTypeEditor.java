package com.onsalenext.base.web;

import java.beans.PropertyEditorSupport;

import com.onsalenext.base.domain.lookup.LookupType;
import com.onsalenext.base.service.LookupTypeService;

/**
 * Provides mapping between Reference Types by ID/Value and the Reference Domain Objects.
 */
public class LookupTypeEditor  extends PropertyEditorSupport  {
    
    Class<? extends LookupType>      specificType;
    LookupTypeService lookupTypeService;

    public LookupTypeEditor(Class<? extends LookupType> specificType, LookupTypeService lookupTypeService) {
        this.specificType = specificType;
        this.lookupTypeService = lookupTypeService;
    }
    
    public Class<? extends LookupType> getSpecificType() {
        return specificType;
    }

    public void setSpecificType(Class<? extends LookupType> specificType) {
        this.specificType = specificType;
    }

    @Override
    public String getAsText() {
        return super.getAsText();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        LookupType val = lookupTypeService.getLookupTypeByCode(text, specificType);
        
        if(val == null || val.getCode() == null || val.getCode().length() == 0) {
            setValue(null);
        } else {
            setValue(val);
        }
    }
    
}

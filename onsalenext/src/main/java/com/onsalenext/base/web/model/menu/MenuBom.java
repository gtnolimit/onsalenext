package com.onsalenext.base.web.model.menu;

public class MenuBom {
	
	DepartmentBom department;
	SaleItemBom saleItem;
	
	public MenuBom ( DepartmentBom department, SaleItemBom saleItem){
		this.department=department;
		this.saleItem=saleItem;
	}
	
	public DepartmentBom getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentBom department) {
		this.department = department;
	}
	public SaleItemBom getSaleItem() {
		return saleItem;
	}
	public void setSaleItem(SaleItemBom saleItem) {
		this.saleItem = saleItem;
	}
}

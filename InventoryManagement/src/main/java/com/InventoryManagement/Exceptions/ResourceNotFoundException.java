package com.InventoryManagement.Exceptions;

//Class to throw Exception
public class ResourceNotFoundException extends RuntimeException {
	
 String resourceName;
 String field;
 long fieldValue;
public ResourceNotFoundException(String resourceName, String field, long fieldValue) {
	super(String.format("%s not found with %s:%s",resourceName,field,fieldValue));
	this.resourceName = resourceName;
	this.field = field;
	this.fieldValue = fieldValue;
}
 
}

package com.itoItTracker.assignment.spring.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	String resourceName;
	String fieldName;
	int fieldValue;
//	Optional<Integer> userId;

//	public Optional<Integer> getUserId() {
//		return userId;
//	}

//	public void setUserId(Optional<Integer> userId) {
//		this.userId = userId;
//	}

	public ResourceNotFoundException(String resourceName, String fieldName, int fieldValue) {
		super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public ResourceNotFoundException(String resourceName) {
		super(resourceName);
	}

//	public ResourceNotFoundException(String resourceName, String fieldName, Optional<Integer> userId) {
//		super(String.format("%s not found with %s : %s", resourceName, fieldName, userId));
//		this.resourceName = resourceName;
//		this.fieldName = fieldName;
//		this.userId = userId;
//	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public int getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(int fieldValue) {
		this.fieldValue = fieldValue;
	}

}

package com.example.demo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DummyClass {
	
	private String altIdSource;
	private String altIdType;
	private String state;
	private String altIdValue;
	
	@JsonFormat(pattern="MM-dd-yyyy")
	private Date effectiveDate;

	@JsonFormat(pattern="MM-dd-yyyy")
	private Date terminationDate;
	private String terminationReason;
	public String getAltIdSource() {
		return altIdSource;
	}
	public void setAltIdSource(String altIdSource) {
		this.altIdSource = altIdSource;
	}
	public String getAltIdType() {
		return altIdType;
	}
	public void setAltIdType(String altIdType) {
		this.altIdType = altIdType;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAltIdValue() {
		return altIdValue;
	}
	public void setAltIdValue(String altIdValue) {
		this.altIdValue = altIdValue;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public Date getTerminationDate() {
		return terminationDate;
	}
	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}
	public String getTerminationReason() {
		return terminationReason;
	}
	public void setTerminationReason(String terminationReason) {
		this.terminationReason = terminationReason;
	}
	public DummyClass(String altIdSource, String altIdType, String state, String altIdValue, Date effectiveDate,
			Date terminationDate, String terminationReason) {
		super();
		this.altIdSource = altIdSource;
		this.altIdType = altIdType;
		this.state = state;
		this.altIdValue = altIdValue;
		this.effectiveDate = effectiveDate;
		this.terminationDate = terminationDate;
		this.terminationReason = terminationReason;
	}
	
	
	

}

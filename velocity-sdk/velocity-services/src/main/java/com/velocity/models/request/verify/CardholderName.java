/**
 * 
 */
package com.velocity.models.request.verify;

/**
 * This class holds the data for CardholderName
 * @author vimalk2
 * @date 13-January-2015
 */
public class CardholderName {
	
	
	/* Attribute for CardholderName value exists or not. */
	private boolean nillable = true;
	private String value = "";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isNillable() {
		return nillable;
	}

	public void setNillable(boolean nillable) {
		this.nillable = nillable;
	}

	

}

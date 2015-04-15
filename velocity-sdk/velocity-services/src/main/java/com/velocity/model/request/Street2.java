package com.velocity.model.request;

/**
 * This class defines the attributes for Street2
 * 
 * @author Vimal Kumar
 * @date 09-January-2015
 */
public class Street2 {

    /* Attribute for Street2 value exists or not. */
    private boolean nillable = true;
    private String value = "";

    public boolean isNillable() {
        return nillable;
    }
    public void setNillable(boolean nillable) {
        this.nillable = nillable;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}

package edu.iit.cs445.s2016.delectable.surcharge;

import com.google.gson.annotations.SerializedName;

public class Surcharge {
	
	@SerializedName("surcharge") 
	private double surcharge;
	
	public Surcharge(){
		this.surcharge = 0;
	}
	
	public double surcharge(){
		return this.surcharge;
	}
	
	public void setSurcharge(double surcharge){
		this.surcharge = surcharge;
	}
}

package edu.iit.cs445.s2016.delectable.surcharge;

public class Surcharge {
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

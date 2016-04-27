package edu.iit.cs445.s2016.delectable.surcharge;

import java.util.Date;

import edu.iit.cs445.s2016.delectable.Common;

public class SurchargeManager implements BoundarySurchargeInterface {

	private static Surcharge surcharge = new Surcharge();
	
	public SurchargeManager(){
		 
	}

	@Override
	public void setSurcharge(double amount) {
		surcharge.setSurcharge(amount);
		
	}

	@Override
	public Surcharge getSurcharge(Date date) {
		if(Common.isWeekend(date)){
			return surcharge;
		}else
		{
		return new Surcharge();
		}
	}
	
	@Override
	public Surcharge getSurcharge() {
			return surcharge;
	}
}

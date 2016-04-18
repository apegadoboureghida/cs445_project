package edu.iit.cs445.s2016.delectable.surcharge;

import java.util.Date;

import edu.iit.cs445.s2016.delectable.Common;

public class SurchargeManager implements BoundarySurchargeInterface {

	private Surcharge surcharge;

	@Override
	public void setSurcharge(double amount) {
		this.surcharge.setSurcharge(amount);
		
	}

	@Override
	public Surcharge getSurcharge(Date date) {
		if(Common.isWeekend(date)){
			return this.surcharge;
		}else
		{
		return new Surcharge();
		}
	}
	
	@Override
	public Surcharge getSurcharge() {
			return this.surcharge;
	}
}

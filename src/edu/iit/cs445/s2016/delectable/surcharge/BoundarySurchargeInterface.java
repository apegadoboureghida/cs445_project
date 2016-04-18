package edu.iit.cs445.s2016.delectable.surcharge;

import java.util.Date;

public interface BoundarySurchargeInterface {

	void setSurcharge(double amount);
	Surcharge getSurcharge(Date date);
	Surcharge getSurcharge();
}

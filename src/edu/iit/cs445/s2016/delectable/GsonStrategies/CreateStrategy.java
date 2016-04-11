package edu.iit.cs445.s2016.delectable.GsonStrategies;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class CreateStrategy implements ExclusionStrategy{

	@Override
	public boolean shouldSkipField(FieldAttributes arg0) {
		return !arg0.getName().equals("id");
	}
	
	@Override
	public boolean shouldSkipClass(Class<?> arg0) {
		return false;
	}

}

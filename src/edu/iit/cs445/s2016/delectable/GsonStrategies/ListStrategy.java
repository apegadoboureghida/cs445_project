package edu.iit.cs445.s2016.delectable.GsonStrategies;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class ListStrategy implements ExclusionStrategy{

	@Override
	public boolean shouldSkipField(FieldAttributes arg0) {
		return arg0.getName().equals("createDate") || arg0.getName().equals("lastModifiedDate") ;
	}
	
	@Override
	public boolean shouldSkipClass(Class<?> arg0) {
		return false;
	}
}

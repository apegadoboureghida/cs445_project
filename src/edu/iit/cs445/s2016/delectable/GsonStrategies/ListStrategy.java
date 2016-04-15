package edu.iit.cs445.s2016.delectable.GsonStrategies;

import java.util.Arrays;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class ListStrategy implements ExclusionStrategy{

	@Override
	public boolean shouldSkipField(FieldAttributes arg0) {
		String[] skip = {"cancelURL","createDate","lastModifiedDate"};
		
		return (Arrays.asList(skip)).contains(arg0.getName()) ;
	}
	
	@Override
	public boolean shouldSkipClass(Class<?> arg0) {
		return false;
	}
}

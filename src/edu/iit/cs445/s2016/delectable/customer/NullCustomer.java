package edu.iit.cs445.s2016.delectable.customer;

public class NullCustomer extends Customer {

	@Override
    public boolean isNil() {
        return true;
    }
}

package edu.iit.cs445.s2016.delectable.report;

import java.util.Collection;

import edu.iit.cs445.s2016.delectable.order.Order;


public interface BoundaryReportInterface {
	
	void addOrder(Order order);
	Collection<ReportType> getAllReports();
	ReportType getRerport(int rid);
}

package edu.iit.cs445.s2016.delectable.report;

import java.util.Collection;
import java.util.Date;

import edu.iit.cs445.s2016.delectable.order.Order;


public interface BoundaryReportInterface {
	
	void addOrder(Order order);
	Collection<ReportType> getAllReports();
	public ReportType getReportToday();
	public ReportType getReport802();
	public ReportType getReport803();
	public ReportType getReport804();
	ReportType getReport804(Date startDate, Date endDate);
	ReportType getReport803(Date startDate, Date endDate);
}

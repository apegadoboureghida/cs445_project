package edu.iit.cs445.s2016.delectable.report;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import edu.iit.cs445.s2016.delectable.Common;
import edu.iit.cs445.s2016.delectable.order.Order;

public class ReportManager implements BoundaryReportInterface {
	
	private static Map<Integer,ReportType> reportTypes = new HashMap<Integer,ReportType>();
	private static Hashtable<String,List<Order>> orders = new Hashtable<String,List<Order>>();

	public ReportManager()
	{
		reportTypes.put(801,new ReportType(801,"Orders to deliver today"));
		reportTypes.put(802,new ReportType(802,"Orders to deliver tomorrow"));
		reportTypes.put(803,new ReportType(803,"Revenue report"));
		reportTypes.put(803,new ReportType(803,"Orders delivery report"));
	}
	
	
	@Override
	public Collection<ReportType> getAllRerports() {
		return reportTypes.values();
	}

	@Override
	public ReportType getRerport(int rid) {
		
		switch(rid){
			case 801:
				reportTypes.get(rid).setOrders(orders.get(Common.todayAsString()));
				return reportTypes.get(rid);
			case 802:
				reportTypes.get(rid).setOrders(orders.get(Common.tomorrowAsString()));
				return reportTypes.get(rid);
		}
		return null;
	}


	@Override
	public void addOrder(Order order) {
		if(orders.containsKey(Common.DateString(order.deliveryDate()))){
			orders.get(Common.DateString(order.deliveryDate())).add(order);
		}else{
			List<Order> list = new ArrayList<Order>();
			list.add(order);
			orders.put(Common.DateString(order.deliveryDate()), list);
		}
	}


}

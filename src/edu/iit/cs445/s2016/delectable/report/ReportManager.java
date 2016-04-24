package edu.iit.cs445.s2016.delectable.report;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import edu.iit.cs445.s2016.delectable.Common;
import edu.iit.cs445.s2016.delectable.order.Order;
import edu.iit.cs445.s2016.delectable.order.OrderStatus;

public class ReportManager implements BoundaryReportInterface {
	
	private static Map<Integer,ReportType> reportTypes = new HashMap<Integer,ReportType>();
	private static Hashtable<String,List<Order>> orders = new Hashtable<String,List<Order>>();

	public ReportManager()
	{
		reportTypes.put(801,new ReportType(801,"Orders to deliver today"));
		reportTypes.put(802,new ReportType(802,"Orders to deliver tomorrow"));
		reportTypes.put(803,new ReportType(803,"Revenue report"));
		reportTypes.put(804,new ReportType(804,"Orders delivery report"));
	}
	
	
	@Override
	public Collection<ReportType> getAllReports() {
		
		reportTypes.put(801,new ReportType(801,"Orders to deliver today"));
		reportTypes.put(802,new ReportType(802,"Orders to deliver tomorrow"));
		reportTypes.put(803,new ReportType(803,"Revenue report"));
		reportTypes.put(804,new ReportType(804,"Orders delivery report"));
		return reportTypes.values();
	}

	@Override
	public ReportType getRerport(int rid) {
		
		switch(rid){
			case 801:
				reportTypes.put(801,new ReportType(801,"Orders to deliver today"));
				reportTypes.get(rid).setOrders(orders.get(Common.todayAsString()));
				return reportTypes.get(rid);
			case 802:
				reportTypes.put(802,new ReportType(802,"Orders to deliver tomorrow"));
				List<Order> ordersAux = new ArrayList<Order>();
				if(orders.get(Common.tomorrowAsString()) != null){
					for(Order tmp :orders.get(Common.tomorrowAsString()) ){
						if(tmp.status()== OrderStatus.OPEN){
							ordersAux.add(tmp);
						}
					}
				}
				reportTypes.get(rid).setOrders(ordersAux);
				return reportTypes.get(rid);
			case 803:
				reportTypes.put(803,new ReportType(803,"Revenue report"));
				reportTypes.get(rid).setOrders(orders.get(Common.tomorrowAsString()));
				int placed = 0;
				int cancelled = 0;
				int open = 0;
				double foodRevenue = 0;
				double surchargeRevenue = 0;
				for(List<Order> tmp : orders.values()){
					for(Order tmpOr : tmp){
						placed++;
						switch(tmpOr.status()){
							case CANCELLED:
								cancelled++;
								break;
							case OPEN:
								open++;
								break;
							default:								
						}
						foodRevenue += tmpOr.amount();
						surchargeRevenue += tmpOr.surcharge();
					}
				}
				reportTypes.get(rid).setEndDate(null);
				reportTypes.get(rid).setStartDate(null);
				reportTypes.get(rid).setOrdersPlaced(placed);
				reportTypes.get(rid).setOrdersCancelled(cancelled);
				reportTypes.get(rid).setOrdersOpen(open);
				reportTypes.get(rid).setFoodRevenuen(foodRevenue);
				reportTypes.get(rid).setSurchargeRevenue(surchargeRevenue);	
				
				return reportTypes.get(rid);
			case 804:
				reportTypes.put(804,new ReportType(804,"Orders delivery report"));
				reportTypes.get(rid).setOrders(orders.get(Common.tomorrowAsString()));
				double foodRevenueD = 0;
				double surchargeRevenueD = 0;
				int placedD = 0;
				for(List<Order> tmp : orders.values()){
					for(Order tmpOr : tmp){
						if(tmpOr.status() == OrderStatus.DELIVERD){
							placedD++;
							foodRevenueD += tmpOr.amount();
							surchargeRevenueD += tmpOr.surcharge();
						}

					}
				}
				reportTypes.get(rid).setEndDate(null);
				reportTypes.get(rid).setStartDate(null);
				reportTypes.get(rid).setOrdersPlaced(placedD);
				reportTypes.get(rid).setFoodRevenuen(foodRevenueD);
				reportTypes.get(rid).setSurchargeRevenue(surchargeRevenueD);	
				
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

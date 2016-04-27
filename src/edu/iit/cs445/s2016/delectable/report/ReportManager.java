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
	public ReportType getReport801(){
		reportTypes.remove(801);
		reportTypes.put(801,new ReportType(801,"Orders to deliver today"));
		reportTypes.get(801).setOrders(orders.get(Common.todayAsString()));

		return reportTypes.get(801);
	}
	@Override
	public ReportType getReport802(){
		reportTypes.put(802,new ReportType(802,"Orders to deliver tomorrow"));
		List<Order> ordersAux = new ArrayList<Order>();
		if(orders.get(Common.tomorrowAsString()) != null){
			for(Order tmp :orders.get(Common.tomorrowAsString()) ){
				if(tmp.status()== OrderStatus.OPEN){
					ordersAux.add(tmp);
				}
			}
		}
		reportTypes.get(802).setOrders(ordersAux);
		return reportTypes.get(802);
	}
	@Override
	public ReportType getReport803(){
		reportTypes.put(803,new ReportType(803,"Revenue report"));
		reportTypes.get(803).setOrders(orders.get(Common.tomorrowAsString()));
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
		reportTypes.get(803).setEndDate(null);
		reportTypes.get(803).setStartDate(null);
		reportTypes.get(803).setOrdersPlaced(placed);
		reportTypes.get(803).setOrdersCancelled(cancelled);
		reportTypes.get(803).setOrdersOpen(open);
		reportTypes.get(803).setFoodRevenuen(foodRevenue);
		reportTypes.get(803).setSurchargeRevenue(surchargeRevenue);	
		
		return reportTypes.get(803);
	}
	
	@Override
	public ReportType getReport804(){
		reportTypes.put(804,new ReportType(804,"Orders delivery report"));
		reportTypes.get(804).setOrders(orders.get(Common.tomorrowAsString()));
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
		reportTypes.get(804).setEndDate(null);
		reportTypes.get(804).setStartDate(null);
		reportTypes.get(804).setOrdersPlaced(placedD);
		reportTypes.get(804).setFoodRevenuen(foodRevenueD);
		reportTypes.get(804).setSurchargeRevenue(surchargeRevenueD);	
		
		return reportTypes.get(804);
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

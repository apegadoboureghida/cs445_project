import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import edu.iit.cs445.s2016.delectable.REST_AbstractControllerTest;
import edu.iit.cs445.s2016.delectable.GsonStrategies.CreateStrategyTest;
import edu.iit.cs445.s2016.delectable.GsonStrategies.ListReportStrategyTest;
import edu.iit.cs445.s2016.delectable.GsonStrategies.ListStrategyTest;
import edu.iit.cs445.s2016.delectable.customer.CustomerManagerTest;
import edu.iit.cs445.s2016.delectable.customer.GenericCustomerTest;
import edu.iit.cs445.s2016.delectable.menu.CategoryTest;
import edu.iit.cs445.s2016.delectable.menu.MenuItemTest;
import edu.iit.cs445.s2016.delectable.menu.MenuManagerTest;
import edu.iit.cs445.s2016.delectable.order.OrderItemTest;
import edu.iit.cs445.s2016.delectable.order.OrderManagerTest;
import edu.iit.cs445.s2016.delectable.order.OrderTest;
import edu.iit.cs445.s2016.delectable.report.ReportManagerTest;
import edu.iit.cs445.s2016.delectable.report.ReportTypeTest;
import edu.iit.cs445.s2016.delectable.surcharge.SurchargeManagerTest;
import edu.iit.cs445.s2016.delectable.surcharge.SurchargeTest;

public class main {

	public static void main(String[] args) {
		int ignore = 0;
		int run=0;
		int failure= 0;
		
		JUnitCore junit = new JUnitCore();
		Result result = junit.run(REST_AbstractControllerTest.class);
		ignore += result.getIgnoreCount();
		run += result.getRunCount();
		failure += result.getFailureCount();
		
		if(result.getFailureCount()> 0)
		{
			for(Failure fail: result.getFailures()){
				System.out.println("Test: FAIL ->"+fail.getMessage());			
				}
		}else{
			System.out.println("Test: OK");			

		}
		result = junit.run(CustomerManagerTest.class);
		ignore += result.getIgnoreCount();
		run += result.getRunCount();
		failure += result.getFailureCount();
		
		if(result.getFailureCount()> 0)
		{
			for(Failure fail: result.getFailures()){
				System.out.println("Test: FAIL ->"+fail.getMessage() + fail.getException().getStackTrace().toString());			
				}
		}else{
			System.out.println("Test: OK");			

		}
		result = junit.run(CustomerManagerTest.class);
		ignore += result.getIgnoreCount();
		run += result.getRunCount();
		failure += result.getFailureCount();
		
		if(result.getFailureCount()> 0)
		{
			for(Failure fail: result.getFailures()){
				System.out.println("Test: FAIL ->"+fail.getMessage());			
				}
		}else{
			System.out.println("Test: OK");			

		}
		
		result = junit.run(GenericCustomerTest.class);
		ignore += result.getIgnoreCount();
		run += result.getRunCount();
		failure += result.getFailureCount();
		
		if(result.getFailureCount()> 0)
		{
			for(Failure fail: result.getFailures()){
				System.out.println("Test: FAIL ->"+fail.getMessage());			
				}
		}else{
			System.out.println("Test: OK");			

		}
		
		
		result = junit.run(CreateStrategyTest.class);
		ignore += result.getIgnoreCount();
		run += result.getRunCount();
		failure += result.getFailureCount();
		
		if(result.getFailureCount()> 0)
		{
			for(Failure fail: result.getFailures()){
				System.out.println("Test: FAIL ->"+fail.getMessage());			
				}
		}else{
			System.out.println("Test: OK");			

		}
		
		
		result = junit.run(ListReportStrategyTest.class);
		ignore += result.getIgnoreCount();
		run += result.getRunCount();
		failure += result.getFailureCount();
		
		if(result.getFailureCount()> 0)
		{
			for(Failure fail: result.getFailures()){
				System.out.println("Test: FAIL ->"+fail.getMessage());			
				}
		}else{
			System.out.println("Test: OK");			

		}
		
		
		result = junit.run(ListStrategyTest.class);
		ignore += result.getIgnoreCount();
		run += result.getRunCount();
		failure += result.getFailureCount();
		
		if(result.getFailureCount()> 0)
		{
			for(Failure fail: result.getFailures()){
				System.out.println("Test: FAIL ->"+fail.getMessage());			
				}
		}else{
			System.out.println("Test: OK");			

		}
		
		
		result = junit.run(CategoryTest.class);
		ignore += result.getIgnoreCount();
		run += result.getRunCount();
		failure += result.getFailureCount();
		
		if(result.getFailureCount()> 0)
		{
			for(Failure fail: result.getFailures()){
				System.out.println("Test: FAIL ->"+fail.getMessage());			
				}
		}else{
			System.out.println("Test: OK");			

		}
		
		
		result = junit.run(MenuItemTest.class);
		ignore += result.getIgnoreCount();
		run += result.getRunCount();
		failure += result.getFailureCount();
		
		if(result.getFailureCount()> 0)
		{
			for(Failure fail: result.getFailures()){
				System.out.println("Test: FAIL ->"+fail.getMessage());			
				}
		}else{
			System.out.println("Test: OK");			

		}
		
		
		result = junit.run(MenuManagerTest.class);
		ignore += result.getIgnoreCount();
		run += result.getRunCount();
		failure += result.getFailureCount();
		
		if(result.getFailureCount()> 0)
		{
			for(Failure fail: result.getFailures()){
				System.out.println("Test: FAIL ->"+fail.getMessage());			
				}
		}else{
			System.out.println("Test: OK");			

		}
		
		
		result = junit.run(OrderItemTest.class);
		ignore += result.getIgnoreCount();
		run += result.getRunCount();
		failure += result.getFailureCount();
		
		if(result.getFailureCount()> 0)
		{
			for(Failure fail: result.getFailures()){
				System.out.println("Test: FAIL ->"+fail.getMessage());			
				}
		}else{
			System.out.println("Test: OK");			

		}
		
		
		result = junit.run(OrderManagerTest.class);
		ignore += result.getIgnoreCount();
		run += result.getRunCount();
		failure += result.getFailureCount();
		
		if(result.getFailureCount()> 0)
		{
			for(Failure fail: result.getFailures()){
				System.out.println("Test: FAIL ->"+fail.getMessage());			
				}
		}else{
			System.out.println("Test: OK");			

		}
		
		
		result = junit.run(OrderTest.class);
		ignore += result.getIgnoreCount();
		run += result.getRunCount();
		failure += result.getFailureCount();
		
		if(result.getFailureCount()> 0)
		{
			for(Failure fail: result.getFailures()){
				System.out.println("Test: FAIL ->"+fail.getMessage());			
				}
		}else{
			System.out.println("Test: OK");			

		}
		
		
		result = junit.run(ReportManagerTest.class);
		ignore += result.getIgnoreCount();
		run += result.getRunCount();
		failure += result.getFailureCount();
		
		if(result.getFailureCount()> 0)
		{
			for(Failure fail: result.getFailures()){
				System.out.println("Test: FAIL ->"+fail.getMessage());			
				}
		}else{
			System.out.println("Test: OK");			

		}
		
		
		result = junit.run(ReportTypeTest.class);
		ignore += result.getIgnoreCount();
		run += result.getRunCount();
		failure += result.getFailureCount();
		
		if(result.getFailureCount()> 0)
		{
			for(Failure fail: result.getFailures()){
				System.out.println("Test: FAIL ->"+fail.getMessage());			
				}
		}else{
			System.out.println("Test: OK");			

		}
		
		

		
		result = junit.run(GenericCustomerTest.class);
		ignore += result.getIgnoreCount();
		run += result.getRunCount();
		failure += result.getFailureCount();
		
		if(result.getFailureCount()> 0)
		{
			for(Failure fail: result.getFailures()){
				System.out.println("Test: FAIL ->"+fail.getMessage());			
				}
		}else{
			System.out.println("Test: OK");			

		}
		
		result = junit.run(SurchargeManagerTest.class);
		ignore += result.getIgnoreCount();
		run += result.getRunCount();
		failure += result.getFailureCount();
		
		if(result.getFailureCount()> 0)
		{
			for(Failure fail: result.getFailures()){
				System.out.println("Test: FAIL ->"+fail.getMessage());			
				}
		}else{
			System.out.println("Test: OK");			

		}
		
		
		result = junit.run(SurchargeTest.class);
		ignore += result.getIgnoreCount();
		run += result.getRunCount();
		failure += result.getFailureCount();
		
		if(result.getFailureCount()> 0)
		{
			for(Failure fail: result.getFailures()){
				System.out.println("Test: FAIL ->"+fail.getMessage());			
				}
		}else{
			System.out.println("Test: OK");			

		}
		
		
		
		System.out.println("Total test: "+(ignore+run+failure)+ " run: " + run + " ignore: " + ignore + " failure: "+failure);
	}
}

package test.tutorial.sample.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.tutorial.sample.service.FinancialServices;

public class TestGrossSalary {

	private  FinancialServices finacialservices = null;
    private static int employeeID = 1;
	@Before
	public  void setup(){
		finacialservices = new FinancialServices();
		
	}
	
	@Test
	public void testBasicPay(){
		//Object obj = Mockito.mock(Object.class);
		double grossSalary = 12000;
		double percentage = 40;
		double expected = grossSalary*percentage/100;
		System.out.println(expected);
		System.out.println("Result "+finacialservices.getBasicSalary(grossSalary));
		Assert.assertEquals((long)expected,(long)finacialservices.getBasicSalary(grossSalary));
	}
	
	@Test
	public void testBasicPayLess20(){
		//Object obj = Mockito.mock(Object.class);
		double grossSalary = 10000;
		double percentage = 20;
		double expected = grossSalary*percentage/100;
		System.out.println(expected);
		System.out.println("Result "+finacialservices.getBasicSalary(grossSalary));
		Assert.assertEquals((long)expected,(long)finacialservices.getBasicSalary(grossSalary));
	}
	
	@Test
	public void testGrossSalaryAccToLeave(){
		int totalMonthsLeave = 3;
		System.out.println("Result "+finacialservices.getGrossSalaryAccToLeave(totalMonthsLeave,employeeID));
		Assert.assertEquals(0,(long)finacialservices.getGrossSalaryAccToLeave(totalMonthsLeave,employeeID));
		
		totalMonthsLeave = 2;
		finacialservices=Mockito.mock(FinancialServices.class);
		Mockito.when(finacialservices.getGrossSalary(employeeID)).thenReturn(10000.0);
		Mockito.when(finacialservices.getGrossSalaryAccToLeave(totalMonthsLeave,employeeID)).thenCallRealMethod();
		Assert.assertEquals((long)10000,(long)finacialservices.getGrossSalaryAccToLeave(totalMonthsLeave,employeeID));
		Mockito.verify(finacialservices).getGrossSalary(employeeID);	
		
	}
	
	@Test
	public void testGrossSalaryAccToLoan(){
		double loanAmount = 15000;
		finacialservices=Mockito.mock(FinancialServices.class);
		Mockito.when(finacialservices.getGrossSalary(employeeID)).thenReturn(10000.0);
		Mockito.when(finacialservices.getGrossSalaryAccToLoan(loanAmount,employeeID)).thenCallRealMethod();
		Assert.assertEquals(-5000,(long)finacialservices.getGrossSalaryAccToLoan(loanAmount, employeeID));
	
		loanAmount =5000;
		Mockito.when(finacialservices.getGrossSalaryAccToLoan(loanAmount, employeeID)).thenCallRealMethod();
		Assert.assertEquals(5000,(long)finacialservices.getGrossSalaryAccToLoan(loanAmount,employeeID));
		
		
	}

	@Test
	public void testCalculatePF(){
		int employeeID = 1;
		double percentage = 12;
		double basicPay =10000;
		double grossSalary = 10000;
		double expected = basicPay*percentage/100;
		finacialservices=Mockito.mock(FinancialServices.class);
		Mockito.when(finacialservices.getGrossSalary(employeeID)).thenReturn(10000.0);
		Mockito.when(finacialservices.getBasicSalary(grossSalary)).thenReturn(10000.0);
		Mockito.when(finacialservices.calculatePF(employeeID)).thenCallRealMethod();
		Assert.assertEquals((long)expected,(long)finacialservices.calculatePF(employeeID));
		Mockito.verify(finacialservices).getBasicSalary(grossSalary);	
	}
	
	
	
}

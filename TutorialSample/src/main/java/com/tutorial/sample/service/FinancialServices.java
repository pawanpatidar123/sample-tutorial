package com.tutorial.sample.service;

/*
 * @Authore - vikas patidar/Pawan Patidar/Amit Sharma
 * @since - 09 December 2016
 * Description - Finacial Services to HR specific
 */


public class FinancialServices {

	private final double  maxPercentage = 40;
	private final double  minPercentage = 20;
	
	public FinancialServices(){
		
	}
	
	public double getBasicSalary(double grossSalary){
		double result = 0;
		if(grossSalary>10000){
			result=	grossSalary*maxPercentage/100;
		}else{
			result=	grossSalary*minPercentage/100;
		}
		System.out.println("Basic salary"+result);
		return result;
	}

	public double getGrossSalaryAccToLeave(int totalMonthsLeave,int employeeID) {
		double grossSalary = 0;
		if(totalMonthsLeave>=3) {
			grossSalary = 0;
		} else {
			grossSalary=getGrossSalary(employeeID);
		}
		return grossSalary;
	}

	public double getGrossSalary(int employeedID) { 
		System.out.println("in getGrossSalary");
		throw new UnsupportedOperationException();
	}
	
	public double getGrossSalaryAccToLoan(double loanAmount,int employeeID) {
		
		double grossSalary = getGrossSalary(employeeID);
		
		grossSalary = grossSalary - loanAmount;
		return grossSalary;
		
	}

	public double calculatePF(int employeeID) {
		System.out.println("calulate pf");
		double grossSalary =getGrossSalary(employeeID);
		double basicPay = getBasicSalary(grossSalary);
		System.out.println("Basic pay "+basicPay);
		double pf = basicPay*12/100;
		return pf;
	}
	
}

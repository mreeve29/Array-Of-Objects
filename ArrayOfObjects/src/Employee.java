
public class Employee {
	
	//instance variables
	private double[] sales = new double[4];
	private String name;
	
	//constructor
	public Employee(String name, double q1, double q2, double q3, double q4) {
		this.name = name;
		sales[0] = q1;
		sales[1] = q2;
		sales[2] = q3;
		sales[3] = q4;
	}
	
	//default constructor
	public Employee() {
		name = "";
		for(int i = 0; i < sales.length; i++) {
			sales[i] = 0;
		}
	}
	
	//constructor
	public Employee(Employee e) {
		name = e.getName();
		sales[0] = e.getSale(0);
		sales[1] = e.getSale(1);
		sales[2] = e.getSale(2);
		sales[3] = e.getSale(3);
	}

	public String toString() {
		return name + ": " + sales[0] + ", " + sales[1] + ", " + sales[2] + ", " + sales[3];
	}
	
	//setter for name
	public void setName(String nm) {
		name = nm;
	}
	
	//setter for sales
	public void setSales(int index, double sale) {
		if(index > 3 || index < 0) return;
		sales[index] = sale;
	}
	
	//setter for sales
	public void setSales(double[]newSales) {
		for(int i = 0; i < sales.length; i++) {
			sales[i] = newSales[i];
		}
	}
	
	//setter for sales
	public void setSales(double q1, double q2, double q3, double q4) {
		sales[0] = q1;
		sales[1] = q2;
		sales[2] = q3;
		sales[3] = q4;
	}
	
	//getter for name
	public String getName() {
		return name;
	}
	
	//getter for sales
	public double[] getSales() {
		return sales;
	}
	
	//getter for a single sale
	public double getSale(int index) {
		if(index > 3 || index < 0) return 0;
		return sales[index];
	}
	
	//getter for total
	public double getTotal() {
		double total = 0;
		for(int i = 0; i < sales.length; i++) {
			total += sales[i];
		}
		return total;
	}
}
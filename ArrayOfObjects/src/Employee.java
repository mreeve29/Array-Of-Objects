
public class Employee {
	private double[] sales = new double[4];
	private String name;
	
	public Employee(String name, double q1, double q2, double q3, double q4) {
		this.name = name;
		sales[0] = q1;
		sales[1] = q2;
		sales[2] = q3;
		sales[3] = q4;
	}
	
	public Employee() {
		name = "";
		for(int i = 0; i < sales.length; i++) {
			sales[i] = 0;
		}
	}
	
	
	public String toString() {
		return name + ": " + sales[0] + ", " + sales[1] + ", " + sales[2] + ", " + sales[3];
	}
	
	
	public void setName(String nm) {
		name = nm;
	}
	
	
	public void setSales(int index, double sale) {
		sales[index] = sale;
	}
	
	public void setSales(double[]newSales) {
		for(int i = 0; i < sales.length; i++) {
			sales[i] = newSales[i];
		}
	}
	
	public void setSales(double q1, double q2, double q3, double q4) {
		sales[0] = q1;
		sales[1] = q2;
		sales[2] = q3;
		sales[3] = q4;
	}
	
	public String getName() {
		return name;
	}
	
	public double[] getSales() {
		return sales;
	}
	
	public double getSale(int index) {
		return sales[index];
	}
	
	public double getTotal() {
		double total = 0;
		for(int i = 0; i < sales.length; i++) {
			total += sales[i];
		}
		return total;
	}
	
	public Employee(Employee e) {
		name = e.getName();
		sales[0] = e.getSale(0);
		sales[1] = e.getSale(1);
		sales[2] = e.getSale(2);
		sales[3] = e.getSale(3);
	}
	
	
}


public class Employee {
	private int[] sales = new int[4];
	private String name;
	
	public Employee(String name, int q1, int q2, int q3, int q4) {
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
	
	
	public void setSales(int index, int sale) {
		sales[index] = sale;
	}
	
	public void setSales(int[]newSales) {
		for(int i = 0; i < sales.length; i++) {
			sales[i] = newSales[i];
		}
	}
	
	public void setSales(int q1, int q2, int q3, int q4) {
		sales[0] = q1;
		sales[1] = q2;
		sales[2] = q3;
		sales[3] = q4;
	}
	
	public String getName() {
		return name;
	}
	
	public int[] getSales() {
		return sales;
	}
	
	public int getSale(int index) {
		return sales[index];
	}
	
	
	
}


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
	
}

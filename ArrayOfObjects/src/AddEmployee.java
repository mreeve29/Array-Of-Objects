
import BreezySwing.*;
import javax.swing.*;

public class AddEmployee extends GBDialog{

	JButton confirmButton = addButton("Confirm",3,1,1,1);
	
	JLabel employeeNameLabel = addLabel("Name:",1,1,1,1);
	JTextField employeeNameField = addTextField("",1,2,4,4);
	
	JLabel employeeSalesLabel = addLabel("Sales:",2,1,1,1);
	DoubleField q1Sales = addDoubleField(0,2,2,1,1);
	DoubleField q2Sales = addDoubleField(0,2,3,1,1);
	DoubleField q3Sales = addDoubleField(0,2,4,1,1);
	DoubleField q4Sales = addDoubleField(0,2,5,1,1);
	
	
	
	public AddEmployee(JFrame arg0) {
		super(arg0);
		this.setSize(300,300);
	}
	
	private Employee emp = new Employee();
	
	public Employee getEmployee() {
		return emp;
	}
	
	
	public void buttonClicked(JButton button) {
		if(button == confirmButton) {
			emp.setName(employeeNameField.getText());
			emp.setSales(q1Sales.getNumber(), q2Sales.getNumber(), q3Sales.getNumber(), q4Sales.getNumber());
			setDlgCloseIndicator("Confirm");
		}
		dispose();
	}
	
}

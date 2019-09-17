
import BreezySwing.*;
import javax.swing.*;

public class ArrayClient extends GBFrame{

	JLabel addEmployeeLabel = addLabel("Add Employee:",1,1,1,1);
	JLabel employeeNameLabel = addLabel("Name:",2,1,1,1);
	JTextField employeeNameField = addTextField("",2,2,1,1);
	
	JLabel employeeSalesLabel = addLabel("Sales:",3,1,1,1);
	
	
	
	
	Employee[] empArr = new Employee[10];
	
	public static void main(String[] args) {
		ArrayClient frm = new ArrayClient();
		frm.setVisible(true);
		frm.setTitle("Array of Objects");
		frm.setSize(400,600);
	}
}

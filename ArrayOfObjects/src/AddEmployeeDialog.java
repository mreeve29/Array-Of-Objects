import BreezySwing.*;
import javax.swing.*;

public class AddEmployeeDialog extends GBDialog{
	//instance class variables
	private JButton confirmButton = addButton("Confirm",4,1,1,1);
	
	private JLabel employeeNameLabel = addLabel("Name:",1,1,1,1);
	private JTextField employeeNameField = addTextField("",1,2,4,4);
	
	private JLabel employeeSalesLabel = addLabel("Sales:",2,1,1,1);
	
	private JLabel q1Label = addLabel("        Q1",2,2,1,1);
	private JLabel q2Label = addLabel("        Q2",2,3,1,1);
	private JLabel q3Label = addLabel("        Q3",2,4,1,1);
	private JLabel q4Label = addLabel("        Q4",2,5,1,1);
	
	private DoubleField q1Sales = addDoubleField(0,3,2,1,1);
	private DoubleField q2Sales = addDoubleField(0,3,3,1,1);
	private DoubleField q3Sales = addDoubleField(0,3,4,1,1);
	private DoubleField q4Sales = addDoubleField(0,3,5,1,1);
	
	private Employee emp = new Employee();
	
	//constructor
	public AddEmployeeDialog(JFrame parent) {
		super(parent);
		this.setSize(500,175);
		this.setTitle("Add Employee");
	}
	
	//returns employee when closed
	public Employee getEmployee() {
		return emp;
	}
	
	//button listener
	public void buttonClicked(JButton button) {
		if(button == confirmButton) {
			
			if(!errorCheck()) return;
			
			emp.setName(employeeNameField.getText());
			emp.setSales(q1Sales.getNumber(), q2Sales.getNumber(), q3Sales.getNumber(), q4Sales.getNumber());
			setDlgCloseIndicator("Confirm");
		}
		//closes the dialog
		dispose();
	}
	
	//error check
	private boolean errorCheck() {
		String errors = "Error(s):\n";
		boolean errBool = true;
		
		if(ReeveHelper.isBlank(employeeNameField)) {
			errors += "Empty name\n";
			errBool = false;
		}
		
		if(!ReeveHelper.isValidNumber(q1Sales)) {
			errors += "Invalid number in Q1\n";
			errBool = false;
		}
		
		if(!ReeveHelper.isValidNumber(q2Sales)) {
			errors += "Invalid number in Q2\n";
			errBool = false;
		}
		
		if(!ReeveHelper.isValidNumber(q3Sales)) {
			errors += "Invalid number in Q3\n";
			errBool = false;
		}
		
		if(!ReeveHelper.isValidNumber(q4Sales)) {
			errors += "Invalid number in Q4\n";
			errBool = false;
		}
		
		if(ReeveHelper.isNegative(q1Sales)) {
			errors += "Negative number in Q1\n";
			errBool = false;
		}

		if(ReeveHelper.isNegative(q2Sales)) {
			errors += "Negative number in Q2\n";
			errBool = false;
		}
		
		if(ReeveHelper.isNegative(q3Sales)) {
			errors += "Negative number in Q3\n";
			errBool = false;
		}
		
		if(ReeveHelper.isNegative(q4Sales)) {
			errors += "Negative number in Q4\n";
			errBool = false;
		}
		
		
		if(!errBool) {
			messageBox(errors);
		}
		
		return errBool;
	}
}

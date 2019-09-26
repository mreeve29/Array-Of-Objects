import BreezySwing.*;

import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.*;

public class EmployeeSelector extends GBDialog{
	//instance variables
	private Employee[] empArr = new Employee[10];
	
	private DecimalFormat formatter = new DecimalFormat("$0.00");

	private JList employeeList = addList(1,1,1,1);
	private JTextArea employeeDetails = addTextArea("",1,2,2,1);
	
	//update detailed info for employee in textarea 
	private void updateSingleEmployeeText(Employee employee) {
		employeeDetails.setText("Employee:\n"
				+ employee.getName()+"\n"
				+ "Q1 Sales: " + formatSale(employee.getSale(0)) + "\n"
				+ "Q2 Sales: " + formatSale(employee.getSale(1)) + "\n"
				+ "Q3 Sales: " + formatSale(employee.getSale(2)) + "\n"
				+ "Q4 Sales: " + formatSale(employee.getSale(3)) + "\n"
				+ "Total Sales: " + formatSale(employee.getTotal()));	
	}
	
	//adds $ to rounded double
	private String formatSale(double sale) {
		return formatter.format(ReeveHelper.roundMoney(sale));
	}
	
	//listens to single clicks --> gets employee selected
	public void listItemSelected(JList list) {
		updateSingleEmployeeText(empArr[list.getSelectedIndex()]);
	}
	
	//listens to double clicks --> gets employee selected
	public void listDoubleClicked(JList list, String str) {
		updateSingleEmployeeText(empArr[list.getSelectedIndex()]);
	}
	
	//upon initialization, populate the list with the employees passed from the client class
	private void populateList() {
		for(int i = 0; i < empArr.length; i++) {
			Employee current = empArr[i];
			if(current == null)break;
			addItemToList(current.getName());
		}
	}
	
	//add a single item to list
	private void addItemToList(String add) {
		DefaultListModel model = (DefaultListModel)employeeList.getModel();
        model.addElement(add);
	}
	
	//constructor --> asks for a parent JFrame and an array of Employees
	public EmployeeSelector(JFrame parent, Employee[] arr) {
		super(parent);
		this.setTitle("Employee Selector");
		this.setSize(400,300);
		
		employeeDetails.setEditable(false);
		employeeDetails.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		for(int i = 0; i < arr.length; i++) {
			empArr[i] = arr[i];
		}
		populateList();
	}
}

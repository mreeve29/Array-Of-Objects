import BreezySwing.*;

import java.text.DecimalFormat;

import javax.swing.*;


public class Client extends GBFrame{

	DecimalFormat formatter = new DecimalFormat("$0.00");
	
	JButton addEmployeeButton = addButton("Add Employee",7,1,2,1);
	JButton findEmployeeButton = addButton("Find Employee",7,3,3,1);
	JTextArea results = addTextArea("",1,1,6,5);
	
	private final int EMPLOYEES = 10;
	private final int COLUMNS = 16;
	
	private String baseTextArea = "";
	
	private Employee[] empArr = new Employee[EMPLOYEES];
	private int empsAdded = 0;
	
	
	public void buttonClicked(JButton button) {
		if(button == addEmployeeButton) {
			AddEmployee empDialog = new AddEmployee(this);
			empDialog.setVisible(true);
			empDialog.setSize(600,500);
			
			if(empDialog.getDlgCloseIndicator().equals("Confirm")) {
				addEmployee(empDialog.getEmployee());
			}
			
		}else if(button == findEmployeeButton) {
			EmployeeSelector selectorDialog = new EmployeeSelector(this, empArr);
			selectorDialog.setVisible(true);
			selectorDialog.setSize(800,600);
		}
	}
	
	
	
	public void addEmployee(Employee e) {
		try {
			empArr[empsAdded] = e;
			empsAdded++;
			if(empsAdded > 0)findEmployeeButton.setEnabled(true);
			if(empsAdded >= 10)addEmployeeButton.setEnabled(false);
		}catch (Exception exc) {
			System.out.println("Too many employees");
			return;
		}
		
		updateTextArea();
	}



	public void updateTextArea() {
		String resultStr = "";
		for(int i = 0; i < empArr.length; i++) {
			Employee current = empArr[i];
			
			if(current == null) break;
			
			String name = Format.justify('l', current.getName(), 10);
			String q1 = formatSale(current.getSale(0));
			String q2 = formatSale(current.getSale(1));
			String q3 = formatSale(current.getSale(2));
			String q4 = formatSale(current.getSale(3));
			String total = formatSale(current.getTotal());
			
			resultStr += name + q1 + q2 + q3 + q4 + total + '\n';
		}
		results.setText(baseTextArea + "\n" + resultStr);
		
	}
	
	public String formatSale(double sale) {
		String formatted = "";
		
		sale = Math.round(sale * 100.0) / 100.0;
		
		formatted = formatter.format(sale);
		
		formatted = Format.justify('l', formatted, COLUMNS);
		return formatted;
	}


	public Client() {
		findEmployeeButton.setEnabled(false);
		results.setEditable(false);
		
		String nameLabel = Format.justify('l', "Name", 10);
		String q1Label = Format.justify('l', "  Q1", COLUMNS);
		String q2Label = Format.justify('l', "  Q2", COLUMNS);
		String q3Label = Format.justify('l', "  Q3", COLUMNS);
		String q4Label = Format.justify('l', "  Q4", COLUMNS);
		String totalLabel = Format.justify('l', "  Total", COLUMNS);
		
		String lineBreak = "-------------------------------------------------------------------------------------------------";
		
		baseTextArea = nameLabel + q1Label + q2Label + q3Label + q4Label + totalLabel + '\n' + lineBreak;
		
		results.setText(baseTextArea);
	}



	public static void main(String[] args) {
		Client frm = new Client();
		frm.setVisible(true);
		frm.setTitle("Array of Objects");
		frm.setSize(700,300);
	}
	
	
}

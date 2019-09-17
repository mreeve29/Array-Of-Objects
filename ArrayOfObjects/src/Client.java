import BreezySwing.*;
import javax.swing.*;


public class Client extends GBFrame{

	
	JButton addEmployeeButton = addButton("Add Employee",7,1,1,1);
	JTextArea results = addTextArea("",1,1,5,5);
	
	private final int EMPLOYEES = 10;
	private final int COLUMNS = 16;
	
	private String baseTextArea = "";
	
	
	private Employee[] empArr = new Employee[EMPLOYEES];
	private int empsAdded = 0;
	
	
	public void buttonClicked(JButton button) {
		if(button == addEmployeeButton) {
			AddEmployee empDialog = new AddEmployee(this);
			empDialog.setVisible(true);
			empDialog.setSize(400,300);
			
			if(empDialog.getDlgCloseIndicator().equals("Confirm")) {
				addEmployee(empDialog.getEmployee());
			}
			
		}
	}
	
	
	
	public static void main(String[] args) {
		Client frm = new Client();
		frm.setVisible(true);
		frm.setTitle("Array of Objects");
		frm.setSize(800,400);
	}
	
	public Client() {
		results.setEditable(false);
		
		String nameLabel = Format.justify('l', "Name", 10);
		String q1Label = Format.justify('c', "Q1", COLUMNS);
		String q2Label = Format.justify('c', "Q2", COLUMNS);
		String q3Label = Format.justify('c', "Q3", COLUMNS);
		String q4Label = Format.justify('c', "Q4", COLUMNS);
		String totalLabel = Format.justify('c', "Total", COLUMNS);
		
		String lineBreak = "------------------------------------------------------------------------------------------------------";
		
		baseTextArea = nameLabel + q1Label + q2Label + q3Label + q4Label + totalLabel + '\n' + lineBreak;
		
		results.setText(baseTextArea);
	}
	
	
	public void addEmployee(Employee e) {
		try {
			empArr[empsAdded] = e;
			empsAdded++;
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
			String total = Format.justify('c', current.getTotal(), COLUMNS,2);
			
			resultStr += name + q1 + q2 + q3 + q4 + total + '\n';
		}
		//Format.justify('c', resultStr, 1);
		results.setText(baseTextArea + "\n" + resultStr);
		
	}
	
	public String formatSale(double sale) {
		String formatted = "";
		
		sale = Math.round(sale * 100.0) / 100.0;
		
		formatted = "$" + sale;
		
		formatted = Format.justify('c', formatted, COLUMNS);
		
		return formatted;
	}
	
	
}

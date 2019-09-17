import BreezySwing.*;
import javax.swing.*;


public class Client extends GBFrame{

	
	JButton addEmployeeButton = addButton("Add Employee",7,1,1,1);
	JTextArea results = addTextArea("",1,1,5,5);
	
	private final int EMPLOYEES = 10;
	private final int COLUMNS = 8;
	
	private String baseTextArea = "";
	
	
	private Employee[] empArr = new Employee[EMPLOYEES];
	private int empsAdded = 0;
	
	
	public void buttonClicked(JButton button) {
		if(button == addEmployeeButton) {
			AddEmployee empDialog = new AddEmployee(this);
			empDialog.setVisible(true);
			empDialog.setSize(400,150);
			
			if(empDialog.getDlgCloseIndicator().equals("Confirm")) {
				addEmployee(empDialog.getEmployee());
			}
			
		}
	}
	
	
	
	public static void main(String[] args) {
		Client frm = new Client();
		frm.setVisible(true);
		frm.setTitle("Array of Objects");
		frm.setSize(400,600);
	}
	
	public Client() {
		results.setEditable(false);
		
		String nameLabel = Format.justify('l', "Name", 10);
		String q1Label = Format.justify('l', "Q1", COLUMNS);
		String q2Label = Format.justify('l', "Q2", COLUMNS);
		String q3Label = Format.justify('l', "Q3", COLUMNS);
		String q4Label = Format.justify('l', "Q4", COLUMNS-5);
		
		String lineBreak = "-------------------------------------";
		
		baseTextArea = nameLabel + q1Label + q2Label + q3Label + q4Label + '\n' + lineBreak;
		
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
			String q1 = Format.justify('l', current.getSale(0), COLUMNS);
			String q2 = Format.justify('l', current.getSale(1), COLUMNS);
			String q3 = Format.justify('l', current.getSale(2), COLUMNS);
			String q4 = Format.justify('l', current.getSale(3), COLUMNS-5);
			
			resultStr += name + q1 + q2 + q3 + q4 + '\n';
		}
		//Format.justify('c', resultStr, 1);
		results.setText(baseTextArea + "\n" + resultStr);
		
	}
	
	
}

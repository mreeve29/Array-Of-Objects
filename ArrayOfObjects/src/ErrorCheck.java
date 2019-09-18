import BreezySwing.*;
import javax.swing.*;

public class ErrorCheck {
	
	public static boolean isInt(double x) {
		if((int)x == x) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isValidNumber(IntegerField field) {
		if(field.isValidNumber()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isValidNumber(DoubleField field) {
		if(field.isValidNumber()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isBlank(String str) {
		if(str == "" || str.isBlank()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isBlank(JTextField field) {
		String str = field.getText();
		if(str == "" || str.isBlank()) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
}

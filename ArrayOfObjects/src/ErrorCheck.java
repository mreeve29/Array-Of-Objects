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
	
	public static boolean isPositive(int x) {
		if(x > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isPositive(double x) {
		if(x > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isPositive(IntegerField field) {
		int x = field.getNumber();
		if(x > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isPositive(DoubleField field) {
		double x = field.getNumber();
		if(x > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isNegative(IntegerField field) {
		int x = field.getNumber();
		if(x < 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isNegative(DoubleField field) {
		double x = field.getNumber();
		if(x < 0) {
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
		if(str == "" || str.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isBlank(JTextField field) {
		String str = field.getText();
		if(str == "" || str.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
}

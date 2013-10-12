package a04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Reflection {
	
	private static final BufferedReader _reader = new BufferedReader(new InputStreamReader(System.in));
	private static Object _theClass;
	private static Method _method;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try { 
			String input = readClassName();
			
			if (!input.equals(null)) {
				Class<?> c = Class.forName(input);
				_theClass = (Object) c.newInstance();
				
				while(true) {
					
					printDetails(c);
					
					String methodName = readMethodName(); 
					_method = c.getMethod(methodName);
					_method.invoke(_theClass);
				}
			}
			
		} catch(Exception e) { 
			e.printStackTrace(); 
		}
	}
	
	public static String readClassName() {
		try {
			System.out.print("Please enter a class name: "); 
			return _reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null; 
	}
	
	public static String readMethodName() {
		try {
			System.out.print("\n" + "Please select a method to execute: "); 
			return _reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null; 
	}
	
	public static void printDetails(Class <?> c) {
		
		Method[] methods = c.getMethods(); 
		Field[] fields = c.getFields();

		System.out.println("\n" + "~~~~~");
		
		System.out.println("\n" + "Public fields: ");
		for (int i = 0; i < fields.length; i++) { 
			if (Modifier.isPublic(fields[i].getModifiers())) {
				try {
					System.out.println(fields[i].getName() + ": " + fields[i].get(_theClass).toString());
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} 
			}
		}
		
		System.out.println("\n" + "Void methods: ");
		for (int i = 0; i < methods.length; i++) { 
			if (methods[i].getParameterTypes().length == 0) {
				System.out.println(methods[i].getName()); 
			}
		}
	}
}

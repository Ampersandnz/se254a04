package a04;

import a04.InterfaceImplementer;

public class Generate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InterfaceImplementer g = new InterfaceImplementer();
		try {
			Class<?> c = Class.forName("a04.A");
			String result = g.generate(c);
			System.out.println(result);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

	}

}

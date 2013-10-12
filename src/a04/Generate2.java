package a04;

public class Generate2 {
	
	private static ExtractorArgument exArg;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		exArg = new ExtractorArgument();
		exArg.className = "Z";
		
		try {
			exArg.a = Class.forName ("a04.X");
			exArg.b = Class.forName ("a04.Y");
			
			ClassCombiner g = new ClassCombiner();
			
			String result = g.generate(exArg);
			System.out.println(result);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}

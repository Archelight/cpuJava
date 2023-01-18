package project4Test;
import project2.Longword;
import project4.Multiplier;
//Nikita Romanovsky, ICSI404
public class Multiplier_test {
	public static void main(String[] args) throws Exception {
		runAllTests();
	}

	public static void runAllTests() throws Exception {
		testMultiply();
	}
	
	private static void testMultiply() throws Exception {
		if (Multiplier.multiply(new Longword(2), new Longword(30)).getSigned() == 60)
			System.out.println("Testing method multiply(), Input: (Longword(2), Longword(30)), Output: 60, Expected Output: 60");
		else
			System.out.println("Testing method multiply(), Input: (Longword(2), Longword(30)), Output: Wrong Longword");
		if (Multiplier.multiply(new Longword(20000), new Longword(123)).getSigned() == 2460000)
			System.out.println("Testing method multiply(), Input: (Longword(20000), Longword(123)), Output: 2460000, Expected Output: 2460000");
		else
			System.out.println("Testing method multiply(), Input: (Longword(20000), Longword(123)), Output: Wrong Longword");
		if (Multiplier.multiply(new Longword(-20000), new Longword(321)).getSigned() == -6420000)
			System.out.println("Testing method multiply(), Input: (Longword(-20000), Longword(321)), Output: -6420000, Expected Output: -6420000");
		else
			System.out.println("Testing method multiply(), Input: (Longword(-20000), Longword(321)), Output: Wrong Longword");
		if (Multiplier.multiply(new Longword(-20000), new Longword(-321)).getSigned() == 6420000)
			System.out.println("Testing method multiply(), Input: (Longword(-20000), Longword(-321)), Output: 6420000, Expected Output: 6420000");
		else
			System.out.println("Testing method multiply(), Input: (Longword(-20000), Longword(-321)), Output: Wrong Longword");
		if (Multiplier.multiply(new Longword(-1), new Longword(-421)).getSigned() == 421)
			System.out.println("Testing method multiply(), Input: (Longword(-1), Longword(-421)), Output: 421, Expected Output: 421");
		else
			System.out.println("Testing method multiply(), Input: (Longword(-1), Longword(-421)), Output: Wrong Longword");
		if (Multiplier.multiply(new Longword(4322), new Longword(0)).getSigned() == 0)
			System.out.println("Testing method multiply(), Input: (Longword(4322), Longword(0)), Output: 0, Expected Output: 0");
		else
			System.out.println("Testing method multiply(), Input: (Longword(4322), Longword(0)), Output: Wrong Longword");
		if (Multiplier.multiply(new Longword(20000), new Longword(-4000)).getSigned() == -80000000)
			System.out.println("Testing method multiply(), Input: (Longword(20000), Longword(-4000)), Output: -80000000, Expected Output: -80000000");
		else
			System.out.println("Testing method multiply(), Input: (Longword(20000), Longword(-4000)), Output: Wrong Longword");
		if (Multiplier.multiply(new Longword(2147483647), new Longword(1)).getSigned() == 2147483647)
			System.out.println("Testing method multiply(), Input: (Longword(2147483647), Longword(1)), Output: 2147483647, Expected Output: 2147483647");
		else
			System.out.println("Testing method multiply(), Input: (Longword(2147483647), Longword(1)), Output: Wrong Longword");
		System.out.println();
	}
}

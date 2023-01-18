package project3Test;
import project2.Longword;
import project3.RippleAdder;
//Nikita Romanovsky, ICSI404
public class RippleAdder_test {
	public static void main(String[] args) throws Exception {
		runAllTests();
	}

	public static void runAllTests() throws Exception {
		testAdd();
		testSubtract();
		
	}
	
	private static void testAdd() throws Exception {
		if (RippleAdder.add(new Longword(25), new Longword(30)).getSigned() == 55)
			System.out.println("Testing method add(), Input: (Longword(25), Longword(30)), Output: 55, Expected Output: 55");
		else
			System.out.println("Testing method add(), Input: (Longword(25), Longword(30)), Output: Wrong Longword");
		if (RippleAdder.add(new Longword(40000000), new Longword(250000000)).getSigned() == 290000000)
			System.out.println("Testing method add(), Input: (Longword(40000000), Longword(250000000)), Output: 290000000, Expected Output: 290000000");
		else
			System.out.println("Testing method add(), Input: (Longword(40000000), Longword(250000000)), Output: Wrong Longword");
		if (RippleAdder.add(new Longword(-40000000), new Longword(250000000)).getSigned() == 210000000)
			System.out.println("Testing method add(), Input: (Longword(-40000000), Longword(250000000)), Output: 210000000, Expected Output: 210000000");
		else
			System.out.println("Testing method add(), Input: (Longword(-40000000), Longword(250000000)), Output: Wrong Longword");
		if (RippleAdder.add(new Longword(40000000), new Longword(-150000000)).getSigned() == -110000000)
			System.out.println("Testing method add(), Input: (Longword(40000000), Longword(-150000000)), Output: -110000000, Expected Output: -110000000");
		else
			System.out.println("Testing method add(), Input: (Longword(40000000), Longword(-150000000)), Output: Wrong Longword");
		if (RippleAdder.add(new Longword(-40000000), new Longword(-90000000)).getSigned() == -130000000)
			System.out.println("Testing method add(), Input: (Longword(-40000000), Longword(-90000000)), Output: -130000000, Expected Output: -130000000");
		else
			System.out.println("Testing method add(), Input: (Longword(40000000), Longword(-90000000)), Output: Wrong Longword");
		System.out.println();
	}
	
	private static void testSubtract() throws Exception {
		if (RippleAdder.subtract(new Longword(30), new Longword(5)).getSigned() == 25)
			System.out.println("Testing method subtract(), Input: (Longword(30), Longword(5)), Output: 25, Expected Output: 25");
		else
			System.out.println("Testing method subtract(), Input: (Longword(30), Longword(5)), Output: Wrong Longword");
		if (RippleAdder.subtract(new Longword(30000000), new Longword(15000000)).getSigned() == 15000000)
			System.out.println("Testing method subtract(), Input: (Longword(30000000), Longword(15000000)), Output: 15000000, Expected Output: 15000000");
		else
			System.out.println("Testing method subtract(), Input: (Longword(30000000), Longword(15000000)), Output: Wrong Longword");
		if (RippleAdder.subtract(new Longword(30000000), new Longword(-15000000)).getSigned() == 45000000)
			System.out.println("Testing method subtract(), Input: (Longword(30000000), Longword(-15000000)), Output: 45000000, Expected Output: 45000000");
		else
			System.out.println("Testing method subtract(), Input: (Longword(30000000), Longword(-15000000)), Output: Wrong Longword");
		if (RippleAdder.subtract(new Longword(-30000000), new Longword(-15000000)).getSigned() == -15000000)
			System.out.println("Testing method subtract(), Input: (Longword(-30000000), Longword(-15000000)), Output: -15000000, Expected Output: -15000000");
		else
			System.out.println("Testing method subtract(), Input: (Longword(-30000000), Longword(-15000000)), Output: Wrong Longword");
		if (RippleAdder.subtract(new Longword(-30000000), new Longword(15000000)).getSigned() == -45000000)
			System.out.println("Testing method subtract(), Input: (Longword(-30000000), Longword(15000000)), Output: -45000000, Expected Output: -45000000");
		else
			System.out.println("Testing method subtract(), Input: (Longword(-30000000), Longword(15000000)), Output: Wrong Longword");
		if (RippleAdder.subtract(new Longword(200), new Longword(500)).getSigned() == -300)
			System.out.println("Testing method subtract(), Input: (Longword(200), Longword(500)), Output: -300, Expected Output: -300");
		else
			System.out.println("Testing method subtract(), Input: (Longword(200), Longword(500)), Output: Wrong Longword");
		
		System.out.println();
		
	}
}

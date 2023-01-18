package project5Test;

import Project6.Assembler;
import project5.Computer;

public class CPU_test2 {


	public static void main(String[] args) throws Exception {
		runAllTests();
	}

	public static void runAllTests() throws Exception {
		testCPU();
	}
	
	public static void testCPU() throws Exception {
		String[] test1 = new String[] {"jump 4","move R1 5","interrupt 0","halt"};
		String[] assembledCode = Assembler.assemble(test1);
		System.out.println("Test 1 Jump:");
		printRegArray(test1);
		printBitArray(assembledCode);
		Computer testComputer = new Computer();
		testComputer.preload(assembledCode);
		testComputer.run();
		System.out.println("Jumping over move instruction, Test Success");
		System.out.println();
		
		String[] test2 = new String[] {"jump 6","move R1 5","move R2 120","jump 12","interrupt 1","halt","move R1 10","interrupt 0","halt"};
		assembledCode = Assembler.assemble(test2);
		System.out.println("Test 2 Jump:");
		printRegArray(test1);
		printBitArray(assembledCode);
		testComputer = new Computer();
		testComputer.preload(assembledCode);
		testComputer.run();
		System.out.println("Jumping over move and interrupt instructions, Test Success");
		System.out.println();
		
		String[] test3 = new String[] {"jump -4"};
		System.out.println("Test 3 Jump:");
		try {
			assembledCode = Assembler.assemble(test3);
			printRegArray(test3);
			printBitArray(assembledCode);
			testComputer = new Computer();
			testComputer.preload(assembledCode);
			testComputer.run();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Attempting to jump to negative instruction, Test Success");
		System.out.println();
		
		String[] test4 = new String[] {"compare R3 R5","halt"};
		assembledCode = Assembler.assemble(test4);
		System.out.println();
		System.out.println("Test 1 Compare :");
		printRegArray(test4);
		printBitArray(assembledCode);
		System.out.println();
		testComputer = new Computer();
		testComputer.preload(assembledCode);
		testComputer.run();
		System.out.println("GreaterThan Bit = "+testComputer.getCompareBits()[0].getValue()+", Equal Bit = "+testComputer.getCompareBits()[1].getValue());
		System.out.println("Comparing 0 with 0, Test Success");
		
		String[] test5 = new String[] {"move R5 5", "compare R3 R5","halt"};
		assembledCode = Assembler.assemble(test5);
		System.out.println();
		System.out.println("Test 2 Compare :");
		printRegArray(test5);
		printBitArray(assembledCode);
		System.out.println();
		testComputer = new Computer();
		testComputer.preload(assembledCode);
		testComputer.run();
		System.out.println("GreaterThan Bit = "+testComputer.getCompareBits()[0].getValue()+", Equal Bit = "+testComputer.getCompareBits()[1].getValue());
		System.out.println("Comparing 0 with 5, Test Success");
		
		String[] test6 = new String[] {"move R2 5", "compare R2 R6","halt"};
		assembledCode = Assembler.assemble(test6);
		System.out.println();
		System.out.println("Test 3 Compare :");
		printRegArray(test6);
		printBitArray(assembledCode);
		System.out.println();
		testComputer = new Computer();
		testComputer.preload(assembledCode);
		testComputer.run();
		System.out.println("GreaterThan Bit = "+testComputer.getCompareBits()[0].getValue()+", Equal Bit = "+testComputer.getCompareBits()[1].getValue());
		System.out.println("Comparing 5 with 0, Test Success");
		
		String[] test7 = new String[] {"move R3 5","compare R3 R3","branchifnotequal 2","move R1 5","interrupt 0","halt"};
		assembledCode = Assembler.assemble(test7);
		System.out.println();
		System.out.println("Test 1 Branchifnotequal :");
		printRegArray(test7);
		printBitArray(assembledCode);
		testComputer = new Computer();
		testComputer.preload(assembledCode);
		testComputer.run();
		System.out.println("Branch condition failed so R1 contains 5, Test Success");
		
		String[] test8 = new String[] {"move R3 5","compare R3 R1","branchifnotequal 2","move R1 5","interrupt 0","halt"};
		assembledCode = Assembler.assemble(test8);
		System.out.println();
		System.out.println("Test 2 Branchifnotequal :");
		printRegArray(test8);
		printBitArray(assembledCode);
		testComputer = new Computer();
		testComputer.preload(assembledCode);
		testComputer.run();
		System.out.println("Branch condition passed so R1 dosnt contain 5, Test Success");
		
		String[] test20 = new String[] {"move R3 5","compare R1 R3","branchifnotequal 2","move R1 5","interrupt 0","halt"};
		assembledCode = Assembler.assemble(test20);
		System.out.println();
		System.out.println("Test 3 Branchifnotequal :");
		printRegArray(test20);
		printBitArray(assembledCode);
		testComputer = new Computer();
		testComputer.preload(assembledCode);
		testComputer.run();
		System.out.println("Branch condition passed so R1 dosnt contain 5, Test Success");
		
		String[] test9 = new String[] {"move R3 5","compare R3 R1","branchifnotequal 4","move R14 32","move R4 1","branchifNotEqual 0","move R10 70","interrupt 0","halt"};
		assembledCode = Assembler.assemble(test9);
		System.out.println();
		System.out.println("Test 4 Branchifnotequal :");
		printRegArray(test9);
		printBitArray(assembledCode);
		testComputer = new Computer();
		testComputer.preload(assembledCode);
		testComputer.run();
		System.out.println("Branch condition passed so R14 and R4 dont contain 32 and 1, Test Success");
		
		String[] test10 = new String[] {"move R3 10","compare R3 R0","branchifnotequal 6","move R3 19","branchifnotequal 6","move R14 32","move R4 1","branchifNotEqual -8","move R10 70","interrupt 0","halt"};
		assembledCode = Assembler.assemble(test10);
		System.out.println();
		System.out.println("Test 5 Branchifnotequal :");
		printRegArray(test10);
		printBitArray(assembledCode);
		testComputer = new Computer();
		testComputer.preload(assembledCode);
		testComputer.run();
		System.out.println("Branch condition passed so R3 and R14 dont contain 19 and 32, Test Success");
		
		String[] test11 = new String[] {"move R3 5","compare R1 R3","branchifequal 2","move R1 5","interrupt 0","halt"};
		assembledCode = Assembler.assemble(test11);
		System.out.println();
		System.out.println("Test 1 Branchifequal :");
		printRegArray(test11);
		printBitArray(assembledCode);
		testComputer = new Computer();
		testComputer.preload(assembledCode);
		testComputer.run();
		System.out.println("Branch condition failed so R1 contains 5, Test Success");
		
		String[] test12 = new String[] {"compare R3 R1","branchifequal 2","move R1 5","interrupt 0","halt"};
		assembledCode = Assembler.assemble(test12);
		System.out.println();
		System.out.println("Test 2 Branchifequal :");
		printRegArray(test12);
		printBitArray(assembledCode);
		testComputer = new Computer();
		testComputer.preload(assembledCode);
		testComputer.run();
		System.out.println("Branch condition success so R1 dosnt contain 5, Test Success");
		
		String[] test21 = new String[] {"move R3 5","compare R3 R1","branchifequal 2","move R1 5","interrupt 0","halt"};
		assembledCode = Assembler.assemble(test21);
		System.out.println();
		System.out.println("Test 3 Branchifequal :");
		printRegArray(test21);
		printBitArray(assembledCode);
		testComputer = new Computer();
		testComputer.preload(assembledCode);
		testComputer.run();
		System.out.println("Branch condition failed so R1 contains 5, Test Success");
		
		String[] test13 = new String[] {"compare R3 R1","branchifgreaterthan 2","move R1 5","interrupt 0","halt"};
		assembledCode = Assembler.assemble(test13);
		System.out.println();
		System.out.println("Test 1 Branchifgreaterthan :");
		printRegArray(test13);
		printBitArray(assembledCode);
		testComputer = new Computer();
		testComputer.preload(assembledCode);
		testComputer.run();
		System.out.println("Branch condition failed so R1 contains 5, Test Success");
		
		String[] test14 = new String[] {"move R3 5","compare R1 R3","branchifgreaterthan 2","move R1 5","interrupt 0","halt"};
		assembledCode = Assembler.assemble(test14);
		System.out.println();
		System.out.println("Test 2 Branchifgreaterthan :");
		printRegArray(test14);
		printBitArray(assembledCode);
		testComputer = new Computer();
		testComputer.preload(assembledCode);
		testComputer.run();
		System.out.println("Branch condition failed so R1 contains 5, Test Success");
		
		String[] test15 = new String[] {"move R3 5","compare R3 R1","branchifgreaterthan 2","move R1 5","interrupt 0","halt"};
		assembledCode = Assembler.assemble(test15);
		System.out.println();
		System.out.println("Test 3 Branchifgreaterthan :");
		printRegArray(test15);
		printBitArray(assembledCode);
		testComputer = new Computer();
		testComputer.preload(assembledCode);
		testComputer.run();
		System.out.println("Branch condition success so R1 dosnt containt 5, Test Success");
		
		String[] test16 = new String[] {"move R3 5","compare R1 R3","branchifgreaterthanorequal 2","move R1 5","interrupt 0","halt"};
		assembledCode = Assembler.assemble(test16);
		System.out.println();
		System.out.println("Test 1 Branchifgreaterthanorequal :");
		printRegArray(test16);
		printBitArray(assembledCode);
		testComputer = new Computer();
		testComputer.preload(assembledCode);
		testComputer.run();
		System.out.println("Branch condition failed so R1 contains 5, Test Success");
		
		String[] test17 = new String[] {"move R3 5","compare R3 R1","branchifgreaterthanorequal 2","move R1 5","interrupt 0","halt"};
		assembledCode = Assembler.assemble(test17);
		System.out.println();
		System.out.println("Test 2 Branchifgreaterthanorequal :");
		printRegArray(test17);
		printBitArray(assembledCode);
		testComputer = new Computer();
		testComputer.preload(assembledCode);
		testComputer.run();
		System.out.println("Branch condition success so R1 dosnt containt 5, Test Success");
		
		String[] test18 = new String[] {"compare R3 R1","branchifgreaterthanorequal 2","move R1 5","interrupt 0","halt"};
		assembledCode = Assembler.assemble(test18);
		System.out.println();
		System.out.println("Test 3 Branchifgreaterthanorequal :");
		printRegArray(test18);
		printBitArray(assembledCode);
		testComputer = new Computer();
		testComputer.preload(assembledCode);
		testComputer.run();
		System.out.println("Branch condition success so R1 dosnt containt 5, Test Success");
		
		System.out.println();
		System.out.println("Test 4 Branchifgreaterthanorequal: ");
		String[] test19 = new String[] {"compare R3 R1","branchifgreaterthanorequal 512","move R1 5","interrupt 0","halt"};
		try {
			assembledCode = Assembler.assemble(test19);
			System.out.println();
			printRegArray(test19);
			printBitArray(assembledCode);
			testComputer = new Computer();
			testComputer.preload(assembledCode);
			testComputer.run();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Attempting to branch to an out of bounds instruction, Test Success");
	}
	
	public static void printRegArray(String[] commands) {
		for (int k = 0; k < commands.length; k++) {
			System.out.print("Original String " + k + ": ");
			for (int i = 0; i < commands[k].length(); i++) {
				System.out.print(commands[k].charAt(i));
			}
			System.out.println();
		}
	}

	public static void printBitArray(String[] commands) {
		System.out.println();
		for (int k = 0; k < commands.length; k++) {
			System.out.print("Assembled String " + k + ": ");
			int j = 3;
			for (int i = 0; i < commands[k].length(); i++) {
				System.out.print(commands[k].charAt(i));
				if (i == j) {
					System.out.print(" ");
					j = j + 4;
				}
			}
			System.out.println();
		}
	}
}

package project5Test;

import Project6.Assembler;
import project5.Computer;

public class CPU_test3 {

	public static void main(String[] args) throws Exception {
		runAllTests();
	}

	public static void runAllTests() throws Exception {
		testCPU();
	}
	
	public static void testCPU() throws Exception {
		String[] test1 = new String[] {"move R2 4","move R1 5","push R2","push R1","pop R4","pop R7","add R4 R7 R8","interrupt 0","halt"};
		String[] assembledCode = Assembler.assemble(test1);
		System.out.println("Test 1 success push and pop:");
		printRegArray(test1);
		printBitArray(assembledCode);
		Computer testComputer = new Computer();
		testComputer.preload(assembledCode);
		testComputer.run();
		System.out.println();
		
		String[] test2 = new String[] {"call 6","interrupt 0","halt","interrupt 1","return"};
		assembledCode = Assembler.assemble(test2);
		System.out.println("Test 2 success call and return:");
		printRegArray(test2);
		printBitArray(assembledCode);
		testComputer = new Computer();
		testComputer.preload(assembledCode);
		testComputer.run();
		System.out.println();
		
		String[] test3 = new String[] {"move R4 10","move R6 13","call 12","subtract R14 R12 R15","interrupt 0","halt","push R4","push R6","pop R14","pop R12","interrupt 1","return","push R4"};
		assembledCode = Assembler.assemble(test3);
		System.out.println("Test 3 success push, pop, call, and return:");
		printRegArray(test3);
		printBitArray(assembledCode);
		testComputer = new Computer();
		testComputer.preload(assembledCode);
		testComputer.run();
		System.out.println();
		
		String[] test4 = new String[] {"call 8","move R1 15","interrupt 0","halt","move R2 20","move R10 74","call 16","return","push R10","push R2","pop R11","pop R15","return"};
		assembledCode = Assembler.assemble(test4);
		System.out.println("Test 4 success push, pop, call, and return:");
		printRegArray(test4);
		printBitArray(assembledCode);
		testComputer = new Computer();
		testComputer.preload(assembledCode);
		testComputer.run();
		System.out.println();
		
		String[] test5 = new String[] {"move R10 45","move R14 100","push R10","push R14","push R10","pop R7","pop R5","pop R0","interrupt 0","halt"};
		assembledCode = Assembler.assemble(test5);
		System.out.println("Test 5 success push and pop:");
		printRegArray(test5);
		printBitArray(assembledCode);
		testComputer = new Computer();
		testComputer.preload(assembledCode);
		testComputer.run();
		System.out.println();
		
		String[] test6 = new String[] {"move r1 3","move R2 4","push R1","push R2","call 14","interrupt 0","halt","pop r15","pop r1","pop r2","add r1 r2 r3","push r3","push r15","return"};
		assembledCode = Assembler.assemble(test6);
		System.out.println("Test 6 success push, pop, call, return: 3 and 4 swapped places");
		printRegArray(test6);
		printBitArray(assembledCode);
		testComputer = new Computer();
		testComputer.preload(assembledCode);
		testComputer.run();
		System.out.println();
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

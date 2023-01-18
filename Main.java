package project1Test;

import Project6Test.Assembler_test;
import project2Test.Longword_test;
import project3Test.RippleAdder_test;
import project4Test.ALU_test;
import project4Test.Multiplier_test;
import project5Test.CPU_test1;
import project5Test.CPU_test2;
import project5Test.CPU_test3;
import project5Test.Memory_test;

public class Main {
	public static void main(String[] args) throws Exception {
		Bit_test.runAllTests();
		Longword_test.runAllTests();
		RippleAdder_test.runAllTests();
		Multiplier_test.runAllTests();
		ALU_test.runAllTests();
		Memory_test.runAllTests();
		CPU_test1.runAllTests();
		Assembler_test.runAllTests();
		CPU_test2.runAllTests();
		CPU_test3.runAllTests();
	}
}

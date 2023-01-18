package project5;
import project1.Bit;
import project2.Longword;
//Nikita Romanovsky, ICSI404
public class Memory {
	
private Bit[] bitStorage;
	
	public Memory() throws Exception {
		this.bitStorage = new Bit[8192];
		for(int i = 0; i < 8192 ; i++) { 
			this.bitStorage[i] = new Bit(false);
		}
	}
	
	public Longword read(Longword address) throws Exception {
		Longword result = new Longword();
		if(address.getUnsigned() > 1020 || address.getSigned() < 0 ) {
			throw new Exception("Address must be less than 1021 and more than -1"); //since each address read will return the byte at the address plus 3 more bytes, the last 4 bytes of memory cannot be addressed
		}
		for (int i = 0; i < 32; i++) {
			result.setBit( i, bitStorage[address.getSigned() * 8 + i]); //since the address is given as a byte address but the memory is in bits, multiply by 8 to convert to bits
		} //add 0-31 to the address to return 32 bits in memory starting from initial address
		return result;
	}
	
	public void write(Longword address, Longword value) throws Exception {
		if(address.getUnsigned() > 1020 || address.getSigned() < 0) {
			throw new Exception("Address must be less than 1021 and more than -1"); //since each address read will return the byte at the address plus 3 more bytes, the last 4 bytes of memory cannot be addressed
		}
		for (int i = 0; i < 32; i++) {
			this.bitStorage[address.getSigned() * 8 + i] = value.getBit(i); //since the address is given as a byte address but the memory is in bits, multiply by 8 to convert to bits
		}//add 0-31 to the address to return 32 bits in memory starting from initial address
	}
	
	public void printMem() {
		int j = 0;
		System.out.println();
		System.out.println("Memory: ");
		for(int i = 0; i < 8192 ; i = i + 8) { 
			System.out.print("Byte "+j/8+": ");
			for(j = i; j < i + 8; j++)
				System.out.print(bitStorage[j].toString());
			System.out.println();
		}
	}
	
	
}

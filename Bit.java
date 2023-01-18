package project1;
//Nikita Romanovsky, ICSI404
//Representing a Bit
public class Bit {
	
	private boolean value;
	
	public Bit(boolean value) {
		this.value = value;
	}
	
	public void set(boolean newValue) {
		this.value = newValue; //sets the bit value to the input value
	}
	
	public void toggle() {
		if(this.value == true) //if the bit value is set to true, set it to false
			set(false);
		else 
			set(true); //if the bit value is set to false, set it to true
	}
	
	public void set() {
		set(true); //set the bit value to true
	}
	
	public void clear() {
		set(false); //set the bit value to false
	}
	
	public boolean getValue() {
		return value; //returns the bit value
	}

	public Bit and(Bit secondBit) {
		boolean result;
		if(this.value == true) {
			if(secondBit.getValue() == true)
				result = true; //if the first bit value is set to true and the second one is set to true, set the result bit value to true
			else
				result = false; //if the first bit value is set to true but the second one is set to false, set the result bit value to false
		}
		else {
			result = false; //if the first bit value is set to true, set the result bit value to false
		}
		Bit newBit = new Bit(result);
		return newBit;
	}
	
	public Bit or(Bit secondBit) {
		boolean result;
		if(this.value == true) {
			result = true; //if the first bit value is set to true, set the result bit value to true
		}
		else {
			if(secondBit.value == true)
				result = true; //if the first bit value is set to false and the second one is set to true, set the result bit value to true
			else
				result = false; //if both bit values are set to false, set the result bit value to false
		}
		Bit newBit = new Bit(result);
		return newBit;
	}
	
	public Bit xor(Bit secondBit) {
		boolean result;
		if(this.value == true) {
			if(secondBit.value == true)
				result = false; //if the first and second bit values are set to true, set the result bit value to false
			else
				result = true; //if the first bit value is set to true but the second one is false, set the result bit value to true
		}
		else {
			if(secondBit.value == true)
				result = true; //if the first bit value is true but the second one is false, set the result bit value to true
			else
				result = false; //if the first and second bit values are both false, set the result bit value to false
		}
		Bit newBit = new Bit(result);
		return newBit;
	}
	
	public Bit not() {
		boolean result;
		if(this.value == true)
			result = false; //if the bit value is true, set it to false
		else
			result = true; //if the bit value is false, set it to true
		Bit newBit = new Bit(result);
		return newBit;
	}

	@Override
	public String toString() {
		if(this.value == true)
			return "t"; //return string t if the bit value is true
		else
			return "f"; //return string f if the bit value is false
	}
	

}

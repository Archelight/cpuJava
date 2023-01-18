package Project6;
//Nikita Romanovsky, ICSI404
public enum TokenCode {
	EOS(-1),
	AND (10), 
	OR (20),
	XOR (30),			
	NOT (40),
	LEFTSHIFT (50),
	RIGHTSHIFT (60),
	ADD (70),
	SUBTRACT (80),
	MULTIPLY (90),
	HALT (100),
	MOVE (110),
	INTERRUPT (120),
	JUMP (130),
	COMPARE (140),
	BRANCHIFEQUAL (150),
	BRANCHIFGREATERTHAN (160),
	BRANCHIFNOTEQUAL (170),
	BRANCHIFGREATERTHANOREQUAL (180),
	PUSH (190),
	POP (200),
	CALL (210),
	RETURN (220),
	REGISTER (230),
	NUMBER (240);
	
	private final int label;
	
	private TokenCode(int label) {
		this.label = label;
	}
	
	public int getLevelCode() {
        return this.label;
    }
}

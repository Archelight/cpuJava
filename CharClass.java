package Project6;
//Nikita Romanovsky, ICSI404
public enum CharClass {

	LETTER (0),
	DIGIT (1),
	SIGN (2),
	BLANKSPACE(3),
	UNSUPORTED(4);
	private final int label;
	
	private CharClass(int label) {
		this.label = label;
	}
	
	public int getLevelCode() {
        return this.label;
    }
}

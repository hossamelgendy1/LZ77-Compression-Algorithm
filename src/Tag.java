
public class Tag {

	int position;
	int length;
	char nextChar;
	
	public Tag(int position, int length, char nextChar) {
		this.position = position;
		this.length = length;
		this.nextChar = nextChar;
	}
	
	public int getPosition() {
		return position;
	}
	
	public int getLength() {
		return length;
	}
	
	public char getNextChar() {
		return nextChar;
	}	
	
	public String toString() {
		return "<" + position + "," + length + ",\'" + nextChar + "\'>";
	}
}

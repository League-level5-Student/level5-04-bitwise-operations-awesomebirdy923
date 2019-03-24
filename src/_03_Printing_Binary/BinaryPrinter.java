package _03_Printing_Binary;

public class BinaryPrinter {
	//Complete the methods below so they print the passed in parameter in binary.
	//Don't be afraid to use the methods that are already complete to finish the others.
	//Create a main method to test your methods.
	
	public BinaryPrinter(byte b, short s, int i, long l) {
		printByteBinary(b);
		System.out.println();
		printShortBinary(s);
		System.out.println();
		printIntBinary(i);
		System.out.println();
		printLongBinary(l);
	}
	
	public void printByteBinary(byte b) {
		byte[] bits = new byte[8];
		int multiple = 1;
		for (int i = 0; i < bits.length; i++) {
				bits[i] = (byte) ((byte) (b & multiple)>>i);
				multiple<<=1;
		}
		for (int i = bits.length-1; i >= 0; i--) {
			if(bits[i] != -1) {
				System.out.print(bits[i]);
			}else {
				System.out.print("1");
			}
		}
	}
	
	public void printShortBinary(short s) {
		byte byte1 = (byte) (s & 255);
		byte byte2 = (byte) ((s>>8) & 255);
		printByteBinary(byte2);
		printByteBinary(byte1);
	}
	
	public void printIntBinary(int i) {
		short short1 = (short) (i & 0b1111111111111111);
		short short2 = (short) ((i>>16) & 0b1111111111111111);
		printShortBinary(short2);
		printShortBinary(short1);
	}
	
	public void printLongBinary(long l) {
		int int1 = (int) (l & 0b11111111111111111111111111111111);
		int int2 = (int) ((l>>32) & 0b11111111111111111111111111111111);
		printIntBinary(int2);
		printIntBinary(int1);
	}
	
	public static void main(String[] args) {
		new BinaryPrinter((byte) 7, (short) 2, 100, 64021505);
	}
	
}

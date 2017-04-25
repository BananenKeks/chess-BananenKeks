import java.io.IOException;

//Main class.
public class Main {
	public static Figure click = new Figure();
	public static Board start = new Board();
	private static int aMoving[][] = new int[8][8];
	public static void main(String[] args) throws IOException {
		// Figure F = new Figure();
	}
	public static int[][] getaMoving() {
		return aMoving;
	}
	public static void setaMoving(int aMoving[][]) {
		Main.aMoving = aMoving;
	}
}
// END Main class.

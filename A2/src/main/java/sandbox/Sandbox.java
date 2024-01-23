package sandbox;

public class Sandbox {
	public static int findMax(int[] array) {
		int max = array[0];
		for (int value : array) {
			if (value > max) {
				max = value;
			}
		}
		return max;
	}
	
	public static int addNumbers(int x, int y) {
		return x+y;
	}
	
	public static void displayName(String name) {
		System.out.println("Hello " + name + ".");
	}
}

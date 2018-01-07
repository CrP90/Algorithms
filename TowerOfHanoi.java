public class TowerOfHanoi {

	public static void main(String[] args) {
		tower(3, "Left", "Right", "Middle");
	}

	static void tower(int n, String src, String dest, String aux) {
		if (n > 0) {
			tower((n - 1), src, aux, dest);
			System.out.println("Move disk " + n + " from " + src + " to " + dest);
			tower((n - 1), aux, dest, src);
		}
	}
}


public class RandomSurfer {
	public static void main(String[] args) {
		int T = Integer.parseInt(args[0]);
		int N = StdIn.readInt();
		StdIn.readInt();
		
		double[][] p = new double[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) 
				p[i][j] = StdIn.readDouble();
		
		int page = 0;
		int[] freq = new int[N];
		for (int t = 0; t < T; t++) {
			double r = Math.random();
			double sum = 0.0;
			for (int j = 0; j < N; j++) {
				sum += p[page][j];
				if (r < sum) {  
					page = j;
					break;
				}
			}
			freq[page]++;
			
			StdDraw.clear();
			StdDraw.setXscale(-1, N);
			StdDraw.setYscale( 0, T);
			StdDraw.setPenRadius(.5/N);
			for (int i = 0; i < N; i++)
				StdDraw.line(i, 0, i, freq[i]);
			StdDraw.show(20);
		}
		for (int i = 0; i < N; i++)
			StdOut.printf("%8.5f", (double) freq[i] / T);
		StdOut.println();		
	}
}

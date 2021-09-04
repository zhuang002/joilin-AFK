import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static char[][] map = null;
	static int[] start = new int[2];
	static int rows;
	static int columns;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = sc.nextInt();
		for (int i=0;i<n;i++) {
			doCase();
		}
	}
	private static void doCase() {
		// TODO Auto-generated method stub
		readInCase();
		
		ArrayList<int[]> current = new ArrayList<>();
		ArrayList<int[]> next = new ArrayList<>();
		current.add(start);
		map[start[0]][start[1]]='P';
		int step=0;
		while (!current.isEmpty()) {
			step++;
			if (step>=60) break;
			for (int[] pos : current) {
				
				
				
				int[] newLoc = tryNextStep(pos, -1,0);
				if (newLoc != null) {
					if (map[newLoc[0]][newLoc[1]]=='W') {
						System.out.println(step);
						return;
					} else
						map[newLoc[0]][newLoc[1]]='P';
						next.add(newLoc);
				}
				
				newLoc = tryNextStep(pos, 0,-1);
				if (newLoc != null) {
					if (map[newLoc[0]][newLoc[1]]=='W') {
						System.out.println(step);
						return;
					} else
						map[newLoc[0]][newLoc[1]]='P';
						next.add(newLoc);
				}
				
				newLoc = tryNextStep(pos, 1,0);
				if (newLoc != null) {
					if (map[newLoc[0]][newLoc[1]]=='W') {
						System.out.println(step);
						return;
					} else
						map[newLoc[0]][newLoc[1]]='P';
						next.add(newLoc);
				}
				
				newLoc = tryNextStep(pos, 0,1);
				if (newLoc != null) {
					if (map[newLoc[0]][newLoc[1]]=='W') {
						System.out.println(step);
						return;
					} else
						map[newLoc[0]][newLoc[1]]='P';
						next.add(newLoc);
				}
				
			}
			current = next;
			next=new ArrayList<>();
		}
		System.out.println("#notworth");
		
	}
	private static int[] tryNextStep(int[] pos, int i, int j) {
		// TODO Auto-generated method stub
		int row = pos[0]+i;
		int col = pos[1]+j;
		if (row>=0 && row<=rows-1 && col>=0 && col <=columns-1 && (map[row][col]=='O' || map[row][col]=='W') ) {
			int[] newLoc = {row,col};
			return newLoc;
		}
		return null;
	}
	private static void readInCase() {
		// TODO Auto-generated method stub
		columns = sc.nextInt();
		rows = sc.nextInt();
		
		map = new char[rows][columns];
		sc.nextLine();
		for (int i=0;i<rows;i++) {
			String line = sc.nextLine();
			for (int j=0;j<columns;j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j]=='C') {
					start[0]=i;
					start[1]=j;
				}
			}
		}
	}

}

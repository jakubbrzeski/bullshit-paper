package bullshit_paper;

import java.util.Random;

public class SudokuGenerator {
    private final Random r = new Random();
    public Sudoku generate() {
        int n = 9;
        Sudoku s = new Sudoku();
        
		if (r.nextInt(9) < 2) s.set(0, 0, 3);
		if (r.nextInt(9) < 2) s.set(0, 1, 8);
		if (r.nextInt(9) < 2) s.set(0, 2, 1);
		if (r.nextInt(9) < 2) s.set(0, 3, 7);
		if (r.nextInt(9) < 2) s.set(0, 4, 4);
		if (r.nextInt(9) < 2) s.set(0, 5, 9);
		if (r.nextInt(9) < 2) s.set(0, 6, 2);
		if (r.nextInt(9) < 2) s.set(0, 7, 6);
		if (r.nextInt(9) < 2) s.set(0, 8, 5);
		
		if (r.nextInt(9) < 2) s.set(1, 0, 2);
		if (r.nextInt(9) < 2) s.set(1, 1, 5);
		if (r.nextInt(9) < 2) s.set(1, 2, 9);
		if (r.nextInt(9) < 2) s.set(1, 3, 6);
		if (r.nextInt(9) < 2) s.set(1, 4, 8);
		if (r.nextInt(9) < 2) s.set(1, 5, 3);
		if (r.nextInt(9) < 2) s.set(1, 6, 7);
		if (r.nextInt(9) < 2) s.set(1, 7, 4);
		if (r.nextInt(9) < 2) s.set(1, 8, 1);
		
		if (r.nextInt(9) < 2) s.set(2, 0, 6);
		if (r.nextInt(9) < 2) s.set(2, 1, 4);
		if (r.nextInt(9) < 2) s.set(2, 2, 7);
		if (r.nextInt(9) < 2) s.set(2, 3, 2);
		if (r.nextInt(9) < 2) s.set(2, 4, 5);
		if (r.nextInt(9) < 2) s.set(2, 5, 1);
		if (r.nextInt(9) < 2) s.set(2, 6, 3);
		if (r.nextInt(9) < 2) s.set(2, 7, 8);
		if (r.nextInt(9) < 2) s.set(2, 8, 9);
		
		if (r.nextInt(9) < 2) s.set(3, 0, 5);
		if (r.nextInt(9) < 2) s.set(3, 1, 3);
		if (r.nextInt(9) < 2) s.set(3, 2, 8);
		if (r.nextInt(9) < 2) s.set(3, 3, 4);
		if (r.nextInt(9) < 2) s.set(3, 4, 6);
		if (r.nextInt(9) < 2) s.set(3, 5, 2);
		if (r.nextInt(9) < 2) s.set(3, 6, 9);
		if (r.nextInt(9) < 2) s.set(3, 7, 1);
		if (r.nextInt(9) < 2) s.set(3, 8, 7);
		
		if (r.nextInt(9) < 2) s.set(4, 0, 1);
		if (r.nextInt(9) < 2) s.set(4, 1, 4);
		if (r.nextInt(9) < 2) s.set(4, 2, 2);
		if (r.nextInt(9) < 2) s.set(4, 3, 8);
		if (r.nextInt(9) < 2) s.set(4, 4, 9);
		if (r.nextInt(9) < 2) s.set(4, 5, 7);
		if (r.nextInt(9) < 2) s.set(4, 6, 5);
		if (r.nextInt(9) < 2) s.set(4, 7, 3);
		if (r.nextInt(9) < 2) s.set(4, 8, 6);
		
		if (r.nextInt(9) < 2) s.set(5, 0, 9);
		if (r.nextInt(9) < 2) s.set(5, 1, 6);
		if (r.nextInt(9) < 2) s.set(5, 2, 7);
		if (r.nextInt(9) < 2) s.set(5, 3, 1);
		if (r.nextInt(9) < 2) s.set(5, 4, 3);
		if (r.nextInt(9) < 2) s.set(5, 5, 5);
		if (r.nextInt(9) < 2) s.set(5, 6, 4);
		if (r.nextInt(9) < 2) s.set(5, 7, 2);
		if (r.nextInt(9) < 2) s.set(5, 8, 8);
		
		if (r.nextInt(9) < 2) s.set(6, 0, 7);
		if (r.nextInt(9) < 2) s.set(6, 1, 1);
		if (r.nextInt(9) < 2) s.set(6, 2, 3);
		if (r.nextInt(9) < 2) s.set(6, 3, 5);
		if (r.nextInt(9) < 2) s.set(6, 4, 2);
		if (r.nextInt(9) < 2) s.set(6, 5, 8);
		if (r.nextInt(9) < 2) s.set(6, 6, 6);
		if (r.nextInt(9) < 2) s.set(6, 7, 9);
		if (r.nextInt(9) < 2) s.set(6, 8, 4);
		
		if (r.nextInt(9) < 2) s.set(7, 0, 8);
		if (r.nextInt(9) < 2) s.set(7, 1, 9);
		if (r.nextInt(9) < 2) s.set(7, 2, 6);
		if (r.nextInt(9) < 2) s.set(7, 3, 3);
		if (r.nextInt(9) < 2) s.set(7, 4, 7);
		if (r.nextInt(9) < 2) s.set(7, 5, 4);
		if (r.nextInt(9) < 2) s.set(7, 6, 1);
		if (r.nextInt(9) < 2) s.set(7, 7, 5);
		if (r.nextInt(9) < 2) s.set(7, 8, 2);
		
		if (r.nextInt(9) < 2) s.set(8, 0, 4);
		if (r.nextInt(9) < 2) s.set(8, 1, 2);
		if (r.nextInt(9) < 2) s.set(8, 2, 5);
		if (r.nextInt(9) < 2) s.set(8, 3, 9);
		if (r.nextInt(9) < 2) s.set(8, 4, 1);
		if (r.nextInt(9) < 2) s.set(8, 5, 6);
		if (r.nextInt(9) < 2) s.set(8, 6, 8);
		if (r.nextInt(9) < 2) s.set(8, 7, 7);
		if (r.nextInt(9) < 2) s.set(8, 8, 3);		
		
        return s;
    }
    public static void main(String[] args) {
        Sudoku s = new SudokuGenerator().generate();
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(s.get(i,j) + " ");
            }
            System.out.println();
        }
    }
}

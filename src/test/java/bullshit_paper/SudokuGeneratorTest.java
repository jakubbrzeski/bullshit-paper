package bullshit_paper;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;


public class SudokuGeneratorTest {
	
	private final SudokuGenerator generator = new SudokuGenerator();
		

	@Test
	public void testThereAreNoDuplicatesInRows() {
		Sudoku sudoku = generator.generate();
		Boolean duplicate = false;
		
		for(int i=0; i<9; i++){
			Set<Integer> set = new HashSet<Integer>();
			int value;
			for(int j=0; j<9; j++){
				if((value = sudoku.get(i, j))!=0){
					if(set.contains(value)){
						duplicate = false;
						break;
					}
					set.add(value);
				}
			}
			if(!duplicate) break;
		}
		
		Assert.assertFalse(duplicate);
	}
	
	@Test
	public void testThereAreNoDuplicatesInColumns() {
		Sudoku sudoku = generator.generate();
		Boolean duplicate = false;
		
		for(int i=0; i<9; i++){
			Set<Integer> set = new HashSet<Integer>();
			int value;
			for(int j=0; j<9; j++){
				if((value = sudoku.get(j, i))!=0){
					if(set.contains(value)){
						duplicate = false;
						break;
					}
					set.add(value);
				}
			}
			if(!duplicate) break;
		}
		
		Assert.assertFalse(duplicate);
	}
	
	@Test
	public void testThereAreNoDuplicatesInSquares() {
		Sudoku sudoku = generator.generate();
		Boolean duplicate = false;
		int c = 0;
		int r = 0;
		int value;
		
		for(int i=0; i<9; i++){
			Set<Integer> set = new HashSet<Integer>();
			c = 0;
			for(int k=r; k<r+3; k++){
				for(int j=c; j<c+3; j++){
					if((value = sudoku.get(i, j))!=0){
						if(set.contains(value)){
							duplicate = false;
							break;
						}
						set.add(value);
					}
				}
				c++;
			}
			r+=3;
		}
		
		Assert.assertFalse(duplicate);
	}

}



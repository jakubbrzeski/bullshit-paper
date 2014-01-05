package bullshit_paper;

import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuGenerator {
    private final Random r = new Random();
    public Sudoku generate() {
        Sudoku s = new Sudoku();
        
    	int value = r.nextInt(9)+1;
    	int i = r.nextInt(3);
    	int q = r.nextInt(3);
    	int j = r.nextInt(3);
		
    	List<Set<Integer>> rows = new ArrayList<Set<Integer>>();
    	List<Set<Integer>> columns = new ArrayList<Set<Integer>>();
    	List<Set<Integer>> squares = new ArrayList<Set<Integer>>();
		int n=9;
		
		Set<Integer> set = new HashSet<Integer>();
		
		while(n-- >0){
		    rows.add(new HashSet<Integer>());
		    columns.add(new HashSet<Integer>());
		    squares.add(new HashSet<Integer>());
		}
    	
    	if(r.nextBoolean()){
    		for(int k=0; k<3; k++){
    			int m = r.nextInt(9)+1;
    			while(m==value || set.contains(m)) m = r.nextInt(9)+1;
    			rows.get(j*3+i).add(m);
    			columns.get(q*3+k).add(m);
    			set.add(m);
    			squares.get(getSquareId(j*3+i, q*3+k)).add(m);
    			s.set(j*3+i, q*3+k, m);
    		}
    		int c = ((q+2)%3)*3+r.nextInt(3);
    		s.set(j*3+(i+1)%3, c, value);
    		columns.get(c).add(value);
    		rows.get(j*3+(i+1)%3).add(value);
    		squares.get(getSquareId(j*3+(i+1)%3, c)).add(value);
    		
    		c = ((q+1)%3)*3+r.nextInt(3);
    		s.set(j*3+(i+2)%3, c, value);    		
    		columns.get(c).add(value);
    		rows.get(j*3+(i+2)%3).add(value);
    		squares.get(getSquareId(j*3+(i+2)%3, c)).add(value);
    	}
    	else{
    		for(int k=0; k<3; k++){
    			int m = r.nextInt(9)+1;
    			while(m==value || set.contains(m)) m = r.nextInt(9)+1;
    			rows.get(q*3+k).add(m);
    			columns.get(j*3+i).add(m);
    			squares.get(getSquareId(q*3+k, j*3+i)).add(value);
    			set.add(m);
    			s.set(q*3+k, j*3+i, m);
    		}
    		
    		int id = ((q+2)%3)*3+r.nextInt(3);
    		s.set(id, j*3+(i+1)%3, value);
    		columns.get(j*3+(i+1)%3).add(value);
    		rows.get(id).add(value);
    		squares.get(getSquareId(id, j*3+(i+1)%3)).add(value);
    		
    		id = ((q+1)%3)*3+r.nextInt(3);
    		s.set(id, j*3+(i+2)%3, value);   		
    		columns.get(j*3+(i+2)%3).add(value);
    		rows.get(id).add(value);
    		squares.get(getSquareId(id, j*3+(i+2)%3)).add(value);
    	}
    	
    	for(int k = 0; k < 9; k++) {
            for (int l = 0; l < 9; l++) {            	
            	if(s.get(k, l)== 0 && r.nextInt(9)<2){
            		value = r.nextInt(9)+1;
            		while(rows.get(k).contains(value) || columns.get(l).contains(value)
            				|| squares.get(getSquareId(k,l)).contains(value)) {
            			value = r.nextInt(9)+1; 
            		}
        			s.set(k, l, value);
            		rows.get(k).add(value); 
            		columns.get(l).add(value);
            		squares.get(getSquareId(k,l)).add(value);
            	}
            }
    	}		
        return s;
    }
    
    private int getSquareId(int row, int column){
    	return (row/3)*3+(column/3);
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

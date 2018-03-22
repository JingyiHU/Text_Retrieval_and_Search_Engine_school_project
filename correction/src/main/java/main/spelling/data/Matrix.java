package main.spelling.data;

import java.util.ArrayList;
import java.util.List;

public class Matrix {
	private final List<List<Integer>> data;
	private final int rows;
	private final int columns;

	public Matrix(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;

		data = new ArrayList<>();
		for (int i = 0; i < rows; i++) {
			ArrayList<Integer> row = new ArrayList<>();
			data.add(row);
			for (int j = 0; j < columns; j++) {
				row.add(0);
			}
		}
	}
	
	public Integer get(int row, int column) {
		return data.get(row).get(column);
	}
	
	public void set(int row, int column, Integer value) {
		data.get(row).set(column, value);
	}
	
	public void print() {
		for (int i = 0; i < rows; i++) {
			System.out.print("|");
			for (int j = 0; j < columns; j++) {
				System.out.print(get(i, j) + "|");
			}
			System.out.print("\n");
		}
	}
}

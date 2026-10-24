package crossword;

public class Grid {
    private char [][] cells;
    private int rows;
    private int cols;

    public Grid(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        cells = new char[rows][cols];
        
        for (int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j++){
                cells[i][j] = '_';
            }
        }
    }

    public boolean isValidPosition (int row, int col){
        return row >=0 && row < rows && col >=0 && col < cols;
    }

    public char getCell(int row, int col){
        if(!isValidPosition(row, col)) return '#';
        return cells[row][col];
    }

    public void setCell(int row, int col, char value){
        if(isValidPosition(row, col)){
            cells[row][col] = Character.toLowerCase(value);
        }
    }

    public void printGrid(){
        StringBuilder row = new StringBuilder();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                row.append(cells[i][j] + " ");
            }
            System.out.print(row + "\n");
            row.setLength(0);
        }
    }
    
}

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

    public boolean canPlaceWord(String word, int row, int col, boolean horizontal){
        word = word.toLowerCase();
        for (int k = 0; k < word.length(); k++){
            int r = row;
            int c = col;
            if (horizontal){
                c = col + k;
            } else {
                r = row + k;
            }
            
            char cell = getCell(r,c);

            if(cell == '_');
            else if(cell == '#')return false;
            else if(word.charAt(k) != cell) return false;
        }
        return true;
    }      

    public boolean[] placeWord(String word, int row, int col, boolean horizontal){
        word = word.toLowerCase();
        boolean[] newCells = new boolean[word.length()];
        for (int i = 0; i < word.length(); i++){
            int c = col;
            int r = row;
            if(horizontal){
                c = col + i;
            } else{
                r = row + i;
            }

            if(getCell(r, c) == '_'){
                setCell(r, c, word.charAt(i));
                newCells[i] = true;
            }
        }
        return newCells;
    }

    public void removeWord(String word, int row, int col, boolean horizontal, boolean[] newCells){
        word = word.toLowerCase();
        for(int i = 0; i < word.length(); i++){
            int r = row;
            int c = col;
            if(horizontal){
                c = col + i;
            } else{
                r = row + i;
            }
            if(newCells[i]){
                setCell(r, c, '_');
            }
        }
    }
}

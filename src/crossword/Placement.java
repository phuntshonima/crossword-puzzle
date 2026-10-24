package crossword;

public class Placement {
    String word;
    int row;
    int col;
    boolean horizontal;
    boolean[] newCells;

    public Placement(String word, int row, int col, boolean horizontal, boolean[] newCells){
        this.word = word;
        this.row = row;
        this.col = col;
        this.horizontal = horizontal;
        this.newCells = newCells;
    }
}
package crossword;

public class Backtracker {
    private Grid grid;
    private String[] words;
    private Stack stack;

    public Backtracker(Grid grid, String[] words){
        this.grid = grid;
        this.words = words;
        this.stack = new Stack();
    }

    public boolean solve(){
        return solve(0);
    }

    private boolean solve(int wordIndex){
        if (wordIndex == words.length) return true;

        String word = words[wordIndex];

        for(int i = 0; i < grid.getRows(); i++){
            for(int j = 0; j < grid.getCols(); j++){
                for(int d = 0; d < 2; d++){
                    boolean horizontal = (d==0);
                    if(grid.isValidPlacement(word, i, j, horizontal, wordIndex == 0)){
                        boolean[] newCells = grid.placeWord(word, i, j, horizontal);
                        stack.push(new Placement(word, i, j, horizontal, newCells));

                        if(solve(wordIndex + 1)) return true;

                        Placement p = stack.pop();
                        grid.removeWord(p.word, p.row, p.col, p.horizontal, p.newCells);
                    }
                }
            }
        }
        return false;
    }
}

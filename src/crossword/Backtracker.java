package crossword;

public class Backtracker {
    private Grid grid;
    private String[] words;
    private Stack stack;
    private boolean[] placed;

    public Backtracker(Grid grid, String[] words){
        this.grid = grid;
        this.words = words;
        this.stack = new Stack();
        this.placed = new boolean[words.length];
    }

    public boolean solve(){
        for (int i = 0; i < words.length; i++){
            if(countValidPlacements(words[i], true) == 0) return false;
        }
        return solve(0);
    }

    private boolean solve(int placedCount){
        if (placedCount == words.length) return true;

        int idx = pickNextWord();
        if(idx == -1) return false;

        String word = words[idx];
        boolean isFirst = stack.isEmpty();
        placed[idx] = true;
 
        for(int i = 0; i < grid.getRows(); i++){
            for(int j = 0; j < grid.getCols(); j++){
                for(int d = 0; d < 2; d++){
                    boolean horizontal = (d==0);
                    if(grid.isValidPlacement(word, i, j, horizontal, isFirst)){
                        boolean[] newCells = grid.placeWord(word, i, j, horizontal);
                        stack.push(new Placement(word, i, j, horizontal, newCells));

                        if(solve(placedCount + 1)) return true;

                        Placement p = stack.pop();
                        grid.removeWord(p.word, p.row, p.col, p.horizontal, p.newCells);
                    }
                }
            }
        }
        placed[idx] = false;
        return false;
    }

    private int countValidPlacements(String word, boolean isFirstWord){
        int count = 0;
        for(int i = 0; i < grid.getRows(); i++){
            for(int j = 0; j < grid.getCols(); j++){
                for(int d = 0; d < 2; d++){
                    boolean horizontal = (d == 0);
                    if(grid.isValidPlacement(word, i, j, horizontal, isFirstWord)){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private  int pickNextWord(){
        int bestIndex = -1;
        int bestCount = Integer.MAX_VALUE;

        for(int i = 0; i < words.length; i++){
            if(placed[i]) continue;
            int count = countValidPlacements(words[i], stack.isEmpty());
            if (count == 0)continue;

            if(count < bestCount){
                bestCount = count;
                bestIndex = i;
            }
        }
        return bestIndex;
    }

}

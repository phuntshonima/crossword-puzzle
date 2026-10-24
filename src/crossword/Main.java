package crossword;

public class Main {
    public static void main(String[] args) {
        Grid g = new Grid(5,5);

        // System.out.println(g.canPlaceWord("Cat", 0, 0, true));
        // System.out.println(g.canPlaceWord("planet", 0, 0, true));

        // g.setCell(0, 0, 'c');
        // g.setCell(0, 1, 'a');
        // g.setCell(0, 2, 't');
        // System.out.println(g.canPlaceWord("car", 0, 0, true));
        // System.out.println(g.canPlaceWord("cab", 0, 0, false));

        // boolean[] cab = g.placeWord("cab", 0, 0, true);
        // boolean[] cat = g.placeWord("cat", 0, 0, false);
        // g.printGrid();
        // System.out.println();

        // g.removeWord("cat", 0, 0, false, cat);
        // g.printGrid();
        // System.out.println();

        // g.removeWord("cab", 0, 0, true, cab);
        // g.printGrid();

        // Stack s = new Stack();
        // System.out.println(s.isEmpty());   

        // s.push(new Placement("cab", 0, 0, true,  new boolean[]{true, true, true}));
        // s.push(new Placement("cat", 0, 0, false, new boolean[]{false, true, true}));

        // System.out.println(s.isEmpty());   
        // System.out.println(s.peek().word); 
        // System.out.println(s.pop().word);  
        // System.out.println(s.pop().word);  
        // System.out.println(s.pop());   

        System.out.println(g.isValidPlacement("cab", 0, 0, true, true));    
        g.placeWord("cab", 0, 0, true);
        System.out.println(g.isValidPlacement("cat", 0, 0, false, false));  
        System.out.println(g.isValidPlacement("dog", 2, 3, false, false));  
    }
}

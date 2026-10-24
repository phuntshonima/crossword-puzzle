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

        boolean[] cab = g.placeWord("cab", 0, 0, true);
        boolean[] cat = g.placeWord("cat", 0, 0, false);
        g.printGrid();
        System.out.println();

        g.removeWord("cat", 0, 0, false, cat);
        g.printGrid();
        System.out.println();

        g.removeWord("cab", 0, 0, true, cab);
        g.printGrid();
    }
}

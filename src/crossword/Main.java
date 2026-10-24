package crossword;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid(5, 5);
        grid.printGrid();

        grid.setCell(0, 0, 'C');
        grid.setCell(0, 1, 'a');
        grid.setCell(0, 2, 't');
        grid.setCell(2, 2, '#');
        grid.setCell(9, 9, 'x');

        System.out.println();
        grid.printGrid();

        System.out.println(grid.getCell(0, 0));
        System.out.println(grid.getCell(9, 9));
    }
}

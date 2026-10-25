package crossword;

public class Main {
    public static void main(String[] args) {
        // Grid g = new Grid(5,5);

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

        // System.out.println(g.isValidPlacement("cab", 0, 0, true, true));    
        // g.placeWord("cab", 0, 0, true);
        // System.out.println(g.isValidPlacement("cat", 0, 0, false, false));  
        // System.out.println(g.isValidPlacement("dog", 2, 3, false, false));  
        
        // Grid g1 = new Grid(5, 5);
        // System.out.println(new Backtracker(g1, new String[]{"cat", "cab", "bat"}).solve());  
        // g1.printGrid();

        // Grid g2 = new Grid(5, 5);
        // System.out.println(new Backtracker(g2, new String[]{"cat", "dog"}).solve());          
        // g2.printGrid();                                                                      

        // Grid g3 = new Grid(5, 5);
        // System.out.println(new Backtracker(g3, new String[]{"cat", "cab", "bat", "xylophone"}).solve()); 
        
        // WordLoader w = new WordLoader();
        // System.out.println(w.isAllLetters("cat"));   
        // System.out.println(w.isAllLetters("Cat"));         
        // System.out.println(w.isAllLetters("ice-cream"));   
        // System.out.println(w.isAllLetters("new york"));    
        // System.out.println(w.isAllLetters("")); 
        
        Trie t = new Trie();
        System.out.println(t.size());   // ?
        t.insert("cat");
        t.insert("cab");
        t.insert("cat");                // duplicate
        t.insert("Cat");                // duplicate after lowercasing
        System.out.println(t.size());   // ?
        
        String[] raw = {"stack", "trie", "grid", "array", "tree", "heap", "node", "graph"};
        String[] words = new WordLoader().loadWords(raw);

        Grid big = new Grid(11, 11);
        long start = System.currentTimeMillis();
        boolean ok = new Backtracker(big, words).solve();
        long ms = System.currentTimeMillis() - start;

        System.out.println(ok + " in " + ms + " ms");
        big.printGrid();
       
    }
}

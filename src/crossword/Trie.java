package crossword;

public class Trie {
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert (String word){
        word = word.toLowerCase();
        TrieNode current = root;
        for (char c : word.toCharArray()){
            int index = c - 'a';
            if (current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word){
        word = word.toLowerCase();
        TrieNode current = root;
        for (char c : word.toCharArray()){
            int index = c - 'a';
            if (current.children[index] == null){
                return false;
            }
            current = current.children[index];
        }
        return current.isEndOfWord;
    }
}

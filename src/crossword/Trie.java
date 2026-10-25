package crossword;

public class Trie {
    private TrieNode root;
    private int wordCount;
    private int fillIndex;

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

        if(!current.isEndOfWord){
            wordCount++;
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

    public int size(){
        return wordCount;
    }

    public String[] collectWords(){
        String[] result = new String[wordCount];
        fillIndex = 0;
        collect(root, "", result);
        return result;
    }

    private void collect (TrieNode node, String path, String[] result){
        if(node.isEndOfWord){
            result[fillIndex] = path;
            fillIndex++;
        }

        for(int i =0; i < 26; i++){
            if(node.children[i] != null){
                char letter = (char) ('a' + i);
                collect(node.children[i], path + letter, result);
            }
        }
    }



}



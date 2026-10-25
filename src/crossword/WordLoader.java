package crossword;

public class WordLoader {
    public boolean isAllLetters(String word){
        if(word.length() == 0) return false;

        word = word.toLowerCase();

        for(int i = 0; i <word.length(); i++){
            char ch = word.charAt(i);
            if(ch < 'a' || ch > 'z')return false;
        }
        return true;
    }

    public String[] loadWords(String[] raw){
        Trie trie = new Trie();

        for(int i = 0; i < raw.length; i++){
            if(isAllLetters(raw[i])){
                trie.insert(raw[i]);
            }
        }
        return trie.collectWords();
    }
 
}

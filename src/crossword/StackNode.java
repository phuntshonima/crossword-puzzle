package crossword;

public class StackNode {
    Placement data;
    StackNode next;

    public StackNode(Placement data){
        this.data = data;
        next = null;
    }
}

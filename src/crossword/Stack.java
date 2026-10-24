package crossword;

public class Stack {
    StackNode top;

    public Stack(){
        top = null;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void push(Placement p){
        StackNode newNode = new StackNode(p);
        newNode.next = top;
        top = newNode;
    }

    public Placement pop(){
        if(isEmpty())return null;
        Placement popped = top.data;
        top = top.next;
        return popped;
    }

    public Placement peek(){
        if(isEmpty()) return null;
        return top.data;
    }
}

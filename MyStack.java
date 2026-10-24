public class MyStack<E extends Comparable<? super E>> {

    private final MyDblLinkedList<E> list = new MyDblLinkedList<E>();

    public MyStack() {
    }
    //Pre: accepts the element to be pushed onto the stack
    //Post: element is added to the top of the stack
    public void push(E e) {
        list.addFirst(e);
    }

    //Pre: none
    //Post: removes and returns the element at the top of the stack
    //return null if the stack is empty
    public E pop() {
        return list.removeFirst();
    }

    //Pre: none
    //Post: returns the element at the top of the stack without removing it
    //return null if the stack is empty
    public E peek() {
        return list.getFirst();
    }

    //Pre: none
    //Post: returns true if the stack is empty, false otherwise
    public boolean isEmpty() {
        return list.isEmpty();
    }

    //Pre: none
    //Post: returns the number of elements in the stack
    public int size() {
        return list.size();
    }

    //Pre: none
    //Post: removes all elements from the stack
    public void clear() {
        list.clear();
    }

    //Pre: none
    //Post: returns a string representation of the stack
    public String stackString() {
        return list.toString();
    }
}

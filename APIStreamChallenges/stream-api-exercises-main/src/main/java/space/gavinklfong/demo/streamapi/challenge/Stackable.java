package space.gavinklfong.demo.streamapi.challenge;

public interface Stackable<T> {

    void push(T value);

    T pop();

    T peek();

    boolean empty();

    int size();

    int search(Object value);

}

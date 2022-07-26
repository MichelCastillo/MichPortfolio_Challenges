package space.gavinklfong.demo.streamapi.challenge2;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Optional;
import java.util.Stack;

public class CustomStack {

    public static void main(String[] args) {

        CustomStackableClass<Integer> stack = new CustomStackableClass<>();

        System.out.println("Value: " + stack.push(3));
        System.out.println("Value: " + stack.push(2));
        System.out.println("Value: " + stack.push(1));
        System.out.println("Value: " + stack.push(3));
        System.out.println("Value: " + stack.push(5));
        System.out.println("Value: " + stack.push(2));
        System.out.println("Value: " + stack.push(1));

    }

    public static class CustomStackableClass<T> extends Stack<T> {

        private CustomStackableClass<T> stack;
        private T value;

        public CustomStackableClass(){}

        public CustomStackableClass(CustomStackableClass<T> stack, T value) {
            this.stack = stack;
            this.value = value;
        }

        @Override
        public boolean empty() {
            return this.stack == null;
        }

        @Override
        public T push(T item) {

            for (CustomStackableClass<T> myStack = this; !myStack.empty(); myStack = myStack.stack) {
                if (myStack.value.equals(item)){
                    return null;
                }
            }

            this.stack = new CustomStackableClass<>(this.stack, this.value);
            this.value = item;
            return item;
        }
    }
}

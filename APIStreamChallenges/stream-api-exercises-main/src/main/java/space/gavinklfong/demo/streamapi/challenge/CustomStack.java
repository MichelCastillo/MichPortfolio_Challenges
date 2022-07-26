package space.gavinklfong.demo.streamapi.challenge;

import space.gavinklfong.demo.streamapi.models.Product;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomStack<T> implements Stackable<T>{

    private CustomStack<T> stack;
    private T value;

    public CustomStack() {
    }

    public CustomStack(CustomStack<T> stack, T value) {
        this.stack = stack;
        this.value = value;
    }

    @Override
    public void push(T value) {
        this.stack = new CustomStack<T>(this.stack, this.value);
        this.value = value;
    }

    @Override
    public T pop() {
        if (this.empty()){
            throw new RuntimeException("Stack is empty");
        }

        T value = this.value;
        this.value = this.stack.value;
        this.stack = this.stack.stack;

        return value;
    }


    @Override
    public T peek() {
        return this.value;
    }

    @Override
    public boolean empty() {
        return this.stack == null;
    }

    @Override
    public int size() {
        return this.empty() ? 0 : this.stack.size() +1;
    }

    @Override
    public int search(Object v) {
        int i = 0;

        for (CustomStack<T> myStack = this; !myStack.empty(); myStack = myStack.stack) {
            if (myStack.value.equals(v)){
                return i;
            }
            i++;
        }

        return -1;
    }

    public static void main(String[] args) {
        CustomStack<Integer> myStack = new CustomStack<>();

        System.out.println("Before pushing: " + myStack.empty());

        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        myStack.push(8);
        myStack.push(8);


        System.out.println("After pushing: " + myStack.empty());
        System.out.println("Size:" +  myStack.size());

        System.out.println("peek(): " + myStack.peek());

        myStack.pop();

        System.out.println("peek(): " + myStack.peek());

        System.out.println("Search: " + myStack.search(16)); // 16: -1 -> 8: 2 -> 5: 1
        System.out.println("Search: " + myStack.search(8));
        System.out.println("Search: " + myStack.search(5));

        System.out.println(getTotalNumberOfLettersOfNamesLongerThanFive("william", "jones", "aaron", "seppe", "frank", "gilliam"));
    }

    public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {
        return Stream.of(names)
                .filter(name -> name.length() > 5)
                .mapToInt(name -> name.length())
                .sum();

    }

    public static Product getOldestPerson(List<Product> people) {
        return people.stream().max(Comparator.comparing(Product::getPrice)).get();
    }

    public static int calculate(List<Integer> numbers) {
        return numbers.stream().reduce(Integer::sum).get();
    }

    public static Set<String> getKidNames(List<Product> people) {

        return people.stream()
                .map(Product::getCategory)
                .filter(category -> category.equals("18"))
                .collect(Collectors.toSet());
    }

    public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {

        return people.stream()
                .collect(
                        Collectors.groupingBy(
                                person -> person.getAge() >= 18, HashMap::new, Collectors.toList()
                        )
                );
    }

    public static Map<String, List<Person>> groupByNationality(List<Person> people) {

        return people.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getNationality, HashMap::new, Collectors.toList()
                        )
                );
    }

    public static String namesToString(List<Person> people) {

        return people.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", ", "Names: ", "."));
    }

    public static String getString(List<Integer> list) {

        list.stream()
                .map(element -> (element % 2 == 0) ? "e" + element : "o" + element)
                .collect(Collectors.joining(","));

        return null;
    }
}

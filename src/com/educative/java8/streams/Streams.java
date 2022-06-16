package com.educative.java8.streams;

import com.educative.java8.lambdas.lambdacomparator.Person;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Streams {
    static final List<Person> personList = new ArrayList<>(Arrays.asList(
            new Person("KK",32,"IN" ),
            new Person("MOTU",27,"IN" ),
            new Person("KESHU",22,"IN" )
    ));

    static final Map<Integer,Person> personMap =  new HashMap<Integer,Person>();



    public static void main(String[] args) {




    }
    static void optionals(){
        int counter=1;
        for(Person person:personList){
            personMap.put(counter,person);
            counter++;
        }
        //System.out.println(getMapValue(1).getName());
        System.out.println(getMapValueOptional(1));

        System.out.println(personList.stream().anyMatch(x -> x.getName() == "KK"));
        System.out.println(personList.stream().findFirst());
        System.out.println("getMapValue::"+getMapValue(1));
        System.out.println("getMapValueOptional::"+getMapValueOptional(1));
        System.out.println("getMapValueOptionalEmpty::"+getMapValueOptionalEmpty(1));
        System.out.println("getMapValueOptionalIsPresent::"+getMapValueOptionalIsPresent(1));
        getMapValueOptionalIfPresent(1);
        try
        {
            System.out.println("getMapValueOptionalGet::"+getMapValueOptionalGet(11));
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

    static Person getMapValue(int id){
        return personMap.get(id);
    }
    static Optional<Person> getMapValueOptional(int id){
        return Optional.ofNullable( personMap.get(id));// use ofNullable if you're not sure of null
    }
    static Optional<Person> getMapValueOptionalEmpty(int id){
        return Optional.empty( );// use ofNullable if u're not sure of null
    }
    static Boolean getMapValueOptionalIsPresent(int id){
         return Optional.ofNullable(personMap.get(id)).isPresent();// isPresent is to check if value is available else return false
    }
    static void getMapValueOptionalIfPresent(int id){
         Optional.ofNullable(personMap.get(id)).ifPresent((x)-> System.out.println(x.getName()));// isPresent is to check if value is available else return false
    }

    static Person getMapValueOptionalGet(int id){
        return Optional.ofNullable(personMap.get(id)).get();// isPresent is to check if value is available else return false
    }


    static void methodReference(){
        //method reference
        Consumer<Person> personConsumer =  System.out::println;

        Function<Person,Integer> personIntegerFunction = Person::getAge;
    }

    static void usingMaps(){
        //using maps
        personList.stream().map(x ->x.getName().toLowerCase(Locale.ROOT)).
                forEach(System.out::println);
        System.out.println("maptoint...");
        personList.stream().mapToInt(x ->x.getName().length()).
                forEach(System.out::println);

        System.out.println("flat maps --");
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("a","b","c"));
        list.add(Arrays.asList("d","e","f"));
        list.add(Arrays.asList("g","h","i"));
        list.add(Arrays.asList("j","k","l"));

        list.stream().forEach(System.out::println);

        list.stream().flatMap(s ->s.stream()).forEach(System.out::println);
    }
    static void filterObject(){
        //filter on custom object
        List<Person> personList = new ArrayList<>(Arrays.asList(
                new Person("KK",32,"IN" ),
                new Person("MOTU",27,"IN" ),
                new Person("KESHU",22,"IN" )
        ));

        personList.stream().filter(x ->x.getAge()>25).forEach(System.out::println);

        //filter chaining
        System.out.println("\nFilter chaining..");
        personList.stream().filter(x->x.getAge()<30)
                .filter(x->x.getAge()>22)
                .forEach(System.out::println);
    }
    static void filterNumber(){
        Stream<Integer> integerStream = Stream.of(1,2,3,4,5,6,7,8,9,10);
        integerStream.forEach(System.out::println);

        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        integerList.stream().forEach(System.out::println);

        System.out.println("Using filters - ");
        integerList.stream().filter(x->x>2).forEach(System.out::println);
    }
}

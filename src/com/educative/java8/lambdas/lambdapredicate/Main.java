package com.educative.java8.lambdas.lambdapredicate;

import com.educative.java8.lambdas.lambdacomparator.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        //predicate evaluates true or false

        Person person = new Person("KK",32,"IN");
        Person person2 = new Person("MOTU",17,"IN");
        Person person3 = new Person("MOTU KA BHAI",21,"IN");

        List<Person> personList = new ArrayList<Person>(Arrays.asList(person,person2,person3));
        Predicate<Person> predicate = p1 ->p1.getAge()>18;

        for(Person p:personList){
            if(isEligibaleForVoting(p,predicate))
                System.out.println(p.getName()+" "+p.getAge());
        }

        Predicate<Person> predicate_less_than_60 = predicate.and(p1 ->p1.getAge()<60);

        System.out.println("---Using AND predicate");
        for(Person p:personList){
            if(isEligibaleForVoting(p,predicate_less_than_60))
                System.out.println(p.getName()+" "+p.getAge());
        }

        //Predicate<Person> predicate_less_than_60 = predicate.and(p1 ->p1.getAge()<60);

        System.out.println("---Using predicate negate");
        for(Person p:personList){
            if(isEligibaleForVoting(p,predicate.negate()))
                System.out.println(p.getName()+" "+p.getAge());
        }

        int minAge =18;
        BiPredicate<Person,Integer> birepdicate = (p1,age)->{return p1.getAge()>age;};
        System.out.println("---Using bipredicate");
        for(Person p:personList){
            if(isEligibaleForVoting(p,18,(p1,age)->{return p1.getAge()>age;}))
                System.out.println(p.getName()+" "+p.getAge());
        }
    }

    static boolean isEligibaleForVoting(Person person,Predicate<Person> predicate){
        return predicate.test(person);
    }
    static boolean isEligibaleForVoting(Person person, int minAge, BiPredicate<Person, Integer> predicate){
        return predicate.test(person,minAge);
    }
}

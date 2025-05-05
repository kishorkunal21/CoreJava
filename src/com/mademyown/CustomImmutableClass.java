package com.mademyown;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
Declare the class as final
    This prevents the class from being subclassed, which could otherwise allow mutability through subclass methods.
Make all fields private and final
    This ensures that fields are assigned once inside the constructor and cannot be modified afterward.
Initialize all fields via constructor only
    The constructor should fully initialize the object’s state. For mutable objects passed in, perform a deep copy to avoid exposing internal references.
Do not provide any setter methods
    No methods should allow modification of fields after construction.
Return copies of mutable objects in getter methods
    If your class contains fields that are mutable objects (e.g., collections, arrays, or custom objects), the getter methods should return defensive copies to prevent clients from modifying the internal state.
Avoid exposing references to mutable internal objects
    This includes returning unmodifiable views or copies of collections.

 */
public final class CustomImmutableClass {
    private final int sr_no;
    private final String name;
    private final List<String> strings;

    public CustomImmutableClass(int sr_no, String name, List<String> strings){
        this.name=name;
        this.sr_no=sr_no;
        this.strings = Collections.unmodifiableList( strings);
    }

    public int getSr_no()
    {
        return this.sr_no;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "CustomImmutableClass{" +
                "sr_no=" + sr_no +
                ", name='" + name + '\'' +
                ", strings=" + strings +
                '}';
    }


}

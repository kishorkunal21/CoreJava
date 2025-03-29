package com.book.modernjavainaction.interfaces;

public class DefaultMethodInheritanceCheck extends D implements A,B {

    //3 rules for handling default inheritance call
    /*
        1. Classes always win - so as C extends D, D's hello should be called
        2. Sun-Interfaces win : so B has a chance here has B extends A
        3. Lastly - if there is still an ambiguity : class has to override and call the method explicitly
     */
    public static void main(String[] args) {
        new DefaultMethodInheritanceCheck().hello();
        // output is Hello from B if D has no implementation
        // Hello from D - as D has an implementation

    }
}

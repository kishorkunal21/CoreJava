package com.book.modernjavainaction.streams;

public class StreamsCh5Practice {
    /*
    Find all transactions in the year 2011 and sort them by value (small to high).
    What are all the unique cities where the traders work?
    Find all traders from Cambridge and sort them by name.
    Return a string of all traders’ names sorted alphabetically.
    Are any traders based in Milan?
    Print the values of all transactions from the traders living in Cambridge.
    What’s the highest value of all the transactions?
    Find the transaction with the smallest value.
     */
    public static void main(String[] args) {
        Transaction.getTransactions().stream().toList().forEach(System.out::println);
        //Find all transactions in the year 2011 and sort them by value (small to high).
        System.out.println("---------------------------");
        System.out.println(
            Transaction.getTransactions().stream()
                    .filter(t->t.year()==2011).toList()
        );

        //What are all the unique cities where the traders work?
        System.out.println("---------------------------");
        System.out.println(
                Transaction.getTransactions().stream()
                        .map(a->a.trader().city())
                        .distinct()
                        .toList()
        );

        //Find all traders from Cambridge and sort them by name.
        System.out.println("---------------------------");
        System.out.println(
                Transaction.getTransactions().stream()
                        .filter(a->a.trader().city().equalsIgnoreCase("Cambridge"))
                        .map(b->b.trader().name())
                        .sorted()
                        .toList()
        );

        //Return a string of all traders’ names sorted alphabetically.
        System.out.println("---------------------------");
        System.out.println(
                Transaction.getTransactions().stream()
                        //.filter(a->a.trader().city().equalsIgnoreCase("Cambridge"))
                        .map(b->b.trader().name())
                        .sorted()
                        .toList()
        );

        //Are any traders based in Milan?
        System.out.println("---------------------------");
        System.out.println(
                Transaction.getTransactions().stream()
                        .filter(a->a.trader().city().equalsIgnoreCase("Milan"))
                        .findAny()
        );
        //Print the values of all transactions from the traders living in Cambridge.
        System.out.println("---------------------------");
        System.out.println(
                Transaction.getTransactions().stream()
                        .filter(a->a.trader().city().equalsIgnoreCase("Cambridge"))
                        .map(Transaction::value)
                        .toList()
        );

        //What’s the highest value of all the transactions?
        System.out.println("---------------------------");
        System.out.println(
                Transaction.getTransactions().stream()
                        .filter(a->a.trader().city().equalsIgnoreCase("Cambridge"))
                        .map(Transaction::value)
                        .reduce(0, Integer::max)
        );
        //Find the transaction with the smallest value.
        System.out.println("---------------------------");
        System.out.println(
                Transaction.getTransactions().stream()
                        .filter(a->a.trader().city().equalsIgnoreCase("Cambridge"))
                        .map(Transaction::value)
                        .reduce( Integer::min)
        );
    }

}

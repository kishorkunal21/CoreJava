package com.codewithmosh.designpatterns.behavioural.template;

// AUDIT trail kind of applications where we want to FORCE some operations in every functionality
// like logging etc.
public class Main {
    public static void main(String[] args) {
        //transfer money
        //generate report

        Task task = new TransferMoneyTask();
        task.doRecord();
        task = new GenerateReportTask();
        task.doRecord();



    }
}

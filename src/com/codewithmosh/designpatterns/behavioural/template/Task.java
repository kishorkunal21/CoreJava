package com.codewithmosh.designpatterns.behavioural.template;

public abstract class Task {
    AuditTrail auditTrail = new AuditTrail();

    abstract void doRecord();

}

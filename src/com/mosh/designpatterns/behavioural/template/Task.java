package com.mosh.designpatterns.behavioural.template;

public abstract class Task {
    AuditTrail auditTrail = new AuditTrail();

    abstract void doRecord();

}

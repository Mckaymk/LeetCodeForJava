package com.mk.demo.designPatterns.responsibility;

/**
 * @author Mckay
 * @create 2020-10-11
 * @description
 **/
public abstract class Approver {
    Approver approver;
    String name;

    public Approver(String name) {
        this.name = name;
    }

    public abstract void processRequest(PurchaseRequest request);

    public Approver getApprover() {
        return approver;
    }

    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


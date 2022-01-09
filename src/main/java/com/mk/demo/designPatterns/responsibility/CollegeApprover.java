package com.mk.demo.designPatterns.responsibility;

/**
 * @author Mckay
 * @create 2020-10-11
 * @description
 **/
public class CollegeApprover extends Approver {


    public CollegeApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getPrice() > 5000 && request.getPrice() <= 10000) {
            System.out.println("请求" + request.getId() + "已经" + this.name + "被处理");
        } else {
            approver.processRequest(request);
        }

    }
}

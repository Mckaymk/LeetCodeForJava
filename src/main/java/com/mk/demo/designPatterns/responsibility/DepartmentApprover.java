package com.mk.demo.designPatterns.responsibility;

/**
 * @author Mckay
 * @create 2020-10-11
 * @description
 **/
public class DepartmentApprover extends Approver {


    public DepartmentApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getPrice() <= 5000) {
            System.out.println("请求" + request.getId() + "已经" + this.name + "被处理");
        } else {
            approver.processRequest(request);
        }

    }
}

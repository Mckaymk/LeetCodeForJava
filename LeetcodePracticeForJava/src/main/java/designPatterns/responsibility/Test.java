package designPatterns.responsibility;

/**
 * @author Mckay
 * @create 2020-10-11
 * @description
 **/
public class Test {
    public static void main(String[] args) {
        PurchaseRequest request = new PurchaseRequest(1, 3100, 1);
        DepartmentApprover departmentApprover = new DepartmentApprover("张主任");
        CollegeApprover collegeApprover = new CollegeApprover("张主任");
        ViceSchoolMasterApprover viceSchoolMasterApprover = new ViceSchoolMasterApprover("张主任");

        departmentApprover.setApprover(collegeApprover);
        collegeApprover.setApprover(viceSchoolMasterApprover);
        viceSchoolMasterApprover.setApprover(departmentApprover);
        viceSchoolMasterApprover.processRequest(request);

    }
}

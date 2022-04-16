package ood.srp.designe.srp.osp.loan_handler;

public class LoanApprovalHandler {
    public void approveLoan(PersonalLoanValidator validator) {
        if (validator.isValid()) {
            System.out.println("Process of the Loan");
        }
    }
}

package com.loki.bmi_tdee.service;

import com.loki.bmi_tdee.model.Loan;
import com.loki.bmi_tdee.model.results.LoanResult;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    public LoanResult calculateSimpleInterest(Loan loan) {
        double interest = (loan.getPrincipal() * loan.getTenure() * loan.getRateOfInterest()) / 100;
        LoanResult simpleInterest = new LoanResult();
        simpleInterest.setTenure(loan.getTenure());
        simpleInterest.setInterestAmount(interest);
        simpleInterest.setTotalAmount(loan.getPrincipal() + interest);
        simpleInterest.setPrincipleAmount(loan.getPrincipal());
        return simpleInterest;
    }

    public LoanResult calculateCompoundInterest(Loan loan, Integer compound) {
        LoanResult compoundInterest = new LoanResult();
        double rate = loan.getRateOfInterest() / 100;
        double interest = loan.getPrincipal() * Math.pow((1 + rate / compound), compound * loan.getTenure());
        compoundInterest.setTotalAmount(interest);
        compoundInterest.setPrincipleAmount(loan.getPrincipal());
        compoundInterest.setTenure(loan.getTenure());
        return compoundInterest;
    }
}

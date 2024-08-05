package com.loki.bmi_tdee.controller.financial;

import com.loki.bmi_tdee.model.Loan;
import com.loki.bmi_tdee.model.results.LoanResult;
import org.springframework.http.ResponseEntity;

public interface LoanController {
    ResponseEntity<LoanResult> simpleInterest(Loan loan);

    ResponseEntity<LoanResult> compoundInterest(Loan loan, int compound);
}

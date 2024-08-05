package com.loki.bmi_tdee.controller.financial;

import com.loki.bmi_tdee.model.Loan;
import com.loki.bmi_tdee.model.results.LoanResult;
import com.loki.bmi_tdee.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanControllerImpl implements LoanController {
    private final LoanService loanService;

    @Autowired
    public LoanControllerImpl(LoanService service) {
        this.loanService = service;
    }

    @Override
    @PostMapping("/simple-interest")
    public ResponseEntity<LoanResult> simpleInterest(@RequestBody Loan loan) {
        LoanResult simpleInterest = loanService.calculateSimpleInterest(loan);
        return new ResponseEntity<>(simpleInterest, HttpStatusCode.valueOf(200));
    }

    @Override
    @PostMapping("/compound-interest")
    public ResponseEntity<LoanResult> compoundInterest(@RequestBody Loan loan, @RequestParam int compound) {
        LoanResult result = loanService.calculateCompoundInterest(loan, compound);
        return new ResponseEntity<>(result, HttpStatusCode.valueOf(200));
    }
}

package com.loki.bmi_tdee.controller.tdee;

import com.loki.bmi_tdee.model.User;
import com.loki.bmi_tdee.model.results.TDEEResult;
import org.springframework.http.ResponseEntity;

public interface TDEEController {
    ResponseEntity<TDEEResult> calculateTDEE(User user);
}

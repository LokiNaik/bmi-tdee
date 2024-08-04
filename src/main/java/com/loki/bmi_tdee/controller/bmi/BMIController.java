package com.loki.bmi_tdee.controller.bmi;

import com.loki.bmi_tdee.model.User;
import com.loki.bmi_tdee.model.results.BMIResult;
import org.springframework.http.ResponseEntity;

public interface BMIController {

    /**
     * Calculates BMI and Category.
     *
     * @param user user.
     * @return BMIResult
     */

    ResponseEntity<BMIResult> calculateBMI(User user);
}

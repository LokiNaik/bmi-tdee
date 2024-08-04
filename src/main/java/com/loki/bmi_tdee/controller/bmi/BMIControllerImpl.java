package com.loki.bmi_tdee.controller.bmi;

import com.loki.bmi_tdee.model.User;
import com.loki.bmi_tdee.model.results.BMIResult;
import com.loki.bmi_tdee.service.BMIService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;

@Slf4j
@RestController
@RequestMapping(value = "/bmi")
public class BMIControllerImpl implements BMIController {

    private final BMIService bmiService;

    @Autowired
    private BMIControllerImpl(BMIService bmiService) {
        this.bmiService = bmiService;
    }

    @Override
    @PostMapping(value = "/calculate-bmi")
    public ResponseEntity<BMIResult> calculateBMI(@RequestBody User user) {
        Double bmi = bmiService.calculateBMI(user.getWeight(), user.getHeight());
        String category = bmiService.bmiCategory(bmi);
        BMIResult results = new BMIResult();
        DecimalFormat df = new DecimalFormat("0.0");
        results.setBmiValue(df.format(bmi));
        results.setCategory(category);
        return new ResponseEntity<>(results, HttpStatusCode.valueOf(200));
    }
}

package com.loki.bmi_tdee.model.results;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BMIResult {
    private String bmiValue;
    private String category;
}

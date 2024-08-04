package com.loki.bmi_tdee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Double age;
    private Double weight;
    private Double height;
    private String gender;
    private String activityLevel;
}

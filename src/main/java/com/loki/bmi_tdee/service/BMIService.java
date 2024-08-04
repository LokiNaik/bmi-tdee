package com.loki.bmi_tdee.service;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class BMIService {

    public Double calculateBMI(Double weight, Double height) {
        return weight / (height * height);
    }

    public String bmiCategory(Double bmi) {

        if (bmi < 16) {
            return "Severe Thinness";
        } else if (bmi <= 18.5) {
            return "Moderate Thinness";
        } else if (bmi <= 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Over weight";
        } else if (bmi > 30) {
            return "Obesity";
        }
        return null;
    }
}

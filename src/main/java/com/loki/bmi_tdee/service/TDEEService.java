package com.loki.bmi_tdee.service;

import com.loki.bmi_tdee.model.User;
import org.springframework.stereotype.Service;

@Service
public class TDEEService {

    public Double tdeeCalculate(User user) {
        Double bmr;
        if (user.getGender().equalsIgnoreCase("male")) {
            bmr = 66 + (13.7 * user.getWeight()) + (5 * user.getHeight()) - (6.8 * user.getAge());
        } else {
            bmr = 655 + (9.6 * user.getWeight()) + (1.8 * user.getHeight()) - (4.7 * user.getAge());
        }
        double activityFactor = switch (user.getActivityLevel()) {
            case "sedentary" -> 1.2;
            case "lightly active" -> 1.37;
            case "moderately active" -> 1.55;
            case "very active" -> 1.725;
            case "extra active" -> 1.9;
            default -> 1.2;
        };
        return bmr * activityFactor;
    }
}

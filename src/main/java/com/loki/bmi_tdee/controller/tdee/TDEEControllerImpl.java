package com.loki.bmi_tdee.controller.tdee;

import com.loki.bmi_tdee.model.User;
import com.loki.bmi_tdee.model.results.TDEEResult;
import com.loki.bmi_tdee.service.TDEEService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/tdee")
public class TDEEControllerImpl implements TDEEController {
    private final TDEEService service;

    @Autowired
    private TDEEControllerImpl(TDEEService service) {
        this.service = service;
    }

    @Override
    @PostMapping("/calculate-tdee")
    public ResponseEntity<TDEEResult> calculateTDEE(@RequestBody User user) {
        log.info("User {}", user);
        Double tdee = service.tdeeCalculate(user);
        TDEEResult result = new TDEEResult();
        result.setTdeeValue(tdee);
        return new ResponseEntity<>(result, HttpStatusCode.valueOf(200));
    }
}

package com.loki.bmi_tdee.model.results;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoanResult {
    private Integer principleAmount;
    private Double interestAmount;
    private Integer tenure;
    private Double totalAmount;
}

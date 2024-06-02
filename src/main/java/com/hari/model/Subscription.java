package com.hari.model;

import com.hari.Type.PlanType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate subScriptionStartDate;
    private LocalDate getScriptionEndDate;
    private PlanType planType;
    private boolean isValid;

    @OneToOne
    private User user;

}

package com.workintech.S19D1.mapping;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ActorResponse {
    private int actorId;
    private String actorFirstName;
    private String actorLastName;
    private LocalDate actorBirthDate;
}

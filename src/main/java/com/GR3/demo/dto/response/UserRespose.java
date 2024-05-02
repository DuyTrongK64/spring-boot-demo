package com.GR3.demo.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRespose {
    private String id;
    String username;
    String password;
    String firstName;
    String lastName;
    LocalDate dob;
}

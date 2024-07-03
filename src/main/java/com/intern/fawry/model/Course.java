package com.intern.fawry.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private int id;
    @NotBlank(message = "the name is required")
    private String name;
    @NotNull(message = "the description is required")
    private String description;
}

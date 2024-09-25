package org.example.spring_exercice3.model;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    private int id;
    @NotEmpty(message = "Le prénom doit être renseigné")
    @Pattern(regexp = "\\w+", message = "Le pattern n''est pas respecté")
    private String firstName;
    @NotEmpty(message = "Le nom doit être renseigné")
    @Pattern(regexp = "\\w+", message = "Le pattern n''est pas respecté")
    private String lastName;
    @Min(value = 17, message = "Vous devez avoir plus de 17 ans")
    @Max(value = 40, message = "Vous devez avoir moins de 40 ans")
    private int age;
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Le pattern n''est pas respecté")
    private String email;
}

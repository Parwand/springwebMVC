package net.parwand.springmvc.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class PersonForm {
    @NotNull
    @Email(message = "you have to put the right email")
    private String email;

    @NotNull
    @Size(min = 2, max = 20)
    private String name;
    @NotNull
    @Min(18)
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

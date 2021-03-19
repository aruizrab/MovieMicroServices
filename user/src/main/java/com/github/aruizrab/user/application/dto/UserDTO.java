package com.github.aruizrab.user.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
public class UserDTO {
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    @NotNull(message = "Can't be null")
    @NotBlank(message = "Can't be blank")
    private String name;
    @Getter
    @Setter
    @NotNull(message = "Can't be null")
    @NotBlank(message = "Can't be blank")
    @Pattern(regexp = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}\\b", message = "Email must look like an email: xxx@xxx.xxx")
    private String email;
}

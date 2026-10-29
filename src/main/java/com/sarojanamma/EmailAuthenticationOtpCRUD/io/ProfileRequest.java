package com.sarojanamma.EmailAuthenticationOtpCRUD.io;

import jakarta.validation.MessageInterpolator;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileRequest {

    @NotBlank(message = "Name should be not empty")
    private String name;
    @NotNull(message = "Email should be not empty")
    @Email(message = "Enter valid email address")
    private String email;
    @Size(min= 6,message = "Password must be atleast 6 characters")
    private String password;
}

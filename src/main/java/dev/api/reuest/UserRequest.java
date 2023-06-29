package dev.api.reuest;

import dev.domain.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.Email;
import java.time.LocalDate;
@Getter
@Setter
@Builder(toBuilder = true)
public class UserRequest {
    @Email
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    @NonNull
    private Role roles;
}

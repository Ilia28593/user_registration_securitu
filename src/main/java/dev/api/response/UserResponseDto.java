package dev.api.response;

import dev.domain.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder(toBuilder = true)
public class UserResponseDto {
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Role roles;
}

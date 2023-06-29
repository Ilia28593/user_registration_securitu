package dev.api;


import dev.domain.User;
import dev.api.reuest.UserRequest;
import org.springframework.stereotype.Component;
import javax.annotation.processing.Generated;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2023-06-14T20:27:59+0300",
        comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class UserMapper{

    public User mapToUser(UserRequest dto) {
        if (dto == null) {
            return null;
        }
        return new User(
                dto.getEmail(),
                dto.getPassword(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getBirthday(),
                dto.getRoles());
    }
}

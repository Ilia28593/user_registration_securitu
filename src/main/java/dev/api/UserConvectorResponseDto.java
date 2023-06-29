package dev.api;

import dev.api.response.UserResponseDto;
import dev.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConvectorResponseDto implements Converter<User, UserResponseDto> {

    @Override
    public UserResponseDto convert(User source) {
        return UserResponseDto.builder()
                .email(source.getEmail())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .birthday(source.getBirthday())
                .roles(source.getRoles())
                .build();
    }

    public List<UserResponseDto> getListResponse(List<User> list) {
        return list.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}

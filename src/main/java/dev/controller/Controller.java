package dev.controller;

import dev.api.UserConvectorResponseDto;
import dev.api.UserMapper;
import dev.api.response.UserResponseDto;
import dev.api.reuest.UserRequest;
import dev.domain.JwtAuthentication;
import dev.domain.Role;
import dev.domain.User;
import dev.service.AuthService;
import dev.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class Controller {
    private final AuthService authService;

    private final UserService userService;

    private final UserMapper userMapper;

    private final UserConvectorResponseDto convertor;

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("hello/user")
    public ResponseEntity<String> helloUser() {
        final JwtAuthentication authInfo = authService.getAuthInfo();
        return ResponseEntity.ok("Hello user " + authInfo.getPrincipal() + "!");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("hello/admin")
    public ResponseEntity<String> helloAdmin() {
        final JwtAuthentication authInfo = authService.getAuthInfo();
        log.info("{}", authInfo);
        return ResponseEntity.ok("Hello admin " + authInfo.getPrincipal() + "!");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<UserResponseDto> crate(@RequestBody UserRequest request) {
        return new ResponseEntity<>(convertor.convert(userService.create(userMapper.mapToUser(request))), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN' && 'USER')")
    @GetMapping("{id}")
    public ResponseEntity<UserResponseDto> getBuId(@PathVariable long id) {
        return new ResponseEntity<>(convertor.convert(userService.getById(id)), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("user")
    public ResponseEntity<List<UserResponseDto>> getAllUser() {
        return new ResponseEntity<>(convertor.getListResponse(userService.getAll()), HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("admin")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return new ResponseEntity<>(convertor.getListResponse(userService.getAll()), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity deleteUser(@PathVariable long id) {
        userService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable long id, @RequestBody UserRequest request) {
        return new ResponseEntity<>(convertor.convert(userService.update(id, userMapper.mapToUser(request))), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("{id}/role")
    public ResponseEntity<UserResponseDto> update(@PathVariable long id, @RequestParam(name = "text") String description) {
        User e = userService.changeRole(id, Role.valueOf(description));
        return new ResponseEntity<>(convertor.convert(userService.changeRole(id, Role.valueOf(description))), HttpStatus.OK);
    }
}
package dev.service;

import dev.domain.Role;
import dev.domain.User;
import dev.exception.NotFoundException;
import dev.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public User create(User entity) {
        log.trace("Request from create entity {}", entity.toString());
        repository.save(entity);
        log.trace("Object created with id {}.", entity.getId());
        return entity;
    }

    public User changeRole(long id, Role role){
        log.trace("Request from change Role {}, {}", id, role);
        User user = getById(id);
        user.setRoles(role);
        log.trace("Change Role {}", user);
        return  repository.save(user);
    }

    public User update(Long id, User entity) {
        log.trace("Request from update entity {}", entity.toString());
        User user = getById(id);
        user.setBirthday(entity.getBirthday() == null ? user.getBirthday() : entity.getBirthday());
        user.setFirstName(entity.getFirstName() == null ? user.getFirstName() : entity.getFirstName());
        user.setLastName(entity.getLastName() == null ? user.getLastName() : entity.getLastName());
        user.setEmail(entity.getEmail() == null ? user.getEmail() : entity.getEmail());
        user.setPassword(entity.getPassword() == null ? user.getPassword() : entity.getPassword());
        repository.save(user);
        log.trace("Update entity {}", user);
        return user;
    }

    public void delete(long entity) {
        log.trace("Request from delete entity {}", entity);
        repository.deleteById(entity);
        log.trace("Delete entity {}", entity);
    }

    public List<User> getAll() {
        log.trace("Request from getting all rows from {}", User.class.getSimpleName());
        List<User> listUser = repository.findAll();
        log.trace("Getting all rows from {}", User.class.getSimpleName());
        return listUser;
    }

    public User getById(long id) {
        log.trace("Request from getting entity with type {}, id = {}", User.class.getSimpleName(), id);
        User user = repository.findById(id).orElseThrow(() -> new NotFoundException(User.class.getSimpleName(), id));
        log.trace("Getting entity with type {}, id = {}", User.class.getSimpleName(), id);
        return user;
    }

    public Optional<User> getByEmail(String email) {
        return repository.findByEmail(email);
    }

}

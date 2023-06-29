package dev.repository;

import dev.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //    @Query("""
//            select *
//            from user
//            where user_email = :email
//            """)
    Optional<User> findByEmail(String email);

//    @Transactional
//    @Modifying
//    @Query(nativeQuery = true, value = """
//            insert into person(user_email, first_name, last_name, password, roles)
//                values
//                    ('dsdsdsd' ,'31232', '321312', '123213', 'dsdsdd')
//            """)
//    void insert();
}


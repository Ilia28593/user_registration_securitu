//package test;
//
//import dev.domain.Role;
//import dev.domain.User;
//import dev.repository.UserRepository;
//import dev.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.TestPropertySource;
//
//import java.time.LocalDate;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//@SpringBootTest
//public class UserTest {
//
//    @Autowired
//    private final UserService userService;
//
//    @Mock
//    private UserRepository repository;
//
//    public UserTest() {
//    }
//
//    @Test
//    public void test() throws Exception {
//        User u = new User(0L, "strtr@mail.ru", "1234", "Ilya",
//                "Sitnik", LocalDate.of(1993, 11, 02), Role.ADMIN);
//        User u = User.builder()
//                .id(0L)
//                .email("strtr@mail.ru")
//                .password("1234")
//                .firstName("ilya")
//                .build();
//        User user = userService.create(u);
//        assertThat(u.equals(user));
//    }
//
//}

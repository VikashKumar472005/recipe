import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

class UserServiceTest {

    @Mock
    private UserDAO userDAO;

    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userDAO);
    }

    @Test
    void testRegisterUser() {
        User user = new User("john_doe", "john@example.com", "password123");
        when(userDAO.createUser(user)).thenReturn(true);

        boolean result = userService.registerUser(user);
        assertTrue(result, "User registration should succeed.");
        verify(userDAO, times(1)).createUser(user);
    }

    @Test
    void testFindUserById() {
        User user = new User(1, "john_doe", "john@example.com");
        when(userDAO.findUserById(1)).thenReturn(user);

        User result = userService.findUserById(1);
        assertNotNull(result, "User should exist.");
        assertEquals("john_doe", result.getUsername());
        verify(userDAO, times(1)).findUserById(1);
    }
}
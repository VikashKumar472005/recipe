import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.List;

class UserDAOTest {

    private UserDAO userDAO;

    @BeforeEach
    void setUp() {
        userDAO = new UserDAO();
    }

    @Test
    void testCreateUser() {
        User user = new User("john_doe", "john@example.com", "password123");
        boolean result = userDAO.createUser(user);
        assertTrue(result, "User should be created successfully.");
    }

    @Test
    void testFindUserById() {
        User user = userDAO.findUserById(1);
        assertNotNull(user, "User with ID 1 should exist.");
    }

    @Test
    void testGetAllUsers() {
        List<User> users = userDAO.getAllUsers();
        assertNotNull(users, "User list should not be null.");
        assertFalse(users.isEmpty(), "User list should not be empty.");
    }

    @Test
    void testUpdateUser() {
        User user = new User(1, "updated_name", "updated_email@example.com", "new_password");
        boolean result = userDAO.updateUser(user);
        assertTrue(result, "User should be updated successfully.");
    }

    @Test
    void testDeleteUser() {
        boolean result = userDAO.deleteUser(1);
        assertTrue(result, "User should be deleted successfully.");
    }
}
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import javax.servlet.http.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

class UserServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private UserService userService;

    private UserServlet userServlet;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userServlet = new UserServlet(userService);
    }

    @Test
    void testDoPost_RegisterUser() throws Exception {
        when(request.getParameter("action")).thenReturn("register");
        when(request.getParameter("username")).thenReturn("john_doe");
        when(request.getParameter("email")).thenReturn("john@example.com");
        when(request.getParameter("password")).thenReturn("password123");

        userServlet.doPost(request, response);

        verify(userService, times(1)).registerUser(any(User.class));
    }
}
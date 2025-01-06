import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import javax.servlet.http.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

class AdminServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private UserService userService;

    private AdminServlet adminServlet;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        adminServlet = new AdminServlet(userService);
    }

    @Test
    void testDoGet() throws Exception {
        when(request.getParameter("action")).thenReturn("viewUsers");

        adminServlet.doGet(request, response);

        verify(userService, times(1)).getAllUsers();
    }
}
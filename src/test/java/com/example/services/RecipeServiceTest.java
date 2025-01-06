import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

class RecipeServiceTest {

    @Mock
    private RecipeDAO recipeDAO;

    private RecipeService recipeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeService = new RecipeService(recipeDAO);
    }

    @Test
    void testAddRecipe() {
        Recipe recipe = new Recipe("Pasta", "Boil water and cook pasta.");
        when(recipeDAO.createRecipe(recipe)).thenReturn(true);

        boolean result = recipeService.addRecipe(recipe);
        assertTrue(result, "Adding recipe should succeed.");
        verify(recipeDAO, times(1)).createRecipe(recipe);
    }

    @Test
    void testGetRecipeById() {
        Recipe recipe = new Recipe(1, "Pasta", "Cook Pasta");
        when(recipeDAO.findRecipeById(1)).thenReturn(recipe);

        Recipe result = recipeService.getRecipeById(1);
        assertNotNull(result, "Recipe should exist.");
        assertEquals("Pasta", result.getTitle());
        verify(recipeDAO, times(1)).findRecipeById(1);
    }
}
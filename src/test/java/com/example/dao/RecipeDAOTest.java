import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.List;

class RecipeDAOTest {

    private RecipeDAO recipeDAO;

    @BeforeEach
    void setUp() {
        recipeDAO = new RecipeDAO();
    }

    @Test
    void testCreateRecipe() {
        Recipe recipe = new Recipe("Pasta", "Boil water. Add pasta. Cook for 10 minutes.");
        boolean result = recipeDAO.createRecipe(recipe);
        assertTrue(result, "Recipe should be created successfully.");
    }

    @Test
    void testFindRecipeById() {
        Recipe recipe = recipeDAO.findRecipeById(1);
        assertNotNull(recipe, "Recipe with ID 1 should exist.");
    }

    @Test
    void testGetAllRecipes() {
        List<Recipe> recipes = recipeDAO.getAllRecipes();
        assertNotNull(recipes, "Recipe list should not be null.");
        assertFalse(recipes.isEmpty(), "Recipe list should not be empty.");
    }

    @Test
    void testUpdateRecipe() {
        Recipe recipe = new Recipe(1, "Updated Recipe", "Updated Instructions");
        boolean result = recipeDAO.updateRecipe(recipe);
        assertTrue(result, "Recipe should be updated successfully.");
    }

    @Test
    void testDeleteRecipe() {
        boolean result = recipeDAO.deleteRecipe(1);
        assertTrue(result, "Recipe should be deleted successfully.");
    }
}
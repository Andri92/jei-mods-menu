package andri92.mods.jei_mods_menu.helpers;

import mezz.jei.api.IJeiRuntime;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.ISubtypeRegistry;
import mezz.jei.api.ingredients.IModIngredientRegistration;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;

@mezz.jei.api.JEIPlugin
public class JeiHelper implements IModPlugin {

    private static JeiHelper instance;

    public static JeiHelper getInstance() {
        if (instance == null) {
            instance = new JeiHelper();
        }
        return instance;
    }

    public static JeiHelper jeiHelper() {
        return JeiHelper.getInstance();
    }

    private static IJeiRuntime runtime;

    public JeiHelper() {
    }

    public void setJeiText(String text) {
        if (runtime != null) {
            runtime.getIngredientFilter().setFilterText(text);
        }
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistry subtypeRegistry) {
    }

    @Override
    public void registerIngredients(IModIngredientRegistration registry) {
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
    }

    @Override
    public void register(IModRegistry registry) {
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
        runtime = jeiRuntime;
    }
}

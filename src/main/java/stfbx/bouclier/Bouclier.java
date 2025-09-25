package stfbx.bouclier;

import net.fabric_extras.shield_api.item.CustomShieldItem;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.List;

public class Bouclier implements ModInitializer {
    public static final Item WOODEN_SHIELD = new CustomShieldItem(null,
            () -> Ingredient.ofItems(Items.IRON_INGOT),
            List.of(
            ),
            new Item.Settings().maxDamage(50));

    public static final Item STONE_SHIELD = new CustomShieldItem(null,
            () -> Ingredient.ofItems(Items.IRON_INGOT),
            List.of(
            ),
            new Item.Settings().maxDamage(250));

    public static final Item IRON_SHIELD = new CustomShieldItem(null,
            () -> Ingredient.ofItems(Items.IRON_INGOT),
            List.of(
            ),
            new Item.Settings().maxDamage(550));

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, Identifier.of("bouclier", "wooden_shield"), WOODEN_SHIELD);
        Registry.register(Registries.ITEM, Identifier.of("bouclier", "stone_shield"), STONE_SHIELD);
        Registry.register(Registries.ITEM, Identifier.of("bouclier", "iron_shield"), IRON_SHIELD);
    }
}

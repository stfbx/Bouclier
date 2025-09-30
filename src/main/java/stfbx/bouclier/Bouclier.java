package stfbx.bouclier;

import com.github.stellarwind22.shieldlib.lib.object.ShieldLibItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class Bouclier implements ModInitializer {
    public static final Item WOODEN_SHIELD = register("wooden_shield", settings -> new ShieldLibItem(settings, Items.OAK_WOOD), new Item.Settings().maxDamage(150));
    public static final Item STONE_SHIELD = register("stone_shield", settings -> new ShieldLibItem(settings, Items.COBBLESTONE), new Item.Settings().maxDamage(250));
    public static final Item IRON_SHIELD = register("iron_shield", settings -> new ShieldLibItem(settings, Items.IRON_INGOT), new Item.Settings().maxDamage(550));

    @Override
    public void onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(WOODEN_SHIELD);
            entries.add(STONE_SHIELD);
            entries.add(IRON_SHIELD);
        });
    }

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("bouclier", name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }
}

package stfbx.bouclier;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Bouclier implements ModInitializer {
    public static final Item WOODEN_SHIELD = new FabricShieldItem(new Item.Settings().maxDamage(150), 10, 13, Items.OAK_WOOD);
    public static final Item STONE_SHIELD = new FabricShieldItem(new Item.Settings().maxDamage(250), 10, 13, Items.COBBLESTONE);
    public static final Item IRON_SHIELD = new FabricShieldItem(new Item.Settings().maxDamage(550), 10, 13, Items.IRON_INGOT);

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, Identifier.of("bouclier", "wooden_shield"), WOODEN_SHIELD);
        Registry.register(Registries.ITEM, Identifier.of("bouclier", "stone_shield"), STONE_SHIELD);
        Registry.register(Registries.ITEM, Identifier.of("bouclier", "iron_shield"), IRON_SHIELD);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(WOODEN_SHIELD);
            entries.add(STONE_SHIELD);
            entries.add(IRON_SHIELD);
        });
    }
}

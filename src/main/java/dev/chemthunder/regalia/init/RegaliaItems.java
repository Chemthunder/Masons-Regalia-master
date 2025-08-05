package dev.chemthunder.regalia.init;

import dev.chemthunder.regalia.MasonsRegalia;
import dev.chemthunder.regalia.item.divinity.DiscFragmentEssence;
import dev.chemthunder.regalia.item.divinity.EffigyItem;
import dev.chemthunder.regalia.item.divinity.EssenceItem;
import dev.chemthunder.regalia.item.femboyihop.FemCookieItem;
import dev.chemthunder.regalia.item.weaponry.FrostbearerItem;
import dev.chemthunder.regalia.item.weaponry.HelianthiItem;
import dev.chemthunder.regalia.item.weaponry.SkarletItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public interface RegaliaItems {


    Map<Item, Identifier> ITEMS = new LinkedHashMap<>();

    Item HELIANTHI = create("helianthi", new HelianthiItem(ToolMaterials.NETHERITE, 4, -2.7f, new  FabricItemSettings()
            .fireproof()
            .rarity(Rarity.EPIC)
            .group(ItemGroup.COMBAT)));

    Item SUNDERED_EFFIGY = create("sundered_effigy", new EffigyItem(new FabricItemSettings()
            .maxCount(1)
            .fireproof()
            .group(ItemGroup.COMBAT)));

    Item BROKEN_EFFIGY = create("broken_effigy", new Item(new FabricItemSettings()
            .fireproof()
            .group(ItemGroup.COMBAT)
            .maxCount(1)));


    Item FEMCOOKIE = create("femcookie", new FemCookieItem(new FabricItemSettings()
            .group(ItemGroup.FOOD)
            .maxCount(16)
            .food(new FoodComponent.Builder()
                    .alwaysEdible()
                    .hunger(1)
                    .snack()
                    .saturationModifier(1f)
                    .build())));

    Item SKARLET_PROMISE = create("skarlet_promise", new SkarletItem(ToolMaterials.GOLD, 8, -2.6f, new FabricItemSettings()
            .group(ItemGroup.COMBAT)
            .fireproof()
            .rarity(Rarity.UNCOMMON)
            ));

    Item ESSENCE_DISC = create("essence_disc", new EssenceItem(new FabricItemSettings()
            .maxCount(1)
            .fireproof()
            .rarity(Rarity.RARE)
            .group(ItemGroup.MISC)));

    Item ESSENCE_PIECE = create("essence_piece", new DiscFragmentEssence(new FabricItemSettings()
            .maxCount(8)
            .group(ItemGroup.MISC)));


    Item FROSTBEARER = create("frostbearer", new FrostbearerItem(ToolMaterials.DIAMOND, 2, -2.9f, new FabricItemSettings()
            .rarity(Rarity.RARE)
            .group(ItemGroup.COMBAT)));

    static <T extends Item> T create(String name, T item) {
        ITEMS.put(item, MasonsRegalia.id(name));

        return item;
    }
    static void initialize() {
        ITEMS.forEach((item, id) -> Registry.register(Registry.ITEM, id, item));

    }
}

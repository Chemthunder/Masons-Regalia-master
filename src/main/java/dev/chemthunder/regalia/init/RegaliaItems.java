package dev.chemthunder.regalia.init;

import dev.chemthunder.regalia.MasonsRegalia;
import dev.chemthunder.regalia.item.divinity.*;
import dev.chemthunder.regalia.item.divinity.FollyScytheItem;
import dev.chemthunder.regalia.item.weaponry.FrostbearerItem;
import dev.chemthunder.regalia.item.weaponry.HelianthiItem;
import dev.chemthunder.regalia.item.weaponry.SkarletItem;
import dev.chemthunder.regalia.item.weaponry.SolitudeItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
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

    Item HELIANTHI = create("helianthi", new HelianthiItem(ToolMaterials.NETHERITE, 5, -2.7f, new  FabricItemSettings()
            .fireproof()
            .rarity(Rarity.UNCOMMON)
            .group(RegaliaItemGroup.MASON)));

    Item SUNDERED_EFFIGY = create("sundered_effigy", new EffigyItem(new FabricItemSettings()
            .maxCount(1)
            .fireproof()
            .group(RegaliaItemGroup.MASON)));

    Item BROKEN_EFFIGY = create("broken_effigy", new Item(new FabricItemSettings()
            .fireproof()
            .group(RegaliaItemGroup.MASON)
            .maxCount(1)));


    Item SKARLET_PROMISE = create("skarlet_promise", new SkarletItem(ToolMaterials.GOLD, 8, -2.6f, new FabricItemSettings()
            .group(RegaliaItemGroup.MASON)
            .fireproof()
            .rarity(Rarity.UNCOMMON)
    ));

    Item ESSENCE_DISC = create("essence_disc", new EssenceItem(new FabricItemSettings()
            .maxCount(1)
            .fireproof()
            .rarity(Rarity.RARE)
            .group(RegaliaItemGroup.MASON))
    );

    Item ESSENCE_PIECE = create("essence_piece", new DiscFragmentEssence(new FabricItemSettings()
            .maxCount(8)
            .group(RegaliaItemGroup.MASON))
    );


    Item FROSTBEARER = create("frostbearer", new FrostbearerItem(ToolMaterials.DIAMOND, 5, -2.9f, new FabricItemSettings()
            .rarity(Rarity.RARE)
            .group(RegaliaItemGroup.MASON))
    );


    Item FOLLYSCYTHE = create("sirens_call", new FollyScytheItem(ToolMaterials.NETHERITE, 4, -2.6f, new FabricItemSettings()
            .group(RegaliaItemGroup.MASON)
            .rarity(Rarity.EPIC)
            .fireproof()));

    Item BOUND_EFFIGY = create("bound_effigy", new BoundItem(ToolMaterials.NETHERITE, 1, -2.3f, new FabricItemSettings()
            .fireproof()
            .rarity(Rarity.UNCOMMON)
            .maxDamage(1)));

    Item SOLITUDE = create("solitude", new SolitudeItem(ToolMaterials.NETHERITE, 5, -2.8f, new FabricItemSettings()
            .rarity(Rarity.UNCOMMON)
            .group(RegaliaItemGroup.MASON)
            .fireproof()));

    Item CRIMSON_OBITUARY = create("crimson", new HalberdItem(ToolMaterials.GOLD, 3, -2.3f, new FabricItemSettings()
            .group(RegaliaItemGroup.MASON)
            .fireproof()
            .rarity(Rarity.UNCOMMON)
            ));

    static <T extends Item> T create(String name, T item) {
        ITEMS.put(item, MasonsRegalia.id(name));
        return item;
    }
    static void initialize() {
        ITEMS.forEach((item, id) -> Registry.register(Registry.ITEM, id, item));

    }
}

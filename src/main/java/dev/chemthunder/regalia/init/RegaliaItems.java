package dev.chemthunder.regalia.init;

import dev.chemthunder.regalia.MasonsRegalia;
import dev.chemthunder.regalia.item.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterials;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

public interface RegaliaItems {


    Map<Item, Identifier> ITEMS = new LinkedHashMap<>();

    Item HELIANTHI = create("helianthi", new HelianthiItem(ToolMaterials.NETHERITE, 5, -2.7f, new  FabricItemSettings()
            .fireproof()
            .group(ItemGroup.COMBAT)));

    Item SUNDERED_EFFIGY = create("sundered_effigy", new EffigyItem(new FabricItemSettings()
            .maxCount(1)
            .fireproof()
            .group(ItemGroup.COMBAT)));

    Item BROKEN_EFFIGY = create("broken_effigy", new Item(new FabricItemSettings()));

    Item CONTRACT = create("contract", new ContractItem(new FabricItemSettings()
            .maxCount(1)
            .fireproof()
            .group(ItemGroup.TOOLS)));

    Item SIGNED_CONTRACT = create("signed_contract", new SignedContractItem(new FabricItemSettings()
            .maxCount(1)
            .fireproof()));


    Item ESSENCE_DISC = create("essence_disc", new EssenceItem(new FabricItemSettings()
            .maxCount(1)
            .fireproof()
            .rarity(Rarity.RARE)
            .group(ItemGroup.MISC)));

    Item ESSENCE_PIECE = create("essence_piece", new DiscFragmentEssence(new FabricItemSettings()
            .maxCount(8)
            .group(ItemGroup.MISC)));


    static <T extends Item> T create(String name, T item) {
        ITEMS.put(item, MasonsRegalia.id(name));

        return item;
    }
    static void initialize() {
        ITEMS.forEach((item, id) -> Registry.register(Registry.ITEM, id, item));

    }
}

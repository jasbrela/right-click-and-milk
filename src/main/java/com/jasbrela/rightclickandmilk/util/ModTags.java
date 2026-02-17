package com.jasbrela.rightclickandmilk.util;

import com.jasbrela.rightclickandmilk.RightClickAndMilk;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class ModTags {
    public static class Entities {
        public static final TagKey<EntityType<?>> MILKABLE_MOBS = create("bottle_milkable");

        private static TagKey<EntityType<?>> create(String tagName) {
            return TagKey.create(Registry.ENTITY_TYPE_REGISTRY,
                    ResourceLocation.fromNamespaceAndPath(RightClickAndMilk.MODID,
                            tagName));
        }
    }
}
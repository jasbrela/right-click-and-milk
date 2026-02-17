package com.jasbrela.rightclickandmilk;

import com.jasbrela.rightclickandmilk.util.ModTags;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import vectorwing.farmersdelight.common.registry.ModItems;

public class CowMilkHandler {
    @SubscribeEvent
    public void onEntityInteract(PlayerInteractEvent.EntityInteractSpecific event) {
        Entity entity = event.getTarget();
        EntityType<?> entityType = entity.getType();

        boolean isMilkable = entityType.is(ModTags.Entities.MILKABLE_MOBS);
        if (!isMilkable) {
            return;
        }

        Player player = event.getEntity();
        InteractionHand hand = event.getHand();
        ItemStack stack = player.getItemInHand(hand);

        if (stack.is(Items.GLASS_BOTTLE)) {
            if (!player.level.isClientSide) {
                ItemStack milkBottle = new ItemStack(ModItems.MILK_BOTTLE.get());
                ItemStack result = ItemUtils.createFilledResult(stack, player, milkBottle);
                player.setItemInHand(hand, result);
                player.level.playSound(null, player.getX(), player.getY(), player.getZ(),
                        getSfx(entity), SoundSource.PLAYERS, 1.0F, 1.0F);
            }

            event.setCancellationResult(InteractionResult.sidedSuccess(player.level.isClientSide));
            event.setCanceled(true);
        }
    }

    public static SoundEvent getSfx(Entity entity) {
        if (entity instanceof Goat goat) {
            if (goat.isScreamingGoat()) {
                return SoundEvents.GOAT_SCREAMING_MILK;
            }
            return SoundEvents.GOAT_MILK;
        }

        return SoundEvents.COW_MILK;
    }
}

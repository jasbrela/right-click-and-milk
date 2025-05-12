package com.bobossaura.rightclickandmilk;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import vectorwing.farmersdelight.common.registry.ModItems;

public class CowMilkHandler {
    @SubscribeEvent
    public void onEntityInteract(PlayerInteractEvent.EntityInteractSpecific event) {
        if (!(event.getTarget() instanceof Cow) && !(event.getTarget() instanceof Goat)) return;
        Player player = event.getEntity();
        InteractionHand hand = event.getHand();
        ItemStack stack = player.getItemInHand(hand);

        if (stack.is(Items.GLASS_BOTTLE)) {
            if (!player.level().isClientSide) {
                ItemStack milkBottle = new ItemStack(ModItems.MILK_BOTTLE.get());
                ItemStack result = ItemUtils.createFilledResult(stack, player, milkBottle);
                player.setItemInHand(hand, result);
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.COW_MILK, SoundSource.PLAYERS, 1.0F, 1.0F);
            }

            event.setCancellationResult(InteractionResult.sidedSuccess(player.level().isClientSide));
            event.setCanceled(true);
        }
    }
}

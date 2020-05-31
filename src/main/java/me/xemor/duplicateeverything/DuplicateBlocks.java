package me.xemor.duplicateeverything;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;

public class DuplicateBlocks implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Collection<ItemStack> drops = e.getBlock().getDrops();
        if (e.getPlayer() != null) {
            ItemStack mainHand = e.getPlayer().getInventory().getItemInMainHand();
            if (mainHand != null) {
                drops = e.getBlock().getDrops(mainHand, e.getPlayer());
            }
        }
        for (ItemStack item: drops) {
            e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), item);
        }
    }

}

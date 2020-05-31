package me.xemor.duplicateeverything;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class DuplicateMobs implements Listener {

    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        if (e.getEntityType() != EntityType.PLAYER) {
            if (!(e.getEntity().getKiller() instanceof Player)) {
                return;
            }
            Location deathLocation = e.getEntity().getLocation();
            World world = e.getEntity().getWorld();
            for (int i = 0; i < 2; i++) {
                LivingEntity livingEntity = (LivingEntity) world.spawnEntity(deathLocation, e.getEntityType());
                livingEntity.getEquipment().setArmorContents(e.getEntity().getEquipment().getArmorContents());
                livingEntity.addPotionEffects(e.getEntity().getActivePotionEffects());
                if (e.getEntity() instanceof Slime) {
                    Slime deadSlime = (Slime) e.getEntity();
                    Slime aliveSlime = (Slime) livingEntity;
                    aliveSlime.setSize(deadSlime.getSize());
                }
            }
        }
    }

}

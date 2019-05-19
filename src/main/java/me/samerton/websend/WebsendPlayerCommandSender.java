package me.samerton.websend;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import org.bukkit.Achievement;
import org.bukkit.FluidCollisionMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.Statistic;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.*;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.MainHand;
import org.bukkit.inventory.Merchant;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

public class WebsendPlayerCommandSender implements Player {
    /*
     * This class allows tapping into command output from plugins if the output is
     * sent through the commandsender. Note to anyone having compilation problems:
     * Compile against Bukkit, not CraftBukkit.
     *
     * Tap this method(1.6.4): sendRawMessage, sendMessage(String),
     * sendMessage(String[])
     */

    private final Player baseObject;
    private final Plugin commandTargetPlugin;

    public WebsendPlayerCommandSender(Player baseObject, Plugin commandTargetPlugin) {
        this.baseObject = baseObject;
        this.commandTargetPlugin = commandTargetPlugin;
    }

    public void sendMessage(java.lang.String param0) {
        PluginOutputManager.handleLogRecord(commandTargetPlugin, new LogRecord(Level.INFO, param0));
        baseObject.sendMessage(param0);
    }

    public void sendMessage(java.lang.String[] param0) {
        for (String str : param0) {
            PluginOutputManager.handleLogRecord(commandTargetPlugin, new LogRecord(Level.INFO, str));
        }
        baseObject.sendMessage(param0);
    }

    public void sendRawMessage(java.lang.String param0) {
        PluginOutputManager.handleLogRecord(commandTargetPlugin, new LogRecord(Level.INFO, param0));
        baseObject.sendRawMessage(param0);
    }

    public java.lang.String getDisplayName() {
        return baseObject.getDisplayName();
    }

    public void setDisplayName(java.lang.String param0) {
        baseObject.setDisplayName(param0);
    }

    public java.lang.String getPlayerListName() {
        return baseObject.getPlayerListName();
    }

    public void setPlayerListName(java.lang.String param0) {
        baseObject.setPlayerListName(param0);
    }

    public void setCompassTarget(org.bukkit.Location param0) {
        baseObject.setCompassTarget(param0);
    }

    public org.bukkit.Location getCompassTarget() {
        return baseObject.getCompassTarget();
    }

    public java.net.InetSocketAddress getAddress() {
        return baseObject.getAddress();
    }

    public void kickPlayer(java.lang.String param0) {
        baseObject.kickPlayer(param0);
    }

    public void chat(java.lang.String param0) {
        baseObject.chat(param0);
    }

    public boolean performCommand(java.lang.String param0) {
        return baseObject.performCommand(param0);
    }

    public boolean isSneaking() {
        return baseObject.isSneaking();
    }

    public void setSneaking(boolean param0) {
        baseObject.setSneaking(param0);
    }

    public boolean isSprinting() {
        return baseObject.isSprinting();
    }

    public void setSprinting(boolean param0) {
        baseObject.setSprinting(param0);
    }

    public void saveData() {
        baseObject.saveData();
    }

    public void loadData() {
        baseObject.loadData();
    }

    public void setSleepingIgnored(boolean param0) {
        baseObject.setSleepingIgnored(param0);
    }

    public boolean isSleepingIgnored() {
        return baseObject.isSleepingIgnored();
    }

    public void playNote(org.bukkit.Location param0, org.bukkit.Instrument param1, org.bukkit.Note param2) {
        baseObject.playNote(param0, param1, param2);
    }

    public void playSound(org.bukkit.Location param0, org.bukkit.Sound param1, float param2, float param3) {
        baseObject.playSound(param0, param1, param2, param3);
    }

    public void playSound(org.bukkit.Location param0, java.lang.String param1, float param2, float param3) {
        baseObject.playSound(param0, param1, param2, param3);
    }

    public void playEffect(org.bukkit.Location param0, org.bukkit.Effect param1, int param2) {
        baseObject.playEffect(param0, param1, param2);
    }

    public <T> void playEffect(org.bukkit.Location param0, org.bukkit.Effect param1, T param2) {
        baseObject.playEffect(param0, param1, param2);
    }

    public void sendBlockChange(org.bukkit.Location param0, org.bukkit.Material param1, byte param2) {
        baseObject.sendBlockChange(param0, param1, param2);
    }

    public boolean sendChunkChange(org.bukkit.Location param0, int param1, int param2, int param3, byte[] param4) {
        return baseObject.sendChunkChange(param0, param1, param2, param3, param4);
    }

    public void sendMap(org.bukkit.map.MapView param0) {
        baseObject.sendMap(param0);
    }

    public void updateInventory() {
        baseObject.updateInventory();
    }

    public void awardAchievement(org.bukkit.Achievement param0) {
        baseObject.awardAchievement(param0);
    }

    public void incrementStatistic(org.bukkit.Statistic param0) {
        baseObject.incrementStatistic(param0);
    }

    public void incrementStatistic(org.bukkit.Statistic param0, int param1) {
        baseObject.incrementStatistic(param0, param1);
    }

    public void incrementStatistic(org.bukkit.Statistic param0, org.bukkit.Material param1) {
        baseObject.incrementStatistic(param0, param1);
    }

    public void incrementStatistic(org.bukkit.Statistic param0, org.bukkit.Material param1, int param2) {
        baseObject.incrementStatistic(param0, param1, param2);
    }

    public void setPlayerTime(long param0, boolean param1) {
        baseObject.setPlayerTime(param0, param1);
    }

    public long getPlayerTime() {
        return baseObject.getPlayerTime();
    }

    public long getPlayerTimeOffset() {
        return baseObject.getPlayerTimeOffset();
    }

    public boolean isPlayerTimeRelative() {
        return baseObject.isPlayerTimeRelative();
    }

    public void resetPlayerTime() {
        baseObject.resetPlayerTime();
    }

    public void setPlayerWeather(org.bukkit.WeatherType param0) {
        baseObject.setPlayerWeather(param0);
    }

    public org.bukkit.WeatherType getPlayerWeather() {
        return baseObject.getPlayerWeather();
    }

    public void resetPlayerWeather() {
        baseObject.resetPlayerWeather();
    }

    public void giveExp(int param0) {
        baseObject.giveExp(param0);
    }

    public void giveExpLevels(int param0) {
        baseObject.giveExpLevels(param0);
    }

    public float getExp() {
        return baseObject.getExp();
    }

    public void setExp(float param0) {
        baseObject.setExp(param0);
    }

    public int getLevel() {
        return baseObject.getLevel();
    }

    public void setLevel(int param0) {
        baseObject.setLevel(param0);
    }

    public int getTotalExperience() {
        return baseObject.getTotalExperience();
    }

    public void setTotalExperience(int param0) {
        baseObject.setTotalExperience(param0);
    }

    public float getExhaustion() {
        return baseObject.getExhaustion();
    }

    public void setExhaustion(float param0) {
        baseObject.setExhaustion(param0);
    }

    public float getSaturation() {
        return baseObject.getSaturation();
    }

    public void setSaturation(float param0) {
        baseObject.setSaturation(param0);
    }

    public int getFoodLevel() {
        return baseObject.getFoodLevel();
    }

    public void setFoodLevel(int param0) {
        baseObject.setFoodLevel(param0);
    }

    public org.bukkit.Location getBedSpawnLocation() {
        return baseObject.getBedSpawnLocation();
    }

    public void setBedSpawnLocation(org.bukkit.Location param0) {
        baseObject.setBedSpawnLocation(param0);
    }

    public void setBedSpawnLocation(org.bukkit.Location param0, boolean param1) {
        baseObject.setBedSpawnLocation(param0, param1);
    }

    public boolean getAllowFlight() {
        return baseObject.getAllowFlight();
    }

    public void setAllowFlight(boolean param0) {
        baseObject.setAllowFlight(param0);
    }

    public void hidePlayer(org.bukkit.entity.Player param0) {
        baseObject.hidePlayer(param0);
    }

    public void showPlayer(org.bukkit.entity.Player param0) {
        baseObject.showPlayer(param0);
    }

    public boolean canSee(org.bukkit.entity.Player param0) {
        return baseObject.canSee(param0);
    }

    public boolean isOnGround() {
        return baseObject.isOnGround();
    }

    public boolean isFlying() {
        return baseObject.isFlying();
    }

    public void setFlying(boolean param0) {
        baseObject.setFlying(param0);
    }

    public void setFlySpeed(float param0) {
        baseObject.setFlySpeed(param0);
    }

    public void setWalkSpeed(float param0) {
        baseObject.setWalkSpeed(param0);
    }

    public float getFlySpeed() {
        return baseObject.getFlySpeed();
    }

    public float getWalkSpeed() {
        return baseObject.getWalkSpeed();
    }

    public void setTexturePack(java.lang.String param0) {
        baseObject.setTexturePack(param0);
    }

    public org.bukkit.scoreboard.Scoreboard getScoreboard() {
        return baseObject.getScoreboard();
    }

    public void setScoreboard(org.bukkit.scoreboard.Scoreboard param0) {
        baseObject.setScoreboard(param0);
    }

    public boolean isHealthScaled() {
        return baseObject.isHealthScaled();
    }

    public void setHealthScaled(boolean param0) {
        baseObject.setHealthScaled(param0);
    }

    public void setHealthScale(double param0) {
        baseObject.setHealthScale(param0);
    }

    public double getHealthScale() {
        return baseObject.getHealthScale();
    }

    public java.lang.String getName() {
        return baseObject.getName();
    }

    public org.bukkit.inventory.PlayerInventory getInventory() {
        return baseObject.getInventory();
    }

    public org.bukkit.inventory.Inventory getEnderChest() {
        return baseObject.getEnderChest();
    }

    public boolean setWindowProperty(org.bukkit.inventory.InventoryView.Property param0, int param1) {
        return baseObject.setWindowProperty(param0, param1);
    }

    public org.bukkit.inventory.InventoryView getOpenInventory() {
        return baseObject.getOpenInventory();
    }

    public org.bukkit.inventory.InventoryView openInventory(org.bukkit.inventory.Inventory param0) {
        return baseObject.openInventory(param0);
    }

    public org.bukkit.inventory.InventoryView openWorkbench(org.bukkit.Location param0, boolean param1) {
        return baseObject.openWorkbench(param0, param1);
    }

    public org.bukkit.inventory.InventoryView openEnchanting(org.bukkit.Location param0, boolean param1) {
        return baseObject.openEnchanting(param0, param1);
    }

    public void openInventory(org.bukkit.inventory.InventoryView param0) {
        baseObject.openInventory(param0);
    }

    public void closeInventory() {
        baseObject.closeInventory();
    }

    public org.bukkit.inventory.ItemStack getItemInHand() {
        return baseObject.getItemInHand();
    }

    public void setItemInHand(org.bukkit.inventory.ItemStack param0) {
        baseObject.setItemInHand(param0);
    }

    public org.bukkit.inventory.ItemStack getItemOnCursor() {
        return baseObject.getItemOnCursor();
    }

    public void setItemOnCursor(org.bukkit.inventory.ItemStack param0) {
        baseObject.setItemOnCursor(param0);
    }

    public boolean isSleeping() {
        return baseObject.isSleeping();
    }

    public int getSleepTicks() {
        return baseObject.getSleepTicks();
    }

    public org.bukkit.GameMode getGameMode() {
        return baseObject.getGameMode();
    }

    public void setGameMode(org.bukkit.GameMode param0) {
        baseObject.setGameMode(param0);
    }

    public boolean isBlocking() {
        return baseObject.isBlocking();
    }

    public int getExpToLevel() {
        return baseObject.getExpToLevel();
    }

    public double getEyeHeight() {
        return baseObject.getEyeHeight();
    }

    public double getEyeHeight(boolean param0) {
        return baseObject.getEyeHeight(param0);
    }

    public org.bukkit.Location getEyeLocation() {
        return baseObject.getEyeLocation();
    }

    public <T extends Projectile> T launchProjectile(java.lang.Class<? extends T> param0) {
        return baseObject.launchProjectile(param0);
    }

    public int getRemainingAir() {
        return baseObject.getRemainingAir();
    }

    public void setRemainingAir(int param0) {
        baseObject.setRemainingAir(param0);
    }

    public int getMaximumAir() {
        return baseObject.getMaximumAir();
    }

    public void setMaximumAir(int param0) {
        baseObject.setMaximumAir(param0);
    }

    public int getMaximumNoDamageTicks() {
        return baseObject.getMaximumNoDamageTicks();
    }

    public void setMaximumNoDamageTicks(int param0) {
        baseObject.setMaximumNoDamageTicks(param0);
    }

    public double getLastDamage() {
        return baseObject.getLastDamage();
    }

    public void setLastDamage(double param0) {
        baseObject.setLastDamage(param0);
    }

    public int getNoDamageTicks() {
        return baseObject.getNoDamageTicks();
    }

    public void setNoDamageTicks(int param0) {
        baseObject.setNoDamageTicks(param0);
    }

    public org.bukkit.entity.Player getKiller() {
        return baseObject.getKiller();
    }

    public boolean addPotionEffect(org.bukkit.potion.PotionEffect param0) {
        return baseObject.addPotionEffect(param0);
    }

    public boolean addPotionEffect(org.bukkit.potion.PotionEffect param0, boolean param1) {
        return baseObject.addPotionEffect(param0, param1);
    }

    public boolean addPotionEffects(java.util.Collection<org.bukkit.potion.PotionEffect> param0) {
        return baseObject.addPotionEffects(param0);
    }

    public boolean hasPotionEffect(org.bukkit.potion.PotionEffectType param0) {
        return baseObject.hasPotionEffect(param0);
    }

    public void removePotionEffect(org.bukkit.potion.PotionEffectType param0) {
        baseObject.removePotionEffect(param0);
    }

    public java.util.Collection<org.bukkit.potion.PotionEffect> getActivePotionEffects() {
        return baseObject.getActivePotionEffects();
    }

    public boolean hasLineOfSight(org.bukkit.entity.Entity param0) {
        return baseObject.hasLineOfSight(param0);
    }

    public boolean getRemoveWhenFarAway() {
        return baseObject.getRemoveWhenFarAway();
    }

    public void setRemoveWhenFarAway(boolean param0) {
        baseObject.setRemoveWhenFarAway(param0);
    }

    public org.bukkit.inventory.EntityEquipment getEquipment() {
        return baseObject.getEquipment();
    }

    public void setCanPickupItems(boolean param0) {
        baseObject.setCanPickupItems(param0);
    }

    public boolean getCanPickupItems() {
        return baseObject.getCanPickupItems();
    }

    public void setCustomName(java.lang.String param0) {
        baseObject.setCustomName(param0);
    }

    public java.lang.String getCustomName() {
        return baseObject.getCustomName();
    }

    public void setCustomNameVisible(boolean param0) {
        baseObject.setCustomNameVisible(param0);
    }

    public boolean isCustomNameVisible() {
        return baseObject.isCustomNameVisible();
    }

    public boolean isLeashed() {
        return baseObject.isLeashed();
    }

    public org.bukkit.entity.Entity getLeashHolder() {
        return baseObject.getLeashHolder();
    }

    public boolean setLeashHolder(org.bukkit.entity.Entity param0) {
        return baseObject.setLeashHolder(param0);
    }

    public org.bukkit.Location getLocation() {
        return baseObject.getLocation();
    }

    public org.bukkit.Location getLocation(org.bukkit.Location param0) {
        return baseObject.getLocation(param0);
    }

    public void setVelocity(org.bukkit.util.Vector param0) {
        baseObject.setVelocity(param0);
    }

    public org.bukkit.util.Vector getVelocity() {
        return baseObject.getVelocity();
    }

    public org.bukkit.World getWorld() {
        return baseObject.getWorld();
    }

    public boolean teleport(org.bukkit.Location param0) {
        return baseObject.teleport(param0);
    }

    public boolean teleport(org.bukkit.Location param0,
            org.bukkit.event.player.PlayerTeleportEvent.TeleportCause param1) {
        return baseObject.teleport(param0, param1);
    }

    public boolean teleport(org.bukkit.entity.Entity param0) {
        return baseObject.teleport(param0);
    }

    public boolean teleport(org.bukkit.entity.Entity param0,
            org.bukkit.event.player.PlayerTeleportEvent.TeleportCause param1) {
        return baseObject.teleport(param0, param1);
    }

    public java.util.List<org.bukkit.entity.Entity> getNearbyEntities(double param0, double param1, double param2) {
        return baseObject.getNearbyEntities(param0, param1, param2);
    }

    public int getEntityId() {
        return baseObject.getEntityId();
    }

    public int getFireTicks() {
        return baseObject.getFireTicks();
    }

    public int getMaxFireTicks() {
        return baseObject.getMaxFireTicks();
    }

    public void setFireTicks(int param0) {
        baseObject.setFireTicks(param0);
    }

    public void remove() {
        baseObject.remove();
    }

    public boolean isDead() {
        return baseObject.isDead();
    }

    public boolean isValid() {
        return baseObject.isValid();
    }

    public org.bukkit.Server getServer() {
        return baseObject.getServer();
    }

    public org.bukkit.entity.Entity getPassenger() {
        return baseObject.getPassenger();
    }

    public boolean setPassenger(org.bukkit.entity.Entity param0) {
        return baseObject.setPassenger(param0);
    }

    public boolean isEmpty() {
        return baseObject.isEmpty();
    }

    public boolean eject() {
        return baseObject.eject();
    }

    public float getFallDistance() {
        return baseObject.getFallDistance();
    }

    public void setFallDistance(float param0) {
        baseObject.setFallDistance(param0);
    }

    public void setLastDamageCause(org.bukkit.event.entity.EntityDamageEvent param0) {
        baseObject.setLastDamageCause(param0);
    }

    public org.bukkit.event.entity.EntityDamageEvent getLastDamageCause() {
        return baseObject.getLastDamageCause();
    }

    public java.util.UUID getUniqueId() {
        return baseObject.getUniqueId();
    }

    public int getTicksLived() {
        return baseObject.getTicksLived();
    }

    public void setTicksLived(int param0) {
        baseObject.setTicksLived(param0);
    }

    public void playEffect(org.bukkit.EntityEffect param0) {
        baseObject.playEffect(param0);
    }

    public org.bukkit.entity.EntityType getType() {
        return baseObject.getType();
    }

    public boolean isInsideVehicle() {
        return baseObject.isInsideVehicle();
    }

    public boolean leaveVehicle() {
        return baseObject.leaveVehicle();
    }

    public org.bukkit.entity.Entity getVehicle() {
        return baseObject.getVehicle();
    }

    public void setMetadata(java.lang.String param0, org.bukkit.metadata.MetadataValue param1) {
        baseObject.setMetadata(param0, param1);
    }

    public java.util.List<org.bukkit.metadata.MetadataValue> getMetadata(java.lang.String param0) {
        return baseObject.getMetadata(param0);
    }

    public boolean hasMetadata(java.lang.String param0) {
        return baseObject.hasMetadata(param0);
    }

    public void removeMetadata(java.lang.String param0, org.bukkit.plugin.Plugin param1) {
        baseObject.removeMetadata(param0, param1);
    }

    public void damage(double param0) {
        baseObject.damage(param0);
    }

    public void damage(double param0, org.bukkit.entity.Entity param1) {
        baseObject.damage(param0, param1);
    }

    public double getHealth() {
        return baseObject.getHealth();
    }

    public void setHealth(double param0) {
        baseObject.setHealth(param0);
    }

    public double getMaxHealth() {
        return baseObject.getMaxHealth();
    }

    public void setMaxHealth(double param0) {
        baseObject.setMaxHealth(param0);
    }

    public void resetMaxHealth() {
        baseObject.resetMaxHealth();
    }

    public boolean isPermissionSet(java.lang.String param0) {
        return baseObject.isPermissionSet(param0);
    }

    public boolean isPermissionSet(org.bukkit.permissions.Permission param0) {
        return baseObject.isPermissionSet(param0);
    }

    public boolean hasPermission(java.lang.String param0) {
        return baseObject.hasPermission(param0);
    }

    public boolean hasPermission(org.bukkit.permissions.Permission param0) {
        return baseObject.hasPermission(param0);
    }

    public org.bukkit.permissions.PermissionAttachment addAttachment(org.bukkit.plugin.Plugin param0,
            java.lang.String param1, boolean param2) {
        return baseObject.addAttachment(param0, param1, param2);
    }

    public org.bukkit.permissions.PermissionAttachment addAttachment(org.bukkit.plugin.Plugin param0) {
        return baseObject.addAttachment(param0);
    }

    public org.bukkit.permissions.PermissionAttachment addAttachment(org.bukkit.plugin.Plugin param0,
            java.lang.String param1, boolean param2, int param3) {
        return baseObject.addAttachment(param0, param1, param2, param3);
    }

    public org.bukkit.permissions.PermissionAttachment addAttachment(org.bukkit.plugin.Plugin param0, int param1) {
        return baseObject.addAttachment(param0, param1);
    }

    public void removeAttachment(org.bukkit.permissions.PermissionAttachment param0) {
        baseObject.removeAttachment(param0);
    }

    public void recalculatePermissions() {
        baseObject.recalculatePermissions();
    }

    public java.util.Set<org.bukkit.permissions.PermissionAttachmentInfo> getEffectivePermissions() {
        return baseObject.getEffectivePermissions();
    }

    public boolean isOp() {
        return baseObject.isOp();
    }

    public void setOp(boolean param0) {
        baseObject.setOp(param0);
    }

    public boolean isConversing() {
        return baseObject.isConversing();
    }

    public void acceptConversationInput(java.lang.String param0) {
        baseObject.acceptConversationInput(param0);
    }

    public boolean beginConversation(org.bukkit.conversations.Conversation param0) {
        return baseObject.beginConversation(param0);
    }

    public void abandonConversation(org.bukkit.conversations.Conversation param0) {
        baseObject.abandonConversation(param0);
    }

    public void abandonConversation(org.bukkit.conversations.Conversation param0,
            org.bukkit.conversations.ConversationAbandonedEvent param1) {
        baseObject.abandonConversation(param0, param1);
    }

    public boolean isOnline() {
        return baseObject.isOnline();
    }

    public boolean isBanned() {
        return baseObject.isBanned();
    }

    public boolean isWhitelisted() {
        return baseObject.isWhitelisted();
    }

    public void setWhitelisted(boolean param0) {
        baseObject.setWhitelisted(param0);
    }

    public org.bukkit.entity.Player getPlayer() {
        return baseObject.getPlayer();
    }

    public long getFirstPlayed() {
        return baseObject.getFirstPlayed();
    }

    public long getLastPlayed() {
        return baseObject.getLastPlayed();
    }

    public boolean hasPlayedBefore() {
        return baseObject.hasPlayedBefore();
    }

    public java.util.Map<java.lang.String, java.lang.Object> serialize() {
        return baseObject.serialize();
    }

    public void sendPluginMessage(org.bukkit.plugin.Plugin param0, java.lang.String param1, byte[] param2) {
        baseObject.sendPluginMessage(param0, param1, param2);
    }

    public java.util.Set<java.lang.String> getListeningPluginChannels() {
        return baseObject.getListeningPluginChannels();
    }

    public void setResourcePack(String arg0) {
        baseObject.setResourcePack(arg0);
    }

    public void removeAchievement(Achievement achievement) {
        baseObject.removeAchievement(achievement);
    }

    public boolean hasAchievement(Achievement achievement) {
        return baseObject.hasAchievement(achievement);
    }

    public void decrementStatistic(Statistic statistic) throws IllegalArgumentException {
        baseObject.decrementStatistic(statistic);
    }

    public void decrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException {
        baseObject.decrementStatistic(statistic, amount);
    }

    public void setStatistic(Statistic statistic, int newValue) throws IllegalArgumentException {
        baseObject.setStatistic(statistic, newValue);
    }

    public int getStatistic(Statistic statistic) throws IllegalArgumentException {
        return baseObject.getStatistic(statistic);
    }

    public void decrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        baseObject.decrementStatistic(statistic, material);
    }

    public int getStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        return baseObject.getStatistic(statistic, material);
    }

    public void decrementStatistic(Statistic statistic, Material material, int amount) throws IllegalArgumentException {
        baseObject.decrementStatistic(statistic, material, amount);
    }

    public void setStatistic(Statistic statistic, Material material, int newValue) throws IllegalArgumentException {
        baseObject.setStatistic(statistic, material, newValue);
    }

    public void incrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        baseObject.incrementStatistic(statistic, entityType);
    }

    public void decrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        baseObject.decrementStatistic(statistic, entityType);
    }

    public int getStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        return baseObject.getStatistic(statistic, entityType);
    }

    public void incrementStatistic(Statistic statistic, EntityType entityType, int amount)
            throws IllegalArgumentException {
        baseObject.incrementStatistic(statistic, entityType, amount);
    }

    public void decrementStatistic(Statistic statistic, EntityType entityType, int amount) {
        baseObject.decrementStatistic(statistic, entityType, amount);
    }

    public void setStatistic(Statistic statistic, EntityType entityType, int newValue) {
        baseObject.setStatistic(statistic, entityType, newValue);
    }

    public <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector velocity) {
        return baseObject.launchProjectile(projectile, velocity);
    }

    public void sendSignChange(Location lctn, String[] strings) throws IllegalArgumentException {
        baseObject.sendSignChange(lctn, strings);
    }

    public Entity getSpectatorTarget() {
        return baseObject.getSpectatorTarget();
    }

    public void setSpectatorTarget(Entity entity) {
        baseObject.setSpectatorTarget(entity);
    }

    public void sendTitle(String string, String string1) {
        baseObject.sendTitle(string, string1);
    }

    public void resetTitle() {
        baseObject.resetTitle();
    }

    public void spawnParticle(Particle prtcl, Location lctn, int i) {
        baseObject.spawnParticle(prtcl, lctn, i);
    }

    public void spawnParticle(Particle prtcl, double d, double d1, double d2, int i) {
        baseObject.spawnParticle(prtcl, d, d1, d2, i);
    }

    public <T> void spawnParticle(Particle prtcl, Location lctn, int i, T t) {
        baseObject.spawnParticle(prtcl, lctn, i, t);
    }

    public <T> void spawnParticle(Particle prtcl, double d, double d1, double d2, int i, T t) {
        baseObject.spawnParticle(prtcl, d, d1, d2, i, t);
    }

    public void spawnParticle(Particle prtcl, Location lctn, int i, double d, double d1, double d2) {
        baseObject.spawnParticle(prtcl, lctn, i, d, d1, d2);
    }

    public void spawnParticle(Particle prtcl, double d, double d1, double d2, int i, double d3, double d4, double d5) {
        baseObject.spawnParticle(prtcl, d, d1, d2, i, d3, d4, d5);
    }

    public <T> void spawnParticle(Particle prtcl, Location lctn, int i, double d, double d1, double d2, T t) {
        baseObject.spawnParticle(prtcl, lctn, i, d, d1, d2, t);
    }

    public <T> void spawnParticle(Particle prtcl, double d, double d1, double d2, int i, double d3, double d4,
            double d5, T t) {
        baseObject.spawnParticle(prtcl, d, d1, d2, i, d3, d4, d5, t);
    }

    public void spawnParticle(Particle prtcl, Location lctn, int i, double d, double d1, double d2, double d3) {
        baseObject.spawnParticle(prtcl, lctn, i, d, d1, d2, d3);
    }

    public void spawnParticle(Particle prtcl, double d, double d1, double d2, int i, double d3, double d4, double d5,
            double d6) {
        baseObject.spawnParticle(prtcl, d, d1, d2, i, d3, d4, d5, d6);
    }

    public <T> void spawnParticle(Particle prtcl, Location lctn, int i, double d, double d1, double d2, double d3,
            T t) {
        baseObject.spawnParticle(prtcl, lctn, i, d, d1, d2, d3, t);
    }

    public <T> void spawnParticle(Particle prtcl, double d, double d1, double d2, int i, double d3, double d4,
            double d5, double d6, T t) {
        baseObject.spawnParticle(prtcl, d, d1, d2, i, d3, d4, d5, d6, t);
    }

    public InventoryView openMerchant(Villager vlgr, boolean bln) {
        return baseObject.openMerchant(vlgr, bln);
    }

    public List<Block> getLineOfSight(Set<Material> set, int i) {
        return baseObject.getLineOfSight(set, i);
    }

    public Block getTargetBlock(Set<Material> set, int i) {
        return baseObject.getTargetBlock(set, i);
    }

    public List<Block> getLastTwoTargetBlocks(Set<Material> set, int i) {
        return baseObject.getLastTwoTargetBlocks(set, i);
    }

    public AttributeInstance getAttribute(Attribute atrbt) {
        return baseObject.getAttribute(atrbt);
    }

    public void setGlowing(boolean bln) {
        baseObject.setGlowing(bln);
    }

    public boolean isGlowing() {
        return baseObject.isGlowing();
    }

    public MainHand getMainHand() {
        return baseObject.getMainHand();
    }

    public boolean isGliding() {
        return baseObject.isGliding();
    }

    public void setGliding(boolean bln) {
        baseObject.setGliding(bln);
    }

    public void setAI(boolean bln) {
        baseObject.setAI(bln);
    }

    public boolean hasAI() {
        return baseObject.hasAI();
    }

    public void setCollidable(boolean bln) {
        baseObject.setCollidable(bln);
    }

    public boolean isCollidable() {
        return baseObject.isCollidable();
    }

    public void setInvulnerable(boolean bln) {
        baseObject.setInvulnerable(bln);
    }

    public boolean isInvulnerable() {
        return baseObject.isInvulnerable();
    }

    public void stopSound(Sound sound) {
        baseObject.stopSound(sound);
    }

    public void stopSound(String string) {
        baseObject.stopSound(string);
    }

    public boolean isSilent() {
        return baseObject.isSilent();
    }

    public void setSilent(boolean bln) {
        baseObject.setSilent(bln);
    }

    public boolean hasGravity() {
        return baseObject.hasGravity();
    }

    public void setGravity(boolean bln) {
        baseObject.setGravity(bln);
    }

    public PotionEffect getPotionEffect(PotionEffectType pet) {
        return baseObject.getPotionEffect(pet);
    }

    public boolean isHandRaised() {
        return baseObject.isHandRaised();
    }

    public boolean addScoreboardTag(String tag) {
        return baseObject.addScoreboardTag(tag);
    }

    public int getPortalCooldown() {
        return baseObject.getPortalCooldown();
    }

    public Set<String> getScoreboardTags() {
        return baseObject.getScoreboardTags();
    }

    public boolean removeScoreboardTag(String tag) {
        return baseObject.removeScoreboardTag(tag);
    }

    public void setPortalCooldown(int cooldown) {
        baseObject.setPortalCooldown(cooldown);
    }

    public AdvancementProgress getAdvancementProgress(Advancement advancement) {
        return baseObject.getAdvancementProgress(advancement);
    }

    public int getClientViewDistance() {
        return baseObject.getClientViewDistance();
    }

    public String getLocale() {
        return baseObject.getLocale();
    }

    public String getPlayerListFooter() {
        return baseObject.getPlayerListFooter();
    }

    public String getPlayerListHeader() {
        return baseObject.getPlayerListHeader();
    }

    public void hidePlayer(Plugin plugin, Player player) {
        baseObject.hidePlayer(plugin, player);
    }

    public void playSound(Location location, Sound sound, SoundCategory category, float volume, float pitch) {
        baseObject.playSound(location, sound, category, volume, pitch);
    }

    public void playSound(Location location, String sound, SoundCategory category, float volume, float pitch) {
        baseObject.playSound(location, sound, category, volume, pitch);
    }

    public void sendBlockChange(Location loc, BlockData block) {
        baseObject.sendBlockChange(loc, block);
    }

    public void sendTitle(String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        baseObject.sendTitle(title, subtitle, fadeIn, stay, fadeOut);
    }

    public void setPlayerListFooter(String footer) {
        baseObject.setPlayerListFooter(footer);
    }

    public void setPlayerListHeader(String header) {
        baseObject.setPlayerListHeader(header);
    }

    public void setPlayerListHeaderFooter(String header, String footer) {
        baseObject.setPlayerListHeaderFooter(header, footer);
    }

    public void setResourcePack(String url, byte[] hash) {
        baseObject.setResourcePack(url, hash);
    }

    public void showPlayer(Plugin plugin, Player player) {
        baseObject.showPlayer(plugin, player);
    }

    public void stopSound(Sound sound, SoundCategory category) {
        baseObject.stopSound(sound, category);
    }

    public void stopSound(String sound, SoundCategory category) {
        baseObject.stopSound(sound, category);
    }

    public void updateCommands() {
        baseObject.updateCommands();
    }

    public boolean discoverRecipe(NamespacedKey recipe) {
        return baseObject.discoverRecipe(recipe);
    }

    public int discoverRecipes(Collection<NamespacedKey> recipes) {
        return baseObject.discoverRecipes(recipes);
    }

    public Location getBedLocation() {
        return baseObject.getBedLocation();
    }

    public int getCooldown(Material material) {
        return baseObject.getCooldown(material);
    }

    public Entity getShoulderEntityLeft() {
        return baseObject.getShoulderEntityLeft();
    }

    public Entity getShoulderEntityRight() {
        return baseObject.getShoulderEntityRight();
    }

    public boolean hasCooldown(Material material) {
        return baseObject.hasCooldown(material);
    }

    public InventoryView openMerchant(Merchant merchant, boolean force) {
        return baseObject.openMerchant(merchant, force);
    }

    public void setCooldown(Material material, int ticks) {
        baseObject.setCooldown(material, ticks);
    }

    public void setShoulderEntityLeft(Entity entity) {
        baseObject.setShoulderEntityLeft(entity);
    }

    public void setShoulderEntityRight(Entity entity) {
        baseObject.setShoulderEntityRight(entity);
    }

    public boolean sleep(Location location, boolean force) {
        return baseObject.sleep(location, force);
    }

    public boolean undiscoverRecipe(NamespacedKey recipe) {
        return baseObject.undiscoverRecipe(recipe);
    }

    public int undiscoverRecipes(Collection<NamespacedKey> recipes) {
        return baseObject.undiscoverRecipes(recipes);
    }

    public void wakeup(boolean setSpawnLocation) {
        baseObject.wakeup(setSpawnLocation);
    }

    public Block getTargetBlockExact(int maxDistance) {
        return baseObject.getTargetBlockExact(maxDistance);
    }

    public Block getTargetBlockExact(int maxDistance, FluidCollisionMode fluidCollisionMode) {
        return baseObject.getTargetBlockExact(maxDistance, fluidCollisionMode);
    }

    public boolean isRiptiding() {
        return baseObject.isRiptiding();
    }

    public boolean isSwimming() {
        return baseObject.isSwimming();
    }

    public RayTraceResult rayTraceBlocks(double maxDistance) {
        return baseObject.rayTraceBlocks(maxDistance);
    }

    public RayTraceResult rayTraceBlocks(double maxDistance, FluidCollisionMode fluidCollisionMode) {
        return baseObject.rayTraceBlocks(maxDistance, fluidCollisionMode);
    }

    public void setSwimming(boolean swimming) {
        baseObject.setSwimming(swimming);
    }

    public boolean addPassenger(Entity passenger) {
        return baseObject.addPassenger(passenger);
    }

    public BoundingBox getBoundingBox() {
        return baseObject.getBoundingBox();
    }

    public BlockFace getFacing() {
        return baseObject.getFacing();
    }

    public double getHeight() {
        return baseObject.getHeight();
    }

    public List<Entity> getPassengers() {
        return baseObject.getPassengers();
    }

    public PistonMoveReaction getPistonMoveReaction() {
        return baseObject.getPistonMoveReaction();
    }

    public double getWidth() {
        return baseObject.getWidth();
    }

    public boolean isPersistent() {
        return baseObject.isPersistent();
    }

    public boolean removePassenger(Entity passenger) {
        return baseObject.removePassenger(passenger);
    }

    public void setPersistent(boolean persistent) {
        baseObject.setPersistent(persistent);
    }

    public void setRotation(float yaw, float pitch) {
        baseObject.setRotation(yaw, pitch);
    }

    public void playNote(Location loc, byte instrument, byte note) {
        baseObject.playNote(loc, instrument, note);
    }

    public Pose getPose() {
        return baseObject.getPose();
    }

    public PersistentDataContainer getPersistentDataContainer() {
        return baseObject.getPersistentDataContainer();
    }
}

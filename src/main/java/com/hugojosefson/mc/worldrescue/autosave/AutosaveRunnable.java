//
// Decompiled by Procyon v0.5.36
//

package com.hugojosefson.mc.worldrescue.autosave;

import com.hugojosefson.mc.worldrescue.WorldRescue;
import com.hugojosefson.mc.worldrescue.commands.Commands;
import org.bukkit.Bukkit;
import org.bukkit.World;

import java.util.List;

public class AutosaveRunnable implements Runnable {
  final Commands commands;

  public AutosaveRunnable() {
    final WorldRescue plugin = (WorldRescue) Bukkit.getPluginManager().getPlugin("WorldRescue");
    commands = new Commands(plugin);
  }

  @Override
  public void run() {
    Bukkit.broadcastMessage("§f[§WorldRescue§f] §6Starting autosave...");

    final List<World> activeWorlds = Bukkit.getServer().getWorlds();
    activeWorlds.stream()
      .map(World::getName)
      .map(name -> new String[]{"save", name, "autosave"})
      .forEach(args -> commands.saveRebuild(null, args));

    Bukkit.broadcastMessage("§f[§WorldRescue§f] §6Finished autosave.");
  }
}

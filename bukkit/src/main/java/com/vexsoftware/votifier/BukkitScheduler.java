package com.vexsoftware.votifier;

import com.vexsoftware.votifier.platform.scheduler.ScheduledVotifierTask;
import com.vexsoftware.votifier.platform.scheduler.VotifierScheduler;
//import org.bukkit.scheduler.BukkitTask;

import java.util.concurrent.TimeUnit;

class BukkitScheduler implements VotifierScheduler {
    private final NuVotifierBukkit plugin;

    public BukkitScheduler(NuVotifierBukkit plugin) {
        this.plugin = plugin;
    }

    private int toTicks(int time, TimeUnit unit) {
        return (int) (unit.toMillis(time) / 50);
    }

    @Override
    public ScheduledVotifierTask delayedOnPool(Runnable runnable, int delay, TimeUnit unit) {
        return new BukkitTaskWrapper(plugin.getServer().getAsyncScheduler().runDelayed(plugin, task -> runnable.run(), Math.max(1, delay), unit));
    }

    @Override
    public ScheduledVotifierTask repeatOnPool(Runnable runnable, int delay, int repeat, TimeUnit unit) {
        return new BukkitTaskWrapper(plugin.getServer().getAsyncScheduler().runAtFixedRate(plugin, task -> runnable.run(), Math.max(1, delay), Math.max(1, repeat), unit));
    }

    private static class BukkitTaskWrapper implements ScheduledVotifierTask {
        private final io.papermc.paper.threadedregions.scheduler.ScheduledTask task;

        private BukkitTaskWrapper(io.papermc.paper.threadedregions.scheduler.ScheduledTask task) {
            this.task = task;
        }

        @Override
        public void cancel() {
            task.cancel();
        }
    }
}

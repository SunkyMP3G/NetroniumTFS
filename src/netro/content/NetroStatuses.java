package netro.content;

import arc.graphics.*;
import mindustry.content.*;
import mindustry.entities.effect.*;
import mindustry.type.*;

public class NetroStatuses {
    public static StatusEffect
    // Usual statuses
    lavaMelting, shock, stasis,
    signalLoss, armorBreak, frostburn, snowy, blizzard,
    // Phomaxite
    phomaxiteAlert, corrosion, phomaxiteMarked,
    // Boss
    bossRage1, bossRage2, bossRage3, bossRage4, buildSuppress, buildSlowdown, immunity,
    // Wave challenges
    waveRage1, waveRage2, waveRage3, waveRage4, waveRage5;

    public static void load(){
        // Since campaign will have its own unique bosses with their own HP and damage, these buffs are unnecessary
        StatusEffects.boss.healthMultiplier = 1;
        StatusEffects.boss.damageMultiplier = 1;

        float dmg = 60f;

        lavaMelting = new StatusEffect("lava-melting"){{
            color = Color.valueOf("ffd27e");
            effect = Fx.melting;
            speedMultiplier = 0.5f;
            damage = 60f/dmg;
            hideDatabase = true;
        }};

        stasis = new StatusEffect("stasis"){{
            color = Color.valueOf("ffd27e");
            speedMultiplier = 0f;
            dragMultiplier = 999f;
            disarm = true;
            hideDatabase = true;
        }};

        signalLoss = new StatusEffect("signal-loss"){{
            color = Color.valueOf("f25555");
            speedMultiplier = 0f;
            dragMultiplier = 0f;
            buildSpeedMultiplier = 0f;
            disarm = true;
            hideDatabase = true;
        }};

        armorBreak = new StatusEffect("armor-break"){{
            color = Color.valueOf("989aa4");
            healthMultiplier = 0.5f;
            hideDatabase = true;
        }};

        frostburn = new StatusEffect("frostburn"){{
            color = Color.valueOf("80a9ff");
            effect = Fx.freezing;
            speedMultiplier = 0.7f;
            damage = 80f/dmg;
            hideDatabase = true;
        }};

        shock = new StatusEffect("shock"){{ // Tesla hit status
            color = Color.valueOf("87ceeb");
            speedMultiplier = 0.33f;
        }};

        buildSuppress = new StatusEffect("build-suppress"){{ // When boss is alive, applied by world processors on any unit that can build
            color = Color.valueOf("f25555");
            buildSpeedMultiplier = 0.01f;
            hideDatabase = true;
        }};

        buildSlowdown = new StatusEffect("build-slowdown"){{ // When boss is alive, applied by world processors on core unit
            color = Color.valueOf("80a9ff");
            buildSpeedMultiplier = 0.5f;
        }};

        snowy = new StatusEffect("snowy"){{ // Snowy weather status
            color = Color.valueOf("ffffff");
            speedMultiplier = 0.9f;
            reloadMultiplier = 0.9f;
            hideDatabase = true;
        }};

        blizzard = new StatusEffect("blizzard-status"){{ // Blizzard weather status
            color = Color.valueOf("87ceeb");
            speedMultiplier = 0.8f;
            reloadMultiplier = 0.8f;
            dragMultiplier = 1.2f;
            hideDatabase = true;
        }};


        // Phomaxite
        phomaxiteAlert = new StatusEffect("phomaxite-alert"){{ // Applied on alerted Phomaxite Abominations
            color = Color.valueOf("55e665");
            speedMultiplier = 2f;
            hideDatabase = true;
        }};
        phomaxiteMarked = new StatusEffect("phomaxite-marked"){{ // Applied on units targeted by Phomaxite Abominations
            color = Color.valueOf("55e665");
            speedMultiplier = 0.9f;
            hideDatabase = true;
        }};
        corrosion = new StatusEffect("corrosion"){{ // Phomaxitic spits and explosions, stepping on phomaxite
            color = Color.valueOf("55e665");
            damage = 25f/dmg;
            effect = new WrapEffect(Fx.vapor, Color.valueOf("c4ff55"));
            speedMultiplier = 0.7f;
            healthMultiplier = 0.8f;
            hideDatabase = true;
        }};


        // Boss rage
        bossRage1 = new StatusEffect("boss-rage1"){{
            color = Color.valueOf("9e78dc");
            effect = NetroFx.bossEnraged;
            effectChance = 0.04f;
            damageMultiplier = 2f;
            reloadMultiplier = speedMultiplier = 2f;
            hideDatabase = true;
        }};
        bossRage2 = new StatusEffect("boss-rage2"){{
            color = Color.valueOf("f25555");
            effect = NetroFx.bossEnraged;
            effectChance = 0.04f;
            damageMultiplier = 3f;
            reloadMultiplier = speedMultiplier = 3f;
            hideDatabase = true;
        }};
        bossRage3 = new StatusEffect("boss-rage3"){{
            color = Color.valueOf("ffd27e");
            effect = NetroFx.bossEnraged;
            effectChance = 0.04f;
            damageMultiplier = 5f;
            reloadMultiplier = speedMultiplier = 5f;
            hideDatabase = true;
        }};
        bossRage4 = new StatusEffect("boss-rage4"){{ // You must be deliberately stalling the boss to reach that
            color = Color.valueOf("f08dd5");
            effect = NetroFx.bossEnraged;
            effectChance = 0.04f;
            damageMultiplier = 999f;
            reloadMultiplier = speedMultiplier = 7.5f;
            hideDatabase = true;
        }};
        immunity = new StatusEffect("immunity"){{ // Makes bosses immune to all debuffs
            color = Color.valueOf("ffffff");
            permanent = true;
            init(() -> {
                opposite(StatusEffects.burning, StatusEffects.unmoving, StatusEffects.wet, StatusEffects.tarred,
                StatusEffects.blasted, StatusEffects.electrified, StatusEffects.corroded, StatusEffects.freezing, StatusEffects.shocked,
                StatusEffects.sapped, StatusEffects.melting, StatusEffects.slow, StatusEffects.sporeSlowed, StatusEffects.disarmed,
                StatusEffects.muddy, shock, corrosion, snowy, blizzard);
            });
        }};


        // Wave stat boosts (so waves don't just increase in size)
        waveRage1 = new StatusEffect("wave-rage1"){{
            color = Color.valueOf("9e78dc");
            effect = NetroFx.waveRageFx;
            damageMultiplier = healthMultiplier = 1.33f;
            speedMultiplier = reloadMultiplier = 1.1f;
            hideDatabase = true;
        }};
        waveRage2 = new StatusEffect("wave-rage2"){{
            color = Color.valueOf("f25555");
            effect = NetroFx.waveRageFx;
            damageMultiplier = healthMultiplier = 1.66f;
            speedMultiplier = reloadMultiplier = 1.2f;
            hideDatabase = true;
        }};
        waveRage3 = new StatusEffect("wave-rage3"){{
            color = Color.valueOf("ffd27e");
            effect = NetroFx.waveRageFx;
            damageMultiplier = healthMultiplier = 2f;
            speedMultiplier = reloadMultiplier = 1.3f;
            hideDatabase = true;
        }};
        waveRage4 = new StatusEffect("wave-rage4"){{
            color = Color.valueOf("87ceeb");
            effect = NetroFx.waveRageFx;
            damageMultiplier = healthMultiplier = 2.5f;
            speedMultiplier = reloadMultiplier = 1.4f;
            hideDatabase = true;
        }};
        waveRage5 = new StatusEffect("wave-rage5"){{
            color = Color.valueOf("f08dd5");
            effect = NetroFx.waveRageFx;
            damageMultiplier = healthMultiplier = 3f;
            speedMultiplier = reloadMultiplier = 1.5f;
            hideDatabase = true;
        }};
    }
}
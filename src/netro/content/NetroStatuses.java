package netro.content;

import arc.graphics.*;
import mindustry.content.*;
import mindustry.entities.effect.*;
import mindustry.graphics.*;
import mindustry.type.*;


public class NetroStatuses {
    public static StatusEffect
    corrosion, weakCorrosion, lavaMelting, shock, stasis, signalLoss, armorBreak, frostBurn, buildSuppress, buildSlowdown, snowy, blizzard;

    public static void load(){
        // Since campaign will have its own unique bosses, these buffs are useless
        StatusEffects.boss.healthMultiplier = 1;
        StatusEffects.boss.damageMultiplier = 1;

        corrosion = new StatusEffect("corrosion"){{ // When you step on phomaxite
            color = Color.valueOf("ffc455");
            damage = 0.4f;
            effect = new WrapEffect(Fx.melting, Color.valueOf("ffc455"));
            speedMultiplier = 0.7f;
            healthMultiplier = 0.8f;
        }};

        weakCorrosion = new StatusEffect("weak-corrosion"){{ // Acid rain internal status
            color = Pal.plastanium;
            speedMultiplier = 0.9f;
            healthMultiplier = 0.9f;
        }};

        lavaMelting = new StatusEffect("lava-melting"){{ // When you step on the lava floor
            color = Color.valueOf("f8c266");
            effect = Fx.melting;
            speedMultiplier = 0.5f;
            damage = 0.6f;
        }};

        stasis = new StatusEffect("stasis"){{
            color = Color.valueOf("ffff00");
            speedMultiplier = 0f;
            dragMultiplier = 999f;
            disarm = true;
        }};

        signalLoss = new StatusEffect("signal-loss"){{
            color = Color.valueOf("994444");
            speedMultiplier = 0f;
            dragMultiplier = 0f;
            buildSpeedMultiplier = 0f;
            disarm = true;
        }};

        armorBreak = new StatusEffect("armor-break"){{
            healthMultiplier = 0.5f;
        }};

        frostBurn = new StatusEffect("frostburn"){{
            color = Color.valueOf("5555ff");
            effect = Fx.freezing;
            speedMultiplier = 0.7f;
            damage = 0.8f;
        }};

        shock = new StatusEffect("shock"){{ // Tesla hit status
            speedMultiplier = 0.33f;
        }};

        buildSuppress = new StatusEffect("build-suppress"){{ // When boss is alive, applied by world processors on any unit that can build
            buildSpeedMultiplier = 0f;
        }};

        buildSlowdown = new StatusEffect("build-slowdown"){{ // When boss is alive, applied by world processors on core unit
            buildSpeedMultiplier = 0.5f;
        }};

        snowy = new StatusEffect("snowy"){{ // Snowy weather status
            speedMultiplier = 0.9f;
            reloadMultiplier = 0.9f;
        }};

        blizzard = new StatusEffect("blizzard-status"){{ // Blizzard weather status
            speedMultiplier = 0.8f;
            reloadMultiplier = 0.8f;
            dragMultiplier = 1.2f;
        }};
    }
}
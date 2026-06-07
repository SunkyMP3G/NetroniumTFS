package classes;

import arc.graphics.Color;
import mindustry.content.*;
import mindustry.entities.effect.WrapEffect;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import netro.content.NetroLiquids;
import netro.content.NetroStatuses;
import mindustry.entities.abilities.*;

public class PhomaxiteUnitType extends UnitType {
    public PhomaxiteUnitType(String name){
        super(name);
        outlineColor = Pal.neoplasmOutline;
        canDrown = false;
        payloadCapacity = 0;
        engineSize = 0;
        lightColor = Color.valueOf("00ff00");
        drawCell = false;
        drawItems = false;
        itemCapacity = 0;
        createScorch = false;
        deathSound = Sounds.shootSap;
        deathExplosionEffect = new WrapEffect(Fx.smokeCloud, Color.valueOf("c4ff55"));
        immunities.add(NetroStatuses.corrosion);
        healFlash = false;

        abilities.add(new LiquidExplodeAbility(){{
            liquid = NetroLiquids.phomaxite;
        }});

        abilities.add(new LiquidRegenAbility(){{
            liquid = NetroLiquids.phomaxite;
            slurpEffect = Fx.neoplasmHeal;
        }});
    }
}
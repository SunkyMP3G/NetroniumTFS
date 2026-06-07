package classes;

import arc.*;
import arc.graphics.Color;
import arc.math.*;
import arc.scene.ui.layout.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.abilities.Ability;
import mindustry.entities.effect.WrapEffect;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.type.*;

import static mindustry.Vars.*;
@SuppressWarnings("all")

public class PhomaxiteUnitSpawnAbility extends Ability { //Same UnitSpawn but without yellow lines and another effect. Used for Swarm boss
    public UnitType unit;
    public float spawnTime = 60f, spawnX, spawnY;
    public Effect spawnEffect = new WrapEffect(Fx.vapor, Color.valueOf("c4ff55"));
    public boolean parentizeEffects;

    protected float timer;

    public PhomaxiteUnitSpawnAbility(UnitType unit, float spawnTime, float spawnX, float spawnY){
        this.unit = unit;
        this.spawnTime = spawnTime;
        this.spawnX = spawnX;
        this.spawnY = spawnY;
    }

    public PhomaxiteUnitSpawnAbility(){
    }

    @Override
    public void addStats(Table t){
        super.addStats(t);
        t.add(abilityStat("buildtime", Strings.autoFixed(spawnTime / 60f, 2)));
        t.row();
        t.add((unit.hasEmoji() ? unit.emoji() : "") + "[stat]" + unit.localizedName);
    }

    @Override
    public void update(Unit unit){
        timer += Time.delta * state.rules.unitBuildSpeed(unit.team);

        if(timer >= spawnTime && Units.canCreate(unit.team, this.unit)){
            //what anuke was thinking when assigning spawnY as 'x' value and vice versa? AND IT SOMEHOW WORKS?
            float x = unit.x + Angles.trnsx(unit.rotation, spawnY, -spawnX), y = unit.y + Angles.trnsy(unit.rotation, spawnY, -spawnX);
            spawnEffect.at(x, y, 0f, parentizeEffects ? unit : null);
            Unit u = this.unit.create(unit.team);
            u.set(x, y);
            u.rotation = unit.rotation;
            Events.fire(new UnitCreateEvent(u, null, unit));
            if(!Vars.net.client()){
                u.add();
                Units.notifyUnitSpawn(u);
            }

            timer = 0f;
        }
    }

    @Override
    public String localized(){
        return Core.bundle.format("ability.unitspawn", unit.localizedName);
    }
}
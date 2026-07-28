package classes;

import arc.graphics.*;
import arc.graphics.g2d.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.graphics.*;

public class FlameBulletType extends BulletType{ //FireBulletType but only makes fire when hits
    public Color colorFrom = Pal.lightFlame, colorMid = Pal.darkFlame, colorTo = Color.gray;
    public float radius = 3f;
    {
        pierce = true;
        ammoMultiplier = 1f;
        displayAmmoMultiplier = false;
        drag = 0.03f;
        trailEffect = Fx.fireHit;
        trailSpread = 5f;
        trailInterval = 1f;
        incendAmount = 1;
        status = StatusEffects.burning;
        statusDuration = 60f * 5;
        despawnEffect = Fx.none;
        hittable = false;
        makeFire = true;
        hitEffect = Fx.fireHit;
    }

    public FlameBulletType(float speed, float damage){
        super(speed, damage);
    }

    @Override
    public void draw(Bullet b){
        Draw.color(colorFrom, colorMid, colorTo, b.fin());
        Fill.circle(b.x, b.y, radius * b.fout());
        Draw.reset();
    }
}
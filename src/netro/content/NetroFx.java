package netro.content;

import arc.graphics.g2d.*;
import mindustry.entities.*;
import mindustry.graphics.*;

import static arc.graphics.g2d.Draw.*;


public class NetroFx {
    public static final Effect
    chainPart = new Effect(40f, e -> {
        color(e.color);
        alpha(e.fout(0.2f));
        rect("netroniummod-chain-part", e.x, e.y, 8f, 8f, e.rotation);
    }),
    bossEnraged = new Effect(60f, e -> {
        color(e.color, e.color, Pal.lightishGray, e.fin());
        alpha(e.fout(0.33f));
        rect("netroniummod-boss-enraged", e.x, e.y, 8f, 8f, 0);
    }),
    waveRageFx = new Effect(60f, e -> {
        color(e.color, e.color, Pal.lightishGray, e.fin());
        alpha(e.fout(0.33f));
        Fill.square(e.x, e.y, e.fout() * 3f, e.fout() * 90f);
    });
}
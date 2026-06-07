package classes;


import mindustry.entities.*;
import static arc.graphics.g2d.Draw.*;


public class NetroFx {

    public static final Effect
    chainPart = new Effect(40f, e -> {
        color(e.color);
        rect("netroniummod-chain-part", e.x, e.y, 8f, 8f, e.rotation);
    });
}
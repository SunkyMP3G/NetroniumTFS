package classes;

import arc.graphics.*;
import mindustry.type.*;

public class GuideItem extends Item {
    public GuideItem(String name){
        super(name);
        hidden = true;
        buildable = false;
        color = Color.black;
    }
}
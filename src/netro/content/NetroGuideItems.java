package netro.content;

import classes.*;
import mindustry.type.*;

public class NetroGuideItems {
    public static Item
        guideIntro, energyGuide, bossGuide, soon;

    public static void load(){
        guideIntro = new GuideItem("guide-intro"){{
            alwaysUnlocked = true;
        }};
        energyGuide = new GuideItem("guide-energy"){};
        bossGuide = new GuideItem("guide-boss"){};
        soon = new GuideItem("soon"){};
    }
}
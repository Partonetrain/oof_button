package info.partonetrain.oof_button;

public enum OofSound {
    //G
    //Ctrl+G
    //Alt+G
    OOF(0),
    ROBLOX_OOF(1),
    VINE_BOOM(2),

    WEBFISHING_MEOW(10),
    WEBFISHING_HISS(11),
    WEBFISHING_MRRP(12),

    WEBFISHING_BARK(20),
    WEBFISHING_GROWL(21),
    WEBFISHING_WHIMPER(22);

    private final int index;
    OofSound(int index) {
        this.index = index;
    }

    public int getIndex(){
        return index;
    }

    public String getI18N(){
        return "oof_sound.player." + this.name().toLowerCase();
    }

}

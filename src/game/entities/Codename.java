package game.entities;

public enum Codename {
    G("Gold"),
    H("Hero"),
    P("Pit"),
    W("Wumpus"),
    B("Breeze"),
    L("Light"),
    S("Stinck");

    private String codename;

    Codename(String codename) {
        this.codename = codename;
    }

    public String getDescription(String codeName){
        return "";
    }

}

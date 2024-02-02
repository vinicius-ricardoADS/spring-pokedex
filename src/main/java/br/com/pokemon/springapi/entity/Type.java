package br.com.pokemon.springapi.entity;

public enum Type {
    FI("FI", "Fire"),
    NO("NO", "Normal"),
    WA("WA", "Water"),
    EL("EL", "Electric"),
    PL("PL", "Plant"),
    IC("IC", "Ice"),
    FT("FT", "Fighter"),
    PO("PO", "Poison"),
    EA("EA", "Earth"),
    FL("FL", "Flying"),
    PS("PS", "Psychic"),
    BU("BU", "Bug"),
    ST("ST", "Stone"),
    GH("GH", "Ghost"),
    DR("DR", "Dragon"),
    DA("DA", "Dark"),
    ME("ME", "Metallic"),
    FA("FA", "Fairy");

    private String acronym;

    private String description;

    Type(String acronym, String description) {
        this.acronym = acronym;
        this.description = description;
    }

    public String getAcronym() {
        return this.acronym;
    }

    public String getDescription() {
        return this.description;
    }
}

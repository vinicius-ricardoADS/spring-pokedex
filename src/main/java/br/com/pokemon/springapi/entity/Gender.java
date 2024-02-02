package br.com.pokemon.springapi.entity;

public enum Gender {
    MA("MA", "Male"),
    FE("FE", "Female"),
    UN("UN", "Unkown");

    private String acronym;

    private String description;

    Gender(String acronym, String description) {
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

package talisman.model.character.defaultCharacters;

enum Dwarf implements Character {
    ;

    public static String getName() {

        return "Dwarf";
    }


    public static String[] getLore() {

        return new String[] {"The Dwarf is an entity that dwells in mountains and in the earth", "The entity is variously associated with wisdom, smithing, mining, and crafting"};
    }


    public static int getHealth() {

        return 3;
    }


    public static int getStrength() {

        return 3;
    }


    public static int getCraft() {

        return 5;
    }


    public static int getFate() {

        return 5;
    }
}

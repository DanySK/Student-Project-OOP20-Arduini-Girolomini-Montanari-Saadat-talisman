package talisman.util;

public enum DiceType {

    SEVEN,
    DOUBLE_SEVEN;

    public int getFaces(){

        switch (this) {

            case SEVEN:
                return 7;
            case DOUBLE_SEVEN:
                return 14;
            default:
                return 0;
        }
    }
}

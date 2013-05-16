package cz.muni.fi.j002.cardgamee.model;

public enum Card {

    CLUB_2(2),
    CLUB_3(3),
    CLUB_4(4),
    CLUB_5(5);//,
//    CLUB_6(6),
//    CLUB_7(7),
//    CLUB_8(8),
//    CLUB_9(9),
//    CLUB_10(10),
//    CLUB_11(11),
//    CLUB_12(12),
//    CLUB_13(13),
//    CLUB_14(14),
//    DIAMOND_2(2),
//    DIAMOND_3(3),
//    DIAMOND_4(4),
//    DIAMOND_5(5),
//    DIAMOND_6(6),
//    DIAMOND_7(7),
//    DIAMOND_8(8),
//    DIAMOND_9(9),
//    DIAMOND_10(10),
//    DIAMOND_11(11),
//    DIAMOND_12(12),
//    DIAMOND_13(13),
//    DIAMOND_14(14),
//    HEART_2(2),
//    HEART_3(3),
//    HEART_4(4),
//    HEART_5(5),
//    HEART_6(6),
//    HEART_7(7),
//    HEART_8(8),
//    HEART_9(9),
//    HEART_10(10),
//    HEART_11(11),
//    HEART_12(12),
//    HEART_13(13),
//    HEART_14(14),
//    SPADE_2(2),
//    SPADE_3(3),
//    SPADE_4(4),
//    SPADE_5(5),
//    SPADE_6(6),
//    SPADE_7(7),
//    SPADE_8(8),
//    SPADE_9(9),
//    SPADE_10(10),
//    SPADE_11(11),
//    SPADE_12(12),
//    SPADE_13(13),
//    SPADE_14(14);

    private final int value;

    Card(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

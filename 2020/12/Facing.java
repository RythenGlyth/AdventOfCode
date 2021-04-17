public enum Facing {
    NORTH((byte)0, (byte)1),EAST((byte)1, (byte)0),SOUTH((byte)0, (byte)-1),WEST((byte)-1, (byte)0);

    private final byte x;
    private final byte y;

    private Facing(byte x, byte y) {
        this.x = x;
        this.y = y;
    }

    public static Facing fromChar(char asText) {
        switch(asText) {
            case 'N':
                return NORTH;
            case 'S':
                return SOUTH;
            case 'E':
                return EAST;
            case 'W':
            default:
                return WEST;
        }
    }

    public void applyToCoordsObject(CoordsObject obj, int amount) {
        obj.x += this.x * amount;
        obj.y += this.y * amount;
    }
}
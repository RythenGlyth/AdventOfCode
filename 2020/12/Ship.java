public class Ship {

    public int x = 0;
    public int y = 0;
    public Facing facing = Facing.EAST;



    public static enum Facing {
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

        public void applyToShip(Ship ship, int amount) {
            ship.x += this.x * amount;
            ship.y += this.y * amount;
        }
    }

    public static class Instruction {

        private char cmd;
        private int amount;

        public Instruction(String asText) {
            cmd = asText.charAt(0);
            amount = Integer.parseInt(asText.substring(1));
        }

        public void apply(Ship ship) {
            switch(cmd) {
                case 'F':
                    ship.facing.applyToShip(ship, amount);
                    break;
                case 'L':
                    ship.facing = Facing.values()[((ship.facing.ordinal() + 4) - (amount / 90)) % 4];
                    break;
                case 'R':
                    ship.facing = Facing.values()[(ship.facing.ordinal() + (amount / 90)) % 4];
                    break;
                default:
                    Facing.fromChar(cmd).applyToShip(ship, amount);
                    break;
            }
        }

    }
}



public class Ship extends CoordsObject {

    public static class Part1 extends Ship {
        public Facing facing = Facing.EAST;
    
        public static class Instruction {
    
            private char cmd;
            private int amount;
    
            public Instruction(String asText) {
                cmd = asText.charAt(0);
                amount = Integer.parseInt(asText.substring(1));
            }
    
            public void apply(Ship.Part1 ship) {
                switch(cmd) {
                    case 'F':
                        ship.facing.applyToCoordsObject(ship, amount);
                        break;
                    case 'L':
                        ship.facing = Facing.values()[((ship.facing.ordinal() + 4) - (amount / 90)) % 4];
                        break;
                    case 'R':
                        ship.facing = Facing.values()[(ship.facing.ordinal() + (amount / 90)) % 4];
                        break;
                    default:
                        Facing.fromChar(cmd).applyToCoordsObject(ship, amount);
                        break;
                }
            }
    
        }
    }
    public static class Part2 extends Ship {
        public Waypoint waypoint = new Waypoint(10, 1);

        public static class Waypoint extends CoordsObject {
            public Waypoint(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public void applyToCoordsObject(CoordsObject obj, int amount) {
                obj.x += this.x * amount;
                obj.y += this.y * amount;
            }

            public void rotate(int by) {
                double byRad = (double)by/180*Math.PI;
                //System.out.println("s" + this.x);
                //System.out.println(this.y);
                //double theta = this.x != 0 ? Math.atan((double)this.y / this.x) : this.y != 0 ? Math.PI / 2 * (this.y / Math.abs(this.y)) : 0;
                //this.x = (int) (Math.cos(theta+byRad)*(double)this.y/Math.sin(theta));
                //this.y = (int) (Math.sin(theta+byRad)*(double)this.y/Math.sin(theta));
                int newx = (int)Math.round(this.x * Math.cos(byRad) - this.y * Math.sin(byRad));
                int newy = (int)Math.round(this.x * Math.sin(byRad) + this.y * Math.cos(byRad));
                this.x = newx;
                this.y = newy;
            }

            @Override
            public String toString() {
                return "Waypoint {" + this.x + "|" + this.y + "}";
            }

        }
    
        public static class Instruction {
    
            public char cmd;
            public int amount;
    
            public Instruction(String asText) {
                cmd = asText.charAt(0);
                amount = Integer.parseInt(asText.substring(1));
            }
    
            public void apply(Ship.Part2 ship) {
                switch(cmd) {
                    case 'F':
                        ship.waypoint.applyToCoordsObject(ship, amount);
                        break;
                    case 'L':
                        ship.waypoint.rotate(amount);
                        break;
                    case 'R':
                        ship.waypoint.rotate(-amount);
                        break;
                    default:
                        Facing.fromChar(cmd).applyToCoordsObject(ship.waypoint, amount);
                        break;
                }
            }
    
        }
    }
}

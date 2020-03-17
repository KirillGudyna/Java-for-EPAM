package equipments;


public class Appliance implements Equipment {
    private boolean inOff;
    private String nameAppliances;
    private int power;
    private Color color;

    public Appliance(String string) {
        this.inOff = false;
        switch (string.toUpperCase()) {
            case "BLACK": {
                color = Color.BLACK;
                break;
            }
            case "BLUE": {
                color = Color.BLUE;
                break;
            }
            case "GREEN": {
                color = Color.GREEN;
                break;
            }
            case "WHITE": {
                color = Color.WHITE;
                break;
            }
        }
    }

    public void setNameAppliances(String nameAppliances) {
        this.nameAppliances = nameAppliances;
    }

    public String getNameAppliances() {
        return nameAppliances;
    }

    @Override
    public void set(boolean inOff) {
        this.inOff = inOff;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }

    public boolean isInOff() {
        return inOff;
    }

    public Color getColor() {
        return this.color;
    }

}

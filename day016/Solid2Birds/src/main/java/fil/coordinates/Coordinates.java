package fil.coordinates;

import java.util.Objects;

public class Coordinates {
    private double x;
    private double y;
    private double z;

    public Coordinates(double x, double y, double z) {
        setCoordinates(x, y, z);
    }

    private void setCoordinates(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", x, y, z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == null || o == null) return false;
        if (!(o instanceof Coordinates that)) return false;
        return Double.compare(x, that.x) == 0 && Double.compare(y, that.y) == 0 && Double.compare(z, that.z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}

package ru.ksergey.isp;

public class Vesta113hp extends VestaImpl implements Vesta {
    public Vesta113hp(String model, String brand) {
        super(model, brand);
    }

    public Characteristic getBodyWheelArrangementTractionWheels() {
        throw new UnsupportedOperationException();
    }

    public Characteristic getBodyEngineLocation() {
        throw new UnsupportedOperationException();
    }

    public Characteristic getBodyTypeNumberOfDoors() {
        throw new UnsupportedOperationException();
    }

    public Characteristic getBodysuits() {
        return Characteristic.set("5");
    }

    public Characteristic getBodyLengthWidthHeight() {
        return Characteristic.set("4410/1764/1497 mm");
    }

    public Characteristic getBodyWheelbase() {
        return Characteristic.set("2635 mm");
    }

    public Characteristic getBodyFrontRearTrack() {
        return Characteristic.set("1510/1510 mm");
    }

    public Characteristic getBodyRoadClearance() {
        return Characteristic.set("178 mm");
    }

    public Characteristic getBodyRearTrunkCapacity() {
        return Characteristic.set("480 mm");
    }

    public Characteristic getSuspensionFront() {
        throw new UnsupportedOperationException();
    }

    public Characteristic getSuspensionBack() {
        throw new UnsupportedOperationException();
    }

    public Characteristic getSteeringControlSteeringMechanism() {
        throw new UnsupportedOperationException();
    }

    public Characteristic getTiresGeneralProportions() {
        return Characteristic.set("185/65 R15 (88/92, H/T); 195/55 R16 (91, H)");
    }
}

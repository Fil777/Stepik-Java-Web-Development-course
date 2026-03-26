package ru.ksergey.isp;

public class Vesta122hp extends VestaImpl implements Vesta {
    public Vesta122hp(String model, String brand) {
        super(model, brand);
    }

    public Characteristic getBodyWheelArrangementTractionWheels() {
        return Characteristic.set("4x2/front");
    }

    public Characteristic getBodyEngineLocation() {
        return Characteristic.set("front lateral");
    }

    public Characteristic getBodyTypeNumberOfDoors() {
        return Characteristic.set("sedan/4");
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
        return Characteristic.set("Independent suspension, MacPherson type, spring-mounted, with an anti-roll bar");
    }

    public Characteristic getSuspensionBack() {
        return Characteristic.set(
                "Half-independent, lever type, spring-actuated, with oil-actuated or gas-filled telescopic shock absorbers");
    }

    public Characteristic getSteeringControlSteeringMechanism() {
        return Characteristic.set("Piston-rack");
    }

    public Characteristic getTiresGeneralProportions() {
        return Characteristic.set("185/65 R15 (88/92, H/T); 195/55 R16 (91, H)");
    }
}

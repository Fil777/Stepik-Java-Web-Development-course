package ru.ksergey.isp;

public class MyAudiA5 extends AudiA5 implements IAudiExclusive {
    public MyAudiA5(String model, String brand) {
        super(model, brand);
    }

    public Characteristic getSLinePackage() {
        return new Characteristic();
    }

    public Characteristic getAudiConnectPackage() {
        return new Characteristic();
    }

    public Characteristic getAudiPreSenseFrontPackage() {
        return new Characteristic();
    }

    public Characteristic getHeadlightsMatrixLedPackage() {
        return new Characteristic();
    }

    public Characteristic getInfotainmentPackage() {
        return new Characteristic();
    }

    public Characteristic getTowingPackagePackage() {
        return new Characteristic();
    }

    public Characteristic getAmbientLightingPackage() {
        return new Characteristic();
    }
}

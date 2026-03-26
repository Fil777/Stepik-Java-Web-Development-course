package ru.ksergey.isp;

public interface ISLine {
    Characteristic getSLinePackage();
}

interface IInfotainment {
    Characteristic getInfotainmentPackage();
}

interface IAudiPreSenseFront {
    Characteristic getAudiPreSenseFrontPackage();
}

interface IAdvanceLine extends IAudiCare, IAudiConnect, IHeadlights {
}

interface IAudiExclusive extends ISportLine, IDesignLine, IAmbientLighting {
}

interface IDesignLine extends IHeadlightsMatrixLed, IInfotainment, ITowingPackage {
}

interface ISportLine extends ISLine, IAudiConnect, IAudiPreSenseFront {
}

interface IAluminumDoorSillInlays {
    Characteristic getAluminumDoorSillInlaysPackage();
}

interface IAmbientLighting {
    Characteristic getAmbientLightingPackage();
}

interface IAudiCare {
    Characteristic getAudiCarePackage();
}

interface IAudiConnect {
    Characteristic getAudiConnectPackage();
}

interface IAudiDesignSelection {
    Characteristic getAudiDesignSelectionPackage();
}

interface IHeadlights {
    Characteristic getHeadlightsPackage();
}

interface IHeadlightsLed {
    Characteristic getHeadlightsLedPackage();
}

interface IHeadlightsMatrixLed {
    Characteristic getHeadlightsMatrixLedPackage();
}

interface IPowerPanoramicSunroof {
    Characteristic getPowerPanoramicSunroofPackage();
}

interface ITowingPackage {
    Characteristic getTowingPackagePackage();
}


package stationservice.test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import stationservice.entity.Bons;
import stationservice.model.BonsModel;
import stationservice.model.DeclarationModel;
import stationservice.report.GenerateReport;
import stationservice.ressource.Methode;

public class Main {

    public static void main(String[] args) {
        System.out.println(Methode.dateFormat(DeclarationModel.getMaxDate()));
    }

}

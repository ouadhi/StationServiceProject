package stationservice.report;

import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import stationservice.entity.Decbons;
import stationservice.entity.Declaration;
import stationservice.entity.DeclarationProduit;
import stationservice.entity.Pompiste;
import stationservice.ressource.Methode;

public class GenerateReport {

    private Declaration declaration;
    private Pompiste pompiste;

    public GenerateReport(Declaration declaration) {
        this.declaration = declaration;
        pompiste = this.declaration.getIdpompiste();
    }

    public void setDeclaration(Declaration declaration) {
        this.declaration = declaration;
    }

    public Declaration getDeclaration() {
        return declaration;
    }

    public void generate() {
        try {

            PdfReader reader = new PdfReader("Mn2.pdf"); // input PDF
            PdfStamper stamper = new PdfStamper(reader,
                    new FileOutputStream("Mn2_report.pdf")); // output PDF
            BaseFont bf = BaseFont.createFont(
                    BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED); // set font

            for (int i = 1; i <= reader.getNumberOfPages(); i++) {

                PdfContentByte over = stamper.getOverContent(i);

                declaration_information(over, bf);
                pompisteInformation(over, bf);
                bons_information(over, bf);
                produit_Information(over, bf);

            }
            stamper.close();
            
            if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("Mn2_report.pdf");
                Desktop.getDesktop().open(myFile);
                System.out.println("opened");
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void declaration_information(PdfContentByte over, BaseFont bf) {
        // id
        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(400, 554);
        over.showText(Integer.toString(declaration.getId()));
        over.endText();
        // date
        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(507, 493);
        over.showText(Methode.dateFormat(declaration.getDate()));
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(350, 417);
        over.showText(Double.toString(declaration.getTotal()));
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(515, 345);
        over.showText(Double.toString(declaration.getBons()));
        over.endText();

    }

    private void pompisteInformation(PdfContentByte over, BaseFont bf) {
        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(507, 481);
        over.showText(pompiste.getNom() + " " + pompiste.getPrenom());
        over.endText();
    }

    private void produit_Information(PdfContentByte over, BaseFont bf) {

        int sup = 155;
        int sp1 = 216;
        int sp2 = 289;
        int gaz = 383;
        for (DeclarationProduit dp : this.declaration.getDeclarationProduits()) {
            if (dp.getIdproduit().getDisignations().equals("sans plomb1")) {
                produit_rows(over, bf, dp, sp1);
            }

            if (dp.getIdproduit().getDisignations().equals("sans plomb2")) {
                produit_rows(over, bf, dp, sp2);
            }

            if (dp.getIdproduit().getDisignations().equals("super")) {
                produit_rows(over, bf, dp, sup);
            }

            if (dp.getIdproduit().getDisignations().equals("gazoil")) {
                produit_rows(over, bf, dp, gaz);
            }
        }
    }

    private void bons_information(PdfContentByte over, BaseFont bf) {
        int y = 417;
        for (Decbons d : this.declaration.getDecbonsCollection()) {
            bons_rows(over, bf, d, y);
            y = y - 12;
        }

    }

    private void bons_rows(PdfContentByte over, BaseFont bf, Decbons d, int y) {
        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(445, y);
        over.showText(d.getIdbons().getDesignation());
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(515, y);
        over.showText(Integer.toString(d.getNbons()));
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(575, y);
        over.showText(Double.toString(d.getIdbons().getVal()));
        over.endText();
    }

    private void produit_rows(PdfContentByte over, BaseFont bf, DeclarationProduit d, int x) {
        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 481);
        over.showText(Integer.toString(d.getAncien()));
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 469);
        over.showText(Integer.toString(d.getNouveau()));
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 457);
        over.showText(Integer.toString(d.getQuantite()));
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 444);
        over.showText(Double.toString(d.getPrix()));
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 432);
        over.showText(Double.toString(d.getSomme()));
        over.endText();
    }

}

package stationservice.report;

import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.codec.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.PieChart;
import stationservice.entity.Decbons;
import stationservice.entity.Declaration;
import stationservice.entity.DeclarationProduit;
import stationservice.entity.Pompiste;
import stationservice.entity.Produit;
import stationservice.ressource.Methode;

public class ReportFacture {

    private Declaration declaration;
    private Pompiste pompiste;

    public ReportFacture(Declaration declaration) {
        this.declaration = declaration;
        this.pompiste = declaration.getIdpompiste();
    }

    public Declaration getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Declaration declaration) {
        this.declaration = declaration;
    }

    public void create_report() {
        try {
           
            PdfReader reader = new PdfReader(getClass().getResourceAsStream("/stationservice/ressource/etat.pdf")) ;  // input PDF
             //PdfReader reader = new PdfReader("etat.pdf"); // input PDF("/stationservice
          //  PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("etatup.pdf")); // output PDF
            System.out.println("print");
            File pdfTemp = new File(getClass().getResource("/stationservice/ressource/etatup.pdf").getPath());
            System.out.println("print2");
            FileOutputStream fos = new FileOutputStream(pdfTemp);
            PdfStamper stamper = new PdfStamper(reader, fos) ;
            
            System.out.println("fin imp");

            BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED); // set font
            BaseFont font_header = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED); // set font

            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                
                PdfContentByte over = stamper.getOverContent(i);
                declaration_information(over, bf);
                pompiste_information(over, bf);
                carburant_information(over, bf);
                bons_infromation(over, bf);
                total_declartion(over, bf);
                
                apppendFootr(over, bf);
               
            }
            stamper.close();
            
            
        } catch (Exception ex) {
            Logger.getLogger(ReportFacture.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void apppendFootr(PdfContentByte over, BaseFont bf) {
        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(30, 30);
        over.showText("impression : " + this.dateimp());
        over.endText();
        
        
        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(30, 60);
        over.showText("utilisateur : " + this.declaration.getIduser().getUsername());
        over.endText();
    }
    
      private void appendHeader(PdfContentByte over, BaseFont bf) {
        over.beginText();
        over.setFontAndSize(bf, 16);
        over.setTextMatrix(210, 760);
        over.showText("entrprise");
        over.endText();
        
        
        
    }

    private void declaration_information(PdfContentByte over, BaseFont bf) {
        // id
        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(90, 670);
        over.showText(Integer.toString(declaration.getId()));
        over.endText();
        // date
        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(110, 650);
        over.showText(Methode.dateFormat(declaration.getDate()));
        over.endText();
    }

    private void pompiste_information(PdfContentByte over, BaseFont bf) {
        int y = 608;
        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(110, y);
        over.showText(this.pompiste.getNom());
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(290, y);
        over.showText(this.pompiste.getNom());
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(485, y);
        over.showText(Methode.dateFormat(pompiste.getDatenes()));
        over.endText();
    }

    public void total_declartion(PdfContentByte over, BaseFont bf) {
        int x = 210;

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 335);
        over.showText("" + this.declaration.getTotal());
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 320);
        over.showText("" + this.declaration.getBons());
        over.endText();
        
        double montant = this.declaration.getTotal() - this.declaration.getBons()  ; 
        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 308);
        over.showText("" +montant);
        over.endText();
        
        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 290);
        over.showText(""+this.declaration.getBillets() );
        over.endText();
        
        double monnaie  =  montant - this.declaration.getBillets(); 
        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 278);
        over.showText(""+monnaie);
        over.endText();
        
        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 263);
        over.showText(""+this.declaration.getAvance());
        over.endText();
        
        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 249);
        over.showText(""+(this.declaration.getTotal()-this.declaration.getAvance()));
        over.endText();
        
        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 232);
        over.showText(""+(monnaie - this.declaration.getAvance()));
        over.endText();
        
        
        
        
        
        
    }

    private void carburant_information(PdfContentByte over, BaseFont bf) {
        for (DeclarationProduit dp : declaration.getDeclarationProduits()) {
            if (dp.getIdproduit().getDisignations().equals("super")) {
                super_information(over, bf, dp);
            }

            if (dp.getIdproduit().getDisignations().equals("sans plomb1")) {
                sp1_information(over, bf, dp);
            }

            if (dp.getIdproduit().getDisignations().equals("sans plomb2")) {
                sp2_information(over, bf, dp);
            }

            if (dp.getIdproduit().getDisignations().equals("gazoil")) {
                gasoil_information(over, bf, dp);
            }
        }
    }

    private void bons_infromation(PdfContentByte over, BaseFont bf) {
        int x[] = {70, 140, 210};
        int y[] = {433, 425, 405, 390, 376, 362};
        int i = 0;

        for (Decbons decbons : this.declaration.getDecbonsCollection()) {
            over.beginText();
            over.setFontAndSize(bf, 10);
            over.setTextMatrix(x[0], y[i]);
            over.showText("" + decbons.getIdbons().getDesignation());
            over.endText();
            
            over.beginText();
            over.setFontAndSize(bf, 10);
            over.setTextMatrix(x[1], y[i]);
            over.showText("" + decbons.getNbons());
            over.endText();
            
            over.beginText();
            over.setFontAndSize(bf, 10);
            over.setTextMatrix(x[2], y[i]);
            over.showText("" + decbons.getTotal());
            over.endText();
            
            i+=1 ; 
        }

    }

    private void super_information(PdfContentByte over, BaseFont bf, DeclarationProduit dp) {
        int x = 165;

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 550);
        over.showText("" + dp.getAncien());
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 534);
        over.showText("" + dp.getNouveau());
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 521);
        over.showText("" + dp.getQuantite());
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 506);
        over.showText("" + dp.getPrix());
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 491);
        over.showText("" + dp.getSomme());
        over.endText();

    }

    private void sp1_information(PdfContentByte over, BaseFont bf, DeclarationProduit dp) {
        int x = 240;

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 550);
        over.showText("" + dp.getAncien());
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 534);
        over.showText("" + dp.getNouveau());
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 521);
        over.showText("" + dp.getQuantite());
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 506);
        over.showText("" + dp.getPrix());
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 491);
        over.showText("" + dp.getSomme());
        over.endText();

    }

    private void sp2_information(PdfContentByte over, BaseFont bf, DeclarationProduit dp) {
        int x = 345;

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 550);
        over.showText("" + dp.getAncien());
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 534);
        over.showText("" + dp.getNouveau());
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 521);
        over.showText("" + dp.getQuantite());
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 506);
        over.showText("" + dp.getPrix());
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 491);
        over.showText("" + dp.getSomme());
        over.endText();

    }

    private void gasoil_information(PdfContentByte over, BaseFont bf, DeclarationProduit dp) {
        int x = 435;

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 550);
        over.showText("" + dp.getAncien());
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 534);
        over.showText("" + dp.getNouveau());
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 521);
        over.showText("" + dp.getQuantite());
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 506);
        over.showText("" + dp.getPrix());
        over.endText();

        over.beginText();
        over.setFontAndSize(bf, 10);
        over.setTextMatrix(x, 491);
        over.showText("" + dp.getSomme());
        over.endText();

    }

    private String dateimp () {
         SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
         String  date  =  sdf.format(new Date())  ;  
         
         return  date  ;  
         
    }


}

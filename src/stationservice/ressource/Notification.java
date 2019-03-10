package stationservice.ressource;

import java.util.Date;
import javafx.scene.control.Alert;
import javafx.util.Duration;
import stationservice.entity.Declaration;
import stationservice.model.DeclarationModel;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class Notification {

    public static void Addnotification() {
        String title = "Succ\u00E8s";
        String message = "l'operation est termin\u00E9 avec succ\u00E8s ";
        NotificationType type = NotificationType.SUCCESS;
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(type);
        tray.showAndDismiss(Duration.seconds(4));
    }

    public static void champVideNotification() {
        String title = "V\u00E9rification";
        String message = "V\u00E9rifier tous les champs s'il vous plait!";
        NotificationType type = NotificationType.ERROR;
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(type);
        tray.showAndDismiss(Duration.seconds(4));
    }

    public static void check(String message) {
        String title = "Verification";
        NotificationType type = NotificationType.ERROR;
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(type);
        tray.showAndDismiss(Duration.seconds(4));
    }

    public static Alert deleteAlert() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation ");
        alert.setHeaderText("suppression  ");
        alert.setContentText("voulez vous vraiment effectuer cette op\u00E9ration ??");

        return alert;
    }

    public static void Deletenotification() {
        String title = "Suppression";
        String message = "l'operation est termin\u00E9 avec succ\u00E8s ";
        NotificationType type = NotificationType.SUCCESS;
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(type);
        tray.showAndDismiss(Duration.seconds(4));

    }

    public static void error(String message) {
        String title = "probl\u00E8me";
        NotificationType type = NotificationType.WARNING;
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(type);
        tray.showAndDismiss(Duration.seconds(4));
    }

    public static void errorNotification() {
        String title = "probl\u00E8me";
        String message = " v\u00E9rifier tous les champs s'il vous plait ";
        NotificationType type = NotificationType.WARNING;
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(type);
        tray.showAndDismiss(Duration.seconds(4));
    }

    public static void errorNotification(String msg) {
        String title = "probl\u00E8me";
        String message = msg;
        NotificationType type = NotificationType.WARNING;
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(type);
        tray.showAndDismiss(Duration.seconds(4));
    }
    
    public static void faildLogin(String msg) {
        String title = "Login";
        String message = msg;
        NotificationType type = NotificationType.WARNING;
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(type);
        tray.showAndDismiss(Duration.seconds(4));
    }

    public static void errorNotificationUserExists() {
        String title = "probl\u00E8me";
        String message = "L'utilisateur que vous avez specifie exit deja";
        NotificationType type = NotificationType.WARNING;
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(type);
        tray.showAndDismiss(Duration.seconds(4));
    }

    public static void fauxNotification() {
        String title = "Verification";
        String message = Erreurmsg.getPassword_user();
        NotificationType type = NotificationType.ERROR;
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(type);
        tray.showAndDismiss(Duration.seconds(4));
    }

    public static void login_notification() {
        String title = "Bonjour";
        String message = " Bonjour ";
        NotificationType type = NotificationType.SUCCESS;
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(type);
        tray.showAndDismiss(Duration.seconds(4));

    }

    public static void notif(NotificationType type, String title, String message) {
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(type);
        tray.showAndDismiss(Duration.seconds(4));
    }

    public static Alert updateAlert() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation ");
        alert.setHeaderText("Modification  ");
        alert.setContentText("voulez vous vraiment effectuer cette op\u00E9ration ??");

        return alert;
    }

    public static void Updatenotification() {
        
        String title = "Modification";
        String message = "l'operation est termin\u00E9 avec succ\u00E8s ";
        NotificationType type = NotificationType.SUCCESS;
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(type);
        tray.showAndDismiss(Duration.seconds(4));
    }

    public static Alert quitterAlert() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation ");
        alert.setHeaderText("Modification  ");
        alert.setContentText("voulez vous vraiment effectuer cette op\u00E9ration ??");
        return alert;
        
    }

    
    public static Alert ConfirmationAlert() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation ");
        alert.setHeaderText("Confirmation Des Donnees   ");
        alert.setContentText("voulez vous vraiment effectuer cette op\u00E9ration ??");
       
        return alert;
        
    }
    
     public static Alert WarningMaxDateAlert() {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Attention ");
        alert.setHeaderText("Attention La  Date");
        alert.setContentText(" impossible d enregistrer une op\u00E9ration apres La date de "+Methode.dateFormat(DeclarationModel.getMaxDate()));
       
        return alert;
        
    }
     
     public static Alert WarningToDateAlert() {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Attention ");
        alert.setHeaderText("Attention La  Date");
        alert.setContentText(" impossible d enregistrer une op\u00E9ration apres La date de "+Methode.dateFormat(new Date()));
       
        return alert;
    }
     
     public static Alert WarningQunatite(String carburant ) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Attention ");
        alert.setHeaderText(carburant);
        alert.setContentText("la quantite consommer dépasse le reservoire"); 
       
        return alert;
    }
     
      public static Alert WarningQunatite() {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Attention ");
        alert.setHeaderText("Attention");
        alert.setContentText("la quantite consommer dépasse le reservoire"); 
       
        return alert;
    }
    
     
      public static Alert errorAlert(String message ) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur ");
        alert.setHeaderText("Exception");
        alert.setContentText(message); 
       
        return alert;
    }
     
      
     
    
}

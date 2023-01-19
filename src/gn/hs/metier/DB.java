package gn.hs.metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB {
 /*
    Enregistrer la classe de pilote
    Créer une connexion
    Créer un objet Statement
    Exécuter des requêtes
    Fermer la connexion
  */
 public static void main(String[] args) {
        try {

         //Etape1:Charger la classe driver
         Class.forName("com.mysql.jdbc.Driver") ;

         //Etape2: creer l'objet de connextion
         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root" , "") ;

         //Etape3: crer l'objet statement
         Statement statement = connection.createStatement() ;
         ResultSet resultSet = statement.executeQuery("SELECT * FROM person") ;

         //Etape4: Executer la requete
         while (resultSet.next()){
             System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));

             //Etape 5:fermeture de la connextion
             connection.close();
         }
        }catch (Exception exception){
         exception.printStackTrace();
     }
 }
}

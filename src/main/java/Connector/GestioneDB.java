package Connector;

import org.Esercizio1.Student;

import java.sql.SQLException;
import java.time.LocalDate;

public class GestioneDB {
    public static void main(String[] args) {
        try {
            DBConnection db = new DBConnection();
            Student S1 = new Student("Mario", "Rossi", "M", LocalDate.of(1998,10,12),3.50, 8.55 );
            Student S2 = new Student("Maria", "Rossa", "F", LocalDate.of(1967,12,21),5.50, 9.50 );
            Student S3 = new Student("Piero", "Verde", "M", LocalDate.of(1988,2,25),6.50, 10.00 );
            Student S4 = new Student("Anna", "Giallo", "F", LocalDate.of(1958,5,2),5.50, 9.0 );
            Student S5 = new Student("Rosa", "Bianchi", "F", LocalDate.of(1951,1,15),2.50, 6.50 );
            Student S6 = new Student("Pietro", "Blu", "M", LocalDate.of(1928,11,23),2.50, 4.50 );
            Student S7 = new Student("Peppe", "Giallo", "M", LocalDate.of(1986,10,19),6.00, 9.50 );
            Student S8 = new Student("Lidia", "Nero", "F", LocalDate.of(1931,10,20),5.50, 8.00 );
            // db.createStudent(S8);
            Student StudenteLetto = db.findStudent(9);
            /// db.deleteStudent(StudenteLetto);
            StudenteLetto.setName("Rosa");
            db.updateStudent(9, StudenteLetto);
            db.getBest();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

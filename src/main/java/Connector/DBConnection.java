package Connector;
import org.Esercizio1.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private String url = "jdbc:postgresql://localhost:5432/";
    private String dbName = "school_students";
    private String userName = "postgres";
    private String password = "root";
    Statement st;

    public DBConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url + dbName, userName, password);
        st = conn.createStatement();
        creaTabStudents();
    }

    public void creaTabStudents() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Students ("
                + "id_student SERIAL PRIMARY KEY,"
                + "name VARCHAR NOT NULL,"
                + "lastname VARCHAR NOT NULL,"
                + "gender VARCHAR NOT NULL,"
                + "birthday DATE NOT NULL,"
                + "avg DECIMAL DEFAULT null ,"
                + "min_vote DECIMAL NOT NULL,"
                + "max_vote DECIMAL NOT NULL)";
        this.st.executeUpdate(sql);
    }

    public void createStudent(Student s) throws SQLException {
        String sql = "INSERT INTO Students (name, lastname, gender, birthday, avg, min_vote, max_vote) "
                + "VALUES ('" + s.getName() + "', '" + s.getLastname() + "', '" + s.getGender() + "', '" + s.getBirthday() + "', " + s.setAvg(s.getMin_vote(), s.getMax_vote()) + ", " + s.getMin_vote() + ", " + s.getMax_vote() + ")";
        this.st.executeUpdate(sql);
        System.out.println("Studente creato");
    }

    public void updateStudent(int id, Student s) throws SQLException {
        String sql = "UPDATE students "
                + "SET name='" + s.getName() + "',"
                + "lastname='" + s.getLastname() + "', "
                + "gender='" + s.getGender() + "', "
                + "birthday='" + s.getBirthday() + "', "
                + "avg=" + s.getAvg() + ", "
                + "min_vote= " + s.getMin_vote() + ", "
                + "max_vote=" + s.getMax_vote() + " "
                + "WHERE id_student = " + id;
        this.st.executeUpdate(sql);
    }

    public void deleteStudent(Student s) throws SQLException {
        String sql = "DELETE FROM students WHERE id_student = " + s.getId();
        this.st.executeUpdate(sql);
        System.out.println("Studente cancellato");
    }

    public Student findStudent(Integer ids) throws SQLException {
        List<Student> listaStudenti = new ArrayList<>();
        Student studente = null;
        String sql = "SELECT * FROM students WHERE id_student =" + ids;
        ResultSet myRes = this.st.executeQuery(sql);
        if (myRes.next()) {
            Long id = myRes.getLong("id_student");
            String name = myRes.getString("name");
            String lastname = myRes.getString("lastname");
            String gender = myRes.getString("gender");
            LocalDate birthday = myRes.getDate("birthday").toLocalDate();
            Double avg = myRes.getDouble("avg");
            Double minVote = myRes.getDouble("min_vote");
            Double maxVote = myRes.getDouble("max_vote");
            studente = new Student(id, name, lastname, gender, birthday, avg, minVote, maxVote);
            listaStudenti.add((Student) myRes);
            System.out.println(studente);
        }
        return studente;
    }
    public void getBest() throws SQLException {
        String sql = "SELECT * FROM students WHERE avg = (SELECT max(avg) FROM students)";
        Student studente = null;
        ResultSet myRes = this.st.executeQuery(sql);
        if (myRes.next()) {
            Long id = myRes.getLong("id_student");
            String name = myRes.getString("name");
            String lastname = myRes.getString("lastname");
            String gender = myRes.getString("gender");
            LocalDate birthday = myRes.getDate("birthday").toLocalDate();
            Double avg = myRes.getDouble("avg");
            Double minVote = myRes.getDouble("min_vote");
            Double maxVote = myRes.getDouble("max_vote");
            studente = new Student(id, name, lastname, gender, birthday, avg, minVote, maxVote);
            System.out.println(studente);
        };
    }

}


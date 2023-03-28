package org.Esercizio1;

import java.time.LocalDate;

public class Student {
    private Long id;
    private String name;
    private String lastname;
    private String gender;
    private LocalDate birthday;
    private Double avg;
    private Double min_vote;
    private Double max_vote;

    public Student(String name, String lastname, String gender, LocalDate birthday, Double min_vote, Double max_vote) {
        super();
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.birthday = birthday;
        this.avg = setAvg(max_vote, max_vote);
        this.min_vote = min_vote;
        this.max_vote = max_vote;
    }

    public Student(Long id, String name, String lastname, String gender, LocalDate birthday, Double avg, Double min_vote, Double max_vote) {
        super();
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.birthday = birthday;
        this.avg = avg;
        this.min_vote = min_vote;
        this.max_vote = max_vote;
    }
    public Student(Double avg) {
        this.avg = avg;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Double getAvg() {
        return avg;
    }

    public double setAvg(double n1, double n2) {
        double result = (n1 + n2)/2;
        return result;
    }

    public Double getMin_vote() {
        return min_vote;
    }

    public Double getMax_vote() {
        return max_vote;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", avg='" + avg + '\'' +
                ", min_vote=" + min_vote +
                ", max_vote=" + max_vote +
                '}';
    }

    public Student setName(String name) {
        this.name = name;
        return null;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setMin_vote(Double min_vote) {
        this.min_vote = min_vote;
    }

    public void setMax_vote(Double max_vote) {
        this.max_vote = max_vote;
    }
}

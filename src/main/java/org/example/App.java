package org.example;


import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Student student = new Student();
        student.setName("Kunal Gupta");
        student.setEmail("kunal@hibernate.test.com");
        Certificate certificate = new Certificate();
        certificate.setCourse("Java Hibernate Course");
        certificate.setDuration(6);
        student.setCertificate(certificate);
        session.save(student);
        transaction.commit();
        session.close();

        //Implementing OneToOne

        Session questionAnswerSession = HibernateUtil.getSessionFactory().openSession();
        Transaction questionAnswerTransaction = questionAnswerSession.beginTransaction();
        Question question1 = new Question();
        question1.setQuestion("What is Hibernate?");
        questionAnswerSession.save(question1);
        Answer answer1 = new Answer();
        answer1.setAnswer("Hibernate is an ORM Framework");
        question1.setAnswer(answer1);
        questionAnswerSession.save(answer1);

        Question question2 = new Question();
        question2.setQuestion("What is Java?");
        questionAnswerSession.save(question2);
        Answer answer2 = new Answer();
        answer2.setAnswer("Java is a programming language");
        question2.setAnswer(answer2);
        questionAnswerSession.save(answer2);
        questionAnswerTransaction.commit();
        questionAnswerSession.close();

        //Implementing OneToMany

        Session stateCitySession = HibernateUtil.getSessionFactory().openSession();
        Transaction stateCityTransaction = stateCitySession.beginTransaction();
        IndianState state1 = new IndianState();
        state1.setStateName("Maharashtra");
        City city1 = new City();
        city1.setCityName("Mumbai");
        City city2 = new City();
        city2.setCityName("Pune");
        List<City> cityListState1 = new ArrayList<>();
        cityListState1.add(city1);
        cityListState1.add(city2);
        state1.setCities(cityListState1);
        stateCitySession.save(state1);

        IndianState state2 = new IndianState();
        state2.setStateName("Bihar");
        City city3 = new City();
        city3.setCityName("Patna");
        City city4 = new City();
        city4.setCityName("Gaya");
        City city5 = new City();
        city5.setCityName("Bhagalpur");
        City city6 = new City();
        city6.setCityName("Muzaffarpur");
        List<City> cityListState2 = new ArrayList<>();
        cityListState2.add(city3);
        cityListState2.add(city4);
        cityListState2.add(city5);
        cityListState2.add(city6);
        state2.setCities(cityListState2);
        stateCitySession.save(state2);

        stateCityTransaction.commit();
        stateCitySession.close();
        HibernateUtil.getSessionFactory().close();
    }
}

package org.example;


import org.hibernate.Session;
import org.hibernate.Transaction;

public class App
{
    public static void main( String[] args )
    {
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

        //Another Session

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


    }
}

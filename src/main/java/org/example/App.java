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

    }
}

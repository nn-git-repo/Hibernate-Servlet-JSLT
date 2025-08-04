package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.entity.Citizen;
import com.example.entity.Passport;
import com.example.util.HibernateUtil;

public class MainApp {
	public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Passport passport = new Passport();
        passport.setPassportNumber("IND987654");

        Citizen citizen = new Citizen();
        citizen.setName("Alice");
        citizen.setPassport(passport);

        session.persist(citizen);  // Save both because of cascade

        tx.commit();

        // Fetch and display
        Citizen fetchedCitizen = session.get(Citizen.class, citizen.getId());
        System.out.println("Citizen: " + fetchedCitizen.getName());
        System.out.println("Passport: " + fetchedCitizen.getPassport().getPassportNumber());

        session.close();
    }
}

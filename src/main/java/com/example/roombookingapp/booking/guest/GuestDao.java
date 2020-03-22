package com.example.roombookingapp.booking.guest;

//        import com.example.roombookingapp.booking.common.HibernateConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestDao {
        @Autowired
        public GuestRepository repository;

        public void createGuest(Guest guest) {
                repository.save(guest);
        }

        public List<Guest> getGuests() {
                return repository.findAll();
        }

        public void updateGuest(Guest guest) {
                repository.save(guest);
        }

        public void delete(Guest guest){ repository.delete(guest);}

//    public void saveGuest(Guest guest){
//        Transaction transaction = null;
//        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            session.save(guest);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//}

}


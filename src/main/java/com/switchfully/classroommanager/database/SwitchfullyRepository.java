package com.switchfully.classroommanager.database;

import com.switchfully.classroommanager.domain.AmazingPeople;
import com.switchfully.classroommanager.domain.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SwitchfullyRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public SwitchfullyRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

//    public void updateAmazingPerson(int id) {
//        entityManager.find(AmazingPeople.class, 11)
//                .setName("Gunther The Best secretmaster ever");
//    }

    public AmazingPeople getBestSecretMaster() {
        return entityManager.find(AmazingPeople.class, 11);
    }

    public List<Employer> getAllAmazingEmployers() {
        return entityManager.createQuery("SELECT e from Employer e", Employer.class)
                .getResultList();
    }

    public List<AmazingPeople> getAllAmazingPeople() {
        return entityManager.createQuery("SELECT p from AmazingPeople p", AmazingPeople.class)
                .getResultList();
    }

    public List<AmazingPeople> printAllAmazingPeopleWithEmail() {
//            return jdbcTemplate.query("select * from switchfullymanager.amazing_people" +
//                        " inner join switchfullymanager.email e on amazing_people.id = e.owner_id;",
//                (resultSet) -> {
//                    Map<Integer, AmazingPeople> mapOfAmazingPeopleByTheirID = new HashMap<Integer, AmazingPeople>();
//                    while (resultSet.next()) {
//                        int id = resultSet.getInt("id");
//                        String name = resultSet.getString("name");
//                        String email = resultSet.getString("email");
//                        AmazingPeople person = mapOfAmazingPeopleByTheirID.get(id);
//                        if (person == null) {
//                            person = new AmazingPeople(id, name);
//                            mapOfAmazingPeopleByTheirID.put(id, person);
//                        }
//                        //person.addEmail(email);
//                    }
//                    List<AmazingPeople> persons = List.copyOf(mapOfAmazingPeopleByTheirID.values());
//                    return persons;
//                });
        return null;
    }


}
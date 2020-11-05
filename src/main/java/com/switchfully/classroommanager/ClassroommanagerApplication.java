package com.switchfully.classroommanager;

import com.switchfully.classroommanager.database.SwitchfullyRepository;
import com.switchfully.classroommanager.database.SetupDatabase;
import com.switchfully.classroommanager.domain.AmazingPeople;
import com.switchfully.classroommanager.domain.Employer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ClassroommanagerApplication implements CommandLineRunner {

    private final SwitchfullyRepository repository;
    private final SetupDatabase setup;

    public ClassroommanagerApplication(SwitchfullyRepository repository, SetupDatabase setup) {
        this.repository = repository;
        this.setup = setup;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClassroommanagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //setup.setupDB();

        //System.out.println(getBestSecretMaster());
        //getAllAmazingEmployers().forEach(System.out::println);
        getAllAmazingPeople().forEach(System.out::println);
        //printAllAmazingPeopleWithEmail().forEach(System.out::println);
    }

    private List<AmazingPeople> printAllAmazingPeopleWithEmail() {
        return repository.printAllAmazingPeopleWithEmail();
    }

    private AmazingPeople getBestSecretMaster() {
        return repository.getBestSecretMaster();
    }

    private List<Employer> getAllAmazingEmployers() {
        // https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/jdbc/core/BeanPropertyRowMapper.html
        return repository.getAllAmazingEmployers();
    }

    private List<AmazingPeople> getAllAmazingPeople() {
        return repository.getAllAmazingPeople();
    }

}

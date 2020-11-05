package com.switchfully.classroommanager.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

@Component
public class SetupDatabase {
    private final JdbcTemplate jdbcTemplate;
    private final DataSource dataSource;

    @Autowired
    public SetupDatabase(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;
    }

    public void setupDB() {
        createSchema();
        createTables();
        loadData();
    }

    public void createSchema() {

        jdbcTemplate.execute("DROP SCHEMA IF EXISTS SWITCHFULLYMANAGER CASCADE ");
        jdbcTemplate.execute("CREATE SCHEMA SWITCHFULLYMANAGER;");
        //https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html
    }

    public void createTables() {
        jdbcTemplate.execute("SET SCHEMA 'switchfullymanager';" +
                "create table employers\n" +
                "(\n" +
                "\tid serial not null\n" +
                "\t\tconstraint employers_pk\n" +
                "\t\t\tprimary key,\n" +
                "\tname text not null,\n" +
                "\taddress text\n" +
                ");\n" +
                "\n" +
                "\n" +
                "create unique index employers_name_uindex\n" +
                "\ton employers (name);\n" +
                "\n" +
                "create table amazing_people\n" +
                "(\n" +
                "\tid serial not null\n" +
                "\t\tconstraint amazing_people_pk\n" +
                "\t\t\tprimary key,\n" +
                "\tname text not null,\n" +
                "\temployer_id integer\n" +
                "\t\tconstraint amazing_people_employers_id_fk\n" +
                "\t\t\treferences employers\n" +
                ");\n" +
                "\n" +
                "\n" +
                "create table email\n" +
                "(\n" +
                "\towner_id integer not null\n" +
                "\t\tconstraint email_amazing_people_id_fk\n" +
                "\t\t\treferences amazing_people,\n" +
                "\temail text not null,\n" +
                "\tconstraint email_pk\n" +
                "\t\tprimary key (owner_id, email)\n" +
                ");\n" +
                "\n" +
                "\n" +
                "create unique index email_email_uindex\n" +
                "\ton email (email);\n" +
                "\n" +
                "create table secrets\n" +
                "(\n" +
                "\tid serial not null\n" +
                "\t\tconstraint secrets_pk\n" +
                "\t\t\tprimary key,\n" +
                "\towner_id integer\n" +
                "\t\tconstraint secrets_amazing_people_id_fk\n" +
                "\t\t\treferences amazing_people,\n" +
                "\tsecret text\n" +
                ");\n" +
                "\n" +
                "\n" +
                "create table guess\n" +
                "(\n" +
                "\tguesser integer not null\n" +
                "\t\tconstraint guess_amazing_people_id_fk\n" +
                "\t\t\treferences amazing_people,\n" +
                "\tguess integer not null\n" +
                "\t\tconstraint guess_amazing_people_id_fk_2\n" +
                "\t\t\treferences amazing_people,\n" +
                "\tsecret integer\n" +
                "\t\tconstraint guess_secrets_id_fk\n" +
                "\t\t\treferences secrets\n" +
                ");\n" +
                "\n" +
                "\n");

    }

    public void loadData() {
        try {
            ScriptUtils.executeSqlScript(
                    dataSource.getConnection(),
                    new ClassPathResource("data.sql"));
            // https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/jdbc/datasource/init/ScriptUtils.html
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // THIS IS NOT THE BEST WAY TO DO THIS!!
    }
}
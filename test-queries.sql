select * from switchfullymanager.amazing_people;

select * from switchfullymanager.amazing_people where id = 11;

select * from switchfullymanager.amazing_people
    left join switchfullymanager.employers
        on amazing_people.employer_id = employers.id;

select p.id as id,
       p.name as name,
       c.id as employer_id,
       c.name as employer_name
from switchfullymanager.amazing_people as p
left join switchfullymanager.employers as c
    on p.employer_id = c.id;

INSERT INTO switchfullymanager.email (owner_id, email) VALUES (7, 'karel@switchfully.com');
INSERT INTO switchfullymanager.email (owner_id, email) VALUES (7, 'karel@cegeka.com');
INSERT INTO switchfullymanager.email (owner_id, email) VALUES (7, 'karel@prive.com');
INSERT INTO switchfullymanager.email (owner_id, email) VALUES (11, 'secretmaster@switchfull.com');

select * from switchfullymanager.amazing_people
inner join switchfullymanager.email e on amazing_people.id = e.owner_id;
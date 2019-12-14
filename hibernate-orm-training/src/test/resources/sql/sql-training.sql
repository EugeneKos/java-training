select * from orm.automobile;
select * from orm.person;

insert into orm.person values (1, 'my_login', 'eugene', 'kosinov');
insert into orm.automobile values (2, 'audi', 'A8', '222ee');
insert into orm.automobile values (3, 'bmw', 'e38', 'fffe');
insert into orm.automobile (id, mark, model, state_number) values (4, 'mercedes', 'amg', '3332');

select mark, model from orm.automobile;
select mark, model from orm.automobile order by model asc;

select * from orm.automobile where mark = 'audi' and state_number like '%222%';

select count(mark) from orm.automobile;

select automobile.mark, automobile.model, person.login, person.name from orm.automobile right join orm.person
on automobile.person_id = person.id where person.login = '333';
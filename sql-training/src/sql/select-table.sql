select person.name, person.code from "sql-training".person;

select * from "sql-training".automobile;

select automobile.mark, automobile.model from "sql-training".automobile
  where person_id is null;

-- left join and like --
select person.name, automobile.mark, automobile.model from "sql-training".person
  left join "sql-training".automobile on automobile.person_id = person.id where person.name like 'a%';

-- between --
select person.name, person.code from "sql-training".person where person.code between '123-447' and '123-449';

-- min / max --
select max (automobile.power) as power from "sql-training".automobile
  where automobile.model between 'model_3' and 'model_6';
select min (automobile.power) as power from "sql-training".automobile
  where automobile.model between 'model_3' and 'model_6';


-- count показывает количество --
select count (automobile.model) from "sql-training".automobile
  where automobile.model like '%3' or automobile.model like '%5';

-- avg показывает среднее значение --
select avg (automobile.power) as avg_power from "sql-training".automobile;

-- sum показывает сумму --
select sum (automobile.power) as sum_power from "sql-training".automobile;

-- order by сортировка по возрастанию/убыванию
select person.name, person.code from "sql-training".person order by person.name desc, person.code asc;

-- group by группирование по колонкам с одинаковыми значениями
select count(mark), color from "sql-training".automobile where color like '%e%' group by color;
select max(power), color from "sql-training".automobile group by color order by color desc;

-- having используется для условий агрегирующих функций
select count(mark), color from "sql-training".automobile where color like '%e%' group by color having count(mark) > 1;
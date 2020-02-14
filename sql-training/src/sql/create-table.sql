create table "sql-training".person(
  id bigint not null primary key,
  name varchar(255),
  surname varchar(255),
  code varchar(255),
  constraint identify_person unique (name, surname, code)
);

create table "sql-training".automobile(
  id bigint not null primary key,
  mark varchar(255),
  model varchar(255),
  state_number varchar(255) constraint state_number_uq unique,
  person_id integer constraint automobile_person_fk
  references "sql-training".person
);
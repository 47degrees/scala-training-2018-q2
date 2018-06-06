create table users (
  id serial primary key,
  name varchar (150) not null
);

create table tasks (
  id serial primary key,
  user_id integer not null references users(id),
  title varchar (150) not null,
  done boolean default false
);
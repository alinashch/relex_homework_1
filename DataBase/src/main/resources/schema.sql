create table if not exists UsersAndMessages (
  id identity,
  name varchar(750) not null,
  message varchar(750) not null,

  convertMessage varchar(750) not null
  );

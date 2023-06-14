create table studentinfo02
(
    StudentID bigint       not null
        primary key,
    Name      varchar(255) not null,
    Sex       varchar(255) not null,
    CardNum   varchar(255) not null,
    PhoneNum  varchar(255) not null,
    Location  varchar(255) not null
);


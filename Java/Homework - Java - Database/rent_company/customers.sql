create table rent_company.customers
(
    customers_id int auto_increment
        primary key,
    firs_name    varchar(15) not null,
    last_name    varchar(15) not null,
    passport_id  int         not null
);



create table rent_company.insurances
(
    insurance_id    int auto_increment
        primary key,
    insurance_type  varchar(50) not null,
    expire_date     date        not null,
    insurance_price int         not null
);



create table rent_company.categories
(
    category_id   int auto_increment
        primary key,
    category_name varchar(40) not null,
    constraint category_name
        unique (category_name)
);



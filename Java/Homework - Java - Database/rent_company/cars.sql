create table rent_company.cars
(
    brand           varchar(40) not null,
    cars_id         int auto_increment
        primary key,
    model_name      varchar(45) not null,
    production_year int         not null,
    mileage         int         not null,
    color           varchar(45) not null,
    category_id     int         not null,
    constraint cars_categories_fk
        foreign key (category_id) references rent_company.categories (category_id)
);



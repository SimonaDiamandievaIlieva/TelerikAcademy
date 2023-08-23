create table rent_company.additions
(
    addition_id int auto_increment
        primary key,
    addition    varchar(50) not null
);

create table rent_company.categories
(
    category_id   int auto_increment
        primary key,
    category_name varchar(40) not null,
    constraint category_name
        unique (category_name)
);

create table rent_company.cars
(
    brand           varchar(40) not null,
    cars_id         int auto_increment
        primary key,
    model_name      varchar(45) not null,
    production_year int         not null,
    mileage         int         not null,
    color           varchar(45) not null,
    category_id     int         null,
    constraint cars_categories_fk
        foreign key (category_id) references rent_company.categories (category_id)
);

create table rent_company.customers
(
    customers_id int auto_increment
        primary key,
    firs_name    varchar(15) not null,
    last_name    varchar(15) not null,
    passport_id  int         not null
);

create table rent_company.insurances
(
    insurance_id    int auto_increment
        primary key,
    insurance_type  varchar(50) not null,
    expire_date     date        not null,
    insurance_price int         not null
);

create table rent_company.locations
(
    location_id int auto_increment
        primary key,
    country     varchar(35) not null,
    city        varchar(35) not null
);

create table rent_company.places
(
    place_id    int auto_increment
        primary key,
    location_id int         null,
    place       varchar(45) not null,
    constraint places_locations_fk
        foreign key (location_id) references rent_company.locations (location_id)
);

create table rent_company.drop_off_locations
(
    drop_off_locations int auto_increment
        primary key,
    place_id           int null,
    constraint drop_off_locations_places_fk
        foreign key (place_id) references rent_company.places (place_id)
);

create table rent_company.pick_up_locations
(
    pick_up_location_id int auto_increment
        primary key,
    place_id            int null,
    constraint pick_up_locations_places_fk
        foreign key (place_id) references rent_company.places (place_id)
);

create table rent_company.reservations
(
    reservation_id       int auto_increment
        primary key,
    customer_id          int  null,
    start_date           date not null,
    end_date             date not null,
    insurance_id         int  null,
    addition_id          int  null,
    pick_up_location_id  int  null,
    drop_off_location_id int  null,
    car_id               int  null,
    constraint reservations_additions_fk
        foreign key (addition_id) references rent_company.additions (addition_id),
    constraint reservations_cars_fk
        foreign key (car_id) references rent_company.cars (cars_id),
    constraint reservations_customers_fk
        foreign key (customer_id) references rent_company.customers (customers_id),
    constraint reservations_drop_off_locations_fk
        foreign key (drop_off_location_id) references rent_company.drop_off_locations (drop_off_locations),
    constraint reservations_insurance_fk
        foreign key (insurance_id) references rent_company.insurances (insurance_id),
    constraint reservations_pick_up_locations_fk
        foreign key (pick_up_location_id) references rent_company.pick_up_locations (pick_up_location_id)
);



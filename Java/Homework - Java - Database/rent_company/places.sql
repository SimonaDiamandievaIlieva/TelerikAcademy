create table rent_company.places
(
    place_id    int auto_increment
        primary key,
    location_id int         not null,
    place       varchar(45) not null,
    constraint places_locations_fk
        foreign key (location_id) references rent_company.locations (location_id)
);



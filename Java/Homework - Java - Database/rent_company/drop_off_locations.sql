create table rent_company.drop_off_locations
(
    drop_off_locations int auto_increment
        primary key,
    place_id           int not null,
    constraint drop_off_locations_places_fk
        foreign key (place_id) references rent_company.places (place_id)
);



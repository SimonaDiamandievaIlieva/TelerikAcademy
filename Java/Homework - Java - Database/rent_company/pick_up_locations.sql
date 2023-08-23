create table rent_company.pick_up_locations
(
    pick_up_location_id int auto_increment
        primary key,
    place_id            int not null,
    constraint pick_up_locations_places_fk
        foreign key (place_id) references rent_company.places (place_id)
);



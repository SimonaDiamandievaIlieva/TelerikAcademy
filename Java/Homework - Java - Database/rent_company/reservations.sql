create table rent_company.reservations
(
    reservation_id       int auto_increment
        primary key,
    customer_id          int  not null,
    start_date           date not null,
    end_date             date not null,
    insurance_id         int  null,
    addition_id          int  null,
    pick_up_location_id  int  not null,
    drop_off_location_id int  not null,
    car_id               int  not null,
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



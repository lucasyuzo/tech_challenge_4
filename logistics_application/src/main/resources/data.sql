INSERT INTO truck
    (id, license_plate, status)
VALUES
    ('d5280be0-ece7-403a-8ab8-98ce61423563', 'FSM-2246', 'AVAILABLE'),
    ('4870e92b-a28b-4555-bff7-449504cebbd3', 'BGH-0688', 'UNAVAILABLE'),
    ('947ec0ba-bc2d-45f2-b305-b4863d02d4f8', 'CGM-7806', 'AVAILABLE'),
    ('52f50865-97e1-4ee5-b0a6-d8b2d6b6e7df', 'ETB-5260', 'UNAVAILABLE');

INSERT INTO delivery_person
    (id, first_name, last_name, status)
VALUES
    ('bbde3e8c-570f-490b-8653-7ecda6ec975a', 'Emiliano', 'Pereira', 'UNAVAILABLE'),
    ('174b0eda-d3cf-49c6-aba4-8b79c6094704', 'Carlos', 'Eduardo', 'AVAILABLE'),
    ('7f386884-ed30-4870-9a82-9230e55f8794', 'Pedro', 'Sampaio', 'AVAILABLE'),
    ('6121c65d-d360-4b4c-b14d-404757dc0c49', 'Lucas', 'Hermano', 'UNAVAILABLE');

INSERT INTO delivery
    (id, delivery_person_id, truck_id, status)
VALUES
    ('e3b0c442-98fc-11e4-91aa-00f00f00f00f', 'bbde3e8c-570f-490b-8653-7ecda6ec975a', '4870e92b-a28b-4555-bff7-449504cebbd3', 'DELIVERED');

INSERT INTO delivery_orders_id
    (delivery_id, orders_id)
VALUES
    ('e3b0c442-98fc-11e4-91aa-00f00f00f00f', 'f47ac10b-58cc-4372-a567-0e02b2c3d480');

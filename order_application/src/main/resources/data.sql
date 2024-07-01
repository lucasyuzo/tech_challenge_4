INSERT INTO order_table
    (id, user_id, status)
VALUES
    ('f47ac10b-58cc-4372-a567-0e02b2c3d479', 'f849fbc4-cb79-4390-982f-ba049f3f103b', 'WAITING_PAYMENT'),
    ('f47ac10b-58cc-4372-a567-0e02b2c3d480', '52a85cff-cf9c-485d-b084-000506ab154b', 'IN_PREPARATION'),
    ('f47ac10b-58cc-4372-a567-0e02b2c3d481', 'e0faafea-ff4b-471f-bc6b-dec783d7df67', 'DELIVERING'),
    ('f47ac10b-58cc-4372-a567-0e02b2c3d482', '87393282-04d4-4264-bc2f-6cea5f786544', 'DELIVERED');

INSERT INTO item
    (id, product_id, quantity, order_id)
VALUES
    ('d94a5c98-6f6a-441d-a778-bbe88e3e55c1', 'c6d3682c-f540-4e79-82c9-3ffe0f6dfd96', 2, 'f47ac10b-58cc-4372-a567-0e02b2c3d479'),
    ('d94a5c98-6f6a-441d-a778-bbe88e3e55c2', '92d1ae57-9b19-46d9-909f-220c8ad31a71', 1, 'f47ac10b-58cc-4372-a567-0e02b2c3d479'),
    ('d94a5c98-6f6a-441d-a778-bbe88e3e55c3', 'a1d12593-beb9-4a11-b2c0-0c6330249810', 3, 'f47ac10b-58cc-4372-a567-0e02b2c3d480'),
    ('d94a5c98-6f6a-441d-a778-bbe88e3e55c4', 'c6cabb17-7a06-432c-9363-895a0207f10e', 4, 'f47ac10b-58cc-4372-a567-0e02b2c3d481'),
    ('d94a5c98-6f6a-441d-a778-bbe88e3e55c5', 'a464e892-15fd-4d89-aadc-66ea7fb94952', 1, 'f47ac10b-58cc-4372-a567-0e02b2c3d482');

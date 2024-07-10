INSERT INTO order_table
    (id, user_id, status)
VALUES
    ('f47ac10b-58cc-4372-a567-0e02b2c3d479', 'f849fbc4-cb79-4390-982f-ba049f3f103b', 'WAITING_PAYMENT'),
    ('f47ac10b-58cc-4372-a567-0e02b2c3d481', 'e0faafea-ff4b-471f-bc6b-dec783d7df67', 'DELIVERING'),
    ('f47ac10b-58cc-4372-a567-0e02b2c3d482', '87393282-04d4-4264-bc2f-6cea5f786544', 'DELIVERED'),

    ('f47ac10b-58cc-4372-a567-0e02b2c3d480', '52a85cff-cf9c-485d-b084-000506ab154b', 'IN_PREPARATION'),

    ('3efaaa5a-ecaa-4170-947c-cbed385e0b6d', '54d72446-3385-46d4-b948-83b597637961', 'IN_PREPARATION'),
    ('72ad5430-8b37-4d38-a099-7e382f1a931e', '293f6892-71b2-479b-a9e1-89af18667e5c', 'IN_PREPARATION'),
    ('94eb4efe-b47c-4fce-bff7-f6d8896f759f', '2b3f9d7f-ea45-466e-9edd-61998c748dc2', 'IN_PREPARATION'),
    ('5dd53416-6526-4e30-b6c9-149d9544b45e', '5f481c00-d9d9-4853-90b3-a2c5ca5cae4f', 'IN_PREPARATION');

INSERT INTO item
    (id, product_id, quantity, order_id)
VALUES
    ('d94a5c98-6f6a-441d-a778-bbe88e3e55c1', 'c6d3682c-f540-4e79-82c9-3ffe0f6dfd96', 2, 'f47ac10b-58cc-4372-a567-0e02b2c3d479'),
    ('d94a5c98-6f6a-441d-a778-bbe88e3e55c2', '92d1ae57-9b19-46d9-909f-220c8ad31a71', 1, 'f47ac10b-58cc-4372-a567-0e02b2c3d479'),
    ('d94a5c98-6f6a-441d-a778-bbe88e3e55c4', 'c6cabb17-7a06-432c-9363-895a0207f10e', 4, 'f47ac10b-58cc-4372-a567-0e02b2c3d481'),
    ('d94a5c98-6f6a-441d-a778-bbe88e3e55c5', 'a464e892-15fd-4d89-aadc-66ea7fb94952', 1, 'f47ac10b-58cc-4372-a567-0e02b2c3d482'),

    ('4c9e67ab-de61-4a0c-a059-8181f86c073c', 'c6d3682c-f540-4e79-82c9-3ffe0f6dfd96', 1, 'f47ac10b-58cc-4372-a567-0e02b2c3d480'),
    ('9d409115-7402-4a10-aadc-0eb8bfd0edf4', '92d1ae57-9b19-46d9-909f-220c8ad31a71', 1, 'f47ac10b-58cc-4372-a567-0e02b2c3d480'),
    ('52b618f3-4ceb-4922-9244-0772750f8667', 'a1d12593-beb9-4a11-b2c0-0c6330249810', 1, 'f47ac10b-58cc-4372-a567-0e02b2c3d480'),
    ('36fc5cfa-6f9c-4c1a-a548-f0f0ac8fb72d', 'c6cabb17-7a06-432c-9363-895a0207f10e', 1, 'f47ac10b-58cc-4372-a567-0e02b2c3d480'),
    ('c3bbe7e9-e5bc-494c-a5dd-8bf6e95dbb2a', 'a464e892-15fd-4d89-aadc-66ea7fb94952', 1, 'f47ac10b-58cc-4372-a567-0e02b2c3d480'),

    ('214b35a4-1233-44b6-bf08-f9907ca39ff6', 'c6d3682c-f540-4e79-82c9-3ffe0f6dfd96', 2, '3efaaa5a-ecaa-4170-947c-cbed385e0b6d'),
    ('257a3cef-89d8-49af-bba9-db213ddb2451', '92d1ae57-9b19-46d9-909f-220c8ad31a71', 2, '3efaaa5a-ecaa-4170-947c-cbed385e0b6d'),
    ('70cb2319-85b3-4a1a-9808-6cc321cd2ed9', 'a1d12593-beb9-4a11-b2c0-0c6330249810', 2, '3efaaa5a-ecaa-4170-947c-cbed385e0b6d'),
    ('fdbd6504-de8b-477a-b677-05d3ff045a65', 'c6cabb17-7a06-432c-9363-895a0207f10e', 2, '3efaaa5a-ecaa-4170-947c-cbed385e0b6d'),
    ('56a5a869-6fe4-45ee-97ee-cdfc6264af98', 'a464e892-15fd-4d89-aadc-66ea7fb94952', 2, '3efaaa5a-ecaa-4170-947c-cbed385e0b6d'),

    ('a68753dd-c5a8-471e-b96f-3be286ee63be', 'c6d3682c-f540-4e79-82c9-3ffe0f6dfd96', 3, '72ad5430-8b37-4d38-a099-7e382f1a931e'),
    ('6716afd8-d92b-41f7-9d93-0fb934e3fd69', '92d1ae57-9b19-46d9-909f-220c8ad31a71', 3, '72ad5430-8b37-4d38-a099-7e382f1a931e'),
    ('016a92e9-02d7-45a7-b722-f9ce37037f6b', 'a1d12593-beb9-4a11-b2c0-0c6330249810', 3, '72ad5430-8b37-4d38-a099-7e382f1a931e'),
    ('00add6bc-f165-4abe-a5cd-b1370b26442d', 'c6cabb17-7a06-432c-9363-895a0207f10e', 3, '72ad5430-8b37-4d38-a099-7e382f1a931e'),
    ('223980d6-9aea-45a4-8569-ee30f2ef2bb7', 'a464e892-15fd-4d89-aadc-66ea7fb94952', 3, '72ad5430-8b37-4d38-a099-7e382f1a931e'),

    ('1be5dc4f-79fc-46cb-badc-a7440e08773b', 'c6d3682c-f540-4e79-82c9-3ffe0f6dfd96', 4, '94eb4efe-b47c-4fce-bff7-f6d8896f759f'),
    ('15c0495c-cf0a-43fb-8579-cedd0a77ac26', '92d1ae57-9b19-46d9-909f-220c8ad31a71', 4, '94eb4efe-b47c-4fce-bff7-f6d8896f759f'),
    ('28eade2b-6304-45d8-b444-21cf85af3de6', 'a1d12593-beb9-4a11-b2c0-0c6330249810', 4, '94eb4efe-b47c-4fce-bff7-f6d8896f759f'),
    ('8ee17a70-ddc9-4e71-97a5-4904ae57a8e5', 'c6cabb17-7a06-432c-9363-895a0207f10e', 4, '94eb4efe-b47c-4fce-bff7-f6d8896f759f'),
    ('978a3ba8-c9dd-4664-bf20-36a639358bbc', 'a464e892-15fd-4d89-aadc-66ea7fb94952', 4, '94eb4efe-b47c-4fce-bff7-f6d8896f759f'),

    ('28589fa9-9e9b-440c-9484-4d6ef40bff67', 'c6d3682c-f540-4e79-82c9-3ffe0f6dfd96', 5, '5dd53416-6526-4e30-b6c9-149d9544b45e'),
    ('2fa99eef-df7d-4b2e-8600-ca91afa2c238', '92d1ae57-9b19-46d9-909f-220c8ad31a71', 5, '5dd53416-6526-4e30-b6c9-149d9544b45e'),
    ('9b4a5d5b-c2ad-47c3-b608-e0ce0ce1dba7', 'a1d12593-beb9-4a11-b2c0-0c6330249810', 5, '5dd53416-6526-4e30-b6c9-149d9544b45e'),
    ('f9d8d264-f0bf-4d94-819c-9918bd012384', 'c6cabb17-7a06-432c-9363-895a0207f10e', 5, '5dd53416-6526-4e30-b6c9-149d9544b45e'),
    ('40784a77-e2a2-429f-8b3e-064ade8be07d', 'a464e892-15fd-4d89-aadc-66ea7fb94952', 5, '5dd53416-6526-4e30-b6c9-149d9544b45e');



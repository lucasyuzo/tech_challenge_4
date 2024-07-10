INSERT INTO address
    (id, cep, street, complement, city, state)
VALUES
    ('b5f860bc-e0ca-4c4e-9758-ada1248ca929', '05712-030', 'Rua Doutor Jerônimo de Campos Freire', 'apto 2', 'São Paulo', 'SP'),
    ('b0953db9-aaec-471f-badb-73a3e3747c89', '02010-400', 'Rua Voluntários da Pátria', 'apto 3', 'São Paulo', 'SP'),
    ('0ae3fc0c-fd50-4a92-849d-6c2d042ac4e5', '05028-040', 'Rua Mário Cardoso', 'apto 3', 'São Paulo', 'SP'),
    ('0d4b05f7-506b-4fb5-9386-1eba94e33cd7', '02084-170', 'Rua Sebastião Arruda', 'apto 4', 'São Paulo', 'SP'),

    ('6816fa65-0ad9-4a61-8b44-bb23031266b0', '05315-170', 'Rua Andréa Palládio', 'apto 1', 'São Paulo', 'SP'),

    ('b83f6b45-f92c-42f9-be79-0e9916ad64ba', '05361-001', 'Rua Francesco Bartolozzi', 'apto 1A', 'São Paulo', 'SP'),
    ('f8eee288-761a-49b5-8470-15c3fcf58e87', '05362-020', 'Rua Doutor Paulo de Barros Marrey', 'apto 20', 'São Paulo', 'SP'),
    ('7429f45e-5ffb-4478-8d00-181601770e07', '05363-300', 'Rua Deputado João Sussumu Hirata', 'apto 33', 'São Paulo', 'SP'),
    ('114ef6e6-479c-4bd2-82b2-a92f91778ef2', '05364-014', 'Travessa dos Imigrantes', 'apto 47', 'São Paulo', 'SP');

INSERT INTO user_table
    (id, cpf, first_name, last_name, email, address_id)
VALUES
    ('87393282-04d4-4264-bc2f-6cea5f786544', '394.964.488-10', 'Sherlock', 'Holmes', 'sherlock_holmes@email.com', 'b5f860bc-e0ca-4c4e-9758-ada1248ca929'),
    ('f849fbc4-cb79-4390-982f-ba049f3f103b', '699.119.468-94', 'Rust', 'Cohle', 'rust_cohler@email.com', 'b0953db9-aaec-471f-badb-73a3e3747c89'),
    ('e0faafea-ff4b-471f-bc6b-dec783d7df67', '310.781.858-59', 'Walter', 'White', 'walter_white@email.com', '0ae3fc0c-fd50-4a92-849d-6c2d042ac4e5'),
    ('3b25179d-4055-45a3-b710-f5fa7d5e0669', '214.280.098-09', 'Obi-Wan', 'Kenobi', 'obi@email.com', '0d4b05f7-506b-4fb5-9386-1eba94e33cd7'),

    ('52a85cff-cf9c-485d-b084-000506ab154b', '198.679.210-20', 'Uncle', 'Bob', 'uncle_bob@email.com', '6816fa65-0ad9-4a61-8b44-bb23031266b0'),

    ('54d72446-3385-46d4-b948-83b597637961', '442.704.480-83', 'Angelina', 'Pereira', 'angelina_pereira@email.com', 'b83f6b45-f92c-42f9-be79-0e9916ad64ba'),
    ('293f6892-71b2-479b-a9e1-89af18667e5c', '311.385.890-98', 'Carlos', 'Eduardo', 'carlos_eduardo@email.com', 'f8eee288-761a-49b5-8470-15c3fcf58e87'),
    ('2b3f9d7f-ea45-466e-9edd-61998c748dc2', '862.166.300-75', 'Adriano', 'Araújo', 'adriano_araujo@email.com', '7429f45e-5ffb-4478-8d00-181601770e07'),
    ('5f481c00-d9d9-4853-90b3-a2c5ca5cae4f', '639.381.810-79', 'Vitoria', 'Bernardes', 'vitoria_bernardes@email.com', '114ef6e6-479c-4bd2-82b2-a92f91778ef2');



-- Delete all existing data from 'volunteer' and 'ben' tables
DELETE FROM volunteer;
DELETE FROM ben;

-- Inserting records into the 'ben' table
INSERT INTO ben (address, age, descriptions, email, firstName, lastName, phone, services)
VALUES
    ('Avenida da Liberdade, 150', 69, 'I need transport help for my appointment tomorrow. I can’t drive, and my family is unavailable.', 'conceicao55@sapo.pt', 'Maria', 'da Conceição', '910110101', 'Transport'),
    ('Praça Martim Moniz, 12', 70, 'I struggle with cooking. I’d like to learn simple and quick recipes.', 'jaquim@sapo.pt', 'Manuel', 'Joaquim', '935551337', 'Cooking'),
    ('Avenida Dom Carlos I, 45', 79, 'My kitchen faucet is leaking. I need help fixing it.', 'oamigoze@gmail.com', 'António', 'José', '964042001', 'Maintenance'),
    ('Avenida Luísa Todi, 60', 67, 'I need help shopping. I can’t carry heavy loads due to my condition.', 'margarida_56@hotmail.com', 'Ana', 'Margarida', '915551234', 'Shopping help'),
    ('Praça da República, 25', 83, 'I’m tired and need help with daily tasks like meals or companionship.', 'joao.deus@gmail.com', 'João', 'de Deus', '928050000', 'Caring'),
    ('Rua do Sol, 18', 74, 'I need help painting a moldy wall. I can’t do it alone.', 'jose.martins@gmail.com', 'José', 'Martins', '935476821', 'Maintenance'),
    ('Jardim da Liberdade, 10', 75, 'I need a ride to the doctor tomorrow. My family is busy.', 'helena_costa@sapo.pt', 'Helena', 'Costa', '917111222', 'Transport'),
    ('Rua Cans, 50', 68, 'I struggle with cooking simple, nutritious meals. I need assistance.', 'ricardo.santos@mail.com', 'Ricardo', 'Santos', '936789456', 'Cooking'),
    ('Rua Santa Teresa, 33', 80, 'My faucet is leaking. I need help fixing it.', 'sergio_ribeiro@gmail.com', 'Sérgio', 'Ribeiro', '963222789', 'Maintenance'),
    ('Avenida da Paz, 22', 72, 'I need help shopping. I can’t carry weight or walk far.', 'sofia.silva@hotmail.com', 'Sofia', 'Silva', '915234567', 'Shopping help'),
    ('Rua da Liberdade, 15', 84, 'I’m weak and need help with daily tasks like cooking or company.', 'maria.joana@gmail.com', 'Maria', 'Joana', '923456789', 'Caring');

-- Inserting records into the 'volunteer' table
INSERT INTO volunteer (address, age, descriptions, email, firstName, lastName, phone, services)
VALUES
    ('Rua das Três Castelos, 155', 29, 'I can drive you to appointments or help with small home repairs.', 'joaosilva@gmail.com', 'João', 'Ferreira', '915672834', 'Transport Maintenance'),
    ('Rua Conceição, 18', 32, 'I love helping with cooking or offering companionship.', 'santinha@hotmail.com', 'Mariana', 'Santos', '936480256', 'Cooking Caring'),
    ('Avenida Roma, 50', 40, 'I can help with shopping or preparing simple meals for you.', 'renata.martins@hotmail.com', 'Renata', 'Martins', '924731509', 'Shopping Help Caring'),
    ('Rua dos Operários, 65', 38, 'I enjoy organizing and helping with light cleaning or simple tasks.', 'miguel.oliveira@gmail.com', 'Miguel', 'Oliveira', '917254683', 'Maintenance Caring'),
    ('Avenida João Crisóstomo, 30', 33, 'I can assist with transportation to appointments or shops.', 'paula.gomes@iol.com', 'Paula', 'Gomes', '923148675', 'Transport Caring'),
    ('Rua do Sol, 95', 30, 'I can help with light cleaning, organizing, or gardening.', 'catcostas@gmail.com', 'Catarina', 'Costa', '920335189', 'Maintenance Caring'),
    ('Jardim da Liberdade, 60', 29, 'I can drive you to stores or appointments.', 'jorge.martins@live.com', 'Jorge', 'Martins', '919741263', 'Transport Caring'),
    ('Rua Cans, 120', 40, 'I love cooking and teaching simple, healthy recipes.', 'ana.alves@hotmail.com', 'Ana', 'Alves', '923876410', 'Cooking Shopping Help Caring'),
    ('Rua Santa Teresa, 105', 36, 'I can help with light repairs or home organization.', 'rui.santos@yahoo.com', 'Rui', 'Santos', '931592804', 'Maintenance Caring'),
    ('Avenida da Paz, 70', 31, 'I help with shopping, light cleaning, or offering company.', 'mariana.pereira@hotmail.com', 'Mariana', 'Pereira', '924351736', 'Shopping Help Maintenance Caring');

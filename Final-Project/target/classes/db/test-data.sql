-- Delete all existing data from 'volunteer' and 'ben' tables
DELETE FROM volunteer;
DELETE FROM ben;


-- Inserindo 5 registros na tabela 'ben'
INSERT INTO ben (address, age, descriptions, email, firstName, lastName, phone, services)
VALUES
    ('Rua das Flores, 123', 34, 'Especialista em marketing digital', 'ben.smith@email.com', 'Ben', 'Smith', '99999-1111', 'Consultoria em marketing'),
    ('Av. Paulista, 456', 28, 'Designer gráfico freelancer', 'lucas.morais@email.com', 'Lucas', 'Morais', '99999-2222', 'Design gráfico'),
    ('Rua José Bonifácio, 789', 45, 'Engenheiro de software', 'carla.souza@email.com', 'Carla', 'Souza', '99999-3333', 'Desenvolvimento de software'),
    ('Rua do Sol, 101', 50, 'Consultora de recursos humanos', 'fernanda.lima@email.com', 'Fernanda', 'Lima', '99999-4444', 'Consultoria de RH'),
    ('Rua dos Limoeiros, 202', 39, 'Arquiteta e urbanista', 'paula.almeida@email.com', 'Paula', 'Almeida', '99999-5555', 'Consultoria em arquitetura');
INSERT INTO volunteer (address, age, descriptions, email, firstName, lastName, phone, services)
VALUES
    ('Rua das Palmeiras, 321', 29, 'Professor de matemática', 'joao.silva@email.com', 'João', 'Silva', '99999-6666', 'Aulas particulares'),
    ('Rua das Acácias, 654', 32, 'Nutricionista clínica', 'mariana.santos@email.com', 'Mariana', 'Santos', '99999-7777', 'Consultoria nutricional'),
    ('Rua São Jorge, 888', 40, 'Psicóloga clínica', 'renata.martins@email.com', 'Renata', 'Martins', '99999-8888', 'Atendimento psicológico'),
    ('Av. Rio Branco, 123', 38, 'Coach de vida', 'diego.oliveira@email.com', 'Diego', 'Oliveira', '99999-9999', 'Coaching pessoal e profissional'),
    ('Rua do Mercado, 212', 33, 'Advogada trabalhista', 'beatriz.gomes@email.com', 'Beatriz', 'Gomes', '99999-0000', 'Consultoria jurídica');


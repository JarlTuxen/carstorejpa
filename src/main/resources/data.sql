INSERT INTO Brands (name)
VALUES
       ('Fiat'),
       ('Mercedes'),
       ('Toyota');
INSERT INTO Mods (name, brand_id)
VALUES
        ('Panda',1),
        ('200E', 2),
        ('Yaris',3),
        ('Punto', 1),
        ('Aygo',3);
INSERT INTO Notes (noter, mod_id)
VALUES
        ('Fin, lille familiebil', 1),
        ('Ekslusiv oplevelse', 2),
        ('Kan fås som elbil', 3),
        ('Bedst i farven rød', 4),
        ('God til to', 5);
UPDATE Mods SET note_id = 1 WHERE id = 1;
UPDATE Mods SET note_id = 2 WHERE id = 2;
UPDATE Mods SET note_id = 3 WHERE id = 3;
UPDATE Mods SET note_id = 4 WHERE id = 4;
UPDATE Mods SET note_id = 5 WHERE id = 5;

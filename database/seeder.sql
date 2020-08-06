use blog_db;

INSERT INTO users (email, password, username)
VALUES
        ('user@email.com', 'pizza', 'user'),
        ('testUser@email.com', 'pizza', 'testUser'),
        ('ghostBuster@email.com', 'pizza', 'ghostBuster');

INSERT INTO categories (name)
VALUES
        ('Extraterrestrial'),
        ('Pets'),
        ('Unexplained'),
        ('GhostBusting'),
        ('Creepy'),
        ('Just Kidding'),
        ('Coding'),
        ('HTML'),
        ('CSS'),
        ('JavaScript'),
        ('jQuery'),
        ('Java'),
        ('MySQL'),
        ('Spring'),
        ('IntelliJ');


INSERT INTO posts (title, body, user_id)
VALUES ('UFO', 'It abducted my lizard. Poor Clementine.', 1),
       ('Ghost','It walked through walls man.', 3),
       ('Clementine Returns!','Clementine showed back up and stares at me while I sleep now. Not cool.', 1),
       ('My Lizard Is Trying To Kill Me','If I stop posting please call the cops. It was 100% Clementine.', 1),
       ('I\'m totally fine', 'HAHA, wat a gret joke, I AM FINE and definetly a human not a lizzard. Clementine is my best friend', 1),
       ('Title1','Body1', 2),
       ('Title2','Body2', 2),
       ('Title3','Body3', 2),
       ('Title4','Body4', 2),
       ('Title5','Body5', 2);


INSERT INTO comments (body, post_id)
VALUES
        ('Comment1', 1),
        ('Comment2',1),
        ('Comment3',2),
        ('Comment4', 3),
        ('Comment5', 5);

INSERT INTO posts_categories (post_id, category_id)
VALUES
        (1,1),
        (1,2),
        (1,3),
        (2,3),
        (2,4),
        (3,2),
        (3,3),
        (3,5),
        (4,3),
        (4,5),
        (5,6),
        (6,7),
        (6,8),
        (7,7),
        (7,9),
        (8,7),
        (8,10),
        (9,7),
        (9,11),
        (10,7),
        (10,12);


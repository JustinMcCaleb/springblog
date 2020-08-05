use blog_db;

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

INSERT INTO users (email, password, username)
VALUES
        ('user@email.com', 'pizza', 'user'),
        ('testUser@email.com', 'pizza', 'testUser'),
        ('ghostBuster@email.com', 'pizza', 'ghostBuster');
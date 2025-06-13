
    INSERT INTO albums (title, artist, release_date) VALUES
        ('交通費', '24000', '2021-08-20'),
        ('唐揚げ', '5000', '2020-11-10'),
        ('日用品', '10000', '2024-01-18');
    INSERT INTO musics (title, duration, album_id) VALUES
        ('Sunset', '00:03:45', 1),
        ('Moonlight', '00:04:12', 1),
        ('Eternal Memories', '00:05:45', 2);
        
    INSERT INTO users (username,password) VALUES ('sample','$2a$08$hBocxV325GV9RKzHR.lHreJr8DsMrkg6vg0kRTbNnBvUFknu670GC');

    INSERT INTO favorites (user_id, music_id) values(1, 1);
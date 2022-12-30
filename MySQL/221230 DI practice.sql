-- 221230 DI practice

use example01;

CREATE TABLE users (
	id			VARCHAR(12)	PRIMARY KEY,
    name	VARCHAR(10)	NOT NULL,
    password	VARCHAR(20)	NOT NULL
);

-- SELECT * FROM users WHERE name = ?
delete from users;
SELECT * FROM example01.users;

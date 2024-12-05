CREATE TABLE IF NOT EXISTS Run (
   id INT NOT NULL,
   title varchar(250) NOT NULL,
   started_on timestamp NOT NULL,
   completed_on timestamp NOT NULL,
   miles INT NOT NULL,
   location varchar(10) NOT NULL,
   version INT,
   PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS restaurant (
    id INT NOT NULL,
    name varchar(250) NOT NULL,
    address varchar(250) NOT NULL,
    type varchar(50) NOT NULL,
    version INT,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS food_item(
    id INT NOT NUll,
    name varchar(250) NOT NULL,
    price float,
    calories int,
    version int,
    primary key (id)
);

create table if not exists restaurant_food_item(
    id SERIAL primary key,
    restaurant_id int not null,
    food_item_id int not null,
    version int,
    foreign key (restaurant_id) references restaurant(id),
    foreign key (food_item_id) references food_item(id)
);

CREATE DATABASE demo_db;

CREATE TABLE IF NOT EXISTS fruits
( id INTEGER NOT NULL AUTO_INCREMENT,
  img VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  article VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
  price DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS orders
( id INTEGER NOT NULL AUTO_INCREMENT,
  order_code VARCHAR(255) NOT NULL,
  buyer_name VARCHAR(255) NOT NULL,
  buyer_phone VARCHAR(255) NOT NULL,
  buyer_email VARCHAR(255) NOT NULL,
  content VARCHAR(255) NOT NULL,
  status VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);


INSERT INTO
 fruits (img, name, article, description, price)
VALUES
 ('hurma.jpg', 'Fruit hurma', 'CBD4114', 'Lorem ipsum hurma', 9.95),
 ('injir.jpg', 'Fruit injir', 'CBG4123', 'Lorem ipsum injir', 7.99),
 ('kivi.jpg', 'Fruit kivi', 'COG4103', 'Lorem ipsum kivi', 6.99),
 ('lichi.jpg', 'Fruit lichi', 'COS4199', 'Lorem ipsum lichi', 12.99),
 ('mango.jpg', 'Fruit mango', 'COW4111', 'Lorem ipsum mango', 6.99);

-- Вставка нового фрукта
INSERT INTO fruits (img, name, article, description, price)
VALUES ('apple.jpg', 'Apple', 'A001', 'A juicy red apple', 1.99);

-- Вставка нового заказа
INSERT INTO orders (order_code, buyer_name, buyer_phone, buyer_email, content, status)
VALUES ('ORD123', 'John Doe', '123-456-7890', 'john@example.com', 'Apple, Banana', 'Pending');

-- Выбрать все фрукты
SELECT * FROM fruits;

-- Выбрать заказы с определенным статусом (например, "Shipped")
SELECT * FROM orders WHERE status = 'Shipped';

-- Выбрать фрукты, цена которых меньше 2 евро
SELECT * FROM fruits WHERE price < 2.0;

-- Обновить описание фрукта по его ID
UPDATE fruits
SET description = 'A delicious red apple'
WHERE id = 1;

-- Изменить статус заказа по его коду
UPDATE orders
SET status = 'Delivered'
WHERE order_code = 'ORD123';

-- Удалить фрукт по его ID
DELETE FROM fruits
WHERE id = 1;

-- Удалить заказ по его коду
DELETE FROM orders
WHERE order_code = 'ORD123';

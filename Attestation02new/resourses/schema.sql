--create database shop;
     --with owner postgres;
--comment on database shop 'База данных промежуточной аттестации02'
--\connect shop

-- создание таблицы Товар
create table if not exists tovar
(
    id serial primary key, --идентификатор строки
    -- определяем столбцы
    описание varchar(20),
    стоимость float,
    количество integer

);

comment on table tovar is 'Таблица с информацией о товаре.';
comment on column tovar.id is 'Идентификатор товара';
comment on column tovar.описание is 'Описание товара';
comment on column tovar.стоимость is 'Стоимость товара';
comment on column tovar.количество is 'Количество товара';

-- создание таблицы Покупатель
create table if not exists pokupatel
(
    id serial primary key, --идентификатор строки
    -- определяем столбцы
    имя_фамилия varchar(40)

);

comment on table pokupatel is 'Таблица с информацией о покупателе.';
comment on column pokupatel.id is 'Идентификатор покупателя';
comment on column pokupatel.имя_фамилия is 'Имя и фамилия покупателя';


-- создание таблицы Заказ
create table if not exists zakaz
(
    id serial primary key, --идентификатор строки
    id_товара integer references tovar(id),
    id_заказчика integer references pokupatel(id),
    дата_заказа date,
    количество_товаров integer

);

comment on table zakaz is 'Таблица с информацией о заказе.';
comment on column zakaz.id is 'Идентификатор заказа';
comment on column zakaz.id_товара is 'Идентификатор товара';
comment on column zakaz.id_заказчика is 'Идентификатор покупателя';
comment on column zakaz.дата_заказа is 'Дата заказа';
comment on column zakaz.количество_товаров is 'Количество заказанных товаров';



--заполнение таблицы "Товар"
insert into tovar(описание, стоимость, количество)
VALUES('Стол', 5000, 10),
      ('Стул', 4000, 30),
      ('Комод', 3000, 5),
      ('Шкаф', 23000, 14),
      ('Тумбочка', 2000, 8),
      ('Пуф', 1000, 20),
      ('Кресло', 18000, 10),
      ('Детская_кроватка', 10000, 25),
      ('Туалетный_столик', 8000, 12),
      ('Кровать', 15000, 15);

--заполнение таблицы "Покупатель"
insert into pokupatel(имя_фамилия)
VALUES
      ('Светлана_Чефонова'),
      ('Михаил_Мишустин'),
      ('Дмитрий_Песков'),
      ('Елена_Ханга'),
      ('Ольга_Медынич'),
      ('Сергей_Светлаков'),
      ('Артемий_Лебедев'),
      ('Артем_Дзюба'),
      ('Николай_Басков'),
      ('Сергей_Лазарев');


--заполнение таблицы "Заказ"
insert into zakaz(id_товара, id_заказчика, дата_заказа, количество_товаров)
VALUES
    (1, 10, now(),3),
    (2, 9, now(),8),
    (3, 8, now(),9),
    (4, 7, now(),5),
    (5, 6, now(),4),
    (6, 5, now(),7),
    (7, 4, now(),3),
    (3, 2, now(),4),
    (6, 5, now(),10),
    (10, 10, now(),6);



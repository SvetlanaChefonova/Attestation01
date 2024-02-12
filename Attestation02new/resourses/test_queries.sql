--create database database_name
 --   with owner postgres;

--comment on database database_name is 'База данных магазина';

   -- \connect shop;

-- №1 Запрос к таблице Товар. Получаем все данные из таблица Товар.
SELECT *
FROM tovar;

-- №2 Запрос к таблице Товар, где стоимость больше 10000.
SELECT *
FROM tovar
WHERE стоимость > 10000;

-- №3 Запрос к таблице Товар. Удаление позиций из таблицы Товар.
delete from tovar
where id = 9;

-- №4 Запрос к таблице Товар. Замена стоимости товаров.
update tovar set стоимость = 8500
where id = 1;
update tovar set стоимость = 4500
where  id =2;
update tovar set стоимость = 7500
where  id =3;
update tovar set стоимость = 70600
where  id =4;
update tovar set стоимость = 4050
where  id =5;
update tovar set стоимость = 3030
where  id =6;


--№5 Запрос к таблице Покупатель. Получаем все данные из таблицы Покупатель.
SELECT *
FROM pokupatel;

--№6 Запрос к таблице Покупатель. Изменение имени и фамилии покупателя.
update pokupatel set имя_фамилия = 'Гарик_Харламов'
where id = 6;

--№7 Запрос к таблице Покупатель. Удаление покупателя.
delete  from pokupatel
where id = 1;

--№8 Запрос к таблице Заказ. Получаем все данные из таблицы Заказ.
SELECT *
FROM zakaz;

--№9 Запрос к таблице Заказ. Удаление заказов у покупателя с id = 5.
delete from zakaz
where zakaz.id_заказчика = 5;


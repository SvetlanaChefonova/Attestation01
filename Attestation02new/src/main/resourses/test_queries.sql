--create database database_name
 --   with owner postgres;

--comment on database database_name is 'База данных магазина';

   -- \connect shop;

-- №1 Запрос к таблице c товаром. Получаем все данные из таблицы "product".
SELECT *
FROM product;

-- №2 Запрос к таблице "product", где стоимость больше 10000.
SELECT *
FROM product
WHERE cost > 10000;

-- №3 Запрос к таблице c товаром. Удаление позиций из таблицы "product".
delete from product
where id = 9;

-- №4 Запрос к таблице c товаром. Замена стоимости товаров.
update product set cost = 8500
where id = 1;
update product set cost = 4500
where  id =2;
update product set cost = 7500
where  id =3;
update product set cost = 70600
where  id =4;
update product set cost = 4050
where  id =5;
update product set cost = 3030
where  id =6;


--№5 Запрос к таблице c покупателями. Получаем все данные из таблицы "customer".
SELECT *
FROM customer;

--№6 Запрос к таблице c покупателями. Изменение имени и фамилии покупателя.
update customer set name_last_name = 'Гарик_Харламов'
where id = 6;

--№7 Запрос к таблице c покупателями. Удаление покупателя.
delete  from customer
where id = 1;

--№8 Запрос к таблице c заказами. Получаем все данные из таблицы "the_order".
SELECT *
FROM the_order;

--№9 Запрос к таблице c заказами. Удаление заказов у покупателя с id = 10.
delete from the_order
where the_order.id_customer = 10;

--№10 Запрос с использованием with и join.

with customer_info as(
    select
         tor.id_customer as customer,
         c.name_last_name as name_of_customer
    from  customer c
        join the_order tor on  c.id = tor.id_customer
)
select * from customer_info;


--№11 Запрос с использованием with и join.
with product_info as(
    select
        p.description as description,
        p.cost as cost,
        tor.id_customer as customer
    from  product p
          join the_order tor on p.id = tor.id_product

)
select * from product_info;


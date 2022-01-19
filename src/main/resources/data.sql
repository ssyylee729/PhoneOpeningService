insert into customer (`id`, `customer_id`, `name`, `phone_number`, `birthday`,`created_dt`, `updated_dt`)
values (1, 'kelly123', 'kelly',  '01011113333', '1995-07-29', now(), now());

insert into customer (`id`, `customer_id`,`name`, `phone_number`, `birthday`,`created_dt`, `updated_dt`)
values (2, 'allie123','allie', '01011112222', '1993-07-23',now(), now());

insert into staff (`id`, `staff_id`,`name`, `phone_number`, `password`,`created_dt`, `updated_dt`)
values (1, 'kelly123','kelly', '01011112222', '1993-07-23',now(), now());

insert into staff (`id`, `staff_id`,`name`, `phone_number`, `password`,`created_dt`, `updated_dt`)
values (2, 'allie123','allie', '01011112222', '1993-07-23',now(), now());

insert into opening(`id`, `request_dt`, `status`, `created_dt`, `updated_dt`)
values (1, now(), 0, now(), now());
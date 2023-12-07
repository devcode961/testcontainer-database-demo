create sequence customer_id_seq start with 1 increment by 50;

create table customers (
    id bigint not null default nextval('customer_id_seq'),
    name varchar(255) not null,
    primary key (id)
);
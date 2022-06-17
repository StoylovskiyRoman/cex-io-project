alter table pairs add column max_lot_size  varchar(25);
alter table pairs add column min_lot_size double;
alter table pairs add column min_lot_sizeS2 double;
alter table pairs add column max_price int;
alter table pairs add column min_price int;
alter table pairs add column price_precision int;
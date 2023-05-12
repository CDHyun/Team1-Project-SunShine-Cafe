use sunshine;

-- CATEGORY INSERT ----------------------
-- 1 : 커피(ICE), 2 : 커피(HOT), 3 : 에이드&주스, 4 : 티(Tea), 5 : 디저트
select * from category;

insert into category(categoryName) values('커피(ICE)');
insert into category(categoryName) values('커피(HOT)');
insert into category(categoryName) values('에이드&주스');
insert into category(categoryName) values('티(Tea)');
insert into category(categoryName) values('디저트');




-- DRINK INSERT -------------------------
select * from drink;
insert into drink(categoryNo, drinkName, drinkPrice, drinkImageName)
values ('1', '아이스 아메리카노', '2000', 'IceAmericano.png');

insert into drink(categoryNo, drinkName, drinkPrice, drinkImageName)
values ('1', '아이스 카페라떼', '3500', 'IceCafeLatte.png');

insert into drink(categoryNo, drinkName, drinkPrice, drinkImageName)
values ('1', '아이스 카페모카', '4000', 'IceCafeMoca.png');

insert into drink(categoryNo, drinkName, drinkPrice, drinkImageName)
values ('3', '수박 주스', '4000', 'IceWaterMelon.png');

insert into drink(categoryNo, drinkName, drinkPrice, drinkImageName)
values ('1', '아이스 말차 라떼', '4000', 'IceMatchaLatte.png');

insert into drink(categoryNo, drinkName, drinkPrice, drinkImageName)
values ('4', '아이스 자몽 허니 블랙', '3000', 'IceHoneyBlack.png');

insert into drink(categoryNo, drinkName, drinkPrice, drinkImageName)
values ('4', '아이스 제주 유기 녹차', '4000', 'IceJejuGreenTea.png');

insert into drink(categoryNo, drinkName, drinkPrice, drinkImageName)
values ('2', '에스프레소', '500', 'Espresso.png');

--

insert into drink(categoryNo, drinkName, drinkPrice, drinkImageName)
values ('1', '자바 칩 프라푸치노', '6300', 'JavaChipFrappuccino.png');

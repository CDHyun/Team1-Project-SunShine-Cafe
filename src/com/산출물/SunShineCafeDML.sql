use sunshine;

ALTER TABLE category AUTO_INCREMENT = 1;
ALTER TABLE item AUTO_INCREMENT = 1;
ALTER TABLE drink AUTO_INCREMENT = 1;
ALTER TABLE dessert AUTO_INCREMENT = 1;


-- USER INSERT --------------------------
select * from user;
insert into user(userid, userPassword, userPhone) values('donghyun', '1234', '01048194105');


-- CATEGORY INSERT ----------------------
-- 1 : 커피(ICE), 2 : 커피(HOT), 3 : 에이드&주스, 4 : 티(Tea), 5 : 디저트
select * from category;

insert into category(categoryName) values('커피(ICE)');
insert into category(categoryName) values('커피(HOT)');
insert into category(categoryName) values('에이드&주스');
insert into category(categoryName) values('티(Tea)');
insert into category(categoryName) values('디저트');
insert into category(categoryName) values('시간');




-- ITEM INSERT -------------------------
select * from item;
insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('1', '아이스 아메리카노', '2000', 'IceAmericano.png', '블렌드 원두로 추출한 에스프레소에 물을 더해, 풍부한 바디감을 느낄 수 있는 스탠다드 커피');

insert into item(categoryNo, itemName, itemPrice, itemImageName)
values ('1', '아이스 카페라떼', '3500', 'IceCafeLatte.png');

insert into item(categoryNo, itemName, itemPrice, itemImageName)
values ('1', '아이스 카페모카', '4000', 'IceCafeMoca.png');

insert into item(categoryNo, itemName, itemPrice, itemImageName)
values ('3', '수박 주스', '4000', 'IceWaterMelon.png');

insert into item(categoryNo, itemName, itemPrice, itemImageName)
values ('1', '아이스 말차 라떼', '4000', 'IceMatchaLatte.png');

insert into item(categoryNo, itemName, itemPrice, itemImageName)
values ('4', '아이스 자몽 허니 블랙', '3000', 'IceHoneyBlack.png');

insert into item(categoryNo, itemName, itemPrice, itemImageName)
values ('4', '아이스 제주 유기 녹차', '4000', 'IceJejuGreenTea.png');

insert into item(categoryNo, itemName, itemPrice, itemImageName)
values ('2', '에스프레소', '500', 'Espresso.png');

insert into item(categoryNo, itemName, itemPrice, itemImageName)
values ('1', '자바 칩 프라푸치노', '6300', 'JavaChipFrappuccino.png');

--

insert into item(categoryNo, itemName, itemPrice, itemImageName)
values ('5', '크루아상', 2000, 'croissant.png');

insert into item(categoryNo, itemName, itemPrice, itemImageName)
values ('5', '초코 스무어 쿠키', 3000, 'chocoSmoreCookie.png');

insert into item(categoryNo, itemName, itemPrice, itemImageName)
values ('5', '크로크무슈', 4000, 'CroqueMonsieur.png');

insert into item(categoryNo, itemName, itemPrice, itemImageName)
values ('5', '한컵 망고놀라', 5000, 'OneCupMango.png');

insert into item(categoryNo, itemName, itemPrice, itemImageName)
values ('6', '30분 시간 이용권', 3000, '30min.png');

insert into item(categoryNo, itemName, itemPrice, itemImageName)
values ('6', '60분 시간 이용권', 6000, '60min.png');
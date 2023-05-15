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

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('1', '아이스 카페라떼', '3500', 'IceCafeLatte.png', '진한 에스프레소와 부드러운 우유가 어우러져 고소한 풍미를 완성한 라떼');

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('1', '아이스 카페모카', '4000', 'IceCafeMoca.png', '초코를 만나 풍부해진 에스프레소와 고소한 우유, 부드러운 휘핑크림까지 더해 달콤하게 즐기는 커피');

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('3', '수박 주스', '4000', 'IceWaterMelon.png', '돌아온 여름시즌 베스트셀러! 달달하고 시원한 선샤인 커피 만의 수박주스');

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('1', '아이스 카푸치노', '4000', 'IceCappuccino.png', '에스프레소 위에 올려진 우유 거품, 그리고 시나몬 파우더로 완성한 조화로운 맛의 커피');

insert into item(categoryNo, itemName, itemPrice, itemImageName)
values ('1', '아이스 큐브 라떼', '3000', 'IceCubeLatte.png', '연유를 섞은 라떼에 에스프레소를 얼린 커피큐브를 올려, 녹을수록 더 진한 커피가 느껴지는 라떼');

insert into item(categoryNo, itemName, itemPrice, itemImageName)
values ('4', '아이스 제주 유기 녹차', '4000', 'IceJejuGreenTea.png');

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('2', '에스프레소', '500', 'Espresso.png', '커피 원두의 향미를 온전히 즐길 수 있는 에스프레소');

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('4', '페퍼민트', '4000', 'PepperMintTea.png', '멘톨향의 묵직한 청량감, 상쾌한 맛과 향이 인상적인 허브티');

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('1', '사과 유자차', '4500', 'ApplecitronTea.png', '애플티의 향긋함과 유자청의 상큼달콤함을 한컵에 담아낸 과일티');

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('4', '핫 얼그레이', '4000', 'HotEarlGrey.png', '홍차 특유의 풍부한 플레이버를 만끽할 수 있는 허브티');

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('3', '샤인 머스캣 그린주스', '4000', 'GreenJuice.png', '달콤한 샤인머스캣과 케일이 만난 싱그러운 주스에 칼슘을 더해 건강한 블렌딩 주스');

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('2', '핫 헤이즐넛 라떼', '4000', 'HazelnutLatte.png', '부드러운 카페라떼에 헤이즐넛의 풍부한 향과 달콤함을 담아 향긋하게 즐길 수 있는 라떼');

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('2', '핫 카푸치노', '3000', 'Cappuccino.png', '에스프레소 위에 올려진 우유 거품, 그리고 시나몬 파우더로 완성한 조화로운 맛의 커피');

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('2', '핫 카라멜 마끼아또', '3000', 'HotCaramel.png', '폼 밀크 속에 진한 에스프레소와 달콤한 카라멜을 가미해 부드럽게 즐기는 커피');

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('2', '핫 고구마 라떼', '3000', 'HotSweetPotatoLatte.png', '달콤하고 고소한 고구마와 부드러운 우유가 만나 누구나 즐기기 좋은 든든한 라떼');

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('1', '아이스 고구마 라떼', '3000', 'IceSweetPotatoLatte.png', '달콤하고 고소한 고구마와 부드러운 우유가 만나 누구나 즐기기 좋은 든든한 라떼');

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('2', '핫 초코', '2000', 'HotChoco.png', '부드러운 우유에 진한 초코소스가 어우러져 달콤하게 입맛을 깨우는 초콜릿 음료');

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('2', '녹차 라떼', '3000', 'GreenTeaLatte.png', '향긋한 녹차에 우유를 더해 입 안에 부드러운 푸릇함을 선물하는 라떼');

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('4', '트로피컬 용과 티플레저', '3800', 'TropicalDragonFruit.png', '상큼 달콤한 트로피컬 과일, 강렬한 레드 용과 에이드에 아삭한 알로에 펄이 들어간 그린티 베이스의 티플레저');

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('3', '레드 오렌지 자몽 주스', '3000', 'RedOrangeJuice.png', '엄선된 시칠리아 레드오렌지와 자몽이 만난 상큼한 주스에 프로바이오틱스를 더해 건강한 블렌딩 주스');

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('3', '딸기 주스', '3000', 'StrawberryJuice.png', '새콤달콤한 딸기주스에 피쉬 콜라겐을 더해 건강한 블렌딩 주스');

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('1', '아이스 콜드브루 라떼', '3000', 'IceColdbrewLatte.png', '콜드브루에 고소한 우유를 섞어, 깔끔함과 부드러움을 잡은 라떼');

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('3', '라임 모히또', '3000', 'LimeMojito.png', '상큼한 라임과 달콤한 향기의 애플민트가 어우러져 상쾌함을 한잔에 가득 채운 모히또 음료');

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('3', '유니콘 매직 에이드(블루)', '4000', 'UnicornMageAceBlue.png', '섞으면 마법처럼 색이 변하는 재미에 라임의 청량함으로 입까지 즐거운 이색 에이드');

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('3', '유니콘 매직 에이드(핑크)', '4000', 'UnicornMageAcePink.png', '섞으면 마법처럼 색이 변하는 재미에 레몬의 상큼함으로 입까지 즐거운 이색 에이드');

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('4', '캐모마일', '3000', 'Chamomile.png', '마음을 진정 시켜주는 산뜻한 풀내음을 느낄 수 있는 허브티');

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('1', '젤라또 아포가토', 5000, 'OneCupMango.png', '바닐라 젤라또에 진한 에스프레소를 부어 만든 디저트');

select * from item;

--

insert into item(categoryNo, itemName, itemPrice, itemImageName)
values ('5', '크루아상', 2000, 'croissant.png');

insert into item(categoryNo, itemName, itemPrice, itemImageName)
values ('5', '초코 스무어 쿠키', 3000, 'chocoSmoreCookie.png');

insert into item(categoryNo, itemName, itemPrice, itemImageName)
values ('5', '크로크무슈', 4000, 'CroqueMonsieur.png');

insert into item(categoryNo, itemName, itemPrice, itemImageName)
values ('5', '한컵 망고놀라', 5000, 'OneCupMango.png');

select * from item;

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('5', '치즈 케이크', 5000, 'CheeseCake.png', '진한 치즈의 맛을 달콤하고 부드럽게 느낄 수 있는 케이크');

insert into item(categoryNo, itemName, itemPrice, itemImageName, itemContent)
values ('5', '초코무스 케이크', 5000, 'ChocolateMousseCake.png', '달콤한 초콜릿 본연의 맛을 더 진하게 느낄 수 있는 케이크');


insert into item(categoryNo, itemName, itemPrice, itemImageName)
values ('6', '30분 시간 이용권', 3000, '30min.png');

insert into item(categoryNo, itemName, itemPrice, itemImageName)
values ('6', '60분 시간 이용권', 6000, '60min.png');
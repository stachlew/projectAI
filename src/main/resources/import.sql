ALTER TABLE USERS MODIFY (IS_MAN NUMBER(1) DEFAULT 1);
ALTER TABLE EVENT MODIFY (ENABLED NUMBER(1) DEFAULT 1);

INSERT INTO "CUSTOMER" (ID, NAME, EMAIL, CREATED_DATE) VALUES(customer_seq.NEXTVAL, 'abacki','spamer@yahoo.com', TO_DATE('2017-02-11', 'yyyy-mm-dd'));
INSERT INTO "CUSTOMER" (ID, NAME, EMAIL, CREATED_DATE) VALUES(customer_seq.NEXTVAL, 'cabacki','mejlik123@gmail.com', TO_DATE('2017-02-12', 'yyyy-mm-dd'));
INSERT INTO "CUSTOMER" (ID, NAME, EMAIL, CREATED_DATE) VALUES(customer_seq.NEXTVAL, 'babacki','pustostan@wp.pl', TO_DATE('2017-02-13', 'yyyy-mm-dd'));

--WOJEWÓDZTWA
INSERT INTO REGION (ID, REGION_NAME) VALUES (1,'Dolnośląskie');
INSERT INTO REGION (ID, REGION_NAME) VALUES (2,'Kujawsko-pomorskie');
INSERT INTO REGION (ID, REGION_NAME) VALUES (3,'Lubelskie');
INSERT INTO REGION (ID, REGION_NAME) VALUES (4,'Lubuskie');
INSERT INTO REGION (ID, REGION_NAME) VALUES (5,'Łódzkie');
INSERT INTO REGION (ID, REGION_NAME) VALUES (6,'Małopolskie');
INSERT INTO REGION (ID, REGION_NAME) VALUES (7,'Mazowieckie');
INSERT INTO REGION (ID, REGION_NAME) VALUES (8,'Opolskie');
INSERT INTO REGION (ID, REGION_NAME) VALUES (9,'Podkarpackie');
INSERT INTO REGION (ID, REGION_NAME) VALUES (10,'Podlaskie');
INSERT INTO REGION (ID, REGION_NAME) VALUES (11,'Pomorskie');
INSERT INTO REGION (ID, REGION_NAME) VALUES (12,'Śląskie');
INSERT INTO REGION (ID, REGION_NAME) VALUES (13,'Świętokrzyskie');
INSERT INTO REGION (ID, REGION_NAME) VALUES (14,'Warmińsko-mazurskie');
INSERT INTO REGION (ID, REGION_NAME) VALUES (15,'Wielkopolskie');
INSERT INTO REGION (ID, REGION_NAME) VALUES (16,'Zachodniopomorskie');

-- MIASTA
INSERT INTO CITY (ID, CITY_NAME, ID_REGION) VALUES (CITY_PK.NEXTVAL,'Warszawa',7);
INSERT INTO CITY (ID, CITY_NAME, ID_REGION) VALUES (CITY_PK.NEXTVAL,'Kraków',6);
INSERT INTO CITY (ID, CITY_NAME, ID_REGION) VALUES (CITY_PK.NEXTVAL,'Gdańsk',11);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Wrocław',  1);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Wałbrzych',  1);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Legnica',  1);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Jelenia Góra', 1);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Bolesławiec',  1);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Bydgoszcz',  2);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Grudziądz',  2);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Inowrocław',  2);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Toruń',  2);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Włocławek',  2);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Lublin',  3);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Biała Podlaska',  3);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Chełm',  3);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Zamość',  3);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Puławy',  3);

INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Zielona Góra',  4);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Gorzów Wielkopolski',  4);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Nowa Sól',  4);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Świebodzin',  4);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Żary',  4);



INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Łódź',  5);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Piotrków Trybunalski',  5);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Pabianice',  5);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Świebodzin',  5);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Tomaszów Mazowiecki',  5);


INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Tarnów',  6);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Nowy Sącz',  6);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Oświęcim',  6);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Chrzanów',  6);


INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Radom',  7);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Płock',  7);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Siedlce',  7);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Pruszków',  7);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Legionowo',  7);


INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Opole',  8);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Kędzierzyn-Koźle',  8);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Nysa',  8);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Brzeg',  8);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Kluczbork',  8);



INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Rzeszów',  9);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Przemyśl',  9);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Stalowa Wola',  9);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Mielec',  9);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Tarnobrzeg',  9);



INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Białystok',  10);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Suwałki',  10);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Łomża', 10);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Augustów',  10);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Bielsk Podlaski',  10);


INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Gdynia',  11);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Słupsk',  11);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Sopot',  11);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Wejherowo',  11);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Krynica Morska',  11);



INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Katowice',  12);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Częstochowa',  12);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Sosnowiec',  12);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Gliwice',  12);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Zabrze',  12);



INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Kielce',  13);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Ostrowiec Świętokrzyski',  13);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Starachowice',  13);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Skarżysko-Kamienna',  13);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Sandomierz',  13);




INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Olsztyn',  14);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Elbląg',  14);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Ełk',  14);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Ostróda',  14);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Iława',  14);



INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Poznań',  15);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Ostrów Wielkopolski',  15);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Gniezno',  15);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Piła',  15);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Konin',  15);


INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Szczecin',  16);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Koszalin',  16);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Stargard',  16);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Kołobrzeg',  16);
INSERT INTO CITY ( id,city_name,id_region ) VALUES (  CITY_PK.nextval,  'Świnoujście',  16);


--- PAROWANIE UŻYTKOWNIKÓW ---
insert into personality_category (id, amount, description) values(PERSONALITY_CATEGORY_PK.nextval,15,'Charakter');
insert into personality_category (id, amount, description) values(PERSONALITY_CATEGORY_PK.nextval,15,'Osobowość');
insert into personality_category (id, amount, description) values(PERSONALITY_CATEGORY_PK.nextval,30,'Czas wolny');

insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Otwarta',1);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Spontaniczna',1);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Introwertyczna',1);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Rozmowna',1);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Z poczuciem humoru',1);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Pomocna',1);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Samodzielna',1);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Energiczna',1);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Osoba oczytana',1);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Odpowiedzialna',1);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Opiekuńcza',1);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Dbająca o porządek',1);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Ma dużo znajomych',1);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Umie rozmawiać na każdy temat ',1);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Perfekcjonista',1);

insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Szara myszka',2);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Wieczny wojownik',2);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Przywódca grupy',2);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Posłuszny wyrobnik',2);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Samotny strzelec',2);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Najlepszy kochanek',2);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Złota rączka',2);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Wierny przyjaciel',2);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Towarzysz życia',2);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Wierny przyjaciel',2);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Wieczny pracuś',2);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Osoba potrafiąca zaskoczyć',2);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Nierozwikłana zagadka',2);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Dusza towarzystwa',2);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Domator',2);

insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Kino przy okazji każdej premiery',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Spacer po niedzielnym obiedzie',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Wieczory przed telewizorem',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Gra w gry wideo',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Wakacje w europejskiej stolicy',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Wakacje egzotyczne',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Weekend w Bieszczadach',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Weekend nad morzem',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Sylwester w Zakopanem',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Sylwester w Paryżu',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Święta w rodzinnym gronie',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Podziwianie przyrody',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Lampka wina przy letnim zachodzie słońca',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Ognisko i pieczone ziemniaki',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Domówka ze znajomymi',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Wyjście do klubu',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Horror przy zgaszonym świetle',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Komedia romantyczna i czekoladki',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Kawa, koc, kot i książka',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Realizowanie swoich pasji',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Czas wyłącznie dla siebie',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Skok na bungge',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Zjazd na nartach z lodowca',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Windsurfing',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Szachy przy herbacie',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Teleturniej w kapciach',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Wspólne gotowanie',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Gry planszowe',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Wspólne leniuchowanie',3);
insert into category_attribute (id, description, category_id) values (CATEGORY_ATTRIBUTE_PK.nextval,'Śniadanie do łóżka',3);

insert into EDUCATION(ID,DESCRIPTION) VALUES (EDUCATION_PK.nextval,'Podstawowe');
INSERT INTO EDUCATION(ID,DESCRIPTION) VALUES (EDUCATION_PK.nextval,'Średnie');

INSERT INTO EYE_COLOR (ID, DESCRIPTION) VALUES (EYE_COLOR_PK.nextval,'Niebieskie');
INSERT INTO EYE_COLOR (ID, DESCRIPTION)  VALUES (EYE_COLOR_PK.nextval,'Brązowe');

INSERT INTO FIGURE(ID, DESCRIPTION) VALUES (FIGURE_PK.nextval,'Szczupła');
INSERT INTO FIGURE(ID, DESCRIPTION) VALUES (FIGURE_PK.nextval,'Puszysta');

INSERT INTO HAIR_COLOR(ID, DESCRIPTION) VALUES (HAIR_COLOR_PK.nextval,'Blond');
INSERT INTO HAIR_COLOR(ID, DESCRIPTION) VALUES (HAIR_COLOR_PK.nextval,'Rude');

INSERT INTO MARTIAL_STATUS(ID, DESCRIPTION) VALUES (MARTIAL_STATUS_PK.nextval,'Wolny');
INSERT INTO MARTIAL_STATUS(ID, DESCRIPTION) VALUES (MARTIAL_STATUS_PK.nextval,'Rozwiedziony');

INSERT INTO RELIGION(ID, DESCRIPTION) VALUES (RELIGION_PK.nextval,'Katolicka');
INSERT INTO RELIGION(ID, DESCRIPTION) VALUES (RELIGION_PK.nextval,'Ateizm');

INSERT INTO ZODIAC_SIGN(ID, DESCRIPTION) VALUES (ZODIAC_SIGN_PK.nextval,'Skorpion');
INSERT INTO ZODIAC_SIGN(ID, DESCRIPTION) VALUES (ZODIAC_SIGN_PK.nextval,'Waga');

INSERT INTO DRINKING(ID, DESCRIPTION) VALUES (DRINKING_PK.nextval,'Okazjonalnie');
INSERT INTO DRINKING(ID, DESCRIPTION) VALUES (DRINKING_PK.nextval,'Abstynent');
INSERT INTO DRINKING(ID, DESCRIPTION) VALUES (DRINKING_PK.nextval,'Do oporu');

INSERT INTO KIDS(ID, DESCRIPTION) VALUES (KIDS_PK.nextval,'Nigdy');
INSERT INTO KIDS(ID, DESCRIPTION) VALUES (KIDS_PK.nextval,'W przyszłości');
INSERT INTO KIDS(ID, DESCRIPTION) VALUES (KIDS_PK.nextval,'Już mam');

INSERT INTO SMOKING(ID, DESCRIPTION) VALUES (SMOKING_PK.nextval,'Nie palę');
INSERT INTO SMOKING(ID, DESCRIPTION) VALUES (SMOKING_PK.nextval,'Okazjonalnie');
INSERT INTO SMOKING(ID, DESCRIPTION) VALUES (SMOKING_PK.nextval,'Jeden za drugim');




INSERT INTO USERS (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, lastpassres, BIRTH_DATE, EDUCATION_ID, SMOKING_ID, DRINKING_ID, KIDS_ID, ZODIAC_SIGN_ID, MARTIAL_STATUS_ID, FIGURE_ID, HAIR_COLOR_ID, EYE_COLOR_ID, RELIGION_ID, CITY_ID, HEIGHT, PROFESSION, IS_MAN) VALUES (USER_SEQ.nextval, 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'Janusz', 'Tracz', 'lol@admin.com', 1, '2017-01-01', '1990-03-07',1,2,1,2,1,2,1,2,1,2,2,175,'Sprzątacz na okęciu',1);
INSERT INTO USERS (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, lastpassres, BIRTH_DATE, EDUCATION_ID, SMOKING_ID, DRINKING_ID, KIDS_ID, ZODIAC_SIGN_ID, MARTIAL_STATUS_ID, FIGURE_ID, HAIR_COLOR_ID, EYE_COLOR_ID, RELIGION_ID, CITY_ID, HEIGHT, PROFESSION, IS_MAN) VALUES (USER_SEQ.nextval, 'user2', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'Krzysztof', 'Ibisz', 'andrzej@randka.com', 1, '2017-01-01', '1999-04-08',2,1,2,1,2,1,2,1,2,1,3,175,'Programista',1);
INSERT INTO USERS (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, lastpassres, BIRTH_DATE, EDUCATION_ID, SMOKING_ID, DRINKING_ID, KIDS_ID, ZODIAC_SIGN_ID, MARTIAL_STATUS_ID, FIGURE_ID, HAIR_COLOR_ID, EYE_COLOR_ID, RELIGION_ID, CITY_ID, HEIGHT, PROFESSION, IS_MAN) VALUES (USER_SEQ.nextval, 'user3', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'Joanna', 'Potaczek', 'AdamNowak@user.com', 1, '2017-01-01', '1970-01-05',1,1,2,2,1,1,2,2,1,1,5,175,'Kierowniczka tira',0);
INSERT INTO USERS (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, lastpassres, BIRTH_DATE, EDUCATION_ID, SMOKING_ID, DRINKING_ID, KIDS_ID, ZODIAC_SIGN_ID, MARTIAL_STATUS_ID, FIGURE_ID, HAIR_COLOR_ID, EYE_COLOR_ID, RELIGION_ID, CITY_ID, HEIGHT, PROFESSION, IS_MAN) VALUES (USER_SEQ.nextval, 'user4', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'Kazimiera', 'Sztuka', 'hehe@admin.com', 1, '2017-01-01', '1980-02-06',1,2,1,2,2,1,1,2,1,2,3,175,'Kucharka kebabów',0);
INSERT INTO USERS (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, lastpassres, BIRTH_DATE, EDUCATION_ID, SMOKING_ID, DRINKING_ID, KIDS_ID, ZODIAC_SIGN_ID, MARTIAL_STATUS_ID, FIGURE_ID, HAIR_COLOR_ID, EYE_COLOR_ID, RELIGION_ID, CITY_ID, HEIGHT, PROFESSION, IS_MAN) VALUES (USER_SEQ.nextval, 'user5', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'Patrycja', 'Aparycja', 'zstonoga@user.com', 1, '2017-01-01', '1975-01-05',2,2,1,1,2,1,1,2,1,1,4,175,'Motorniczka tramwajowa',0);
INSERT INTO USERS (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, lastpassres, BIRTH_DATE) VALUES (USER_SEQ.nextval, 'manager', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'Arnold', 'Boczek', 'boczek@admin.com', 1, '2017-01-01', '1999-04-15');
INSERT INTO USERS (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, lastpassres, BIRTH_DATE) VALUES (USER_SEQ.nextval, 'manager2', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'Maja', 'Kwiatuszek', 'zielsko@admin.com', 1, '2017-01-01', '1987-03-07');
INSERT INTO USERS (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, lastpassres, BIRTH_DATE) VALUES (USER_SEQ.nextval, 'manager3', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'Grzegorz', 'Lato', '3sekundyna100@randka.com', 1, '2017-01-01', '1950-04-08');
INSERT INTO USERS (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, lastpassres, BIRTH_DATE) VALUES (USER_SEQ.nextval, 'manager4', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'Zbyszek', 'Boniek', 'forzajuve0@randka.com', 1, '2017-01-01', '1958-04-08');
INSERT INTO USERS (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, lastpassres, BIRTH_DATE) VALUES (USER_SEQ.nextval, 'manager5', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'Wiesław', 'Paleta', 'mielonecodziennie@randka.com', 1, '2017-01-01', '1992-04-08');

INSERT INTO AUTHORITY (ID, NAME) VALUES (AUTH_SEQ.nextval, 'ROLE_USER');
INSERT INTO AUTHORITY (ID, NAME) VALUES (AUTH_SEQ.nextval, 'ROLE_MANAGER');

--admin ma prawa usera, managera i admina!!!
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (2, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (3, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (4, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (5, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (6, 2);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (7, 2);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (8, 2);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (9, 2);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (10, 2);


--przykladowa rozmowa
-- INSERT INTO CONVERSATION (ID,MEMBER_ONE_ID,MEMBER_TWO_ID) VALUES (1,1,2);
-- INSERT INTO CONVERSATION (ID,MEMBER_ONE_ID,MEMBER_TWO_ID) VALUES (2,2,3);

Insert into LOCALIZATION (ID,ADDRESS,CITY_ID,GEO_LENGTH,GEO_WIDTH) values (LOCALIZATION_PK.nextval,'Plac Defilad 1, 00-901 Warszawa','1','21.00551','52.23147');
Insert into LOCALIZATION (ID,ADDRESS,CITY_ID,GEO_LENGTH,GEO_WIDTH) values (LOCALIZATION_PK.nextval,'Lubelska 158, 26-600 Radom','33','21.15040','51.39641');
Insert into LOCALIZATION (ID,ADDRESS,CITY_ID,GEO_LENGTH,GEO_WIDTH) values (LOCALIZATION_PK.nextval,'Drewnowska 58, 91-002 Łódź','24','20.90067','52.25353');
Insert into LOCALIZATION (ID,ADDRESS,CITY_ID,GEO_LENGTH,GEO_WIDTH) values (LOCALIZATION_PK.nextval,'Sulechowska, 66-200 Świebodzin','22','21.90067','52.02253');
Insert into LOCALIZATION (ID,ADDRESS,CITY_ID,GEO_LENGTH,GEO_WIDTH) values (LOCALIZATION_PK.nextval,'Norbertańska 2, 09-400 Płock','34','21.25067','51.11353');

Insert into EVENT (ID,CAPACITY,DESCRIPTION,EVENT_START,TITLE,LOCALOZATION_ID,ORGANIZER_ID) values (EVENT_PK.nextval,'50','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris efficitur erat justo, in ultrices magna aliquet at. Donec ornare, orci sit amet ullamcorper molestie, nunc massa fringilla nulla, nec egestas.',to_timestamp('2017-11-14 20:00:00','rrrr-mm-dd hh24:mi:ss'),'Wieczorne udawanie małp','1','6');
Insert into EVENT (ID,CAPACITY,DESCRIPTION,EVENT_START,TITLE,LOCALOZATION_ID,ORGANIZER_ID) values (EVENT_PK.nextval,'20','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris efficitur erat justo, in ultrices magna aliquet at. Donec ornare, orci sit amet ullamcorper molestie, nunc massa fringilla nulla, nec egestas.',to_timestamp('2017-12-14 20:00:00','rrrr-mm-dd hh24:mi:ss'),'Nocne odloty ku gwiazdom','2','7');
Insert into EVENT (ID,CAPACITY,DESCRIPTION,EVENT_START,TITLE,LOCALOZATION_ID,ORGANIZER_ID) values (EVENT_PK.nextval,'75','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris efficitur erat justo, in ultrices magna aliquet at. Donec ornare, orci sit amet ullamcorper molestie, nunc massa fringilla nulla, nec egestas.',to_timestamp('2017-12-20 20:00:00','rrrr-mm-dd hh24:mi:ss'),'Ubieranie choinki domu handlowego Oszust','3','8');
Insert into EVENT (ID,CAPACITY,DESCRIPTION,EVENT_START,TITLE,LOCALOZATION_ID,ORGANIZER_ID) values (EVENT_PK.nextval,'100','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris efficitur erat justo, in ultrices magna aliquet at. Donec ornare, orci sit amet ullamcorper molestie, nunc massa fringilla nulla, nec egestas.',to_timestamp('2017-12-24 20:00:00','rrrr-mm-dd hh24:mi:ss'),'Trzeźwa pasterka i kolędy','4','9');
Insert into EVENT (ID,CAPACITY,DESCRIPTION,EVENT_START,TITLE,LOCALOZATION_ID,ORGANIZER_ID) values (EVENT_PK.nextval,'200','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris efficitur erat justo, in ultrices magna aliquet at. Donec ornare, orci sit amet ullamcorper molestie, nunc massa fringilla nulla, nec egestas.',to_timestamp('2017-12-31 20:00:00','rrrr-mm-dd hh24:mi:ss'),'Sylwestrowa biba na ostatnim piętrze','5','10');

Insert into PARTICIPANT(ID,EVENT_ID,USER_ID) VALUES (PARTICIPANT_PK.nextval,1,2);
Insert into PARTICIPANT(ID,EVENT_ID,USER_ID) VALUES (PARTICIPANT_PK.nextval,1,3);
Insert into PARTICIPANT(ID,EVENT_ID,USER_ID) VALUES (PARTICIPANT_PK.nextval,2,2);








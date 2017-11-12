ALTER TABLE USERS MODIFY (ACTIVE NUMBER(1) DEFAULT 1);

INSERT INTO "CUSTOMER" (ID, NAME, EMAIL, CREATED_DATE) VALUES(customer_seq.NEXTVAL, 'abacki','spamer@yahoo.com', TO_DATE('2017-02-11', 'yyyy-mm-dd'));
INSERT INTO "CUSTOMER" (ID, NAME, EMAIL, CREATED_DATE) VALUES(customer_seq.NEXTVAL, 'cabacki','mejlik123@gmail.com', TO_DATE('2017-02-12', 'yyyy-mm-dd'));
INSERT INTO "CUSTOMER" (ID, NAME, EMAIL, CREATED_DATE) VALUES(customer_seq.NEXTVAL, 'babacki','pustostan@wp.pl', TO_DATE('2017-02-13', 'yyyy-mm-dd'));


INSERT INTO USERS (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, lastpassres, BIRTH_DATE) VALUES (USER_SEQ.nextval, 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'Adam', 'Nowak', 'AdamNowak@user.com', 1, '2017-01-01', '1970-01-05');
INSERT INTO USERS (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, lastpassres, BIRTH_DATE) VALUES (USER_SEQ.nextval, 'one', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'Kazimierz', 'Rubaszka', 'hehe@admin.com', 1, '2017-01-01', '1980-02-06');
INSERT INTO USERS (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, lastpassres, BIRTH_DATE) VALUES (USER_SEQ.nextval, 'two', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'Ludmiła', 'Krzak', 'lol@admin.com', 1, '2017-01-01', '1990-03-07');
INSERT INTO USERS (ID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, EMAIL, ENABLED, lastpassres, BIRTH_DATE) VALUES (USER_SEQ.nextval, 'manager', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'Andrzej', 'Randka', 'andrzej@randka.com', 1, '2017-01-01', '2000-04-08');

INSERT INTO AUTHORITY (ID, NAME) VALUES (AUTH_SEQ.nextval, 'ROLE_USER');
INSERT INTO AUTHORITY (ID, NAME) VALUES (AUTH_SEQ.nextval, 'ROLE_MANAGER');
INSERT INTO AUTHORITY (ID, NAME) VALUES (AUTH_SEQ.nextval, 'ROLE_ADMIN');

--admin ma prawa usera, managera i admina!!!
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (2, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (3, 1);
INSERT INTO USER_AUTHORITY (USER_ID, AUTHORITY_ID) VALUES (4, 2);


--przykladowa rozmowa
INSERT INTO CONVERSATION (ID,MEMBER_ONE_ID,MEMBER_TWO_ID) VALUES (1,1,2);
INSERT INTO CONVERSATION (ID,MEMBER_ONE_ID,MEMBER_TWO_ID) VALUES (2,2,3);


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
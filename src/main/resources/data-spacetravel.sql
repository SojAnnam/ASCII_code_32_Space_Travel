--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.10
-- Dumped by pg_dump version 9.5.10

-- Started on 2017-11-23 19:28:06 CET

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 2232 (class 0 OID 47366)
-- Dependencies: 189
-- Data for Name: planetPicture; Type: TABLE DATA; Schema: public; Owner: potyi
--

INSERT INTO planetPicture VALUES (1, 'Ugly insects', 'geonosis.jpg', 'Geonosis');
INSERT INTO planetPicture VALUES (2, 'The planet where maybe exists life', 'mars.jpg', 'Mars');
INSERT INTO planetPicture VALUES (3, 'The place of waving flag', 'moon.jpg', 'Moon');
INSERT INTO planetPicture VALUES (4, 'Giant planet with giant ring', 'saturn.jpg', 'Saturn');
INSERT INTO planetPicture VALUES (5, 'Desert Planet', 'tatooine.jpg', 'Tatooine');


--
-- TOC entry 2242 (class 0 OID 47412)
-- Dependencies: 199
-- Data for Name: solarsystem; Type: TABLE DATA; Schema: public; Owner: potyi
--

INSERT INTO solarsystem VALUES (1, 'Milky Way');
INSERT INTO solarsystem VALUES (2, 'Star Wars');


--
-- TOC entry 2234 (class 0 OID 47377)
-- Dependencies: 191
-- Data for Name: planet; Type: TABLE DATA; Schema: public; Owner: potyi
--

INSERT INTO planet VALUES (1, 'The place where we live. Mars is the fourth planet from the Sun and the second-smallest planet in the Solar System after Mercury. Mars''s average distance from the Sun is roughly 230 million kilometres. Orbital period is 687 (Earth) days.', 'Mars', 'The winter is coming...Average temperature is about -60 C°, although it can vary from -125 C° near the poles during the winter to as much as a comfortable 20 C° at midday near the equator.', 2, 1);
INSERT INTO planet VALUES (2, 'Far far away from home. Saturn is the sixth planet from the Sun and the second-largest in the Solar System.The planet''s most famous feature is its prominent ring system that is composed mostly of ice particles, rocky debris and dust. ', 'Saturn', 'Pretty violent and stormy!', 4, 1);
INSERT INTO planet VALUES (3, 'In the neighbourhood.', 'Moon', 'Daytime temperatures on the sunny side of the moon reach 273 degrees F (134 C°); on the dark side it gets as cold as minus 243 F (minus 153 C°).', 3, 1);
INSERT INTO planet VALUES (4, 'Tatooine was a sparsely inhabited circumbinary desert planet located in the galaxy''s Outer Rim Territories. It would serve as the homeworld to the influential Anakin and Luke Skywalker, who would go on to shape galactic history.', 'Tatooine', 'Warm and dry', 5, 2);
INSERT INTO planet VALUES (5, 'Rocky and hard place. Situated in the Geonosis system of the Arkanis sector in the Outer Rim Territories, the planet of Geonosis was 43,000 light years from the Galactic Core, and less than a parsec away from the Outer Rim planet of Tatooine.', 'Geonosis', 'Dry', 1, 2);


--
-- TOC entry 2226 (class 0 OID 47336)
-- Dependencies: 183
-- Data for Name: accomodation; Type: TABLE DATA; Schema: public; Owner: potyi
--

INSERT INTO accomodation VALUES (1, 'Hotel with green plants. On every morning we offer you to taste fresh veggies. Enjoy the long walk in the first Martian greenhouse!', 'Mars base 1', 1);
INSERT INTO accomodation VALUES (2, 'ESA Hotel for backpackers. Since the dawn of the space age, Mars has been the target of orbiters, landers and rovers. And now for the backpackers! We offer a multicultural atmosphere, many cultural programs are available.', 'Welcome Hotel', 1);
INSERT INTO accomodation VALUES (3, 'Memorable and chip hotel in Venusville, a very special and bizarre district of a human town. Radiation protection is weak, but enjoyment is guaranteed. Mercenaries, freedom fighters and a lot of mutants.', 'The Last Resort in Venusville', 1);
INSERT INTO accomodation VALUES (4, 'Iron walls, deep jail cells in the middle of the desert. The boss has big ambition, and big body. Mercenaries, bounty hunters and other bizarre creatures. Only for the braves.', 'Jabba''s Palace', 4);
INSERT INTO accomodation VALUES (5, 'Nice music and a lot of guests from all part of the Universe', 'Mos Esley Cantina', 4);



INSERT INTO accomodationPicture VALUES (1, 'Iron walls in the desert.', 'jabba_palace.jpg', 'Jabba''s palace', 4);
INSERT INTO accomodationPicture VALUES (2, 'A twi''lek receptionist. He will salute you with these words: "Die wanna wanga"', 'jabba_bib_fortuna.jpg', 'Bib Fortuna', 4);
INSERT INTO accomodationPicture VALUES (3, 'Always tell him the truth. For your sake.', 'jabba_guard.jpg', 'Gamorrean security man', 4);
INSERT INTO accomodationPicture VALUES (4, 'She waits only for you, if you are a good boy. Or a bad girl.', 'jabba_dancer.jpg', 'Sensual maid', 4);
INSERT INTO accomodationPicture VALUES (5, 'Jabba''s best supplier.', 'jabba_boba_fett.jpg', 'Boba Fett', 4);
INSERT INTO accomodationPicture VALUES (6, 'Golden protocol droid.', 'jabba_3cpo.jpg', '3CPO', 4);
INSERT INTO accomodationPicture VALUES (7, 'The big, big boss.', 'jabba_face.jpg', 'Jabba the Hutt', 4);
INSERT INTO accomodationPicture VALUES (8, 'Very special bed.', 'jabba_han_place.jpg', 'Single Room', 4);
INSERT INTO accomodationPicture VALUES (9, 'Rancor Pit', 'jabba_rancor_pit.jpg', 'Family Room', 4);
INSERT INTO accomodationPicture VALUES (10, 'It''s not the Franz Liszt Chamber Orchestra...', 'jabba_band.jpg', 'The Band', 4);
INSERT INTO accomodationPicture VALUES (11, 'Safari in the desert.', 'jabba_desert.jpg', 'Excursion', 4);
INSERT INTO accomodationPicture VALUES (12, 'Dark cave.', 'jabba_sarlacc.jpg', 'Special offer', 4);
INSERT INTO accomodationPicture VALUES (13, 'Hotel with silo', 'marsbase1.jpg', 'Mars base 1', 1);
INSERT INTO accomodationPicture VALUES (14, 'ESA Hotel', 'marsbase2.jpg', 'Mars base 2', 2);
INSERT INTO accomodationPicture VALUES (15, 'Han Solo and Luke: The beginning of a beautiful friendship', 'mos_esley.jpg', 'mos_esley', 5);
INSERT INTO accomodationPicture VALUES (16, 'Total Recall', 'venusville4.jpg', 'Venusville', 3);


--
-- TOC entry 2247 (class 0 OID 0)
-- Dependencies: 182
-- Name: accomodation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: potyi
--

SELECT pg_catalog.setval('accomodation_id_seq', 5, true);


--
-- TOC entry 2228 (class 0 OID 47347)
-- Dependencies: 185
-- Data for Name: amenitytype; Type: TABLE DATA; Schema: public; Owner: potyi
--



--
-- TOC entry 2248 (class 0 OID 0)
-- Dependencies: 184
-- Name: amenitytype_id_seq; Type: SEQUENCE SET; Schema: public; Owner: potyi
--

SELECT pg_catalog.setval('amenitytype_id_seq', 1, false);


--
-- TOC entry 2230 (class 0 OID 47355)
-- Dependencies: 187
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: potyi
--

INSERT INTO customer VALUES (1, 'Várkert bazár 1.', 'Budapest', 'Hungary', 'admin', 'admin', 'admin','admin', '$2a$10$kyaa9hEWPvMkg1Is201KPuhsOvo3/y5PLNWw5IFi05T.CdUnOyKXK', '1140');
INSERT INTO customer VALUES (2, 'Hősök tere 1.', 'Budapest', 'Hungary', 'berci@freemail.hu', 'Bertalan', 'Farkas','user', '$2a$10$GZOSeWHJyWSaBOJy/imdW.GXvpSusJR9Sy/Xqh7S8OeaSkLQ2tZSK', '1140');


--
-- TOC entry 2249 (class 0 OID 0)
-- Dependencies: 186
-- Name: customer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: potyi
--

SELECT pg_catalog.setval('customer_id_seq', 2, true);


--
-- TOC entry 2250 (class 0 OID 0)
-- Dependencies: 181
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: potyi
--

--SELECT pg_catalog.setval('hibernate_sequence', 5, true);


--
-- TOC entry 2251 (class 0 OID 0)
-- Dependencies: 188
-- Name: picture_id_seq; Type: SEQUENCE SET; Schema: public; Owner: potyi
--

SELECT pg_catalog.setval('planetpicture_id_seq', 5, true);



SELECT pg_catalog.setval('accomodationpicture_id_seq', 16, true);


--
-- TOC entry 2252 (class 0 OID 0)
-- Dependencies: 190
-- Name: planet_id_seq; Type: SEQUENCE SET; Schema: public; Owner: potyi
--

SELECT pg_catalog.setval('planet_id_seq', 5, true);


--
-- TOC entry 2240 (class 0 OID 47404)
-- Dependencies: 197
-- Data for Name: roomtype; Type: TABLE DATA; Schema: public; Owner: potyi
--

INSERT INTO roomtype VALUES (1, 1, 'Single Room');
INSERT INTO roomtype VALUES (2, 4, 'King''s Suite');
INSERT INTO roomtype VALUES (3, 10, 'Family Room');
INSERT INTO roomtype VALUES (4, 2, 'Honeymoon Suite');
INSERT INTO roomtype VALUES (5, 2, 'Double Room');


--
-- TOC entry 2236 (class 0 OID 47388)
-- Dependencies: 193
-- Data for Name: room; Type: TABLE DATA; Schema: public; Owner: potyi
--

INSERT INTO room VALUES (1, 300, 1, 5);
INSERT INTO room VALUES (2, 600, 1, 2);
INSERT INTO room VALUES (3, 2500, 1, 3);
INSERT INTO room VALUES (4, 2500, 1, 3);
INSERT INTO room VALUES (5, 1000, 1, 4);
INSERT INTO room VALUES (6, 300, 4, 1);
INSERT INTO room VALUES (7, 1000, 4, 2);
INSERT INTO room VALUES (8, 600, 4, 5);
INSERT INTO room VALUES (9, 800, 4, 4);
INSERT INTO room VALUES (10, 200, 3, 1);
INSERT INTO room VALUES (11, 600, 3, 5);
INSERT INTO room VALUES (12, 800, 3, 4);
INSERT INTO room VALUES (13, 1000, 3, 2);
INSERT INTO room VALUES (14, 1000, 3, 2);
INSERT INTO room VALUES (15, 2000, 3, 3);


--
-- TOC entry 2253 (class 0 OID 0)
-- Dependencies: 192
-- Name: room_id_seq; Type: SEQUENCE SET; Schema: public; Owner: potyi
--

SELECT pg_catalog.setval('room_id_seq', 15, true);


--
-- TOC entry 2238 (class 0 OID 47396)
-- Dependencies: 195
-- Data for Name: roomreservation; Type: TABLE DATA; Schema: public; Owner: potyi
--

INSERT INTO roomreservation VALUES (1, '2017-12-20', '2017-12-10', 2, 10);
INSERT INTO roomreservation VALUES (2, '2017-12-20', '2017-12-10', 2, 13);


--
-- TOC entry 2254 (class 0 OID 0)
-- Dependencies: 194
-- Name: roomreservation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: potyi
--

SELECT pg_catalog.setval('roomreservation_id_seq', 2, true);


--
-- TOC entry 2255 (class 0 OID 0)
-- Dependencies: 196
-- Name: roomtype_id_seq; Type: SEQUENCE SET; Schema: public; Owner: potyi
--

SELECT pg_catalog.setval('roomtype_id_seq', 5, true);


--
-- TOC entry 2256 (class 0 OID 0)
-- Dependencies: 198
-- Name: solarsystem_id_seq; Type: SEQUENCE SET; Schema: public; Owner: potyi
--

SELECT pg_catalog.setval('solarsystem_id_seq', 2, true);


-- Completed on 2017-11-23 19:28:06 CET

--
-- PostgreSQL database dump complete
--
INSERT INTO amenitytype VALUES (1,'wifi', 'space');
INSERT INTO amenitytype VALUES (2,'melegviz', 'kave');
INSERT INTO amenitytype VALUES (3,'tengerpart', 'lo');

INSERT INTO accomodation_amenity_types VALUES (1,1);
INSERT INTO accomodation_amenity_types VALUES (1,2);
INSERT INTO accomodation_amenity_types VALUES (1,3);

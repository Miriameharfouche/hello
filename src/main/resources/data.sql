INSERT INTO BUILDING(ID) VALUES(-10);

INSERT INTO ROOM(ID, NAME, FLOOR,BUILDING_ID) VALUES(-10, 'Room1', 1, -10);
INSERT INTO ROOM(ID, NAME, FLOOR,BUILDING_ID) VALUES(-9, 'Room2', 1, -10);

INSERT INTO LIGHT(ID, LEVEL, STATUS, ROOM_ID) VALUES (-1, 8, 'ON', -10);
INSERT INTO LIGHT(ID, LEVEL, STATUS, ROOM_ID) VALUES (-2, 0, 'OFF', -10);
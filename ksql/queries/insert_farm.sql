INSERT INTO FARM (ID, HAYSTACK) VALUES ('1', ARRAY[STRUCT(TYPE:='HAY',ID:='1'), STRUCT(TYPE:='NEEDLE',ID:='2'), STRUCT(TYPE:='HAY',ID:='1')]);
INSERT INTO FARM (ID, HAYSTACK) VALUES ('2', ARRAY[STRUCT(TYPE:='HAY',ID:='1'), STRUCT(TYPE:='HAY',ID:='1'), STRUCT(TYPE:='NEEDLE',ID:='2')]);
INSERT INTO FARM (ID, HAYSTACK) VALUES ('3', ARRAY[STRUCT(TYPE:='NEEDLE',ID:='2'), STRUCT(TYPE:='HAY',ID:='1'), STRUCT(TYPE:='HAY',ID:='1')]);
+---------------------------------------------------------------+
|NEEDLE                                                         |
+---------------------------------------------------------------+
|{TYPE=NEEDLE, ID=2}                                            |
|{TYPE=NEEDLE, ID=2}                                            |
|{TYPE=NEEDLE, ID=2}                                            |
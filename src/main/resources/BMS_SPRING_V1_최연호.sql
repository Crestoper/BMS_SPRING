--------------------------------------------------------
--  ������ ������ - ������-7��-12-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BOARD
--------------------------------------------------------

  CREATE TABLE "BMS_CYH"."BOARD" 
   (	"NUM" NUMBER(5,0), 
	"WRITER" VARCHAR2(20 BYTE), 
	"SUBJECT" VARCHAR2(50 BYTE) DEFAULT '������ �����ϴ�.', 
	"PASSWD" VARCHAR2(10 BYTE), 
	"CONTENT" VARCHAR2(1000 BYTE), 
	"READCNT" NUMBER(5,0) DEFAULT 0, 
	"REF" NUMBER(5,0) DEFAULT 0, 
	"REF_STEP" NUMBER(5,0) DEFAULT 0, 
	"REF_LEVEL" NUMBER(5,0) DEFAULT 0, 
	"REG_DATE" TIMESTAMP (6) DEFAULT sysdate
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table BOOK
--------------------------------------------------------

  CREATE TABLE "BMS_CYH"."BOOK" 
   (	"ISBN" VARCHAR2(260 BYTE), 
	"TITLE" VARCHAR2(1280 BYTE), 
	"SUBTITLE" VARCHAR2(1280 BYTE), 
	"AUTHOR" VARCHAR2(2600 BYTE), 
	"TRANS" VARCHAR2(2600 BYTE), 
	"PUBLISHER" VARCHAR2(260 BYTE), 
	"DATE1" DATE, 
	"ORIGIN" VARCHAR2(2560 BYTE), 
	"PRICE" VARCHAR2(260 BYTE), 
	"PERCENT" VARCHAR2(100 BYTE), 
	"POINT" VARCHAR2(260 BYTE), 
	"CATEGORY" VARCHAR2(260 BYTE), 
	"COUNT" VARCHAR2(260 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table GUEST
--------------------------------------------------------

  CREATE TABLE "BMS_CYH"."GUEST" 
   (	"GUESTNUM" NUMBER(8,0), 
	"GUESTID" VARCHAR2(10 BYTE), 
	"GUESTPW" VARCHAR2(20 BYTE), 
	"GUESTNAME" VARCHAR2(10 BYTE), 
	"GUESTBIRTH" DATE, 
	"GUESTADDR" VARCHAR2(200 BYTE), 
	"GUESTEMAIL" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table SALESINFO
--------------------------------------------------------

  CREATE TABLE "BMS_CYH"."SALESINFO" 
   (	"SALESNUM" NUMBER(8,0), 
	"GUESTID" VARCHAR2(20 BYTE), 
	"SALESDAY" DATE DEFAULT sysdate, 
	"ISBN" VARCHAR2(100 BYTE), 
	"SALESSTOCK" NUMBER(4,0), 
	"STATE" VARCHAR2(1 BYTE), 
	"CLOSING" NUMBER(20,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into BMS_CYH.BOARD
SET DEFINE OFF;
Insert into BMS_CYH.BOARD (NUM,WRITER,SUBJECT,PASSWD,CONTENT,READCNT,REF,REF_STEP,REF_LEVEL,REG_DATE) values (68,'1','12','12','12',3,64,0,0,to_timestamp('17/07/04 06:55:21.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into BMS_CYH.BOARD (NUM,WRITER,SUBJECT,PASSWD,CONTENT,READCNT,REF,REF_STEP,REF_LEVEL,REG_DATE) values (72,'1','13','1','13',0,64,2,1,to_timestamp('17/07/04 07:03:16.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into BMS_CYH.BOARD (NUM,WRITER,SUBJECT,PASSWD,CONTENT,READCNT,REF,REF_STEP,REF_LEVEL,REG_DATE) values (73,'1','77','1','77',1,64,1,1,to_timestamp('17/07/04 07:06:17.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into BMS_CYH.BOARD (NUM,WRITER,SUBJECT,PASSWD,CONTENT,READCNT,REF,REF_STEP,REF_LEVEL,REG_DATE) values (74,'1','22','1','22',2,74,0,0,to_timestamp('17/07/04 07:10:36.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into BMS_CYH.BOARD (NUM,WRITER,SUBJECT,PASSWD,CONTENT,READCNT,REF,REF_STEP,REF_LEVEL,REG_DATE) values (75,'1','23','1','23',1,74,1,1,to_timestamp('17/07/04 07:10:49.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into BMS_CYH.BOARD (NUM,WRITER,SUBJECT,PASSWD,CONTENT,READCNT,REF,REF_STEP,REF_LEVEL,REG_DATE) values (61,'1','1','1','1',0,1,0,0,to_timestamp('17/07/04 06:22:46.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into BMS_CYH.BOARD (NUM,WRITER,SUBJECT,PASSWD,CONTENT,READCNT,REF,REF_STEP,REF_LEVEL,REG_DATE) values (67,'1','5','5','5',4,64,0,0,to_timestamp('17/07/04 06:53:02.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into BMS_CYH.BOARD (NUM,WRITER,SUBJECT,PASSWD,CONTENT,READCNT,REF,REF_STEP,REF_LEVEL,REG_DATE) values (69,'1','15','1','15',0,64,5,1,to_timestamp('17/07/04 06:57:26.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into BMS_CYH.BOARD (NUM,WRITER,SUBJECT,PASSWD,CONTENT,READCNT,REF,REF_STEP,REF_LEVEL,REG_DATE) values (63,'1','1','1','1',1,1,0,0,to_timestamp('17/07/04 06:28:04.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into BMS_CYH.BOARD (NUM,WRITER,SUBJECT,PASSWD,CONTENT,READCNT,REF,REF_STEP,REF_LEVEL,REG_DATE) values (41,'host','1','1','1',2,1,0,0,to_timestamp('17/06/28 14:31:33.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into BMS_CYH.BOARD (NUM,WRITER,SUBJECT,PASSWD,CONTENT,READCNT,REF,REF_STEP,REF_LEVEL,REG_DATE) values (42,'host','2','2','2',0,1,1,1,to_timestamp('17/06/28 14:31:41.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into BMS_CYH.BOARD (NUM,WRITER,SUBJECT,PASSWD,CONTENT,READCNT,REF,REF_STEP,REF_LEVEL,REG_DATE) values (64,'1','1','1','1',3,64,0,0,to_timestamp('17/07/04 06:46:45.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into BMS_CYH.BOARD (NUM,WRITER,SUBJECT,PASSWD,CONTENT,READCNT,REF,REF_STEP,REF_LEVEL,REG_DATE) values (44,'1','������ ����1','host','�����ڿ� ���� ������ ���Դϴ�.',10,43,1,1,to_timestamp('17/06/28 14:32:07.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into BMS_CYH.BOARD (NUM,WRITER,SUBJECT,PASSWD,CONTENT,READCNT,REF,REF_STEP,REF_LEVEL,REG_DATE) values (65,'1','2','2','2',18,64,0,0,to_timestamp('17/07/04 06:46:59.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into BMS_CYH.BOARD (NUM,WRITER,SUBJECT,PASSWD,CONTENT,READCNT,REF,REF_STEP,REF_LEVEL,REG_DATE) values (70,'1','16','1','16',0,64,4,1,to_timestamp('17/07/04 06:59:47.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into BMS_CYH.BOARD (NUM,WRITER,SUBJECT,PASSWD,CONTENT,READCNT,REF,REF_STEP,REF_LEVEL,REG_DATE) values (76,'1','123','1','123',0,76,0,0,to_timestamp('17/07/05 10:44:37.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into BMS_CYH.BOARD (NUM,WRITER,SUBJECT,PASSWD,CONTENT,READCNT,REF,REF_STEP,REF_LEVEL,REG_DATE) values (77,'1','123','1','123',3,77,0,0,to_timestamp('17/07/05 10:46:48.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into BMS_CYH.BOARD (NUM,WRITER,SUBJECT,PASSWD,CONTENT,READCNT,REF,REF_STEP,REF_LEVEL,REG_DATE) values (81,'1','123123123','1','123123123',1,78,0,0,to_timestamp('17/07/07 21:10:44.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into BMS_CYH.BOARD (NUM,WRITER,SUBJECT,PASSWD,CONTENT,READCNT,REF,REF_STEP,REF_LEVEL,REG_DATE) values (66,'1','1','1','1',2,64,0,0,to_timestamp('17/07/04 06:51:47.000000000','RR/MM/DD HH24:MI:SSXFF'));
Insert into BMS_CYH.BOARD (NUM,WRITER,SUBJECT,PASSWD,CONTENT,READCNT,REF,REF_STEP,REF_LEVEL,REG_DATE) values (71,'1','17','1','17',0,64,3,1,to_timestamp('17/07/04 07:00:33.000000000','RR/MM/DD HH24:MI:SSXFF'));
REM INSERTING into BMS_CYH.BOOK
SET DEFINE OFF;
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8932029997','������ ���',null,'�Ѱ�',null,'���а������� ',to_date('17/04/17','RR/MM/DD'),null,'21000','2','1050','����','99816');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8954645062','����ö ���� ����Ų�� ��� - ��',null,'����ڿ� ȣ���',null,'�����ø� ',to_date('17/04/17','RR/MM/DD'),null,'12000','2','600','����','58');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('k492535338','�ñ׳� 1',null,'������',null,'��ܽ� ',to_date('16/11/01','RR/MM/DD'),null,'14000','2','600','����','49');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8994040986','���̺������� ������',null,'������, ������',null,'��å',to_date('16/12/28','RR/MM/DD'),null,'11000','2','600','����','35');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('s072536178','������ �غ��� ��Ʈ',null,'������ ',null,'���ȴ�',to_date('17/02/06','RR/MM/DD'),null,'42000','7','600','����','30');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8937434059','�Ķ��� ����','�Ķ����� ��� ��� �̵��� ����� �ް� �Ǿ��°�','�̼� �Ľ�����','�����','������',to_date('17/03/03','RR/MM/DD'),null,'16800','7','600','����','70');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8961962892','���� ������ ����̼�','��Ƽ��Ʈ 10�ΰ��� ģ���� ��ȭ','Ķ�� ��Ų��','�輼��, �����','��Ʈ�Ͻ�',to_date('17/03/29','RR/MM/DD'),'Lives of the Artists','21000','7','600','����','70');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('k072530233','���� ����� ����',null,'�̰��,������',null,'����ε�',to_date('17/03/29','RR/MM/DD'),null,'13000','7','600','����','80');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('k092530745','���� ���� ����� �ٶ󺸾Ҵ�','�������� ��ȭ�� �ϱ�','������',null,'��ũ�ν�',to_date('17/03/29','RR/MM/DD'),null,'14000','7','600','����','80');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8930088147','��ȭ�� �ǹ��� Ž�� 1','��� - ��ü - ���','������ ������Ű','���ȯ, ������','��������',to_date('17/03/15','RR/MM/DD'),null,'21000','7','600','����','80');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8968483515','NDC Art Book 2017','2017�� �ؽ� ������ ���۷��� ��Ʈ ����ȸ','�ؽ�',null,'�Ѻ��̵��',to_date('17/04/24','RR/MM/DD'),null,'20000','7','600','����','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8954641636','������ �̼�',null,'������',null,'���е���',to_date('16/07/07','RR/MM/DD'),null,'17000','7','600','����','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8954645089','��� ���� �η�',null,'�պ���',null,'���е���',to_date('16/04/19','RR/MM/DD'),null,'13500','7','600','����','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8952777956','������� ���� �� ������ Vol.3','������� �𽺾�����','�� �귡���','�̱Կ� ','�ð���(��ȭ)',to_date('17/03/25','RR/MM/DD'),'Guardians of the Galaxy VOL. 3 Guardians Disassembled','14000','3','600','��ȭ','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8952777964','������� ���� �� ������ Vol.4','����','�߷����� ��ŰƼ','�̱Կ�','�ð���(��ȭ)',to_date('17/04/25','RR/MM/DD'),'Guardians of the Galaxy VOL. 4 Original Sin','12000','3','600','��ȭ','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8952778014','���۸� ��ü�ε�',null,'�˷��� ��Ŭ����','�̱Կ�','�ð���(��ȭ)',to_date('17/04/25','RR/MM/DD'),'Superman Unchained','27000','3','600','��ȭ','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('s962536178','�簡 Vol. 1','�ð��׷��ȳ��','�ǿ��� �������ý�','�̼���','�ð���(��ȭ)',to_date('17/01/25','RR/MM/DD'),'Saga Volume one','13000','3','600','��ȭ','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8952777972','����� : �õ� �� �ΰ�',null,'��ũ �з�, ��Ƽ�� �ƴϺ�','������','�ð���(��ȭ)',to_date('17/03/05','RR/MM/DD'),'Wolverine: Old Man Logan','19000','3','600','��ȭ','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8952778006','(�� 52) ��Ʈ�� 9 : ���',null,'���� �����̴�, ��� ��Ű','�̱Կ�','�ð���(��ȭ)',to_date('17/03/25','RR/MM/DD'),'(The New 52) Batman Vol.9 : Bloom','17000','3','600','��ȭ','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8952778219','��� ��Ʈ�� Book 1','��� ���� l','���� ��纣��Ŀ','������','�ð���(��ȭ)',to_date('17/04/25','RR/MM/DD'),'Gotham Central Book 1: In The Line Of Duty (2017��)','20000','3','600','��ȭ','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8998171341','���� õ�縦 �̱��','1+1�� 10���� ����� ���� ��','����Ŭ ����','�輺�� ','Ʒ��',to_date('17/04/14','RR/MM/DD'),'Team genius (2015��) ','15000','3','750','��ȸ','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8925561646','���� ���','���ο� �̷��� �߰��ϴ� ���� �ν��� Ʋ ','�µ� Ȧ','������','�˿���ġ�ڸ���(RHK)',to_date('17/04/17','RR/MM/DD'),'Competing against luck (2016��)','20000','5','1000','��ȸ','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('k042530231','������ �м���� �̷��� �̷������','���� ���� Ʈ���� �缱�� ��Ȯ�� ������ ������ ������ ���� ������ ��� ����!','������ ',null,'���ϰ����Ź���',to_date('17/03/31','RR/MM/DD'),null,'15000','7','750','��ȸ','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8932918279','���ĵ� �ƿ�',null,'���� Ŭ��ũ','�ڼ��� ','����å�� ',to_date('17/03/30','RR/MM/DD'),'Stand out (2015��)','15000','2','750','��ȸ','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('k192530948','����Ʈ ���ε�','������ �����ϴ� ������� ������ �� ���� ','���� ��÷','���鸸 ','���������� ',to_date('17/03/30','RR/MM/DD'),'ELITE MINDS (2016��)','24000','4','1200','��ȸ','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('k162530537','Ÿ��ź�� ������','1�� �ð��� ��Ģ�� �� ���ε��� 61���� ���� ','�� �丮��','������ ','����̵� ',to_date('17/04/03','RR/MM/DD'),'Tools of titans (2017��)','11000','9','550','��ȸ','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('k322536390','���ǽ��� �����ϴ� ��� ���ǽĿ� ������ϴ� ���',null,'������ �����','���ؿ�','����Ͻ�(���繮��)',to_date('17/03/10','RR/MM/DD'),'�����Ⱓ 2015��','19000','4','950','��ȸ','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8947541931','���ǴϽ� Ʈ��','�����۵���б��� �ָ��� �ູ������ ','���� ���ȶ�','�̼���','�ѱ������Ź�',to_date('17/04/20','RR/MM/DD'),'The happiness track (2016��)','15000','1','750','��ȸ','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('k102530543','�ֿ�ȨƮ �ƽø�','������� ������ ���ִ� ���ĸ�Ÿ Ʈ���̴� l �ֿ�ȨƮ','���ֿ�',null,'����������',to_date('17/04/15','RR/MM/DD'),null,'13500','3','600','������','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('k992536565','������ı� ��� 2��1��1 �Ĵ�','������ı� ��� �Ļ���� ���� �ִ�!','���⼱',null,'���������丮',to_date('17/01/13','RR/MM/DD'),null,'15800','3','600','������','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('s372536483','������ ì���ִ� û�ҳ��� ��ħ �Ļ�','���δ� ü��! ü���� ��ħ��!','�̳���',null,'���������丮',to_date('17/01/13','RR/MM/DD'),null,'15800','3','600','������','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('k702536489','�˼� ���','���� ����, �������� ź���� ���� �Ǹ� Ʈ���̴�','�� ���̵�','����ȭ','��Ÿ�Ͻ�',to_date('17/02/24','RR/MM/DD'),'Convict Conditioning (2009��)','22000','3','600','������','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('k112530949','���� �ǰ� ���ڸ� ����','(���� ��θ��̵� 2��)','�����ǰ�����ȸ, �����',null,'������',to_date('17/04/03','RR/MM/DD'),null,'3500','3','600','������','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8997008307','���� ���� �����̴�','�ż��� �ǿ� ���� ����ü�̴�.','����',null,'�ϸ�',to_date('17/04/03','RR/MM/DD'),null,'17000','3','600','������','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('k212530450','�� ���� �������� ��ٴ� ��','���� ������ ��¥ ���� �����ϴ� ������ ȸ�� Ŭ����','��Ǽ�',null,'å��������',to_date('17/04/24','RR/MM/DD'),null,'15000','3','600','�ڱ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('k682530352','�����ϴ� �ϸ� �ϸ� ����ְ� �� �� ������?',null,'��ī��� ���ν�','������','�Ƴ��α�(�۴�)',to_date('17/05/05','RR/MM/DD'),null,'13000','3','600','�ڱ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8960515906','����� ����','�λ��� Ȧ�� ���� ���� �� �̵鿡�� �ǳ״� ���� ���� ����','���� ȣũ','���̿�','��Ű',to_date('17/04/14','RR/MM/DD'),'Rules for a Knight : The Last Letter of Sir Thomas Lemuel Hawke','12000','3','600','�ڱ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('k512530855','�Ϸ� 30���� ��','����� �̷��� �ٲٴ� ������ �ð� ����','�����',null,'����Ͻ��Ͻ�',to_date('17/04/20','RR/MM/DD'),null,'12800','3','600','�ڱ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('k512530155','�λ��� �������� �ټ� ���� ����',null,'�ι�Ʈ ����Ŭ','�ȱ��','å����',to_date('17/04/20','RR/MM/DD'),'The Five Life Decisions: How Economic Principles and 18 Million Millennials Can Guide Your Thinking','15000','3','600','�ڱ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8984076252','ȣ�� ����ġ�� �Ѷ�','�ƹ��� ��ĥ�� ����� �� ������ ����� FBI ������ �ɸ���','���� Į����','�����','��������',to_date('17/04/28','RR/MM/DD'),'The Like Switch: An Ex-FBI Agent��s Guide to Influencing, Attracting, and Winning People Over','16000','3','600','�ڱ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('s372530546','��·�ų� ���̿���','�� �̻� ���� ����ϴ��� ��ó���� �ʰڴ�','�ȵ巹�� ����','�Ӱ���','ȫ�����ǻ�',to_date('17/04/20','RR/MM/DD'),'52 Ways to Live a Kick-Ass Life: BS-Free Wisdom to Ignite Your Inner Badass and Live the Life You Deserve','14800','3','600','�ڱ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('k862530742','�Ϸ� 1�� �׸�����','���� ���� �γ�ȸ���� ����','YM��ȹ','���ſ�','�����Ͻ�',to_date('17/03/31','RR/MM/DD'),null,'12800','3','600','�ڱ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8935211672','�Ϸ� 2�ð� ������ ��','���� ���� �� ����ϰ� ��ġ��� �������� ���','���� ���̺�','�ڽ���','û������',to_date('17/04/24','RR/MM/DD'),null,'13500','3','600','�ڱ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('k662530939','���� �ϳ� �ٲ��� ���ε�','��, ���, ���谡 ���� Ǯ���� 40���� �ɸ� ���','������ �������','���ѳ�','����Ͻ�',to_date('17/03/10','RR/MM/DD'),null,'13000','3','600','�ڱ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8925561239','������ �ɸ���','97%�� ����� �� ����� �����ϴ�','�ι̿� �ε帮�Խ� �ִϾ�','���ϰ�','�˿���ġ�ڸ���(RHK)',to_date('17/03/13','RR/MM/DD'),null,'13000','3','600','�ڱ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('k162530353','���ķ�','����� ö�п��� ���� ''������ ����� �ٲٴ� ��''','���̾� Ȧ������','������','���ö�����',to_date('17/04/28','RR/MM/DD'),'The obstacle is the way ','14000','3','600','�ڱ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('893743346x','���� ����','���� �� ���ݾ� �λ��� �ٲٴ� ������ ��','�Ƹ��Ƴ� ������','������','������',to_date('16/09/05','RR/MM/DD'),'The Sleep Revolution: Transforming Your Life, One Night at a Time','16800','3','600','�ڱ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8965703972','�װ��� ���� ����� ���δ�','���� ����� �ް� ���� ����� ���ϴ� Ư���� ����� ���','���ȣ',null,'�ܾ���Ŀ��',to_date('17/03/15','RR/MM/DD'),null,'15000','3','600','�ڱ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8943310587','���ܳ��� ��','4���� �׸�å l 4���� �׸�å','��Ʈ���Ʈ ���ܳ� ������','������','����',to_date('17/03/15','RR/MM/DD'),'Nacht-Wimmelbuch','15000','3','600','�Ƶ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8955823908','�ƺ��� �޷�����! l �迵�� �׸�å 6',null,'�迵��',null,'������',to_date('17/04/25','RR/MM/DD'),null,'12000','3','600','�Ƶ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('k512531861','���� ���� �������� ���� ū ����',null,'����Ÿ ���׽�','������','���ĸ�',to_date('17/05/01','RR/MM/DD'),'Little monkey','10800','3','600','�Ƶ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('k942531862','��� ������ 75���� ���߷� ���� ī��',null,'�� �Ǳ�','�����ٹ�','����ڸ���',to_date('17/04/27','RR/MM/DD'),null,'8500','3','600','�Ƶ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('k702530650','�Ӹ� ���� ã��å : ������ ����ã�� l �Ӹ� ���� ã��å',null,'�ӱԼ�',null,'�����߾��',to_date('17/04/28','RR/MM/DD'),null,'6500','3','600','�Ƶ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('s672530550','�˵�, ���̰� ����!','��Ȱ ���� �̾߱� l ������ ���빮ȭ �׸�å 5','��ȫ��','�ӿ���','������',to_date('17/05/10','RR/MM/DD'),null,'11800','3','600','�Ƶ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('s652530150','���� ������',null,'������ �� ������','������','�Ѽּ���',to_date('17/04/03','RR/MM/DD'),null,'13000','3','600','�Ƶ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('k452530554','�ƹ��� ������ �� �̾߱�','�Ƹ��ϰ� ���� �ڽ��� ã�ư��� ���� ��ȭ','���� ���','������','��������',to_date('17/05/10','RR/MM/DD'),'Der bar, der nicht da war','11000','3','600','�Ƶ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8915104234','���� ����簡 �� �ž�!',null,'Ƽ�ư� �Ƹ޸���','�Ｚ���ǻ�������','�Ｚ���ǻ�',to_date('17/04/01','RR/MM/DD'),null,'8800','3','600','�Ƶ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('k392530458','���󿡼� ���� ���� ������ �׸�����',null,'�� ������','������','�����߾��',to_date('17/04/24','RR/MM/DD'),null,'22000','3','600','�Ƶ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8970949690','����',null,'��Ź��',null,'�Ѹ����ǻ�',to_date('17/04/20','RR/MM/DD'),null,'11000','3','600','�Ƶ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('k102530157','�Ƿη� ��� ������ ��� ���� 2 : �̷γ���',null,'Ű������� ������',null,'Ű�������',to_date('17/04/18','RR/MM/DD'),null,'10000','3','600','�Ƶ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('892556100x','�尡�� ��å l MoMA ���� ������ �׸�å',null,'ũ����Ƽ�� �ǿ�����','�ּ���','�ִϾ�RHK(�ִϾ��)',to_date('17/04/05','RR/MM/DD'),null,'25000','3','600','�Ƶ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('k592434587','��� JAVA�� ó������!',null,'õ�α�',null,'���Ǵ�Ƽ�Ͻ�',to_date('15/11/25','RR/MM/DD'),null,'33000','3','600','�ڱ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8925561000','�� ������ ���� �׷��� �װ� �׸� �� �ִ� �� ũ�� �װ� �� ��ŭ �� �����',null,'���¿�',null,'�����',to_date('93/05/01','RR/MM/DD'),null,'3500','3','600','����','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8993964041','������ �����',null,'�ٿͶ� ��ġ','������','����',to_date('09/11/20','RR/MM/DD'),'����� ���ͪ��','23000','3','600','����','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('1674230','�� ���ؼ����',null,'å������� ������',null,'å�������',to_date('98/12/20','RR/MM/DD'),null,'6000','3','600','����','53');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('1674240','�� ���� �غ��߾�',null,'�ؼ��̾��� ������',null,'å�������',to_date('98/06/15','RR/MM/DD'),null,'5400','3','600','����','78');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('893746005x','��������','������ ���蹮������ 5','���� ����','������','������',to_date('98/08/05','RR/MM/DD'),'Animal Farm','5400','3','600','����','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8949702924','��� 1',null,'�߸���ī ����ġ','������','������ȭ����(������ȭ��)',to_date('05/04/01','RR/MM/DD'),' �����Ⱓ 1967�� ','12800','3','600','����','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8970755373','������ ������ 1 : ������ ������ ����','������ ������ �ø��� 1','���̸� ����ũ �ٿ�','������','���м����',to_date('12/12/20','RR/MM/DD'),'The Wonderful Wizard of OZ','10500','3','600','�Ƶ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8949701723','�¾��� ������','���� �̽��͸� �Ͻ� 87','��Ʈ���� ���̽��̽�','�蹮��','������ȭ����(������ȭ��)',to_date('03/06/01','RR/MM/DD'),'The Talented Mr. Ripley','7800','3','600','����','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('1358387338','�Ƶ��󸣳� ������ �ƺ����������� ����',null,'����긮��','�Ű���','����',to_date('03/02/20','RR/MM/DD'),null,'7000','3','600','����','43');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('6000802448','�� �ҿ��� ����','������ ���蹮������ 203','��ũ Ʈ����','���','������',to_date('09/03/13','RR/MM/DD'),'The Adventures of Tom Sawyer','11000','3','600','�Ƶ�','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('6000781928','��Ŭ���� ���� ����','������ ���蹮������ 6','��ũ Ʈ����','���','������',to_date('98/08/05','RR/MM/DD'),'The Adventures of Huckleberry Finn','11000','3','600','�Ƶ�','98');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8970635262','���� 2���� 1','�� ���� ���ۼ�','�� ����','�輮��','������',to_date('07/01/22','RR/MM/DD'),'Vingt Mille Heues Sous Les Mers ','12000','3','600','����','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8937462842','�˿� �� 1','������ ���蹮������ 284','ǥ���� �����俹����Ű','�迬��','������',to_date('12/03/30','RR/MM/DD'),'����֬����ݬ֬߬ڬ� �� �߬ѬܬѬ٬Ѭ߬ڬ�','10000','3','600','����','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('6000797176','ī������ ���� ������ 1','������ ���蹮������ 154','ǥ���� �����俹����Ű','�迬��','������',to_date('07/09/20','RR/MM/DD'),'����Ѭ��� ���Ѭ�ѬެѬ٬�Ӭ�','9500','3','600','����','79');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('6000826237','�˴ٸ�Ÿ','������ ���蹮������ 58','�츣�� �켼','�ں���','������',to_date('02/01/20','RR/MM/DD'),'Siddhartha','7000','3','600','����','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8925244926','������! ����� �������� 4','�콺Ÿ �콺��','�콺Ÿ �콺��',null,'���������(��ȭ)',to_date('09/05/29','RR/MM/DD'),null,'9500','3','600','��ȭ','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('8925234505','�߸���~ �Ҿ��! ��Ծ� 1','����� ''������ ����''','�콺Ÿ �콺��',null,'���������(��ȭ)',to_date('03/10/15','RR/MM/DD'),null,'4200','3','600','��ȭ','100');
Insert into BMS_CYH.BOOK (ISBN,TITLE,SUBTITLE,AUTHOR,TRANS,PUBLISHER,DATE1,ORIGIN,PRICE,PERCENT,POINT,CATEGORY,COUNT) values ('k582535393','����� �µ�','���� �ۿ��� ������ �����԰� �������� �ִ�','�̱���',null,'������',to_date('16/08/19','RR/MM/DD'),null,'12000','3','600','����','100');
REM INSERTING into BMS_CYH.GUEST
SET DEFINE OFF;
Insert into BMS_CYH.GUEST (GUESTNUM,GUESTID,GUESTPW,GUESTNAME,GUESTBIRTH,GUESTADDR,GUESTEMAIL) values (144,'asdf','asdf1234!','�ֿ�ȣ',null,'@',null);
Insert into BMS_CYH.GUEST (GUESTNUM,GUESTID,GUESTPW,GUESTNAME,GUESTBIRTH,GUESTADDR,GUESTEMAIL) values (161,'fasd','asdf1234!','��ȣ',null,'@',null);
Insert into BMS_CYH.GUEST (GUESTNUM,GUESTID,GUESTPW,GUESTNAME,GUESTBIRTH,GUESTADDR,GUESTEMAIL) values (122,'host','host','host',null,'@',null);
Insert into BMS_CYH.GUEST (GUESTNUM,GUESTID,GUESTPW,GUESTNAME,GUESTBIRTH,GUESTADDR,GUESTEMAIL) values (123,'1','1','1',to_date('17/06/01','RR/MM/DD'),'@',null);
Insert into BMS_CYH.GUEST (GUESTNUM,GUESTID,GUESTPW,GUESTNAME,GUESTBIRTH,GUESTADDR,GUESTEMAIL) values (181,'test','test1!test','�׽�Ʈ',to_date('13/10/29','RR/MM/DD'),'@','test@test.com');
REM INSERTING into BMS_CYH.SALESINFO
SET DEFINE OFF;
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (121,'1',to_date('17/07/03','RR/MM/DD'),'1358387338',10,'4',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (125,'1',to_date('17/07/04','RR/MM/DD'),'1358387338',5,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (126,'1',to_date('17/07/04','RR/MM/DD'),'1674230',5,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (84,'1',to_date('17/06/26','RR/MM/DD'),'8932029997',2,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (85,'1',to_date('17/06/26','RR/MM/DD'),'8954645062',12,'3',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (86,'1',to_date('17/06/26','RR/MM/DD'),'k492535338',10,'4',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (87,'1',to_date('17/06/26','RR/MM/DD'),'8954645062',5,'3',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (88,'1',to_date('17/06/26','RR/MM/DD'),null,null,'4',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (90,'1',to_date('17/06/26','RR/MM/DD'),'8954645062',3,'4',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (91,'1',to_date('17/06/26','RR/MM/DD'),'8954645062',5,'4',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (92,'1',to_date('17/06/27','RR/MM/DD'),'8954645062',10,'4',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (95,'1',to_date('17/06/27','RR/MM/DD'),'8954645062',10,'4',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (96,'1',to_date('17/06/27','RR/MM/DD'),'8954645062',10,'4',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (97,'1',to_date('17/06/27','RR/MM/DD'),'8954645062',10,'3',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (98,'1',to_date('17/06/27','RR/MM/DD'),'8954645062',10,'3',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (99,'2',to_date('17/06/27','RR/MM/DD'),'k072530233',10,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (100,'2',to_date('17/06/27','RR/MM/DD'),'k092530745',10,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (101,'2',to_date('17/06/27','RR/MM/DD'),'8930088147',10,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (102,'2',to_date('17/06/27','RR/MM/DD'),'8937434059',10,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (103,'2',to_date('17/06/27','RR/MM/DD'),'8961962892',10,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (104,'2',to_date('17/06/27','RR/MM/DD'),'s072536178',10,'4',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (122,'1',to_date('17/07/03','RR/MM/DD'),'1358387338',10,'4',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (123,'1',to_date('17/07/03','RR/MM/DD'),'1674230',10,'4',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (81,'1',to_date('17/06/26','RR/MM/DD'),'8932029997',5,'3',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (82,'1',to_date('17/06/26','RR/MM/DD'),'8932029997',10,'3',210000);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (83,'1',to_date('17/06/26','RR/MM/DD'),'8954645062',10,'1',120000);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (93,'1',to_date('17/06/27','RR/MM/DD'),'8954645062',10,'4',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (94,'1',to_date('17/06/27','RR/MM/DD'),'8954645062',10,'4',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (124,'test',to_date('17/07/04','RR/MM/DD'),'s072536178',10,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (127,'1',to_date('17/07/04','RR/MM/DD'),'1358387338',10,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (128,'1',to_date('17/07/04','RR/MM/DD'),'1358387338',10,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (129,'1',to_date('17/07/04','RR/MM/DD'),'1674230',10,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (130,'1',to_date('17/07/04','RR/MM/DD'),'1674240',10,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (131,'1',to_date('17/07/04','RR/MM/DD'),'6000797176',10,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (132,'1',to_date('17/07/04','RR/MM/DD'),'1358387338',1,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (133,'1',to_date('17/07/04','RR/MM/DD'),'1674230',1,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (134,'1',to_date('17/07/04','RR/MM/DD'),'1674240',1,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (135,'1',to_date('17/07/04','RR/MM/DD'),'6000781928',1,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (136,'1',to_date('17/07/04','RR/MM/DD'),'6000797176',1,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (146,'1',to_date('17/07/06','RR/MM/DD'),'8932029997',1,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (147,'1',to_date('17/07/06','RR/MM/DD'),'8954645062',1,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (148,'1',to_date('17/07/06','RR/MM/DD'),'k492535338',1,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (149,'1',to_date('17/07/06','RR/MM/DD'),'8932029997',1,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (150,'1',to_date('17/07/06','RR/MM/DD'),'8954645062',1,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (161,'1',to_date('17/07/07','RR/MM/DD'),'k492535338',7,'0',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (105,'asdf',to_date('17/06/29','RR/MM/DD'),'8932029997',10,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (106,'asdf',to_date('17/06/29','RR/MM/DD'),'8954645062',10,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (137,'1',to_date('17/07/04','RR/MM/DD'),'1358387338',10,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (138,'1',to_date('17/07/04','RR/MM/DD'),'1674230',10,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (139,'1',to_date('17/07/04','RR/MM/DD'),'1674240',10,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (140,'1',to_date('17/07/04','RR/MM/DD'),'6000797176',10,'2',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (141,'1',to_date('17/07/04','RR/MM/DD'),'1358387338',1,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (142,'1',to_date('17/07/04','RR/MM/DD'),'1674230',1,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (143,'1',to_date('17/07/04','RR/MM/DD'),'1674240',1,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (144,'1',to_date('17/07/04','RR/MM/DD'),'6000781928',1,'1',null);
Insert into BMS_CYH.SALESINFO (SALESNUM,GUESTID,SALESDAY,ISBN,SALESSTOCK,STATE,CLOSING) values (145,'1',to_date('17/07/04','RR/MM/DD'),'6000797176',1,'4',null);
--------------------------------------------------------
--  DDL for Index SYS_C007166
--------------------------------------------------------

  CREATE UNIQUE INDEX "BMS_CYH"."SYS_C007166" ON "BMS_CYH"."BOARD" ("NUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007093
--------------------------------------------------------

  CREATE UNIQUE INDEX "BMS_CYH"."SYS_C007093" ON "BMS_CYH"."BOOK" ("ISBN") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007147
--------------------------------------------------------

  CREATE UNIQUE INDEX "BMS_CYH"."SYS_C007147" ON "BMS_CYH"."GUEST" ("GUESTID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table BOARD
--------------------------------------------------------

  ALTER TABLE "BMS_CYH"."BOARD" ADD PRIMARY KEY ("NUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "BMS_CYH"."BOARD" MODIFY ("PASSWD" NOT NULL ENABLE);
  ALTER TABLE "BMS_CYH"."BOARD" MODIFY ("WRITER" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table BOOK
--------------------------------------------------------

  ALTER TABLE "BMS_CYH"."BOOK" ADD PRIMARY KEY ("ISBN")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table GUEST
--------------------------------------------------------

  ALTER TABLE "BMS_CYH"."GUEST" ADD PRIMARY KEY ("GUESTID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "BMS_CYH"."GUEST" MODIFY ("GUESTNAME" NOT NULL ENABLE);
  ALTER TABLE "BMS_CYH"."GUEST" MODIFY ("GUESTPW" NOT NULL ENABLE);
  ALTER TABLE "BMS_CYH"."GUEST" MODIFY ("GUESTNUM" NOT NULL ENABLE);

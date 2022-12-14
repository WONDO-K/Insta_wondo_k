DROP TABLE MJOIN;
DROP TABLE MPOST;
DROP TABLE MTAG;
DROP TABLE POST_TAG;
DROP TABLE MFOLLOW;
DROP TABLE MLIKE;
DROP TABLE MREPLY;
DROP TABLE MDM;
DROP TABLE MFOLLOW;


CREATE TABLE MJOIN(
     EMAIL VARCHAR2(50) PRIMARY KEY,
     NICKNAME VARCHAR2(50) UNIQUE,
     PASSWORD VARCHAR2(50) NOT NULL,
     NAME VARCHAR2(30) NOT NULL,
     TEL VARCHAR2(30) NOT NULL,
     JOINDATE DATE DEFAULT SYSDATE,
     P_THUMBNAIL VARCHAR2(200) DEFAULT 'default.png',
     P_INTRODUCE VARCHAR2(1000)
);




CREATE TABLE MPOST(
     POST_NUM NUMBER PRIMARY KEY,
     NICKNAME VARCHAR2(50),
     POST_CONT VARCHAR2(4000),
     POST_IMG VARCHAR2(2000),
     REGDATE DATE DEFAULT SYSDATE,
     PLACE VARCHAR2(100),
     LIKECOUNT NUMBER,
     FOREIGN KEY(NICKNAME) REFERENCES MJOIN(NICKNAME)
);

CREATE TABLE MTAG(
    TAG_NUM NUMBER PRIMARY KEY,
    NICKNAME VARCHAR2(50),
    FOREIGN KEY(NICKNAME) REFERENCES MJOIN(NICKNAME)
);

CREATE TABLE POST_TAG(
    POST_NUM NUMBER,
    TAG_NUM NUMBER,
    FOREIGN KEY(POST_NUM) REFERENCES MPOST(POST_NUM),
    FOREIGN KEY(TAG_NUM) REFERENCES MTAG(TAG_NUM)
);

CREATE TABLE MFOLLOW(
    NICKNAME VARCHAR2(50),
    FOLLOW_USER VARCHAR2(50),
    FOLLOWING_USER VARCHAR2(50),
    FOREIGN KEY(NICKNAME) REFERENCES MJOIN(NICKNAME),
    FOREIGN KEY(FOLLOW_USER) REFERENCES MJOIN(NICKNAME),
    FOREIGN KEY(FOLLOWING_USER) REFERENCES MJOIN(NICKNAME)
);


CREATE TABLE MLIKE(
     LIKENUM NUMBER PRIMARY KEY,
     LIKE_POST_NUM NUMBER,
     LIKE_POST_USER VARCHAR2(50),
     FOREIGN KEY(LIKE_POST_USER) REFERENCES MJOIN(NICKNAME) ON DELETE CASCADE,
     FOREIGN KEY(LIKE_POST_NUM) REFERENCES MPOST(POST_NUM)ON DELETE CASCADE
);


CREATE TABLE MREPLY(
    REPLY_IDX NUMBER PRIMARY KEY, --댓글 인덱스
    REPLY_WRITER VARCHAR2(100), --댓글 작성자
    POST_NUM NUMBER,            -- 원 게시글 번호
    REPLY_CONT VARCHAR2(1000), -- 댓글 내용
    TARGET_ID VARCHAR2(100), -- 댓글의 대상이 되는 아이디(글작성자)
    REPLY_CLASS NUMBER,           -- 0은 부모(댓글) 1는 자식(대댓글)
    REPLY_ORDER NUMBER, --댓글 순서
    GRP_NUM NUMBER, --댓글 그룹번호
    REGDATE DATE DEFAULT SYSDATE,
    FOREIGN KEY(REPLY_WRITER) REFERENCES MJOIN(NICKNAME),
    FOREIGN KEY(POST_NUM) REFERENCES MPOST(POST_NUM)
    );

CREATE TABLE MDM(
    SEND_USER VARCHAR2(50),
    SEND_CONT VARCHAR2(3000),
    SENT_TIME DATE DEFAULT SYSDATE,
    RECEIVE_USER VARCHAR2(50),
    RECEIVE_CONT VARCHAR2(3000),
    RECEIVE_TIME DATE, 
    FOREIGN KEY(SEND_USER) REFERENCES MJOIN(NICKNAME),
    FOREIGN KEY(RECEIVE_USER) REFERENCES MJOIN(NICKNAME)
);

CREATE TABLE MADVERTISEMENT(
    AD_NUM NUMBER PRIMARY KEY,
    AD_TITLE VARCHAR2(100),
    AD_CONT VARCHAR2(3000),
    AD_IMG VARCHAR2(2000)
);
commit;
-----------------------------------------------------------------------------------------------
CREATE SEQUENCE SEQ_POST_NUM 
INCREMENT BY 1 
START WITH 1
MINVALUE 1
MAXVALUE 50000
NOCYCLE;

CREATE SEQUENCE SEQ_LIKE_NUM 
INCREMENT BY 1 
START WITH 1
MINVALUE 1
MAXVALUE 50000
NOCYCLE;

CREATE SEQUENCE SEQ_REPLY_NUM 
INCREMENT BY 1 
START WITH 1
MINVALUE 1
MAXVALUE 50000
NOCYCLE;

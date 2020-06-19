# ajax_Baseball 과제
```
1. 팀목록 테이블 : id, 팀목록 뿌리기
2. 팀 클릭하면 동적으로 선수 목록 데이터 뿌려짐
3. 선수목록 테이블 : id,선수이름 뿌리기
4. 선수이름 클릭시 동적으로 선수 데이터 뿌려짐
5. 선수 테이블 : id, 이름, 포지션 뿌리기
```

## 오라클 사용자 생성
```sql
alter session set "_ORACLE_SCRIPT"=true;
CREATE USER cos IDENTIFIED BY bitc5600;

GRANT CREATE SESSION TO cos;
GRANT CREATE TABLESPACE TO cos;
GRANT CREATE TABLE TO cos;
GRANT RESOURCE, CONNECT to cos;
GRANT CREATE SEQUENCE to cos;
ALTER user cos DEFAULT TABLESPACE users QUOTA UNLIMITED on users;
```

## 테이블
```sql
CREATE TABLE kboteam(
	id NUMBER primary key,
    teamName varchar2(20) not null unique
);

CREATE TABLE Players(
	id number primary key,
    teamId number,
    playerName varchar2(100) not null,
    position varchar2(20) not null,
    foreign key (teamId) references kboteam (id)
);
```

## DB 데이터(kboteam테이블)
```
INSERT INTO kboteam VALUES(1, '두산');
INSERT INTO kboteam VALUES(2, '키움');
INSERT INTO kboteam VALUES(3, 'SK');
INSERT INTO kboteam VALUES(4, 'LG');
INSERT INTO kboteam VALUES(5, 'NC');
INSERT INTO kboteam VALUES(6, 'KT');
INSERT INTO kboteam VALUES(7, 'KIA');
INSERT INTO kboteam VALUES(8, '삼성');
INSERT INTO kboteam VALUES(9, '한화');
INSERT INTO kboteam VALUES(10, '롯데');
```

## DB 데이터(ㅔlayers테이블)
```
INSERT INTO Players VALUES(1, 1, '정수빈', '외야수');
INSERT INTO Players VALUES(2, 1, '권혁', '투수');
INSERT INTO players VALUES(3, 1, '이현승', '투수');
INSERT INTO players VALUES(4, 1, '정상호', '포수');
INSERT INTO players VALUES(5, 1, '최주환', '내야수');

INSERT INTO players VALUES(6, 2, '박동원', '포수');
INSERT INTO players VALUES(7, 2, '김수환', '내야수');
INSERT INTO players VALUES(8, 2, '김혜성', '내야수');
INSERT INTO players VALUES(9, 2, '박병호', '내야수');
INSERT INTO players VALUES(10, 2, '김규민', '외야수');

INSERT INTO players VALUES(11, 3, '길지석', '투수');
INSERT INTO players VALUES(12, 3, '김주환', '투수');
INSERT INTO players VALUES(13, 3, '김찬호', '투수');
INSERT INTO players VALUES(14, 3, '이재원', '포수');
INSERT INTO players VALUES(15, 3, '김민재', '내야수');

INSERT INTO players VALUES(16, 4, '고우석', '투수');
INSERT INTO players VALUES(17, 4, '구본혁', '내야수');
INSERT INTO players VALUES(18, 4, '김지용', '투수');
INSERT INTO players VALUES(19, 4, '류원석', '투수');
INSERT INTO players VALUES(20, 4, '박재욱', '포수');

INSERT INTO players VALUES(21, 5, '강동연', '투수');
INSERT INTO players VALUES(22, 5, '김태군', '포수');
INSERT INTO players VALUES(23, 5, '김민수', '내야수');
INSERT INTO players VALUES(24, 5, '김시훈', '투수');
INSERT INTO players VALUES(25, 5, '이우석', '투수');

INSERT INTO players VALUES(26, 6, '강장산', '투수');
INSERT INTO players VALUES(27, 6, '이상화', '투수');
INSERT INTO players VALUES(28, 6, '조현우', '투수');
INSERT INTO players VALUES(29, 6, '조근종', '투수');
INSERT INTO players VALUES(30, 6, '조병욱', '투수');

INSERT INTO players VALUES(31, 7, '서재응', '투수');
INSERT INTO players VALUES(32, 7, '송지만', '타자');
INSERT INTO players VALUES(33, 7, '이형곤', '내야수');
INSERT INTO players VALUES(34, 7, '김종국', '내야수');
INSERT INTO players VALUES(35, 7, '김민우', '내야수');

INSERT INTO players VALUES(36, 8, '권오준', '투수');
INSERT INTO players VALUES(37, 8, '박승규', '외야수');
INSERT INTO players VALUES(38, 8, '최영진', '내야수');
INSERT INTO players VALUES(39, 8, '임현준', '투수');
INSERT INTO players VALUES(40, 8, '홍정우', '투수');

INSERT INTO players VALUES(41, 9, '이용규', '외야수');
INSERT INTO players VALUES(42, 9, '정우람', '투수');
INSERT INTO players VALUES(43, 9, '이성열', '내야수');
INSERT INTO players VALUES(44, 9, '정은원', '내야수');
INSERT INTO players VALUES(45, 9, '최재훈', '포수');

INSERT INTO players VALUES(46, 10, '김원중', '투수');
INSERT INTO players VALUES(47, 10, '이대호', '내야수');
INSERT INTO players VALUES(48, 10, '전준우', '내야수');
INSERT INTO players VALUES(49, 10, '민병헌', '외야수');
INSERT INTO players VALUES(50, 10, '손아섭', '외야수');
```

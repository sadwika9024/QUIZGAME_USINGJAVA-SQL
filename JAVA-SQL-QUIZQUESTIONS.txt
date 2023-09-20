mysql> create database quiz;

mysql> use quiz;

mysql> create table Question(
    -> id INT,
    -> question varchar(300),
    -> option1 varchar(100),
    -> option2 varchar(100),
    -> option3 varchar(100),
    -> option4 varchar(100),
    -> crtanswer varchar(100));
Query OK, 0 rows affected (0.02 sec)

mysql> desc questions1;
+-----------+--------------+------+-----+---------+-------+
| Field     | Type         | Null | Key | Default | Extra |
+-----------+--------------+------+-----+---------+-------+
| id        | int          | YES  |     | NULL    |       |
| question  | varchar(300) | YES  |     | NULL    |       |
| option1   | varchar(100) | YES  |     | NULL    |       |
| option2   | varchar(100) | YES  |     | NULL    |       |
| option3   | varchar(100) | YES  |     | NULL    |       |
| option4   | varchar(100) | YES  |     | NULL    |       |
| crtanswer | varchar(100) | YES  |     | NULL    |       |
+-----------+--------------+------+-----+---------+-------+
7 rows in set (0.00 sec)

mysql> insert into Question values(1,"Who invented Java Programming?","A)Guido van Rossum","B)James Gosling","C)Dennis Ritchie","D)Bjarne Stroustrup","B");
Query OK, 1 row affected (0.01 sec)



mysql> insert into Question values(2,"Which one of the following is not a Java feature?","A)Object-oriented","B)Use of pointers","C)Portable","D)Dynamic and Extensible","B");
Query OK, 1 row affected (0.00 sec)



mysql> insert into Question values(3,"What is the extension of compiled java classes?","A).txt","B).exe","C).class","D).java","C");
Query OK, 1 row affected (0.00 sec)



mysql> insert into Question values(4,"What is the numerical range of a char data type in Java","A)0 to 256","B)-128 to 127","C)0 to 65535","D)0 to 32767","C");
Query OK, 1 row affected (0.00 sec)



mysql> insert into Question values(5,"Which of these statements is incorrect about Thread?","A)start() method is used to begin execution of the thread"," B)run() method is used to begin execution of a thread before start() method in special cases","C)A thread can be formed by implementing Runnable interface only","D)A thread can be formed by a class that extends Thread class","B");
Query OK, 1 row affected (0.00 sec)

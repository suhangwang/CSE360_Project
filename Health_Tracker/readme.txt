This is CSE360 Group Project.

To run this project, you must have installed MySQL database.

After that, please follow the following step to set up the database that will be used for this project: 
1. login into MySQL as root user using the following command:
command:	create database cse360db;
2. create the cse360db
command:	use cse360db
3. create a user whose username is testuser and password is also test user
command:	create user testuser identified by 'testuser'
4. grant privileges on cse360db to testuser
command:	grant all privileges on cse360db.* to testuser identified by 'testuser'
5. create three tables
command:	create table userInfo(username varchar(255), password varchar(255), question int, answer varchar(255));
command:	create table physicalActivity(username varchar(255), password varchar(255), date date, cardio double, strength double, work double, sleep double, recreation double, primary key(username, date));
command:	create table healthIndicator(username varchar(255), password varchar(255), date date, pressure double, suger double, rate double, temperature double, weight double, primary key(username, date));

Packages Dependency:
1. We use itext to generate pdf.
2. We use JFreeChart to generate the lineChart, histogram
3. We use MySQL JDBC driver to connect to the MySQL database

Please include these packages to the project

Acknowledgement:
1. itext: http://itextpdf.com/
2. JFreeChart: http://www.jfree.org/jfreechart/
3. JCommon: http://www.jfree.org/jcommon/
4. MySQL JDBC: https://dev.mysql.com/downloads/connector/j/
5. The three figures (one on welcome window, two on add records window) are from online
6. Some codes are also from online
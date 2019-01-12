# MySQL
## Install MySQL on macOS Mojave
This procedure explains how to install [MySQL](https://www.mysql.com) using [Homebrew](http://brew.sh) on macOS Mojave 10.14

### Install Homebrew
* Installing Homebrew is effortless, open Terminal and enter :  
 `$  /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"`
* **Note:** Homebrew will download and install Command Line Tools for Xcode 8.0 as part of the installation process.

### Install MySQL
At this time of writing, Homebrew has MySQL version **8.0.12** as default formulae in its main repository :

* Enter the following command : `$ brew info mysql`  
* Expected output: **mysql: stable 8.0.12 (bottled)**

To install MySQL enter : `$ brew install mysql`
  

## Additional configuration
### Homebrew

* Install **brew services** first : `$ brew tap homebrew/services`
* Load and start the MySQL service : `$ brew services start mysql`  
Expected output : **Successfully started `mysql` (label: homebrew.mxcl.mysql)** 	  

* Check of the MySQL service has been loaded : `$ brew services list` <sup>[1](#1)</sup>

* Verify the installed MySQL instance : `$ mysql -V`.   
Expected output : **mysql  Ver 8.0.12 for osx10.14 on x86_64 (Homebrew)**
* Set path in .bash_profile: `export PATH=$PATH:/usr/local/Cellar/mysql/8.0.12/bin`

### MySQL
Open Terminal and execute the following command to set the root password:  
 mysqladmin -u root -p password <br>
 Enter password: <br>
 New password: <br>
 Confirm new password: <br>
 
### Database Management
 Log in to root account <br>
 `mysql -u root -p` <br>
 
<h3>Create DB</h3>

`create database testdb;`

<h3>To see all the available databases</h3>

`show databases`

<h3>Create Table</h3>

`CREATE TABLE students (id INT NOT NULL PRIMARY KEY, name VARCHAR(40), grade VARCHAR(10));`

<h3>Insert Data into table</h3>

`insert into students (id, name, grade) values (1, 'John', 'A');` <br>
`insert into students (id, name, grade) values (2, 'Jack', 'B');`

<h3>To see everything from table</h3>

`select * from students;`

<h3>Grant root user access through command line</h3>

`grant on *.* to 'root'@'localhost' identified by 'rootuser';`

<h2> Connecting by Java </h2>

* Use password field for root user empty String while connectig through localhost otherwise you will have to write the password explicitly in a configuration file<br>
 
`String password ="";` <br>

* To set password run this sql command

`ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'rootuser';
`

<h3> Getting JDBC Jar and maven dependency </h3>
[JDBC Jar 8.0.12](https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.12)<br>

* crerate a directory named `lib` in your IntelliJ project and store it there. <br>
* Go to `File> Project Structure> Libraries> Use + sign to add the JDBC Connector Jar in class path.` <br>
* Select `Module`> Use + sign add same jar and mark the Jar checkbox and apply> Ok <br>

You are all set to work with mysql databases using Java

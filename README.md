# Assignment 1
A Reddit Database for Course 2DV513 - Database Theory


## Introduction
For the course Database Theory at the LNU we had to build a Database for Plattform Reddit. 


## Technical Details
### The Basic structure. 
Our System is structured in three Parts:

- A Database
- Two Python scripts that create and fill the Tables
- A Java Gui to analyze the created Data.

### The Deployment Structure
To deploy our DB on many different Systems, we decided to use Docker for the Deployment. 
Inside of this Docker Cluster we have two Instances running, the DB itself and a Python Script, called Tablecreater, that creates the Tables. The Cluster itself is running inside a Network called *Assignment 1 DB*. 

```
version: '0'

services:

  db:
    image: mysql:latest
    environment:
      MYSQL_DATABASE: Reddit
      MYSQL_ALLOW_EMPTY_PASSWORD: "yes"
      MYSQL_User: Python
      MYSQL_PASSWORD: Python
      MYSQL_HOST: '%'
      MYSQL_ROOT_HOST: '%'
      # MYSQL_ROOT_HOST: 0.0.0.0/255.255.255.248
    volumes:
      - db_data:/var/lib/mysql
    restart: always
    ports:
      - "3308:3306"

  Tablecreater:
    links:
      - "db:database"
    image: tablescreater:0.1


networks:
  main:
    name: Assignment 1 DB

volumes:
  db_data: {}
```

The Data from the final DB is stored in a Volume called *db_data*. 

The originial Plan was to deploy another container called *DB_filler*. We had to change Plans, because Containers have a size limit of 10 GB. We would have needed a container of roughly 25 GB. 
We then decided to run that container seperatly as a normal Python script.


### The Database
To make our DB usebull on many different Systems, we decided to use Docker for the Deployment.
The DB itself is a MySQL-Database. 
#### Internal Structure
Inside of the Database are three Tables. 

### The Tablecreater
The Tablecreater is a small Python script that connects to the Database and creates the needed Tables. The Script will do nothing if the Tables already exist.

To connect to the Database we use the Package mySQL.Connector. 

```
def main():
    # Load the keys for the MySql Database

    File = open("Setup.config").readlines()
    host = File.pop(0)
    port = File.pop(0)
    user = File.pop(0)
    passwd = File.pop(0)
    database = File.pop(0)

    print("------------------------------------------------------")
    print("Connecting to Database: " + host + " as " + user + " on port " + port)
    print("Password: " + passwd)
    print("------------------------------------------------------")

    Database = mysql.connect(
        host=host,
        port=port,
        user=user,
        database=database
    )

    return Database
    
```

The Creater will connect to the DB and will then execute a few SQL Scripts.

```
CREATE TABLE IF NOT EXISTS `Reddit`.`Comments` 
(`ID` VARCHAR(45) NOT NULL, 
`name` VARCHAR(45) NULL,
`parentID` VARCHAR(45) NULL,
`body` VARCHAR(10000) NULL,
`ups` INT NULL,
`downs` INT NULL,
`created` INT NULL,
`conttiversiality` INT NULL,
`Archived` BOOLEAN NULL,
`USER` VARCHAR(128) NULL,
`SUBREDDIT` VARCHAR(128) NULL, PRIMARY KEY (`ID`));

CREATE TABLE IF NOT EXISTS `Reddit`.`Subreddits` (`Name` VARCHAR(48) NOT NULL, `Subreddit_id` VARCHAR(48) NOT NULL, PRIMARY KEY (`Subreddit_id`));

CREATE TABLE IF NOT EXISTS `Reddit`.`User` (`ID` INT NOT NULL,`Name` VARCHAR(45) NOT NULL,PRIMARY KEY (`Name`),UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE);

```


### The Tabelfiller


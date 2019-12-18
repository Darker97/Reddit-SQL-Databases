---
title: "Assignment 2"
author: "Carolin Brückman und Christian Baltzer"
output: pdf_document

---


# Assignment 
## Task 1: Relational Algebra

```{SQL} 
<!-- Bei 1 - 5 muss jeweils noch die Schreibweise angepasst werden. Z.B bei 1 muss name nach unten gesetzt werden und die Bedninung für den Theta- Join muss unter das Symbol, steht hier jeweils in Klammern dahinter -->

1) 
SELECT name 
IN student JOIN enrolled
Where code = ‚2dv513‘  

result := 𝜋 name(student ⋈ (code = '2dv513') enrolledIn)

2)
SELECT name 
IN student JOIN enrolled
WHERE code = ‚2dv513‘ OR code = ‚1dv513‘

result := (𝜋 name(student ⋈ (code = '2dv513') enrolledIn)) ∪ (𝜋 name(student ⋈ (code = '1dv513') enrolledIn))

3) 
SELECT lecturer
IN subject
WHERE code = ‚2dv610‘

result := 𝜋 lecturer (𝜎 code = '2dv610'(subject))

4)
SELECT lecturer
IN subject
WHERE code = ‚2dv513‘ AND code =‚1dv513‘

result := (𝜋 lecturer (𝜎 code = '2dv610'(subject))) ∪ (𝜋 lecturer (𝜎 code = '1dv513'(subject)))

5)
SELECT name 
IN student JOIN enrolled JOIN subject
WHERE lecturer != ‚ILIR‘

``` 
$$ result := (𝜋 name(student ⋈ enrolledIn ⋈(lecturer != 'ilir') subject) $$

## Task 2: FDs and Normalization
1. *Functional Dependencies* 


**We have multiple FDs.**


		room time day -> manager 

		room time day -> applicant 
		
		--> room time day --> manager applicant 
		
     **or more?**		
  		manager day -> room
		
		manager applicant day -> room time
		
		room time day -> manager applicant
		
		applicant day -> room manager time 
1. *Find the Keys* 	

		Primary Key: room, time, day 


		Super Keys: 

		* room, time, day, applicant 
		* room, time, day, manager 
		* room, time, day, manager, applicant 

1. *Show the relations is in 3NF but not in BCNF*

 
        The manager and the applicant are independent from one another therefore the relation is in 3NF. 


<!--Beweis das es nicht in BCNF ist fehlt noch--> 
1. *Decompose the Relations that are in BCNF*
1. *Draw an E/R-Diagram that describes the System.*

## Task 3: Setting up the Reddit Database

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
We then decided to run that container seperatly as a normal Python script, which takes some time, but works perfectly.


### The Database
To make our DB usefull on many different Systems, we decided to use Docker for the Deployment.
The DB itself is a MySQL-Database with an attached volume to store the data. 

#### Internal Structure
Inside of the Database are three Tables. 

### The Tablecreater
The Tablecreater is a small docker container, containing python 3.7 and a small Python Script. The Script will try to connect to the DB and create the needed Tables. If this fails, the Script will wait for 60 seconds and then try again.

### The DB Filler
The DB Filler is another Python script that will take the Files, extract the Data and then transfer it into the needed Querys. It will then send these to the DB.

### The GUI
For the purpose of simplicity we use a GUI, written in JAVA.
![Picture of the JAVA GUI](./GUI.png)


###Schemas with types

* users(author)
* subreddits(subreddit, subreddit-id,)
* comments(id, name, body, score(ups , downs)<!--brauchen wir das?-->created_utc, link-id, parent-id)


### Notes
- The data is stored in Files
- The data is in Form of JSON FILES
- Each file contains a single month of Reddit posts

### JSON - Structure

![]("Reddit-JSONStructure.jpeg")
### Keys

![](Reddit - Keys.jpeg)

We can safely ignore keys not mentioned here.

## Task 5: Queries
```
1) function (NameOfUser){
	QUERY:
		SELECT SUM()
		IN COMMENTS
		WHERE user = NameOfUser
	}
2)
	function (subreddit) {
	QUERY:
		SELECT DURCHSCHNITT
		IN 
			SELECT GROUP(COMMENTS - DAY)
			IN Comments
			Where sub = subreddit
	}
3)
	function (Word) {
	QUERY:
		SELECT SUM
		IN
			SELECT *
			In Comments
			WHERE text INCLUDES Word
	}
4)
	function 
```


##Task 4: Importing data
##task 5: Queries

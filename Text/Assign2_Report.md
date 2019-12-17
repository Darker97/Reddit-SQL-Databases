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

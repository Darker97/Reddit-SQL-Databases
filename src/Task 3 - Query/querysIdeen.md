#querys
1. How many comments have a specific user posted? <!--Wie sieht man welcher user den Kommentar geschrieben hat?-->

2. How many comments does a specific subreddit get per day?
**select count**(link-id) as amount **from** comments **where** link-id = ''; 
3. How many comments include the word 'lol'?
**select count**(body) as amount **from** comments **where** body = '*lol*';<!--Wie macht man das?--> 
4. Users that commented on a specific link has also posted to which subreddits?

5. Which users have the highest and lowest combined scores? (combined as the sum of all
scores)

6. Which subreddits have the highest and lowest scored comments?
**select max**(score) as max **from** comments; 
**select min**(score) as min **from** comments;
7. Given a specific user, list all the users he or she has potentially interacted with (i.e., everyone
who as commented on a link that the specific user has commented on).
8. Which users has only posted to a single subreddit?


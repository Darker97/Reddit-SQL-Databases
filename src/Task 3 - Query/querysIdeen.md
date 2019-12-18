#querys
1. How many comments have a specific user posted? <!--Wie sieht man welcher user den Kommentar geschrieben hat?-->

select count(id) as amount from comments where user ='';

2. How many comments does a specific subreddit get per day? <!--pro Tag??!-->


**select count**(link-id) as amount **from** comments **where** link-id = ''; 


3. How many comments include the word 'lol'?


**select count**(body) as amount **from** comments **where** body like '%lol%';


4. Users that commented on a specific link has also posted to which subreddits?

select distinct Comments.SUBREDDIT
from Comments join (select distinct Comments.USER 
from Comments join Subreddits on Subreddits.Name = Comments.SUBREDDIT 
where linkID = 't3_2zrn9')as test on Comments.USER = test.USER;

5. Which users have the highest and lowest combined scores? (combined as the sum of all
scores)


select user, min(combination.result), max(combination.result) from combination where (select sum(ups) as result from comments group by users) as combination;

6. Which subreddits have the highest and lowest scored comments?


(select subreddit as highest from comments join subreddits on subreddit.subbredit-id = comments.parent-id where max(ups)) UNION (select subreddit as lowest from comments join subreddits on subreddit.subbredit-id = comments.parent-id where min(ups)) 

<!--select sum(score) as sumScore from comments

**select max**(score) as max **from** comments; 


**select min**(score) as min **from** comments;-->


7. Given a specific user, list all the users he or she has potentially interacted with (i.e., everyone
who as commented on a link that the specific user has commented on).


select distinct USER from Reddit.Comments where linkID in (select linkID from Reddit.Comments where USER = 'gaso');


8. Which users has only posted to a single subreddit?

select USER from comments group by USER having count(link-id) = 1;

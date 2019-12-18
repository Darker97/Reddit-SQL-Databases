public class Querys {

    /**
     * Query to use in other, not mentioned cases
     * @param Input
     * @return
     */
    public static String SELECT(String Input){
        return "";
    }

    /**
     * Task 1
     * @param USER
     * @return
     */
    public static String SELECT_SPECIFIC_USER(String USER){
    	String query = "select count(id) " +
                "as amount from Comments " +
                "where user ='"+ USER + "';";
    	// query = "select count(id) as amount from Comments where user ='Arve';";
        return query;
    }

    /**
     * Task 2
     * @param SUB
     * @return
     */
    //Pro Tag!!!! -> created-utc
    public static String SELECT_COMMENTS_SPECIFIC_SUB(String SUB){
    	String query = "Select avg(allPerDay.Anzahl)" + 
    			"from (" + 
    			"	Select SUBREDDIT, count(WRITTEN_ON) as Anzahl" + 
    			"		FROM (" + 
    			"			SELECT SUBREDDIT, round((created / 60 / 60 / 24), 0) as WRITTEN_ON " + 
    			"			FROM Reddit.Comments" + 
    			"			where SUBREDDIT = '" + SUB + "'" + 
    			"			ORDER by WRITTEN_ON" + 
    			"		) AS daylight" + 
    			"	group by WRITTEN_ON" + 
    			") as allPerDay" + 
    			";";
        return query;
    }

    /**
     * Task 3
     * Do we have to consider LOL as well? Should we add the title?
     * casesensitiv
     * @return
     */
    public static String SELECT_COMMENTS_WITH_LOL(){
    	String query = "select count(body) as amount " +
                "from Comments " +
                "where body like '%lol%'";
        return query;
    }

    /** TODO: BUG FIXING but finished 
     * Task 4
     * @param Link
     * @return
     */
    public static String SELECT_SUB_BY_LINK(String Link){
    	String query = "select Comments.user, subreddits.subreddit " +
                "from Comments join subreddits on subreddits.id = Comments.SUBREDDIT " +
                "where(select" +
                    "Comments.users " +
                    "from Comments " +
                    "where link-id = '"+ Link +"') IN Comments.users;";
        return query;
    }

    /**
     * TODO: BUG FIXING - SYNTAX ERROR
     * Task 5
     * @param USER
     * @return
     */
    //user muss noch gelöscht werden!!
    //?
    public static String SELECT_SCORE_BY_USER(String USER){
    	String query = "" + 
    			"Select test.USER, test.Summe " + 
    			"from" + 
    			"	(Select USER, sum(ups) as Summe " + 
    			"		from Comments " + 
    			"        group by USER) as test " + 
    			"join" + 
    			"    (" + 
    			"		(select max(Summe) as Summe " + 
    			"			from (" + 
    			"				Select USER, sum(ups) as Summe " + 
    			"				from Comments " + 
    			"				group by USER)" + 
    			"			as Scores)" + 
    			"		union" + 
    			"			(select min(Summe) as Summe " + 
    			"			from (" + 
    			"				Select USER, sum(ups) as Summe" + 
    			"				from Comments" + 
    			"				group by USER)" + 
    			"			as Scores)" + 
    			"    )as dumm on test.Summe = dumm.Summe;";
        return query;
    }

    /**
     * 
     * Task 6
     * @param SUB
     * @return
     */
    //not sure about this one 
    public static String SELECT_HIGHEST_COMMENTS_BY_SUB(String SUB){
    	String query = "Select SUBREDDIT, ups as SCORE " + 
    			"from Comments" + 
    			"where ups in (" + 
    			"	select MIN(ups)" + 
    			"    from Comments" + 
    			") UNION " + 
    			"Select SUBREDDIT, ups from Comments where ups in(" + 
    			"	select MAX(ups) " + 
    			"    from Comments" + 
    			");";
        return query;
    }

    /**
     * TODO: link_ID einbauen
     * Task 7
     * @param USER
     * @return
     */
    public static String SELECT_CONTACTED_USERS(String USER){
    	String query = "select user " +
                "from Comments where parentID IN (select parentID from Comments where user = '"+ USER +"');";
        return query;
    }

    /**
     * Task 8
     * @return
     */
    public static String SELECT_USER_ONLY_COMMETED_ONCE(){
    	String query = "select *" + 
    			"from Comments;";
        return query;
    }
}

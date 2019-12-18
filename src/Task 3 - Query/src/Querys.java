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
    	String query = "select count(SUBREDDIT) as amount " +
                "from Comments " +
                "where SUBREDDIT = '"+SUB+"'";
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

    /** TODO: BUG FIXING
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
    	String query = "select user, min(combination.result), max(combination.result) " +
                "from combination " +
                "where (select sum(ups) as result from Comments group by users) as combination;";
        return query;
    }

    /**
     * TODO: BUG FIXING - SYNTAX ERROR
     * Task 6
     * @param SUB
     * @return
     */
    //not sure about this one 
    public static String SELECT_HIGHEST_COMMENTS_BY_SUB(String SUB){
    	String query = "select subreddit " +
                "from Comments join subreddits on subreddit.subbredit_id = Comments.parent_id as mix " +
                "where max((select sum(ups)from mix) as MAX and min((select sum(ups)from mix) as MIN))";
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
    	String query = "select USER" + 
    			"from Comments" + 
    			"group by USER having count(linkID) = 1;";
        return query;
    }
}

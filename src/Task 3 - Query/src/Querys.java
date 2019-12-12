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
    	String query = "select count(id) as amount from comments where user ='"+ USER + "';";
        return "";
    }

    /**
     * Task 2
     * @param SUB
     * @return
     */
    //Pro Tag!!!! -> created-utc
    public static String SELECT_COMMENTS_SPECIFIC_SUB(String SUB){
    	String query = "select count (link-id) as amount from comments where link-id = '"+SUB+"'";
        return "";
    }

    /**
     * Task 3
     * @return
     */
    //Do we have to consider LOL as well? Should we add the title?
    public static String SELECT_COMMENTS_WITH_LOL(){
    	String query = "select count(body) as amount from comments where body like '%lol%'"; 
        return "";
    }

    /**
     * Task 4
     * @param Link
     * @return
     */
    public static String SELECT_SUB_BY_LINK(String Link){
    	String query = "";
        return "";
    }

    /**
     * Task 5
     * @param USER
     * @return
     */
    public static String SELECT_SCORE_BY_USER(String USER){
    	String query = "";
        return "";
    }

    /**
     * Task 6
     * @param SUB
     * @return
     */
    //not sure about this one 
    public static String SELECT_HIGHEST_COMMENTS_BY_SUB(String SUB){
    	String query = "select subreddit from comments join subreddits on subreddit.subbredit-id = comments.parent-id as mix where max((select sum(ups)from mix) as MAX and min((select sum(ups)from mix) as MIN";
        return "";
    }

    /**
     * Task 7
     * @param USER
     * @return
     */
    public static String SELECT_CONTACTED_USERS(String USER){
    	String query = "";
        return "";
    }

    /**
     * Task 8
     * @return
     */
    public static String SELECT_USER_ONLY_COMMETED_ONCE(){
    	String query = "";
        return "";
    }
}

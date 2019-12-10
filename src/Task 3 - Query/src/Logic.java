public class Logic{
	
  public static String  submittQuery(String specific, int queryType, connector main) {
	//TEST
	  //System.out.println("test: " + specific + " " + queryType);	
	  String answer ="";
	  switch(queryType) {
	  case 1: 
		  answer = Querys.SELECT_SPECIFIC_USER(specific);
	  case 2: 
		  answer = Querys.SELECT_COMMENTS_SPECIFIC_SUB(specific);
	  case 3:
		  answer = Querys.SELECT_COMMENTS_WITH_LOL();
	  case 4:
		  answer = Querys.SELECT_SUB_BY_LINK(specific);
	  case 5:
		  answer = Querys.SELECT_SCORE_BY_USER(specific);
	  case 6:
		  answer = Querys.SELECT_HIGHEST_COMMENTS_BY_SUB(specific);
	  case 7:
		  answer = Querys.SELECT_CONTACTED_USERS(specific);
	  case 8:
		  answer = Querys.SELECT_USER_ONLY_COMMETED_ONCE();
	  }
	  return answer;
  }
  
  

}
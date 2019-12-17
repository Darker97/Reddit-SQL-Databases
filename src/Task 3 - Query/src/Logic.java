import java.sql.*;



public class Logic{
	
  public static String submittQuery(String specific, int queryType, connector main) {
	//TEST
	  //System.out.println("test: " + specific + " " + queryType);	
	  String question ="";
	  switch(queryType) {
	  case 1: 
		  question = Querys.SELECT_SPECIFIC_USER(specific);
	  case 2: 
		  question = Querys.SELECT_COMMENTS_SPECIFIC_SUB(specific);
	  case 3:
		  question = Querys.SELECT_COMMENTS_WITH_LOL();
	  case 4:
		  question = Querys.SELECT_SUB_BY_LINK(specific);
	  case 5:
		  question = Querys.SELECT_SCORE_BY_USER(specific);
	  case 6:
		  question = Querys.SELECT_HIGHEST_COMMENTS_BY_SUB(specific);
	  case 7:
		  question = Querys.SELECT_CONTACTED_USERS(specific);
	  case 8:
		  question = Querys.SELECT_USER_ONLY_COMMETED_ONCE();
	  }
	  return answer(question, main);
  }
  
  private static String answer(String question, connector con){
	String temp = "";
	try {
		Statement sm = con.getCon().createStatement();
		ResultSet rs = sm.executeQuery(question);
		while (rs.next()){
			temp += rs.getString(0);
		}
	}catch (SQLException e) {
		e.printStackTrace();
	}

	return temp;
  }

}
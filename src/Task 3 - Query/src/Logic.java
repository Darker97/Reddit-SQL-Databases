import java.sql.*;

import javax.swing.JOptionPane;



public class Logic{
	
  public static String submittQuery(String specific, int queryType, connector main) {
	//TEST
	  //System.out.println("test: " + specific + " " + queryType);	
	  String question ="";
	  switch(queryType) {
	  case 1: 
		  question = Querys.SELECT_SPECIFIC_USER(specific);
		  break;
	  case 2: 
		  question = Querys.SELECT_COMMENTS_SPECIFIC_SUB(specific);
		  break;
	  case 3:
		  question = Querys.SELECT_COMMENTS_WITH_LOL();
		  break;
	  case 4:
		  question = Querys.SELECT_SUB_BY_LINK(specific);
		  break;
	  case 5:
		  question = Querys.SELECT_SCORE_BY_USER(specific);
		  break;
	  case 6:
		  question = Querys.SELECT_HIGHEST_COMMENTS_BY_SUB(specific);
		  break;
	  case 7:
		  question = Querys.SELECT_CONTACTED_USERS(specific);
		  break;
	  case 8:
		  question = Querys.SELECT_USER_ONLY_COMMETED_ONCE();
		  break;
	  }
	  return answer(question, main);
  }
  
  private static String answer(String question, connector con){
	String temp = "";
	try {
		Statement sm = con.getCon().createStatement();
		ResultSet rs = sm.executeQuery(question);
		
		while (rs.next()){
			//System.out.println(rs.getString(1));
			temp += rs.getString(1);
			temp += "\n";
		}
	}catch (SQLException e) {
		JOptionPane.showMessageDialog(null, e.getMessage(),
			    "SQL error",
			    JOptionPane.ERROR_MESSAGE);
		e.printStackTrace();
	}

	return temp;
  }

}
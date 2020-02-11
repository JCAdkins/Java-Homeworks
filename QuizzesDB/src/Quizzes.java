import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Quizzes {

	public static void main(String[] args) throws Exception {
		
		String userName = "jcadkins";
		String password = "Password2";

		String url = "jdbc:sqlserver://awsdb.c7xm7gdw2r6x.us-east-2.rds.amazonaws.com:1433;databaseName=redditdb";

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		try (Connection conn = DriverManager.getConnection(url, userName, password);) {
			Statement stat = conn.createStatement();
			
			stat.execute("DROP TABLE guest.Quiz");
			stat.execute("DROP TABLE guest.Question");
			stat.execute("DROP TABLE guest.Choice");
			
			stat.execute("CREATE TABLE Quiz (QuizID VARCHAR(10), Description VARCHAR(100), Questions INT, CONSTRAINT Quiz_pk PRIMARY KEY (QuizID))");
			stat.execute("CREATE TABLE Question (QuizID VARCHAR(10), Number VARCHAR(5), Question VARCHAR(50), CONSTRAINT Question_pk PRIMARY KEY (Number))");
			stat.execute("CREATE TABLE Choice (Number VARCHAR(5), Choice1 VARCHAR(50), Choice2 VARCHAR(50), Choice3 VARCHAR(50), Choice4 VARCHAR(50), Answer CHAR(1), CONSTRAINT Choice_pk PRIMARY KEY (Number))");
			
			stat.execute("INSERT INTO Quiz (QuizID, [Description], Questions) VALUES ('Quiz 1', 'Mathematical Concepts', 9)");
			stat.execute("INSERT INTO Question (QuizID, Number, Question) VALUES ('Quiz 1', '1-1', 'What''s the square root of 100?')");
			stat.execute("INSERT INTO Choice (Number, Choice1, Choice2, Choice3, Choice4, Answer) VALUES ('1-1', '5', '6', '8', '10', 'D')");

			stat.execute("INSERT INTO Question (QuizID, Number, Question) VALUES ('Quiz 1', '1-2', 'What''s the square root of 1000?')");
			stat.execute("INSERT INTO Choice (Number, Choice1, Choice2, Choice3, Choice4, Answer) VALUES ('1-2', '50', '60', '80', '100', 'D')");
			
			stat.execute("INSERT INTO Question (QuizID, Number, Question) VALUES ('Quiz 1', '1-3', 'What''s 24 divided by 8?')");
			stat.execute("INSERT INTO Choice (Number, Choice1, Choice2, Choice3, Choice4, Answer) VALUES ('1-3', '2', '3', '5', '6', 'B')");
			
			stat.execute("INSERT INTO Question (QuizID, Number, Question) VALUES ('Quiz 1', '1-4', 'What''s 6 multiplied by 3?')");
			stat.execute("INSERT INTO Choice (Number, Choice1, Choice2, Choice3, Choice4, Answer) VALUES ('1-4', '12', '15', '18', '21', 'C')");
			
			stat.execute("INSERT INTO Question (QuizID, Number, Question) VALUES ('Quiz 1', '1-5', 'What''s 1 + 1?')");
			stat.execute("INSERT INTO Choice (Number, Choice1, Choice2, Choice3, Choice4, Answer) VALUES ('1-5', '1', '2', '3', '4', 'B')");
			
			stat.execute("INSERT INTO Question (QuizID, Number, Question) VALUES ('Quiz 1', '1-6', 'What''s 1 + 2?')");
			stat.execute("INSERT INTO Choice (Number, Choice1, Choice2, Choice3, Choice4, Answer) VALUES ('1-6', '1', '2', '3', '4', 'C')");
			
			stat.execute("INSERT INTO Question (QuizID, Number, Question) VALUES ('Quiz 1', '1-7', 'What''s 2 + 2?')");
			stat.execute("INSERT INTO Choice (Number, Choice1, Choice2, Choice3, Choice4, Answer) VALUES ('1-7', '1', '2', '3', '4', 'D')");
			
			stat.execute("INSERT INTO Question (QuizID, Number, Question) VALUES ('Quiz 1', '1-8', 'What''s 3 + 2?')");
			stat.execute("INSERT INTO Choice (Number, Choice1, Choice2, Choice3, Choice4, Answer) VALUES ('1-8', '5', '6', '7', '8', 'A')");
			
			stat.execute("INSERT INTO Question (QuizID, Number, Question) VALUES ('Quiz 1', '1-9', 'What''s 4 + 2?')");
			stat.execute("INSERT INTO Choice (Number, Choice1, Choice2, Choice3, Choice4, Answer) VALUES ('1-9', '5', '6', '7', '8', 'B')");
			
			
			//===============================================================================================================================
			//===============================================================================================================================
			
			
			stat.execute("INSERT INTO Quiz (QuizID, [Description], Questions) VALUES ('Quiz 2', 'Concepts on Math', 9)");
			stat.execute("INSERT INTO Question (QuizID, Number, Question) VALUES ('Quiz 2', '2-1', 'What''s the square root of 100?')");
			stat.execute("INSERT INTO Choice (Number, Choice1, Choice2, Choice3, Choice4, Answer) VALUES ('2-1', '5', '6', '8', '10', 'D')");

			stat.execute("INSERT INTO Question (QuizID, Number, Question) VALUES ('Quiz 2', '2-2', 'What''s the square root of 1000?')");
			stat.execute("INSERT INTO Choice (Number, Choice1, Choice2, Choice3, Choice4, Answer) VALUES ('2-2', '50', '60', '80', '100', 'D')");
			
			stat.execute("INSERT INTO Question (QuizID, Number, Question) VALUES ('Quiz 2', '2-3', 'What''s 24 divided by 8?')");
			stat.execute("INSERT INTO Choice (Number, Choice1, Choice2, Choice3, Choice4, Answer) VALUES ('2-3', '2', '3', '5', '6', 'B')");
			
			stat.execute("INSERT INTO Question (QuizID, Number, Question) VALUES ('Quiz 2', '2-4', 'What''s 6 multiplied by 3?')");
			stat.execute("INSERT INTO Choice (Number, Choice1, Choice2, Choice3, Choice4, Answer) VALUES ('2-4', '12', '15', '18', '21', 'C')");
			
			stat.execute("INSERT INTO Question (QuizID, Number, Question) VALUES ('Quiz 2', '2-5', 'What''s 1 + 1?')");
			stat.execute("INSERT INTO Choice (Number, Choice1, Choice2, Choice3, Choice4, Answer) VALUES ('2-5', '1', '2', '3', '4', 'B')");
			
			stat.execute("INSERT INTO Question (QuizID, Number, Question) VALUES ('Quiz 2', '2-6', 'What''s 1 + 2?')");
			stat.execute("INSERT INTO Choice (Number, Choice1, Choice2, Choice3, Choice4, Answer) VALUES ('2-6', '1', '2', '3', '4', 'C')");
			
			stat.execute("INSERT INTO Question (QuizID, Number, Question) VALUES ('Quiz 2', '2-7', 'What''s 2 + 2?')");
			stat.execute("INSERT INTO Choice (Number, Choice1, Choice2, Choice3, Choice4, Answer) VALUES ('2-7', '1', '2', '3', '4', 'D')");
			
			stat.execute("INSERT INTO Question (QuizID, Number, Question) VALUES ('Quiz 2', '2-8', 'What''s 3 + 2?')");
			stat.execute("INSERT INTO Choice (Number, Choice1, Choice2, Choice3, Choice4, Answer) VALUES ('2-8', '5', '6', '7', '8', 'A')");
			
			stat.execute("INSERT INTO Question (QuizID, Number, Question) VALUES ('Quiz 2', '2-9', 'What''s 4 + 2?')");
			stat.execute("INSERT INTO Choice (Number, Choice1, Choice2, Choice3, Choice4, Answer) VALUES ('2-9', '5', '6', '7', '8', 'B')");
		
			
		//===========================================================================================================================================
		//===========================================================================================================================================
			
			
			QuizDB quizDB = new QuizDB();
			quizDB.run();

		} catch (Exception e)
		{
			System.out.println(e);
		}

	}
	
}
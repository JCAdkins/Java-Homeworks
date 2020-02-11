import java.sql.*;
import java.util.Scanner;

public class QuizDB  {

	public QuizDB() {};
	
	public void run() throws Exception
	{
		
		// Variables needed to make 
		int correctAnswers = 0;
		int questions = 0;
		
		// Database Variables
		String userName = "jcadkins";
		String password = "Password2";

		// URL of database
		String url = "jdbc:sqlserver://awsdb.c7xm7gdw2r6x.us-east-2.rds.amazonaws.com:1433;databaseName=redditdb";

		
		// Get the class of the driver to communicate with the server
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		
		// Use the driver manager to set up a connection to the DB server
		try (Connection conn = DriverManager.getConnection(url, userName, password);)
		{
			
			Statement stat = conn.createStatement();
			
			// Query that selects the top 1000 quizzes that are in the quiz table of the DB
			ResultSet resultSet = stat.executeQuery("SELECT TOP (1000) [QuizID]\n" + 
					"      ,[Description]\n" + 
					"      ,[Questions]\n" + 
					"  FROM [redditdb].[guest].[Quiz]");
			
			
			// Loop through all available quizzes in the DB and print them on screen
			while(resultSet.next())
			{
				
				System.out.println("Quiz: " + resultSet.getString("QuizID") + " | Description: " + resultSet.getString("Description") + " | Number of Questions: " + resultSet.getString("Questions"));	
				
			}
			
			
			// This is where user selects a quiz to take
			String selection = UserSelection("Make a selection");
			
			// Query to get all the questions from the selected quiz
			resultSet = stat.executeQuery("SELECT Quiz.Questions FROM Quiz WHERE Quiz.QuizID = '" + selection + "'");
			
			
			// Loop through the questions
			while(resultSet.next())
			{
				
				questions = resultSet.getInt("Questions");
				
			}
			
			
			// Since the used JDBC Driver can't support two Result Sets being open at the same time
			// these variables are used to store the questions, the choices and the users answers
			String[] stringQuestions = new String[questions+1];
			String[] stringChoices = new String[questions+1];
			String[] answers = new String[questions];
			
			for (int a = 0; a <= questions; a++)
			{
				
				// Query to get all the question numbers
				resultSet = stat.executeQuery("SELECT Question.Number, Question.Question FROM Question WHERE Question.QuizID = '" + selection + "' AND Question.Number = '" + selection.substring(5) + "-" + Integer.toString(a) + "'");
			
				
				// Loop through the result set and store the question number to stringQuestions
				while(resultSet.next()) 
				{
					String number = resultSet.getString("Number");
					
					stringQuestions[a-1] = number + ": " + resultSet.getString("Question");
	
				}
				
				// Query to select the possible choices (e.g. A, B, C, D) for the given question
					ResultSet resultSet2 = stat.executeQuery("SELECT * FROM Choice WHERE Choice.Number = '" + selection.substring(5) + "-" + Integer.toString(a) + "'");
					
					
				// Loop through and store the choices to the string array stringChoices
				while(resultSet2.next())
				{
						
					stringChoices[a-1] = "A) " + resultSet2.getString("Choice1") + "  B) " + resultSet2.getString("Choice2") + "  C) " + resultSet2.getString("Choice3") + "  D) " + resultSet2.getString("Choice4");
						
				}
				
				
			}
			
			
			// This loop gets the users answer to the given question and stores it in answers[]
			for (int a = 0; a < questions; a++)
			{
				
				System.out.println(stringQuestions[a]);
				System.out.println(stringChoices[a]);
				
				answers[a] = UserSelection("Select a letter");
			}
			
			
			// This loop compares the users choice with the actual answer and adds one to the 
			// variable correctAnswers
			for (int a = 0; a <= questions; a++)
			{
				resultSet = stat.executeQuery("SELECT Choice.Answer FROM Choice WHERE Choice.Number = '" + selection.substring(5) + "-" + Integer.toString(a) + "'");
				
				while(resultSet.next())
				{
					
					if (answers[a-1].equalsIgnoreCase(resultSet.getString("Answer")))
					{
						
						correctAnswers = correctAnswers + 1;
						
					}
					
				}
			
			}
			
			
			// Display how many questions the users got correct
			System.out.println("\nYou answered " + correctAnswers + " out of " + questions + " correct.");
			
		
		} catch (Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	
	
	// Method to get the users input
	public String UserSelection(String string)
	{
			
		System.out.println(string);
		Scanner s = new Scanner(System.in);
		String returnString = s.nextLine();
		
		return returnString;
		
	}
	

	
	
	
}

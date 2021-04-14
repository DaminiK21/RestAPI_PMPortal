package Files;

import java.util.Random;

public class Payloads {
	

	public static String LoginDetails(String username, String password) {
		return "{\"email\":\""+username+"\",\"passwordDigest\":\""+password+"\"}";
	}

	public static String createPatient() {

	
		
		Random random = new Random();   
		int pid = random.nextInt(100);
		

		return "{\"identifier\":\"TMN-" + pid
				+ "\",\"group\":{\"id\":\"1\"},\"phi\":{\"id\":null,\"firstName\":\"TimeLine Validation note\",\"lastName\":\"Test Account\",\"dob\":\"\",\"age\":\"\",\"gender\":\"\",\"race\":\"\",\"ethnicity\":\"\",\"vitalStatus\":\"\",\"dateOfDeath\":\"\",\"causeOfDeath\":\"\",\"physician\":\"\"}}";

	}
	
	public static String createGroup() {
		return "{\"name\":\"Test11\"}";
	}
	
	public static String addMemberToGroup() {
		return "{\"id\":19,\"createdAt\":\"2020-11-26T06:40:50.486+0000\",\"updatedAt\":\"2020-11-26T06:40:50.486+0000\",\"activationToken\":\"0275f87b-c57c-44fb-9438-2684fb61c6f4\",\"email\":\"logandeo33@gmail.com\",\"passwordDigest\":\"$2a$11$L./3pqH5bJjiO7CCEEdqzuF7P/ne1fxEWqCi.Tz0KtL6bJ4ljSkcy\",\"roles\":[{\"id\":4,\"name\":\"Member\",\"roleCode\":\"member\",\"description\":\"member is part of group\",\"createdAt\":\"2020-10-23T17:01:14.713+0000\",\"updatedAt\":\"2020-10-23T17:01:14.713+0000\"}],\"name\":\"Logan deo\",\"admin\":false,\"deactivatedAt\":\"2021-03-31T08:00:00.018+0000\",\"confirmedAt\":\"2020-11-26T06:42:53.336+0000\",\"lastLoginAt\":\"2020-12-29T07:01:00.000+0000\",\"passwordChangedAt\":\"2020-11-26T06:42:53.336+0000\",\"passwordResetRequired\":false,\"disabledAt\":null,\"locked\":false,\"confirmed\":true,\"deactivated\":true,\"active\":false}";
	}

	
	public static String getMedicationDetails() {
		return "{\r\n"
				+ "\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "\"courses\": [\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\r\n"
				+ "\"price\": 50,\r\n"
				+ "\r\n"
				+ "\"copies\": 6\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\r\n"
				+ "\"price\": 40,\r\n"
				+ "\r\n"
				+ "\"copies\": 4\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\r\n"
				+ "\"price\": 45,\r\n"
				+ "\r\n"
				+ "\"copies\": 10\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "]\r\n"
				+ "\r\n"
				+ "}";
	}
}

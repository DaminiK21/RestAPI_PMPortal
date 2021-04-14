package RestApIBasic;

import Files.Payloads;
import io.restassured.path.json.JsonPath;

public class ResponseTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0;
		JsonPath js= new JsonPath(Payloads.getMedicationDetails());
		int count=js.getInt("courses.size()");
		System.out.println("Number of courses:- "+count);
		int purchesAmt=js.getInt("dashboard.purchaseAmount");
		System.out.println("Number of Purches amount:- "+purchesAmt);
		String titleFirstcourse=js.getString("courses[0].title");
		System.out.println("Title of the first course:- "+titleFirstcourse);
		for(int i=0;i<count;i++) {
		String title=	js.getString("courses["+i+"].title");
		int price=	js.get("courses["+i+"].price");
		int AllCopies=	js.get("courses["+i+"].copies");
		System.out.println(title+" "+price);
		
		sum=sum+(price*AllCopies);
		System.out.println("sum:- "+sum);
		if(title.equalsIgnoreCase("RPA")) {
			int copies=js.getInt("courses["+i+"].copies");
			System.out.println("Copies of RPA:="+copies);
		}
		}
		
		
		
	}

}

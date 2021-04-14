package RestApIBasic;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.MatcherAssert.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.Payloads;

public class LoginAuthentication {

	@Test(dataProvider = "credData")
	public void loginAuthentication(String userName, String Password) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://srmt3.cirraspec.tgen.org/pmportal";
		String loginRespose = given().log().all().header("Content-Type", "application/json")
				.body(Payloads.LoginDetails(userName, Password))
				.when().post("authenticate").then().assertThat()
				.statusCode(200).extract().response().asString();

		JsonPath js = new JsonPath(loginRespose);

		String name = js.getString("name");
		System.out.println(name);
	}

	@DataProvider(name = "credData")

	public Object[][] getdata() {
		return new Object[][] { {"jckdoe46@gmail.com","Password@123"},{"kkinikar@tgen.org","Password@123"},{"kpl.kini@gmail.com","Password@123"} };

	}
}

package RestApIBasic;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import Files.Payloads;

public class PatientController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		RestAssured.baseURI = "https://srmt3.cirraspec.tgen.org/pmportal";
		String patientDetails = given().log().all()
				.header("Authorization", "Basic amNrZG9lNDZAZ21haWwuY29tOlBhc3N3b3JkQDEyMw==")
				.header("Content-Type", "application/json").body(Payloads.createPatient()).when()
				.post("group/1/patient").then().assertThat().statusCode(201).extract().response().asString();

		JsonPath js = new JsonPath(patientDetails);
		System.out.println(patientDetails);
		int pid = js.getInt("id");
		
		String getpatientDetails = given().log().all()
				.header("Authorization", "Basic amNrZG9lNDZAZ21haWwuY29tOlBhc3N3b3JkQDEyMw==")
				.when().get("group/1/patient/"+pid+"")
				.then().assertThat().statusCode(200).extract().response().asString();

		JsonPath jsPatientDetails = new JsonPath(getpatientDetails);
		System.out.println(jsPatientDetails);
		
		String getSimilarpatientDetails = given().log().all()
				.header("Authorization", "Basic amNrZG9lNDZAZ21haWwuY29tOlBhc3N3b3JkQDEyMw==")
				.when().get("group/1/patient/" + pid + "/similar-patients")
				.then().assertThat().statusCode(200).extract().response().asString();

		JsonPath jsGetSimilarPatientDetails = new JsonPath(getSimilarpatientDetails);
		System.out.println(jsGetSimilarPatientDetails);
		
		
		
		String deletePatient = given().log().all()
				.header("Authorization", "Basic amNrZG9lNDZAZ21haWwuY29tOlBhc3N3b3JkQDEyMw==")
				.header("Content-Type", "application/json").when().delete("group/1/patient/" + pid + "").then()
				.assertThat().statusCode(204).extract().response().asString();
		System.out.println(deletePatient);

	}

}

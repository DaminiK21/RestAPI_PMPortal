package RestApIBasic;

import static io.restassured.RestAssured.given;

import Files.Payloads;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GroupController {
	public static JsonPath js;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://srmt3.cirraspec.tgen.org/pmportal";
		String createGrp = given().log().all().header("Content-Type", "application/json")
				.header("Authorization", "Basic a2tpbmlrYXJAdGdlbi5vcmc6UGFzc3dvcmRAMTIz").body(Payloads.createGroup())
				.when().post("group").then().assertThat().statusCode(201).extract().response().asString();
		js = new JsonPath(createGrp);
		String grpId = js.getString("id");

		String groupId = "28";

		String addMemberToGrp = given().log().all().header("Content-Type", "application/json")
				.header("Authorization", "Basic amNrZG9lNDZAZ21haWwuY29tOlBhc3N3b3JkQDEyMw==")
				.body(Payloads.addMemberToGroup()).when().post("group/" + groupId + "/add-user").then().assertThat()
				.statusCode(201).extract().response().asString();
		js = new JsonPath(addMemberToGrp);
		String userId = js.getString("id");

		String rmvMemberfrmGrp = given().log().all().header("Content-Type", "application/json")
				.header("Authorization", "Basic amNrZG9lNDZAZ21haWwuY29tOlBhc3N3b3JkQDEyMw==").when()
				.put("group/" + groupId + "/member/" + userId + "").then().assertThat().statusCode(200).extract()
				.response().asString();
		System.out.println(rmvMemberfrmGrp);

		String getMemberfrmGrp = given().log().all()
				.header("Authorization", "Basic amNrZG9lNDZAZ21haWwuY29tOlBhc3N3b3JkQDEyMw==").when()
				.get("group/" + groupId + "/members").then().assertThat().statusCode(200).extract().response()
				.asString();
		js = new JsonPath(getMemberfrmGrp);
		String getMemberids = js.getString("id");
		System.out.println(getMemberids);
	
		

		/*
		 * String grpDetail=given().log().all()
		 * .header("Authorization","Basic a2tpbmlrYXJAdGdlbi5vcmc6UGFzc3dvcmRAMTIz")
		 * .when().get("group/"+grpId+"").then().assertThat()
		 * .statusCode(200).extract().response().asString();
		 */
	}

}

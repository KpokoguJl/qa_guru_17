package site.kpokogujl.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class ListUsersTests extends TestBase {
    private final String api_url = baseUrl + "/api/users";

    @Test
    public void getListTest() {

        given()
                .when()
                .get(api_url)
                .then()
                .statusCode(200);
    }

    @Test
    public void userCountTest() {

        Response response =
                get(api_url)
                        .then()
                        .statusCode(200)
                        .extract().response();

        int per_page = response.path("per_page");
        ArrayList data = response.path("data");

        assertThat(per_page).isEqualTo(data.size());
    }
}

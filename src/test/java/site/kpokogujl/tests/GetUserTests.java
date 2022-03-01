package site.kpokogujl.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.CoreMatchers.is;

public class GetUserTests extends TestBase{
    private final String api_url = baseUrl + "/api/users/2";

    @Test
    public void getCreatedUserTest(){

        step("Открываем главную страницу", () -> {});
        Response response = given()
                .get(api_url)
                .then()
                .statusCode(200)
                .extract().response();

        step("Парсим ответ", () -> {});
        int id = response.path("data.id");
        String first_name = response.path("data.first_name");

        step("Проверяем, что в ответе корректные данные", () -> {});
        assertThat(id).isEqualTo(2);
        assertThat(first_name).isEqualTo("Janet");
    }

    @Test
    public void getNonexistentUserTest(){

        String req_url = api_url + "3";

        given()
                .get(req_url)
                .then()
                .statusCode(404)
                .body(is("{}"));
    }
}

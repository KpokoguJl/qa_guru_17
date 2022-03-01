package site.kpokogujl.tests;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class CreateUserTests extends TestBase{
    Faker faker = new Faker();
    private final String api_url = baseUrl + "/api/users";

    @Test
    public void createUserTest(){
        String name = faker.name().firstName(),
                job = faker.job().title(),

                data = String.format("{\"name\": \"%s\", \"job\": \"%s\"}", name, job);

        Response response = given()
                    .contentType(ContentType.JSON)
                    .body(data)
                        .post(api_url)
                    .then()
                    .statusCode(201)
                        .extract().response();
        String res_name = response.path("name"),
                res_job = response.path("job");

        assertThat(res_name).isEqualTo(name);
        assertThat(res_job).isEqualTo(job);
    }
}


package at.htl.carrental.boundary;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class TimeServerResourceTest {
    @Test
    public void fetchTime() {
        when()
                .get("time")
                .then()
                .statusCode(200)
                .body(startsWith("Time:"));
    }
}
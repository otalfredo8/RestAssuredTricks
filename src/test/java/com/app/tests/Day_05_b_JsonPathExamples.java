package com.app.tests;

import com.app.utlities.Day_04_e_BookITRestUtility;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Day_05_b_JsonPathExamples {
    Logger log = Logger.getLogger(Day_05_b_JsonPathExamples.class);

    @Test
    public void paths_test() {
        log.info("starting the method");


        String token = Day_04_e_BookITRestUtility.getTeacherToken();

        Response response = given().header("Authorization", token)
                .get("/api/clusters");

        JsonPath jsonPath = response.jsonPath();

        Object id = jsonPath.get("id");
        System.out.println(id);

        // get the list of IDs in the top level
        List<String> idsString = jsonPath.get("id");
        System.out.println(idsString);

        String idOfFirstObject = jsonPath.getString("id[0]");
        log.info(idOfFirstObject);


        Integer idOfFirstObjectNumber = jsonPath.getInt("id[0]");
        log.info(idOfFirstObjectNumber);

        List<String> isListSt = jsonPath.getList("id");
        log.info(isListSt);

        String harvard = jsonPath.getString("rooms[0].name[0]");
        log.info(harvard);


        // get all rooms in every cluster
        List<String> allrooms = jsonPath.getList("rooms.name.", String.class);
        log.info("size: " + allrooms.size());
        log.info(allrooms);

        // get the first cluster in the resp
        Map<String, Object> cluster1 = jsonPath.getMap("[0]");
        log.info(cluster1);
        for (Object s : cluster1.keySet()) {
            log.info(s);
            log.info(cluster1.get(s));
        }

        Map<String, String> cluster1String = jsonPath.getMap("[0]");
        log.info(cluster1String+"askjflasjdlfkjsadlfkjasdlkfjadsjflkdsajflasjdflskdjflksdjflksdjlkfjdl");

        for (String s : cluster1String.keySet()) {
            log.info(s);
            log.info(cluster1String.get(s));
        }

        Map<String, String> harv = jsonPath.getMap("[0].rooms[0]");
        System.out.println(harv);
        for (String s : harv.keySet()) {
            log.info(harv.get(s));
        }

        // CASTING
        Map<String, String> harv2 =
                jsonPath.getMap("[0].rooms[0]", String.class, String.class);
        System.out.println(harv);
        for (String s : harv.keySet()) {
            log.info(harv2.get(s));
        }

        // get is as doubles

        List<Double> id2 = jsonPath.getList("id", Double.class);
        System.out.println(id2);



    }
}

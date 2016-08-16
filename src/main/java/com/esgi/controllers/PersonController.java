package com.esgi.controllers;

import com.esgi.model.Casting;
import com.esgi.model.Person;
import com.esgi.services.PersonService;
import com.esgi.utils.SearchUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Class PersonController
 */
@Controller
@RequestMapping("/person")
public class PersonController extends BaseController {

    /**
     * @param personService PersonService
     */
    @Autowired
    private PersonService personService;

    @RequestMapping(method = GET)
    public String all(Model model) {
        ArrayList<Person> listPersons =  (ArrayList) personService.getPersons();
        model.addAttribute("listPersons", listPersons);
        return "person";
    }

    /**
     * @param namePerson String
     * @return Person
     */
    @RequestMapping(value = "/{namePerson:[A-z]*}", method = GET)
    public String retrieveByName(@ModelAttribute SearchUtils searchUtils, Model model, @PathVariable("namePerson") String namePerson) {
        String queryValue = "";
        if (!searchUtils.getResearch().equals("")) {
            queryValue = searchUtils.getResearch();
        } else if (!namePerson.equals("")) {
            queryValue = namePerson;
        }

        if (!queryValue.equals("")) {
            try {
                InputStream is = new URL(URL_API + "&" + URL_GET_FILTER + FILTER_PERSON + "&" + URL_GET_SEARCH + queryValue).openStream();
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                JsonObject body = Json.createReader(new StringReader(parseJsonFromReader(rd))).readObject();
                ArrayList<Person> listPersons = parsePersonListFromAPI(body.getJsonObject("feed").getJsonArray("person"));
                model.addAttribute("listPersons", listPersons);

                if (listPersons.size() <= 0) {
                    model.addAttribute("info", "Aucune donnée trouvé.");
                } else {
                    personService.saves(listPersons);
                }
            } catch (IOException error) {
                System.out.println(error);
            }
        } else {
            model.addAttribute("info", "Aucune donnée trouvé.");
        }

        return "person";
    }

    /**
     * @param listPersonFromApi
     * @return
     */
    private ArrayList<Person> parsePersonListFromAPI(JsonArray listPersonFromApi) {
        ArrayList<Person> listPersons = new ArrayList();

        if (listPersonFromApi != null) {
            for (int i = 0; i < listPersonFromApi.size(); i++) {
                JsonObject personJson = listPersonFromApi.getJsonObject(i);
                if(personJson == null)
                    continue;
                Person person = new Person();
                //person.setId(personJson.getInt("code"));
                person.setName(personJson.getString("name"));
                DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

                try {
                    person.setBirthday((Date) fmt.parseObject(personJson.getString("birthDate")));
                } catch (ParseException e) {
                    System.out.println(e);
                } catch (NullPointerException npe) {
                    LOGGER.error("Exception : NullPointerException on birthDate JsonData");
                }

                if (personJson.get("picture") != null) {
                    person.setPicture(personJson.getJsonObject("picture").getString("href"));
                }

                if (personJson.get("link") != null) {
                    person.setLinkBo(personJson.getJsonArray("link").getJsonObject(0).getString("href"));
                }

                if (personJson.get("nationality") != null) {
                    person.setNationality(personJson.getJsonArray("nationality").getJsonObject(0).getString("$"));
                }

                if (personJson.get("activity") != null) {
                    HashSet<Casting> castings = new HashSet<>();

                    for (JsonValue activity : (JsonArray) personJson.get("activity")) {
                        Casting casting = new Casting();
                        casting.setRole(((JsonObject) activity).getString("$"));
                        castings.add(casting);
                    }

                    person.setRoles(castings);
                }

                listPersons.add(person);
            }
        }

        return (listPersons);
    }

}
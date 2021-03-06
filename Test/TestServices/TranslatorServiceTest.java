/*
* Software Engineering 3733, Worcester Polytechnic Institute
* Team H
* Code produced for Iteration1
* Original author(s): Erica Snow, Vojta Mosby, Tyrone Patterson
* The following code
*/

package TestServices;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import service.Staff;
import service.TranslatorService;

import java.util.ArrayList;

public class TranslatorServiceTest {

    public TranslatorServiceTest(){}

    private Staff spanishJoe;
    private Staff frenchBen;
    private ArrayList<Staff> translators = new ArrayList<>();
    private TranslatorService service;

    @Before
    public void initialize(){
        spanishJoe = new Staff("joe", "joe", "Translator", "Joe Man", 2, service);
        frenchBen = new Staff("ben", "ben", "Translator" ,"Ben Man", 3, service);
        service = new TranslatorService("Spanish", 100);
    }

    @Test
    public void assignPersonTest(){
        service.assignPerson(spanishJoe);
        assertTrue(service.getPersonnel().contains(spanishJoe));
    }

    @Test
    public void assignPeopleTest(){
        translators.add(spanishJoe);
        translators.add(frenchBen);
        service.assignPeople(translators);
        assertTrue(service.getPersonnel().contains(spanishJoe) && service.getPersonnel().contains(frenchBen));
    }
}

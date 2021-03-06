/*
* Software Engineering 3733, Worcester Polytechnic Institute
* Team H
* Code produced for Iteration1
* Original author(s): Nicholas Fajardo, Tyrone Patterson, Leo Grande, Meghana Bhatia
* The following code
*/

//testing file for Node testing each method
package TestMap;

import map.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NodeTest {
    public NodeTest(){}

    private Node N1 = new Node("A1", "0", "100", "L1", "Tower", "Bathroom", "Long1", "Short1", "H");
    private Node N1Copy = new Node("A1", "0", "100", "L1", "Tower", "Bathroom", "Long1", "Short1", "H");
    private Node N2 = new Node("A2", "100","100", "L1", "Tower", "Restaurant", "Long2", "Short2", "H");
    private Node N2Copy = new Node("A2", "100","100", "L1", "Tower", "Restaurant", "Long2", "Short2", "H");
    private Node N3 = new Node("A3", "200", "200", "L1", "Tower", "Desk", "Long3", "Short3", "H");

    @Before
    public void initialize(){

    }

    @Test
    public void testNodeParameters(){
        assertEquals("A1", N1.getID());
        assertEquals(0, N1.getX());
        assertEquals("0", N1.getXString());
        assertEquals(100, N1.getY());
        assertEquals("100", N1.getYString());
        assertEquals("L1", N1.getFloor());
        assertEquals("Tower", N1.getBuilding());
        assertEquals("Bathroom", N1.getType());
        assertEquals("Long1", N1.getLongName());
        assertEquals("Short1", N1.getShortName());
        assertEquals("H", N1.getTeam());
    }

    //Test toString() override
    @Test
    public void testNodeToString1(){
        assertEquals("Short1", N1.toString());
    }
    @Test
    public void testNodeToString2(){
        assertEquals("Short2", N2.toString());
    }
    @Test
    public void testNodeToString3(){
        assertEquals("Short3", N3.toString());
    }

    //Test equals() override
    @Test
    public void testNodeEquals1(){
        assertTrue(N1.equals(N1Copy));
    }
    @Test
    public void testNodeEquals2(){
        assertTrue(N2.equals(N2Copy));
    }
    @Test
    public void testNodeEqualsFail1(){
        assertFalse(N1.equals(N2));
    }
    @Test
    public void testNodeEqualsFail2(){
        assertFalse(N2.equals(N1Copy));
    }

    @Test
    public void testCost(){
    }
}

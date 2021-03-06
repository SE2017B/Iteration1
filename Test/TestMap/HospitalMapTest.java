/*
* Software Engineering 3733, Worcester Polytechnic Institute
* Team H
* Code produced for Iteration1
* Original author(s): Nicholas Fajardo, Tyrone Patterson, Leo Grande, Meghana Bhatia
* The following code
*/

package TestMap;

import map.*;
import org.junit.Before;
import org.junit.Test;

import static java.lang.Math.sqrt;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class HospitalMapTest {

    //set up example map for testing
    public HospitalMapTest() {
    }

    private HospitalMap smallArea = new HospitalMap();
    private Node N1 = new Node("A1", "0", "400", "L1", "Tower", "Bathroom", "Long1", "Short1", "H");
    private Node N2 = new Node("A2", "0", "200", "L1", "Tower", "Desk", "Long2", "Short2", "H");
    private Node N3 = new Node("A3", "0", "0", "L1", "Tower", "Desk", "Long3", "Short3", "H");
    private Node N4 = new Node("A4", "100", "300", "L1", "Tower", "Desk", "Long4", "Short4", "H");
    private Node N5 = new Node("A5", "100", "100", "L1", "Tower", "Stairs", "Long5", "Short5", "H");
    private Node N6 = new Node("A6", "200", "400", "L1", "Tower", "Desk", "Long6", "Short6", "H");
    private Node N7 = new Node("A7", "200", "300", "L1", "Tower", "Desk", "Long7", "Short7", "H");
    private Node N8 = new Node("A8", "200", "100", "L1", "Tower", "Bathroom", "Long8", "Short8", "H");
    private Node N9 = new Node("A9", "200", "0", "L1", "Tower", "Elevator", "Long9", "Short9", "H");
    private Node N10 = new Node("A10", "300", "300", "L1", "Tower", "Desk", "Long10", "Short10", "H");
    private Node N11 = new Node("A11", "300", "100", "L1", "Tower", "Bathroom", "Long11", "Short11", "H");
    private Node N12 = new Node("A12", "400", "400", "L1", "Tower", "Desk", "Long12", "Short12", "H");
    private Node N13 = new Node("A13", "400", "100", "L1", "Tower", "Desk", "Long13", "Short13", "H");
    private Node N14 = new Node("A14", "400", "100", "L1", "Tower", "Desk", "Long14", "Short14", "H");
    private Node N15 = new Node("A15", "400", "0", "L1", "Tower", "Stairs", "Long15", "Short15", "H");
    private Node N16 = new Node("A16", "600", "400", "L1", "Tower", "Office", "Long16", "Short16", "H");
    private Node N17 = new Node("A17", "600", "300", "L1", "Tower", "Office", "Long17", "Short17", "H");
    private Node N18 = new Node("A18", "500", "100", "L1", "Tower", "Bathroom", "Long18", "Short18", "H");
    private Node N19 = new Node("A19", "500", "0", "L1", "Tower", "Stairs", "Long19", "Short19", "H");
    private Node N20 = new Node("A20", "700", "300", "L1", "Tower", "Elevator", "Long20", "Short20", "H");
    private Node N21 = new Node("A21", "700", "100", "L1", "Tower", "Stairs", "Long21", "Short21", "H");
    private Node N22 = new Node("A22", "700", "0", "L1", "Tower", "Desk", "Long22", "Short22", "H");
    private Node N23 = new Node("A23", "800", "0", "L1", "Tower", "Desk", "Long23", "Short23", "H");


    @Before
    public void initialize() {
        //Creating nodes for the map

        //Add connections for nodeOne
        N1.addConnection(N2);
        N1.addConnection(N6);

        //Add connections for nodeTwo
        N2.addConnection(N3);
        N2.addConnection(N1);

        //Add connections for nodeThree
        N3.addConnection(N2);
        N3.addConnection(N9);

        //Add connections for nodeFour
        N4.addConnection(N7);
        N4.addConnection(N5);

        //Add connections for nodeFive
        N5.addConnection(N8);
        N5.addConnection(N4);

        //Add connections for nodeSix
        N6.addConnection(N1);
        N6.addConnection(N7);

        //Add connections for nodeSeven
        N7.addConnection(N4);
        N7.addConnection(N6);
        N7.addConnection(N8);
        N7.addConnection(N10);

        //Add connections for nodeEight
        N8.addConnection(N7);
        N8.addConnection(N9);
        N8.addConnection(N5);

        //Add connections for nodeNine
        N9.addConnection(N3);
        N9.addConnection(N8);
        N9.addConnection(N15);

        //Add connections for nodeTen
        N10.addConnection(N7);
        N10.addConnection(N11);

        //Add connections for nodeEleven
        N11.addConnection(N10);
        N11.addConnection(N14);

        //Add connections for nodeTwelve
        N12.addConnection(N13);
        N12.addConnection(N16);

        //Add connections for nodeThirteen
        N13.addConnection(N12);
        N13.addConnection(N14);
        N13.addConnection(N17);

        //Add connections for nodeFourteen
        N14.addConnection(N11);
        N14.addConnection(N13);
        N14.addConnection(N15);
        N14.addConnection(N18);

        //Add connections for nodeFifteen
        N15.addConnection(N9);
        N15.addConnection(N14);

        //Add connections for nodeSixteen
        N16.addConnection(N14);
        N16.addConnection(N17);

        //Add connections for nodeSeventeen
        N17.addConnection(N13);
        N17.addConnection(N16);
        N17.addConnection(N20);

        //Add connections for nodeEighteen
        N18.addConnection(N14);
        N18.addConnection(N19);
        N18.addConnection(N21);

        //Add connections for nodeNineteen
        N19.addConnection(N18);
        N19.addConnection(N22);

        //Add connections for nodeTwenty
        N20.addConnection(N17);
        N20.addConnection(N21);

        //Add connections for nodeTwentyOne
        N21.addConnection(N18);
        N21.addConnection(N20);
        N21.addConnection(N22);
        N21.addConnection(N23);

        //Add connections for nodeTwentyTwo
        N22.addConnection(N19);
        N22.addConnection(N21);

        //Add connections for nodeTwentyThree
        N23.addConnection(N21);
    }

    // findPath tests

    @Test
    //Node 1 to Node 9
    public void testMap1() throws InterruptedException {
        smallArea.setStart(N1);
        smallArea.setEnd(N9);

        String answer = smallArea.findPath(N9).toString();
        System.out.println(answer);
        assertEquals("[Short1, Short2, Short3, Short9]", answer);
    }
    @Test
    //Node 9 to Node 1
    public void testMap1Reverse() throws InterruptedException{
        smallArea.setStart(N9);
        smallArea.setEnd(N1);

        String answer = smallArea.findPath(N1).toString();
        System.out.println(answer);
        assertEquals("[Short9, Short8, Short7, Short6, Short1]", answer);
    }

    @Test
    //Node 1 to Node 10
    public void testMap2() throws InterruptedException{
        smallArea.setStart(N1);
        smallArea.setEnd(N10);

        String answer = smallArea.findPath(N10).toString();
        System.out.println(answer);
        assertEquals("[Short1, Short6, Short7, Short10]", answer);
    }
    @Test
    //Node 10 to Node 1
    public void testMap2Reverse() throws InterruptedException{
        smallArea.setStart(N10);
        smallArea.setEnd(N1);

        String answer = smallArea.findPath(N1).toString();
        System.out.println(answer);
        assertEquals("[Short10, Short7, Short6, Short1]", answer);
    }

    @Test
    //Node 1 to Node 12
    public void testMap3() throws InterruptedException{
        smallArea.setStart(N1);
        smallArea.setEnd(N12);

        String answer = smallArea.findPath(N12).toString();
        System.out.println(answer);
        assertEquals("[Short1, Short6, Short7, Short10, Short11, Short14, Short13, Short12]", answer);
    }
    @Test
    //Node 12 to Node 1
    public void testMap3Reverse() throws InterruptedException{
        smallArea.setStart(N12);
        smallArea.setEnd(N1);

        String answer = smallArea.findPath(N1).toString();
        System.out.println(answer);
        assertEquals("[Short12, Short16, Short14, Short11, Short10, Short7, Short6, Short1]", answer);
    }

    @Test
    //Node 1 to Node 20
    public void testMap4() throws InterruptedException{
        smallArea.setStart(N1);
        smallArea.setEnd(N20);

        String answer = smallArea.findPath(N20).toString();
        System.out.println(answer);
        assertEquals("[Short1, Short6, Short7, Short10, Short11, Short14, Short13, Short17, Short20]", answer);
    }
    @Test
    //Node 20 to Node 1
    public void testMap4Reverse() throws InterruptedException{
        smallArea.setStart(N20);
        smallArea.setEnd(N1);

        String answer = (smallArea.findPath(N1).toString());
        System.out.println(answer);
        assertEquals("[Short20, Short17, Short16, Short14, Short11, Short10, Short7, Short6, Short1]", answer);
    }

    @Test
    //Node 1 to Node 23
    public void testMap5() throws InterruptedException{
        smallArea.setStart(N1);
        smallArea.setEnd(N23);

        String answer = smallArea.findPath(N23).toString();
        System.out.println(answer);
        assertEquals("[Short1, Short6, Short7, Short10, Short11, Short14, Short18, Short21, Short23]", answer);
    }
    @Test
    //Node 23 to Node 1
    public void testMap5Reverse() throws InterruptedException{
        smallArea.setStart(N23);
        smallArea.setEnd(N1);

        String answer = smallArea.findPath(N1).toString();
        System.out.println(answer);
        assertEquals("[Short23, Short21, Short18, Short14, Short11, Short10, Short7, Short6, Short1]", answer);
    }

    @Test
    //Node 6 to Node 15
    public void testMap6() throws InterruptedException{
        smallArea.setStart(N6);
        smallArea.setEnd(N15);

        String answer = smallArea.findPath(N15).toString();
        System.out.println(answer);
        assertEquals("[Short6, Short7, Short8, Short9, Short15]", answer);
    }
    @Test
    //Node 15 to Node 6
    public void testMap6Reverse() throws InterruptedException{
        smallArea.setStart(N15);
        smallArea.setEnd(N6);

        String answer = smallArea.findPath(N6).toString();
        System.out.println(answer);
        assertEquals("[Short15, Short14, Short11, Short10, Short7, Short6]", answer);
    }

    @Test
    //Node 3 to Node 22
    public void testMap7() throws InterruptedException{
        smallArea.setStart(N3);
        smallArea.setEnd(N22);

        String answer = smallArea.findPath(N22).toString();
        System.out.println(answer);
        assertEquals("[Short3, Short9, Short15, Short14, Short18, Short19, Short22]", answer);
    }
    @Test
    //Node 22 to Node 3
    public void testMap7Reverse() throws InterruptedException{
        smallArea.setStart(N22);
        smallArea.setEnd(N3);

        String answer = smallArea.findPath(N3).toString();
        System.out.println(answer);
        assertEquals("[Short22, Short19, Short18, Short14, Short15, Short9, Short3]", answer);
    }

    @Test
    //Node 4 to Node 2
    public void testMap8() throws InterruptedException {
        smallArea.setStart(N4);
        smallArea.setEnd(N2);

        String answer = smallArea.findPath(N2).toString();
        System.out.println(answer);
        assertEquals("[Short4, Short7, Short6, Short1, Short2]", answer);
    }
    @Test
    //Node 2 to Node 4
    public void testMap8Reverse() throws InterruptedException {
        smallArea.setStart(N2);
        smallArea.setEnd(N4);

        String answer = smallArea.findPath(N4).toString();
        System.out.println(answer);
        assertEquals("[Short2, Short1, Short6, Short7, Short4]", answer);
    }

    @Test
    //Node 7 to Node 3
    public void testMap9() throws InterruptedException {
        smallArea.setStart(N7);
        smallArea.setEnd(N3);

        String answer = smallArea.findPath(N3).toString();
        System.out.println(answer);
        assertEquals("[Short7, Short8, Short9, Short3]", answer);
    }
    @Test
    //Node 3 to Node 7
    public void testMap9Reverse() throws InterruptedException {
        smallArea.setStart(N3);
        smallArea.setEnd(N7);

        String answer = smallArea.findPath(N7).toString();
        System.out.println(answer);
        assertEquals("[Short3, Short9, Short8, Short7]", answer);
    }
    @Test
    //Node 7 to Node 3
    public void testMap9Repeat() throws InterruptedException{
        smallArea.setStart(N7);
        smallArea.setEnd(N3);

        String answer1 = smallArea.findPath(N3).toString();
        String answer2 = smallArea.findPath(N3).toString();
        System.out.println(answer1);
        assertEquals(answer1, answer2);
        assertEquals("[Short7, Short8, Short9, Short3]", answer1);
    }

    @Test
    //Node 6 to Node 6
    public void testMap1Same() throws InterruptedException{
        smallArea.setStart(N6);
        smallArea.setEnd(N6);

        String answer = smallArea.findPath(N6).toString();
        System.out.println(answer);
        assertEquals("[Short6]", answer);
    }
    @Test
    //Node 18 to Node 18
    public void testMap2Same() throws InterruptedException{
        smallArea.setStart(N18);
        smallArea.setEnd(N18);

        String answer = smallArea.findPath(N18).toString();
        System.out.println(answer);
        assertEquals("[Short18]", answer);
    }
    @Test
    //Node 9 to Node 9
    public void testMap3Same() throws InterruptedException{
        smallArea.setStart(N9);
        smallArea.setEnd(N9);

        String answer = smallArea.findPath(N9).toString();
        System.out.println(answer);
        assertEquals("[Short9]", answer);

    }

    // findPath tests (2 Nodes given)

    @Test
    //Node 1 to Node 17
    public void testMap10() throws InterruptedException{
        smallArea.setStart(N1);
        smallArea.setEnd(N17);

        String answer = smallArea.findPath(N1, N17).toString();
        System.out.println(answer);
        assertEquals("[Short1, Short6, Short7, Short10, Short11, Short14, Short13, Short17]", answer);
    }
    @Test
    //Node 17 to Node 1
    public void testMap10Reverse() throws InterruptedException{
        smallArea.setStart(N17);
        smallArea.setEnd(N1);

        String answer = smallArea.findPath(N17, N1).toString();
        System.out.println(answer);
        assertEquals("[Short17, Short16, Short14, Short11, Short10, Short7, Short6, Short1]", answer);
    }

    @Test
    //Node 3 to Node 23
    public void testMap11() throws InterruptedException{
        smallArea.setStart(N3);
        smallArea.setEnd(N23);

        String answer = smallArea.findPath(N3, N23).toString();
        System.out.println(answer);
        assertEquals("[Short3, Short9, Short15, Short14, Short18, Short21, Short23]", answer);
    }
    @Test
    //Node 23 to Node 3
    public void testMap11Reverse() throws InterruptedException{
        smallArea.setStart(N23);
        smallArea.setEnd(N3);

        String answer = smallArea.findPath(N23, N3).toString();
        System.out.println(answer);
        assertEquals("[Short23, Short21, Short18, Short14, Short15, Short9, Short3]", answer);
    }

    @Test
    //Node 4 to Node 19
    public void testMap12() throws InterruptedException{
        smallArea.setStart(N4);
        smallArea.setEnd(N19);

        String answer = smallArea.findPath(N4, N19).toString();
        System.out.println(answer);
        assertEquals("[Short4, Short7, Short10, Short11, Short14, Short18, Short19]", answer);
    }

    @Test
    //Node 19 to Node 4
    public void testMap12Reverse() throws InterruptedException{
        smallArea.setStart(N19);
        smallArea.setEnd(N4);

        String answer = smallArea.findPath(N19, N4).toString();
        System.out.println(answer);
        assertEquals("[Short19, Short18, Short14, Short11, Short10, Short7, Short4]", answer);
    }

    @Test
    //Node 15 to Node 15
    public void testMap4Same() throws InterruptedException{
        smallArea.setStart(N15);
        smallArea.setEnd(N15);

        String answer = smallArea.findPath(N15, N15).toString();
        System.out.println(answer);
        assertEquals("[Short15]", answer);
    }

    @Test
    //Node 20 to Node 20
    public void testMap5Same() throws InterruptedException{
        smallArea.setStart(N20);
        smallArea.setEnd(N20);

        String answer = smallArea.findPath(N20, N20).toString();
        System.out.println(answer);
        assertEquals("[Short20]", answer);
    }

    @Test
    //Node 3 to Node 3
    public void testMap6Same() throws InterruptedException{
        smallArea.setStart(N3);
        smallArea.setEnd(N3);

        String answer = smallArea.findPath(N3, N3).toString();
        System.out.println(answer);
        assertEquals("[Short3]", answer);
    }

    @Test
    //Node 3 to Node 3
    public void testMap3To7() throws InterruptedException{
        smallArea.setStart(N3);
        smallArea.setEnd(N7);

        String answer = smallArea.findPath(N3, N7).toString();
        System.out.println(answer);
        assertEquals("[Node 3, Node 9, Node 8, Node 7]", answer);
    }

    @Test
    //Node 3 to Node 3
    public void testMap3To7Repeat() throws InterruptedException{
        smallArea.setStart(N3);
        smallArea.setEnd(N7);

        String answer = smallArea.findPath(N3, N7).toString();
        System.out.println(answer);
        assertEquals("[Node 3, Node 9, Node 8, Node 7]", answer);
        assertEquals("[Node 3, Node 9, Node 8, Node 7]", answer);
        assertEquals("[Node 3, Node 9, Node 8, Node 7]", answer);
    }

    @Test
    //Node 3 to Node 3
    public void testMapMultiplePaths() throws InterruptedException{
        smallArea.setStart(N3);
        smallArea.setEnd(N7);

        String answer = smallArea.findPath(N3, N7).toString();
        System.out.println(answer);
        assertEquals("[Node 3, Node 9, Node 8, Node 7]", answer);

        smallArea.setStart(N4);
        smallArea.setEnd(N20);

        answer = smallArea.findPath(N4, N20).toString();
        System.out.println(answer);
        assertEquals("[Node 4, Node 7, Node 10, Node 11, Node 14, Node 18, Node 21, Node 20]", answer);
    }

    // getEuclideanDistance tests
    @Test
    //Node 3 to Node 14
    public void testGetEuclideanDistance1(){
        assertEquals(sqrt(170000),smallArea.getEuclidianDistance(N3, N14), .01);
    }
    @Test
    //Node 14 to Node 3
    public void testGetEuclideanDistance1Reverse(){
        assertEquals(sqrt(170000), smallArea.getEuclidianDistance(N14, N3), .01);
    }

    @Test
    //Node 11 to Node 23
    public void testGetEuclideanDistance2(){
        assertEquals(sqrt(260000), smallArea.getEuclidianDistance(N11, N23), .01);
    }
    @Test
    //Node 23 to Node 11
    public void testGetEuclideanDistance2Reverse(){
        assertEquals(sqrt(260000), smallArea.getEuclidianDistance(N23, N11), .01);
    }

    @Test
    //Node 1 to Node 6
    public void testGetEuclideanDistance3(){
        assertEquals(sqrt(40000), smallArea.getEuclidianDistance(N1, N6), .01);
    }
    @Test
    //Node 6 to Node 1
    public void testGetEuclideanDistance3Reverse(){
        assertEquals(sqrt(40000), smallArea.getEuclidianDistance(N6, N1), .01);
    }

    @Test
    //Node 5 to Node 5
    public void testGetEuclideanDistanceSame(){
        assertEquals(0, smallArea.getEuclidianDistance(N5, N5), .01);
    }


    @Test
    //Node 6 to Node 1
    public void testTwoPaths(){
        assertEquals(smallArea.findPath(N4, N1),smallArea.findPath(N4, N1));
    }

}
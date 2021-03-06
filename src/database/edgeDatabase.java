package database;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class edgeDatabase {

    private static final String JDBC_URL="jdbc:derby:teamHDB;create=true";
    private static Connection conn;

    ///////////////////////////////////////////////////////////////////////////////
    // Add an edge function
    ///////////////////////////////////////////////////////////////////////////////

    // Add item(s) from corresponding ArrayList

    // Add new edge to the edge table

    public static void addEdge(String anyStartNode, String anyEndNode) {
        try {
            conn = DriverManager.getConnection(JDBC_URL);
            conn.setAutoCommit(false);
            conn.getMetaData();

            String anyEdgeID = (anyStartNode + "_" + anyEndNode);

            PreparedStatement addAnyEdge = conn.prepareStatement("INSERT INTO mapHEdges VALUES (?, ?, ?)");

            addAnyEdge.setString(1, anyEdgeID);
            addAnyEdge.setString(2, anyStartNode);
            addAnyEdge.setString(3, anyEndNode);

            addAnyEdge.executeUpdate();
            System.out.println("Insert Edge Successful for edgeID: " + anyEdgeID);

            conn.commit();
            addAnyEdge.close();
            conn.close();

            // Add nodes to their ArrayLists
            mainDatabase.edgeID.add(anyEdgeID);
            mainDatabase.startNode.add(anyStartNode);
            mainDatabase.endNode.add(anyEndNode);

        } catch (Exception e) {
            e.printStackTrace();// end try
        }
    }

    ///////////////////////////////////////////////////////////////////////////////
    // Modify an edge from the edge table
    ///////////////////////////////////////////////////////////////////////////////

    // Modify item(s) from corresponding ArrayList

    // Modify item(s) from edge table

    public static void modifyEdge(String colAttr, String setCond, String anyEdgeID) {
        try {
            conn = DriverManager.getConnection(JDBC_URL);
            conn.setAutoCommit(false);
            conn.getMetaData();

            String code= "UPDATE MapHEdges SET "+ colAttr+ " = ? WHERE edgeID = ?";

            PreparedStatement modifyAnyEdge = conn.prepareStatement(code);

            modifyAnyEdge.setString(1, setCond);
            modifyAnyEdge.setString(2, anyEdgeID);

            modifyAnyEdge.executeUpdate();
            System.out.println("Update Edge Successful!");

            conn.commit();
            modifyAnyEdge.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();// end try
        }

        // Add nodes to their ArrayLists
        int indexOf = mainDatabase.edgeID.indexOf(anyEdgeID);

        switch (colAttr) {

            case "edgeID":
                mainDatabase.edgeID.remove(indexOf);
                mainDatabase.edgeID.add(indexOf, setCond);
                break;

            case "startNode":
                mainDatabase.startNode.remove(indexOf);
                mainDatabase.startNode.add(indexOf, setCond);
                break;

            case "endNode":
                mainDatabase.endNode.remove(indexOf);
                mainDatabase.endNode.add(indexOf, setCond);
                break;

            default:
                break;
        }
    }

    ///////////////////////////////////////////////////////////////////////////////
    // Delete an edge from the edge table
    ///////////////////////////////////////////////////////////////////////////////

    // Delete item(s) from corresponding ArrayList

    // Delete item(s) from edge table
    public static void deleteAnyEdge(String delCond) {
        try {
            conn = DriverManager.getConnection(JDBC_URL);
            conn.setAutoCommit(false);
            conn.getMetaData();

            PreparedStatement deleteAnyEdge = conn.prepareStatement("DELETE FROM mapHEdges WHERE edgeID = ?");

            deleteAnyEdge.setString(1, delCond);

            deleteAnyEdge.executeUpdate();
            System.out.println("Delete Edge Successful");

            conn.commit();
            deleteAnyEdge.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();// end try
        }

        int indexOf2 = mainDatabase.edgeID.indexOf(delCond);

        mainDatabase.edgeID.remove(indexOf2);
        mainDatabase.startNode.remove(indexOf2);
        mainDatabase.endNode.remove(indexOf2);

    }

    ///////////////////////////////////////////////////////////////////////////////
    // Query all edges from the edge table
    ///////////////////////////////////////////////////////////////////////////////
    public static void queryAllEdges() {
        try {
            conn = DriverManager.getConnection(JDBC_URL);
            conn.setAutoCommit(false);
            conn.getMetaData();

            Statement selectAllEdges = conn.createStatement();
            String allEdges = "SELECT * FROM MAPHEDGES";
            ResultSet rsetAllEdges = selectAllEdges.executeQuery(allEdges);

            String strEdgeID = "";
            String strStartNode = "";
            String strEndNode = "";

            System.out.println("");
            System.out.printf("%-30s %-20s %-20s\n", "edgeID", "startNode", "endNode");

            //Process the results
            while (rsetAllEdges.next()) {
                strEdgeID = rsetAllEdges.getString("edgeID");
                strStartNode = rsetAllEdges.getString("startNode");
                strEndNode = rsetAllEdges.getString("endNode");

                System.out.printf("%-30s %-20s %-20s\n", strEdgeID, strStartNode, strEndNode);
            } // End While

            conn.commit();

            rsetAllEdges.close();
            selectAllEdges.close();
            conn.close();

        } // end try
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

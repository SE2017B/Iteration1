/*
* Software Engineering 3733, Worcester Polytechnic Institute
* Team H
* Code produced for Iteration1
* Original author(s): Erica Snow, Vojta Mosby, Tyrone Patterson
* The following code
*/

package service;

import java.util.ArrayList;

public class Service{
    protected String type;
    protected ArrayList<Staff> personnel;
    protected ArrayList<ServiceRequest> backlog;
    protected ArrayList<Staff> availablePer;
    protected String description;

    public Service(){
        personnel = new ArrayList<>();
        backlog = new ArrayList<>();
        availablePer = new ArrayList<>();
    }

    /*
    adds a staff member to the list of staff members in a service and a list of staff
    available to fill a request
     */
    public void assignPerson(Staff person){
        this.personnel.add(person);
        this.availablePer.add(person);
    }
    /*
    adds multiple staff members to the lists
     */
    public void assignPeople(ArrayList<Staff> people){
        this.personnel.addAll(people);
        this.availablePer.addAll(people);
    }

    /*
    gives an available staff member a request assignment, or adds the request to a
    backlog if there are no free staff members
     */
    public void addRequest(ServiceRequest request){
        if(availablePer.isEmpty()) {
            System.out.println("Staff Are Busy, Added to Backlog");
            backlog.add(request);
        }else{
            Staff avaStaff = availablePer.get(0);
            if(!avaStaff.isBusy()) {
                System.out.println("Service Request Added");
                avaStaff.setCurrentRequest(request);
                availablePer.remove(avaStaff);
            }

        }
    }

    /*
    adds a staff member to a list of people available for a request assignment
     */
    public void addAvailable(Staff staff) {
        availablePer.add(staff);
    }

    //getters
    public String getType(){
        return this.type;
    }

    public void addPersonnel(Staff staff){
        personnel.add(staff);
        addAvailable(staff);
    }
    public ArrayList<Staff> getPersonnel(){
        return this.personnel;
    }
    public ArrayList<ServiceRequest> getBacklog() {
        return backlog;
    }
    public ArrayList<Staff> getAvailablePer() {
        return availablePer;
    }
    public String getDescription(){
        return this.description;
    }

    public ServiceRequest getNextRequest() {
        if(backlog.isEmpty()) {
            return null;
        }
        return backlog.remove(0);
    }

    //setters
    public void setType(String type){ this.type = type; }
    public void setDescription(String description){
        this.description = description;
    }
}
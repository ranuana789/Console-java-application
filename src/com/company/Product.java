package com.company;

public class Product {
    private int id;
    private String name;
    private String details;
    public Product(){
    }
    public Product(int id, String name, String details){
        setID(id);
        setName(name);
        setDetails(details);
    }
    public Product(String name, String details) {
        setName(name);
        setDetails(details);
    }
    public int getID(){ return id;}
    public void setID(int id){ this.id = id;}
    public String getName(){ return name;}
    public void setName(String name){ this.name = name;}
    public String getDetails(){ return details;}
    public void setDetails(String surname){ this.details = details;}
    @Override
    public String toString() {
        return "User{ "+
                "id='" +id +
                ", name='" + name + '\''+
                ", details='" + details + '\'' +
                '}';
    }
}

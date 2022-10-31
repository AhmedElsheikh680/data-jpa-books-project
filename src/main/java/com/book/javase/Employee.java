package com.book.javase;

public  class Employee {

    private int id;

    private String name;

    private Object object = new Object(){
        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public String toString() {
            return super.toString();
        }
    };

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee() {

    }

    public int getId() {
        return id;
    }

    public String getDetails() {
        return "Id: "+ id+ " Name: "+name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public abstract String test(int x, int y);

    public void setState(PowerState powerState) {
        switch (powerState){
            case ON:
                System.out.println("ON");
                break;
            case OFF:
                System.out.println("OFF");
                break;
            case SUSBEND:
                System.out.println("SUSBEND");
                break;
            default:
                System.out.println("Invalid!!!!!!!!!");
        }
    }
}

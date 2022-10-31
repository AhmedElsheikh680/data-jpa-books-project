package com.book.javase;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public  class Manager extends Employee{
    private int dept;

    public Manager(int id, String name, int dept) {
        super(id, name);
        this.dept = dept;
    }

    @Override
    public String getDetails() {
        return super.getDetails()+ " Dept: "+dept;
    }

//    @Override
//    public String test(int x, int y) {
//        return null;
//    }


}

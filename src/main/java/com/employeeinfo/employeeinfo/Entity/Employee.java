package com.employeeinfo.employeeinfo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_emp")
public class Employee
    {
        @Id
        @SequenceGenerator(name="seqTest",sequenceName="TEST_SEQ")
        @GeneratedValue(strategy=SEQUENCE,generator="seqTest")
        int id;

        
        String name;

        String yearOfJoining;

       
        double salary;

        String dept;


      /*  @Override
        public String toString()
        {
            return "Id : "+id
                    +", Name : "+name
                    +", Year Of Joining : "+yearOfJoining
                    +", Salary : "+salary;
        }*/
    }


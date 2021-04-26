package Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="departments")
public class Departments {
    
    @Id
    @Column(name="dept_no")
    private int dept_no;
        
    @Column(name="dept_name")
    private char dept_name;        

    public Departments(int dept_no, char dept_name) {
        this.dept_no = dept_no;
        this.dept_name = dept_name;
    }

    public Departments(){
    
    }

    public int getDept_no() {
        return dept_no;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }

    public char getDept_name() {
        return dept_name;
    }

    public void setDept_name(char dept_name) {
        this.dept_name = dept_name;
    }

    @Override
    public String toString() {
        return "Departments[" + "dept_no=" + dept_no + ", dept_name=" + dept_name + "]";
    }        
            
}

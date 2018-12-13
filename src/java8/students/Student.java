package java8.students;

import java.time.LocalDate;

public class Student {
    public Student(long l, String zhangsan, Gender male, Integer age, Department at, Integer credit, LocalDate of) {
    }

    public enum Gender{
        FEMALE,
        MALE

    }
    public enum Department{
        CS,SE,CN,AT
    }
    private long id;
    private  String name;
    private Gender gender;
    private  Integer age;
    private  Department department;
    private Integer credit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEntryDate() {
        return localDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this. localDate= entryDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private LocalDate localDate;

    @Override
    public String toString() {
      //  return String.format("Student{id=%s,,name=%s,gender=%s,age=%d,}",id,name,gender,age)
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", department=" + department +
                ", credit=" + credit +
                ", entryDate=" +  +
                '}';
    }

}

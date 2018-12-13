package java8.students;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;


public class StudentStates {

    public static void main(String[] args) {
        List<Student> students = readDB();

       long studentCount= students
               .stream()
               .mapToLong(s->1L)
               .sum();
       log("total number of student is:",studentCount);

       long  totalCredits=students
               .stream()
               .mapToLong(Student::getCredit)
               .sum();
       log("total credits of student is",totalCredits);

       Map<Student.Gender,Long> grounpCountByGender=students.stream()
               .collect(Collectors.groupingBy(Student::getGender,Collectors.counting()));

       log("total number by gender is",grounpCountByGender);

        Optional<Student> maxCredit=students.stream()
                .max((s1,s2)->s2.getCredit()-s1.getCredit());

        if(maxCredit.isPresent()){
            log("max credit is",maxCredit.get().getName());

        }else{
            log("can nit find","!");
        }


        Integer sumCredits =students.stream()
                .reduce(0,

                        (Integer partialSum,Student s)->{
                        Integer middle =partialSum+s.getCredit();
                            System.out.println(Thread.currentThread().getName()+" "+s.getName()+" "+middle);
                            return middle;
                        },
                        (a,b)->{   //连接器，单线程返回null即可
                            System.out.println(Thread.currentThread().getName()+" "+a+" "+b);
                            return null;
                        });
        log("the sum credits is",sumCredits);
        boolean allMale=students.stream().allMatch(s->s.getGender()==Student.Gender.MALE);   //判断所有是否为女生
        log("whether all student are male:",allMale);

        LongSummaryStatistics creditStats=students.stream()
                .map(Student::getCredit)
                .collect(LongSummaryStatistics::new,
                        LongSummaryStatistics::accept,
                        LongSummaryStatistics::combine);
        log("starts",creditStats);
        Map<String,Integer> simpleStudent= students.stream()
          .collect(Collectors.toMap(Student::getName,Student::getCredit));



        log("name.credits",simpleStudent);


        String names=students.stream()
          .filter(s->s.getCredit()>=60)
          .map(Student::getName)
          .collect(Collectors.joining(",","YD 2018 best<",">"));
        log("",names);
     //     students.sort((s1,s2)->s2.getCredit()-s1.getCredit());
     //        System.out.println(students);
    }




  //list可以用流
        private static List<Student> readDB() {
            Student s1 = new Student(1L, "zhangsan", Student.Gender.MALE, 20, Student.Department.AT, 50, LocalDate.of(1996, Month.FEBRUARY, 12));
            Student s2 = new Student(4L, "yumingyue", Student.Gender.MALE, 20, Student.Department.AT, 50, LocalDate.of(1996, Month.FEBRUARY, 9));
            Student s3 = new Student(2L, "zhangsan", Student.Gender.MALE, 23, Student.Department.CS, 50, LocalDate.of(1996, Month.DECEMBER, 12));
            Student s4 = new Student(4L, "wangwu", Student.Gender.MALE, 21, Student.Department.SE, 43, LocalDate.of(1995, Month.APRIL, 12));
            Student s5 = new Student(1L, "liuning", Student.Gender.MALE, 24, Student.Department.CN, 50, LocalDate.of(1998, Month.FEBRUARY, 3));
            Student s6 = new Student(5L, "xaiowei", Student.Gender.MALE, 22, Student.Department.AT, 30, LocalDate.of(1996, Month.FEBRUARY, 12));
            Student s7 = new Student(4L, "liuxue", Student.Gender.MALE, 21, Student.Department.AT, 50, LocalDate.of(1996, Month.NOVEMBER, 2));
            Student s8 = new Student(1L, "wangsi", Student.Gender.MALE, 23, Student.Department.AT, 50, LocalDate.of(1993, Month.FEBRUARY, 5));
            Student s9 = new Student(2L, "zhangsan", Student.Gender.MALE, 21, Student.Department.CS, 23, LocalDate.of(1996, Month.DECEMBER, 12));
            Student s10= new Student(2L, "weichen", Student.Gender.MALE, 22, Student.Department.AT, 50, LocalDate.of(1992, Month.FEBRUARY, 3));
            Student s11= new Student(2L, "zhaoliying", Student.Gender.MALE, 20, Student.Department.SE, 30, LocalDate.of(1993, Month.FEBRUARY, 24));

            return Arrays.asList(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11);

        }
        private static void log(String prefix, Object content){

            System.out.println(prefix+content);
        }

}

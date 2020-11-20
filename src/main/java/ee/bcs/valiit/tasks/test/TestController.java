package ee.bcs.valiit.tasks.test;

import ee.bcs.valiit.tasks.test.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class TestController {

//
//    @GetMapping("hello")
//    public String hello(){
//        return "Hello World Again!";
//    }
//
//     localhost:8080/text/assd?employeeId=5&testId=4
//    @GetMapping("/text/{text}")
//    public String test(@PathVariable("text") String text,
//                       @RequestParam("employeeId") Long employeeId,
//                       @RequestParam(value = "testId", required = false)
//                                   Long optional){
//        return text + " :) " + employeeId;
//    }
    List<Employee> employeeList = new ArrayList<>();

    @PostMapping("employee")
    public void addEmployee(@RequestBody Employee employee){
        employeeList.add(employee);
    }

    @GetMapping("employee")
    public List<Employee> employeeList() {
        return employeeList;
    }

    @GetMapping("employee/{id}")
    public Employee getEmp(@PathVariable("id") int id){
        return employeeList.get(id);
    }

    @PutMapping("employee/{id}")
    public Employee replaceEmp(@PathVariable("id") int id,
                               @RequestBody Employee employee){
        return employeeList.set(id, employee);
    }

    @DeleteMapping("employee/{id}")
    public Employee deleteEmp(@PathVariable("id") int id){
        return employeeList.remove(id);
    }



    @GetMapping("dto-test")
    public Employee getEmployee(){
        Employee e = new Employee();
        e.setFirstName("Makar");
        e.setLastName("Sokarev");
        return e;
    }

    @PostMapping("dto-test")
    public List<Employee> getEmployee2(@RequestBody Employee employee){
        List<Employee> list = new ArrayList<>();
        Employee e = new Employee();
        e.setFirstName("rakaM");
        e.setLastName("verakoS");
        list.add(employee);
        list.add(e);
        return list;
    }



    public int fibonacci(int x) {
        int n0 = 0;
        int n1 = 1;
        int fibo = 0;

        for (int i = 0; i < x; i++) {
            fibo = n0 + n1;
            n0 = n1;
            n1 = fibo;
        }
        return n1;
    }

    @GetMapping("ex2")
    public List<Integer> ex2(@RequestParam("value") int value) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < value; i++) {
            list.add(i);
        }
        return list;
    }

    Random random = new Random();
    int ran = random.nextInt(100);
    int count = 0;

    @GetMapping("random")
    public String ex3(@RequestParam(value = "nr", required = false)  Integer y ){

        if(y == null){

        }

        String s = "You need to guess the number from 0 to 100. Please insert the number: ";
        String x = "";

            if (y == ran) {
                x = "You guessed the number and spent for it " + count + " tries:";
            } else if (y < ran) {
                x = "The number is greater. Try again.\nInsert the number: ";
                count++;
            } else if (y > ran) {
                x = "The number is less. Try again.\nInsert the number: ";
                count++;
            }
        return ran + s + x;
    }

    @GetMapping("company/{nr}/employee/{nr2}/contract/{nr3}")
    public String ex1(@PathVariable("nr") int x,
                      @PathVariable("nr2") int y,
                      @PathVariable("nr3") int z) {
        return x + " " + y + " " + z;
    }

    @GetMapping("company/{value}")
    public String ex3(@PathVariable("value") int x,
                      @RequestParam("company") int y,
                      @RequestParam("a") String s,
                      @RequestParam("b") String m){
        return x + " " + y + " " + s + " " + m;
    }

    @GetMapping("a/*/a/{a}/{b}/c")
    public String ex3(@PathVariable("a") String a,
                      @RequestParam("a") String aa,
                      @RequestParam("b") Integer bb,
                      @PathVariable("b") Integer b){
        return a + " " + aa + " " + bb + " " + b;
    }





}

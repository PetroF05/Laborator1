package md.usm.lab1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSonDecode {public static void main(String[] args) {
    JSONParser parser = new JSONParser();
    try{
        Object obj = parser.parse(new FileReader("departments.json"));

        JSONObject obj1 = (JSONObject) obj;
        System.out.println(obj);

        System.out.println();
        System.out.println("Company");
        JSONArray company = (JSONArray) obj1.get("company");
        System.out.println(company);
        System.out.println();

        int companyLength = company.size();


        System.out.println("Departments");
        for (int i = 0; i < companyLength; i++){
            JSONObject listDepartments = (JSONObject) company.get(i);
            System.out.println((i+1)+".  "+listDepartments);
            JSONArray department = (JSONArray) listDepartments.get("department");
            System.out.println("Value --> "+department);

            System.out.println();
            JSONObject departmentInf = (JSONObject) department.get(0);
            System.out.println("Department");
            System.out.println("Name: "+departmentInf.get("name"));
            System.out.println("Id: "+departmentInf.get("depId"));
            System.out.println("\nEmployees");

            getIngTag2(department, 1);
            getIngTag2(department, 2);

            System.out.println();
        }

    }catch (ParseException | FileNotFoundException pe){
        pe.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public static void getIngTag2(JSONArray department, int index){
        JSONObject employeeList = (JSONObject) department.get(index);
        JSONObject employee = (JSONObject) employeeList.get("employee");
        System.out.println("Id: "+employee.get("empId"));
        System.out.println("Last name: "+employee.get("lastName"));
        System.out.println("First name: "+employee.get("firstName"));
        System.out.println("Birth date: "+employee.get("birthDate"));
        System.out.println("Position: "+employee.get("position"));
        System.out.println("Skills: ");
        JSONObject skills = (JSONObject) employee.get("skills");
        System.out.println("  1 : "+skills.get("1"));
        System.out.println("  2 : "+skills.get("2"));
        System.out.println("  3 : "+skills.get("3"));
        System.out.println("  4 : "+skills.get("4"));
        System.out.println("Manager id "+employee.get("managerId"));
        System.out.println();
    }
}

package md.usm.lab1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class JSonCreate {
    public static void main(String[] args) {
        JSONObject company = new JSONObject();
        JSONArray companyList = new JSONArray();
        JSONObject department1 = new JSONObject();
        JSONObject department2 = new JSONObject();
        JSONArray department1WithId = new JSONArray();
        JSONArray department2WithId = new JSONArray();
        JSONObject employee1 = new JSONObject();
        JSONObject employee2 = new JSONObject();
        JSONObject employee3 = new JSONObject();
        JSONObject employee4 = new JSONObject();

        JSONObject department1WithValue = new JSONObject();
        JSONObject department2WithValue = new JSONObject();

        ////////////////////////////////////////////////

        Map<Object, Object> map21 = new LinkedHashMap<>();
        map21.put("empId", "001");
        map21.put("lastName", "Cornelis");
        map21.put("firstName", "Willem");
        map21.put("birthDate", "01.01.1990");
        map21.put("position", "Department Manager");

        Map<Integer, String> array = new LinkedHashMap<>();
        array.put(1, "Communication");
        array.put(2, "Java");

        map21.put("skills", array);
        map21.put("managerId", "0");

        employee1.put("employee", map21);
        department1WithValue.put("department", employee1);


        ////////////////////////////////////////////////////

        Map<Object, Object> map22 = new LinkedHashMap<>();
        map22.put("empId", "002");
        map22.put("lastName", "Adelung");
        map22.put("firstName", "Friedrich Von");
        map22.put("birthDate", "04.12.1988");
        map22.put("position", "Developer");

        Map<Integer, String> array2 = new LinkedHashMap<>();
        array2.put(1, "C#");
        array2.put(2, "Html");
        array2.put(3, "C++");
        map22.put("skills", array2);
        map22.put("managerId", "001");

        employee2.put("employee", map22);

        ////////////////////////////////////////////////////////
        Map<Object, Object> map23 = new LinkedHashMap<>();
        map23.put("empId", "003");
        map23.put("lastName", "Bernhart");
        map23.put("firstName", "Johann");
        map23.put("birthDate", "01.09.1980");
        map23.put("position", "Department Manager");

        Map<Integer, String> array3 = new LinkedHashMap<>();
        array3.put(1, "Communication");
        array3.put(2, "Java");
        array3.put(3, "Management");
        map23.put("skills", array3);
        map23.put("managerId", "0");

        employee3.put("employee", map23);
        department2WithValue.put("department", employee3);

        //////////////////////////////////////////////////////////////////

        Map<Object, Object> map24 = new LinkedHashMap<>();
        map24.put("empId", "004");
        map24.put("lastName", "Balabin");
        map24.put("firstName", "Victor");
        map24.put("birthDate", "01.01.1995");
        map24.put("position", "Database administrator");

        Map<Integer, String> array4 = new LinkedHashMap<>();
        array4.put(1, "SQL");
        array4.put(2, "JAVA");
        array4.put(3, "PHP");
        map24.put("skills", array4);
        map24.put("managerId", "003");

        employee4.put("employee", map24);

        ////////////////////////////////////////////////

        Map<Object, Object> map1 = new LinkedHashMap<>();
        map1.put("name", "Development");
        map1.put("depId", "1");
        department1WithId.add(map1);
        department1WithId.add(employee1);
        department1WithId.add(employee2);

        Map<Object, Object> map12 = new LinkedHashMap<>();
        map12.put("name", "Accounting");
        map12.put("depId", "2");
        department2WithId.add(map12);
        department2WithId.add(employee3);
        department2WithId.add(employee4);

        department1.put("department",department1WithId);
        department2.put("department",department2WithId);

        companyList.add(department1);
        companyList.add(department2);

        company.put("company", companyList);


        try(FileWriter file = new FileWriter("departments.json")){
            file.write(company.toJSONString());
            file.flush();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}

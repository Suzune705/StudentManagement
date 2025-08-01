package src.data;

import src.model.Students;

import java.io.IOException;
import java.io.* ;
import java.util.ArrayList;
import java.util.List;

// FileReader : mở luồng đọc file
// readline  : đọc tới cuối dòng sẽ trả về null
// wrileLine : ghi nhưng ko tự xuống dòng , cần write.newLine
public class LoadStudentInformation {

    public static List<Students> loadInfo(File file){
        List<Students> studentList = new ArrayList<>();
        String line ;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            // đọc từng dòng
            while( (line = br.readLine()) != null){
                String[] tmp = line.split(",");
                String id = tmp[0];
                String name = tmp[1];
                int age = Integer.parseInt(tmp[2]);
                String studentClass = tmp[3];
                double gpa = Double.parseDouble(tmp[4]);
                String phone = tmp[5];
                String address = tmp[6];
                Students s = new Students(id, name, age, studentClass, gpa, phone, address);
                studentList.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(studentList.isEmpty()) return null ;
        return studentList ;
    }

}

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
                String phoneNumber = tmp[3];
                String address = tmp[4];
                String studentClass = tmp[5];
                double gpa = Double.parseDouble(tmp[6]);
                Students s = new Students(id, name, age, phoneNumber, address, studentClass, gpa);
                studentList.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(studentList.isEmpty()) return null ;
        return studentList ;
    }

}

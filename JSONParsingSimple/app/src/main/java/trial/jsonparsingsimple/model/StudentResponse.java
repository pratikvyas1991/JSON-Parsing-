
package trial.jsonparsingsimple.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentResponse {

    @SerializedName("students")
    @Expose
    private List<StudentModel> students = new ArrayList<StudentModel>();

    /**
     * 
     * @return
     *     The students
     */
    public List<StudentModel> getStudents() {
        return students;
    }

    /**
     * 
     * @param students
     *     The students
     */
    public void setStudents(List<StudentModel> students) {
        this.students = students;
    }

}

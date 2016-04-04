
package trial.jsonparsingsimple.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class StudentModel {

    @SerializedName("Id")
    @Expose
    private String Id;
    @SerializedName("Name ")
    @Expose
    private String Name;
    @SerializedName("Password")
    @Expose
    private String Password;
    @SerializedName("Age")
    @Expose
    private String Age;
    @SerializedName("Mobile")
    @Expose
    private String Mobile;
    @SerializedName("Gender")
    @Expose
    private String Gender;

    /**
     * 
     * @return
     *     The Id
     */
    public String getId() {
        return Id;
    }

    /**
     * 
     * @param Id
     *     The Id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * 
     * @return
     *     The Name
     */
    public String getName() {
        return Name;
    }

    /**
     * 
     * @param Name
     *     The Name 
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * 
     * @return
     *     The Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * 
     * @param Password
     *     The Password
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * 
     * @return
     *     The Age
     */
    public String getAge() {
        return Age;
    }

    /**
     * 
     * @param Age
     *     The Age
     */
    public void setAge(String Age) {
        this.Age = Age;
    }

    /**
     * 
     * @return
     *     The Mobile
     */
    public String getMobile() {
        return Mobile;
    }

    /**
     * 
     * @param Mobile
     *     The Mobile
     */
    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    /**
     * 
     * @return
     *     The Gender
     */
    public String getGender() {
        return Gender;
    }

    /**
     * 
     * @param Gender
     *     The Gender
     */
    public void setGender(String Gender) {
        this.Gender = Gender;
    }

}

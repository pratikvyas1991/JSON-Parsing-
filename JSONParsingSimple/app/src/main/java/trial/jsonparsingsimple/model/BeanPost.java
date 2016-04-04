package trial.jsonparsingsimple.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vyas on 3/21/2016.
 */
public class BeanPost {
    @SerializedName("post_name")
    private String post_name;
    @SerializedName("auther")
    private String author;
    @SerializedName("date")
    private String date;
    @SerializedName("description")
    private String description;

}

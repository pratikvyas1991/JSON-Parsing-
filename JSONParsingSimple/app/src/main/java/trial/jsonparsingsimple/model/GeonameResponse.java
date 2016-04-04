package trial.jsonparsingsimple.model;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GeonameResponse {

    @SerializedName("geonames")
    @Expose
    private List<GeonameModel> geonames = new ArrayList<GeonameModel>();
    public List<GeonameModel> getGeonames() {
        return geonames;
    }
    public void setGeonames(List<GeonameModel> geonames) {
        this.geonames = geonames;
    }
}

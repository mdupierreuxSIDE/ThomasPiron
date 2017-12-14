package eu.side.thomaspiron.android.RESTService;

import java.util.List;

import eu.side.thomaspiron.android.model.News;
import retrofit2.Callback;
import retrofit2.http.GET;


/**
 * Created by mdupierreux1 on 1/12/15.
 */
public interface WebsiteService {
    @GET("/fr/?option=com_json_api&format=json")
    void getNewsFromWebsiteAsync(Callback<List<News>> callback);
}

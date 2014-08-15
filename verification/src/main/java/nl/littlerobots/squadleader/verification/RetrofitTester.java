package nl.littlerobots.squadleader.verification;

import retrofit.http.GET;

public interface RetrofitTester {
    @GET("/test")
    public String test();
}

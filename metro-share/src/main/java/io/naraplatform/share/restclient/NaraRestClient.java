package io.naraplatform.share.restclient;

public interface NaraRestClient {
    //
    <T> T sendAndRecieve(RequestBuilder requestBuilder);
}

package com.app.whatsupmessage.utils;

import org.json.simple.JSONObject;

public interface Response {

    JSONObject getJson();

    JSONObject customGetJson();

    JSONObject customGetJsonForAll();
}
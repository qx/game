//package com.fullwish.junit;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.json.JSONTokener;
//
///**
// * @author fullwish
// * 
// */
//public class JsonParse {
//
//    /**
//     * @param args
//     */
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        String json = "{" + "  \"query\": \"Pizza\", "
//                + "  \"locations\": [ 94043, 90210 ] " + "}";
//        try {
//            JSONObject object = (JSONObject) new JSONTokener(json).nextValue();
//            String query = object.getString("query");
//            System.out.println(query);
//            JSONArray locations = object.getJSONArray("locations");
//            System.out.println(locations.toString());
//        } catch (JSONException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }
//
//}

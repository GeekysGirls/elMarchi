package geekygirls.prog.dev.elmarchi.models;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import geekygirls.prog.dev.elmarchi.utils.ConstantsApp;

public final class DataManager {
    public static void postNewFood(String userId, String username, String title, String body) {
        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        String key = mDatabase.child(ConstantsApp.FIREBASE_LOCATION_FOODS).push().getKey();
        Food food = new Food(userId, username, title, body);
        Map<String, Object> postValues = food.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put(ConstantsApp.FIREBASE_LOCATION_FOODS + "/" + key, postValues);
        childUpdates.put(ConstantsApp.FIREBASE_LOCATION_USER_FOODS + "/" + userId + "/" + key, postValues);

        mDatabase.updateChildren(childUpdates);
    }

    public static void deleteFood(String postKey, String uidFood) {
        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child(ConstantsApp.FIREBASE_LOCATION_FOODS).child(postKey).removeValue();
        mDatabase.child(ConstantsApp.FIREBASE_LOCATION_USER_FOODS).child(uidFood).child(postKey).removeValue();

    }
}

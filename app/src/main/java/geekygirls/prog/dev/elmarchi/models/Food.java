package geekygirls.prog.dev.elmarchi.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

// [START post_class]
@IgnoreExtraProperties
public class Food {

    public String uid;
    public String author;
    public String title;
    public String body;

    public Food() {
        // Default constructor required for calls to DataSnapshot.getValue(Food.class)
    }

    public Food(String uid, String author, String title, String body) {
        this.uid = uid;
        this.author = author;
        this.title = title;
        this.body = body;
    }

    // [START post_to_map]
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("author", author);
        result.put("title", title);
        result.put("body", body);
        return result;
    }
    // [END post_to_map]

}
// [END post_class]

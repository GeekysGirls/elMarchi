package geekygirls.prog.dev.elmarchi.fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

public class MyFoodsFragment extends FoodsListFragment {

    public MyFoodsFragment() {
    }

    @Override
    public Query getQuery(DatabaseReference databaseReference) {
        // All my posts
        return databaseReference.child("user-foods")
                .child(getUid());
    }
}

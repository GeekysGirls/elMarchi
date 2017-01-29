package geekygirls.prog.dev.elmarchi.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import geekygirls.prog.dev.elmarchi.R;
import geekygirls.prog.dev.elmarchi.models.Food;

public class PostViewHolder extends RecyclerView.ViewHolder {

    public TextView titleView;
    public TextView bodyView;

    public PostViewHolder(View itemView) {
        super(itemView);

        titleView = (TextView) itemView.findViewById(R.id.post_title);
        bodyView = (TextView) itemView.findViewById(R.id.post_body);
    }

    public void bindToPost(Food food, View.OnClickListener starClickListener) {
        titleView.setText(food.title);
        bodyView.setText(food.body);
    }
}

package kmitl.lab07.bawonsak58070074.lazyinstagram.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import kmitl.lab07.bawonsak58070074.lazyinstagram.Holder.PostItemHolder;
import kmitl.lab07.bawonsak58070074.lazyinstagram.Model.Post;
import kmitl.lab07.bawonsak58070074.lazyinstagram.R;

/**
 * Created by student on 10/17/2017 AD.
 */
public class PostAdapter extends RecyclerView.Adapter<PostItemHolder> {

    private List<Post> posts;
    private Context context;

    public PostAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @Override
    public PostItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.post_item, parent, false);
        return new PostItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PostItemHolder holder, int position) {
        ImageView image = holder.imageView;
        Glide.with(context).load(posts.get(position).getUrl()).into(image);

        TextView tvLike = holder.like;
        tvLike.setText(String.valueOf(posts.get(position).getLike()));

        TextView tvComment = holder.comment;
        tvComment.setText(String.valueOf(posts.get(position).getComment()));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}

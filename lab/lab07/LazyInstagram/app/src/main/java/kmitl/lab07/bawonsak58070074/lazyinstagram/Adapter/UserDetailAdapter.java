package kmitl.lab07.bawonsak58070074.lazyinstagram.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import kmitl.lab07.bawonsak58070074.lazyinstagram.Holder.UserDetailHolder;
import kmitl.lab07.bawonsak58070074.lazyinstagram.Model.UserProfile;
import kmitl.lab07.bawonsak58070074.lazyinstagram.R;

/**
 * Created by student on 10/17/2017 AD.
 */

public class UserDetailAdapter extends RecyclerView.Adapter<UserDetailHolder> {

    private Context context;
    private UserProfile userProfile;

    public UserDetailAdapter(Context context, UserProfile userProfile) {
        this.context = context;
        this.userProfile = userProfile;
    }

    @Override
    public UserDetailHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.user_detail, parent, false);
        return new UserDetailHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserDetailHolder holder, int position) {
        ImageView imageView = holder.getAvatar();
        Glide.with(context).load(userProfile.getUrlProfile()).into(imageView);

        TextView tvId = holder.getTvId();
        TextView tvPost = holder.getTvPost();
        TextView tvFollowing = holder.getTvFollowing();
        TextView tvFollower = holder.getTvFollower();
        TextView tvBio = holder.getTvBio();

        tvId.setText("@"+userProfile.getUser());
        tvPost.setText(String.valueOf(userProfile.getPost())+"\nPosts");
        tvFollowing.setText(String.valueOf(userProfile.getFollowing())+"\nFollowing");
        tvFollower.setText(String.valueOf(userProfile.getFollower())+"\nFollower");
        tvBio.setText(userProfile.getBio());
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}

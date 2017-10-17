package kmitl.lab07.bawonsak58070074.lazyinstagram.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import kmitl.lab07.bawonsak58070074.lazyinstagram.R;

/**
 * Created by student on 10/17/2017 AD.
 */

public class UserDetailHolder extends RecyclerView.ViewHolder {
    private TextView tvId, tvPost, tvFollowing, tvFollower, tvBio;
    private ImageView avatar;

    public UserDetailHolder(View itemView) {
        super(itemView);
        tvId = (TextView) itemView.findViewById(R.id.user_id);
        tvPost = (TextView) itemView.findViewById(R.id.post);
        tvFollowing = (TextView) itemView.findViewById(R.id.following);
        tvFollower = (TextView) itemView.findViewById(R.id.follower);
        tvBio = (TextView) itemView.findViewById(R.id.bio);
        avatar = (ImageView) itemView.findViewById(R.id.avatar);
    }

    public TextView getTvId() {
        return tvId;
    }

    public void setTvId(TextView tvId) {
        this.tvId = tvId;
    }

    public TextView getTvPost() {
        return tvPost;
    }

    public void setTvPost(TextView tvPost) {
        this.tvPost = tvPost;
    }

    public TextView getTvFollowing() {
        return tvFollowing;
    }

    public void setTvFollowing(TextView tvFollowing) {
        this.tvFollowing = tvFollowing;
    }

    public TextView getTvFollower() {
        return tvFollower;
    }

    public void setTvFollower(TextView tvFollower) {
        this.tvFollower = tvFollower;
    }

    public TextView getTvBio() {
        return tvBio;
    }

    public void setTvBio(TextView tvBio) {
        this.tvBio = tvBio;
    }

    public ImageView getAvatar() {
        return avatar;
    }

    public void setAvatar(ImageView avatar) {
        this.avatar = avatar;
    }
}

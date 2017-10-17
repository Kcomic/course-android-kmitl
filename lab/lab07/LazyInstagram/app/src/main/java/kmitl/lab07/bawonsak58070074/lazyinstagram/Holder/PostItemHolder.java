package kmitl.lab07.bawonsak58070074.lazyinstagram.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import kmitl.lab07.bawonsak58070074.lazyinstagram.R;

/**
 * Created by student on 10/17/2017 AD.
 */

public class PostItemHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView like;
    public TextView comment;

    public PostItemHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
        like = (TextView) itemView.findViewById(R.id.tvLike);
        comment = (TextView) itemView.findViewById(R.id.tvComment);

    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public TextView getLike() {
        return like;
    }

    public void setLike(TextView like) {
        this.like = like;
    }

    public TextView getComment() {
        return comment;
    }

    public void setComment(TextView comment) {
        this.comment = comment;
    }
}

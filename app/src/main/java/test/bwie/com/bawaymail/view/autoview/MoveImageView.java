package test.bwie.com.bawaymail.view.autoview;

import android.content.Context;
import android.graphics.PointF;
import android.widget.ImageView;

/**
 * @ Description:
 * @ Date:2017/7/7
 * @ Author:刘刚
 */

public class MoveImageView extends ImageView {

    public MoveImageView(Context context) {
        super(context);
    }

    public void setMPointF(PointF pointF) {
        setX(pointF.x);
        setY(pointF.y);
    }
}

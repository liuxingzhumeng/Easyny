package easyny.ludashen.com.easyny.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import easyny.ludashen.com.easyny.R;

/**
 * Created by Administrator on 2017/7/18.
 */

public class TitlebarView extends RelativeLayout {
    private LinearLayout layout_left, layout_right;
    private TextView tv_left, tv_title, tv_right;
    private ImageView iv_left, iv_right,iv_rights;
    public TitlebarView(Context context) {
        this(context, null);
    }

    public TitlebarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitlebarView(final Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.layout_title, this);
        initView();
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TitlebarView, defStyleAttr, 0);
        int count = array.getIndexCount();
        for (int i = 0; i < count; i++) {
            int attr = array.getIndex(i);
            switch (attr) {
                case R.styleable.TitlebarView_leftTextColor:
                    tv_left.setTextColor(array.getColor(attr, Color.BLACK));
                    break;
                case R.styleable.TitlebarView_leftDrawble:
                    iv_left.setImageResource(array.getResourceId(attr, 0));
                    break;
                case R.styleable.TitlebarView_leftText:
                    tv_left.setText(array.getString(attr));
                    break;
                case R.styleable.TitlebarView_centerTextColor:
                    tv_title.setTextColor(array.getColor(attr, Color.BLACK));
                    break;
                case R.styleable.TitlebarView_centerTitle:
                    tv_title.setText(array.getString(attr));
                    break;
                case R.styleable.TitlebarView_rightDrawable:
                    iv_right.setImageResource(array.getResourceId(attr, 0));
                    break;
                case R.styleable.TitlebarView_rightsDrawable:
                    iv_rights.setImageResource(array.getResourceId(attr, 0));
                    break;
                case R.styleable.TitlebarView_rightText:
                    tv_right.setText(array.getString(attr));
                    break;
                case R.styleable.TitlebarView_rightTextColor:
                    tv_right.setTextColor(array.getColor(attr, Color.BLACK));
                    break;
            }
        }
        array.recycle();
    }

    private void initView() {
        tv_left = (TextView) findViewById(R.id.tv_left);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_right = (TextView) findViewById(R.id.tv_right);
        iv_left = (ImageView) findViewById(R.id.iv_left);
        iv_right = (ImageView) findViewById(R.id.iv_right);
        iv_rights = (ImageView) findViewById(R.id.iv_rights);
        layout_left = (LinearLayout) findViewById(R.id.layout_left);
        layout_right = (LinearLayout) findViewById(R.id.layout_right);
    }



    //设置标题
    public void setTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            tv_title.setText(title);
        }
    }

    //设置左标题
    public void setLeftText(String title) {
        if (!TextUtils.isEmpty(title)) {
            tv_left.setText(title);
        }
    }

    //设置右标题
    public void setRightText(String title) {
        if (!TextUtils.isEmpty(title)) {
            tv_right.setText(title);
        }
    }

    //设置标题大小
    public void setTitleSize(int size) {
        if (tv_title != null) {
            tv_title.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        }
    }

    //设置左标题大小
    public void setLeftTextSize(int size) {
        if (tv_left != null) {
            tv_left.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        }
    }

    //设置右标题大小
    public void setRightTextSize(int size) {
        if (tv_right != null) {
            tv_right.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        }
    }

    //设置左图标
    public void setLeftDrawable(int res) {
        if (iv_left != null) {
            iv_left.setImageResource(res);
        }
    }

    //设置右图标
    public void setRightDrawable(int res) {
        if (iv_right != null) {
            iv_right.setImageResource(res);
        }
    }
    public void setOnClickSearch(OnClickListener l){
        iv_rights.setOnClickListener(l);
    }
    public void setOnClickTwoTitle(OnTouchListener l){
        tv_title.setOnTouchListener(l);
    }
    public void setOnClickRightImg(OnClickListener l){
        iv_right.setOnClickListener(l);
    }
    public void setOnClickRightText(OnClickListener l){
        tv_right.setOnClickListener(l);
    }
    public void setOnClickLeft(OnClickListener l){
        layout_left.setOnClickListener(l);
    }
    public void setOnClickRidht(OnClickListener l){
        layout_right.setOnClickListener(l);
    }
    public void setOnClickLeftText(OnClickListener l){
        tv_left.setOnClickListener(l);
    }
    public void setOnClickLeftImg(OnClickListener l){
        iv_left.setOnClickListener(l);
    }
    public void setRightsDrawable(int res) {
        if (iv_rights != null) {
            iv_rights.setImageResource(res);
        }
    }



}

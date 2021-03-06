package easyny.ludashen.com.easyny.ui;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executors;

import easyny.ludashen.com.easyny.R;
import easyny.ludashen.com.easyny.adapter.PhotoWallAdapter;
import easyny.ludashen.com.easyny.components.DensityUtil;
import easyny.ludashen.com.easyny.model.PhotoPack;
import easyny.ludashen.com.easyny.view.SelectPopupWindow;


public class PhotoPickerActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String INTENT_PHOTO_PATHS = "photo_paths";;

    private static final int LATEST_PHOTO_NUM = 100;

    private static final String LATEST_PHOTO_STR = "ζθΏη§η";

    private View titleView;

    private TextView tvCacel, tvComplete, tvPicker;

    private GridView gvPhotoWall;

    private List<String> photoPathList;

    private List<String> latestPhotoPathList;

    private List<PhotoPack> photoPackList;

    private PhotoWallAdapter photoWallAdapter;

    private SelectPopupWindow photoPackSelectPopup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_picker);

        initView();

        setViewListener();

        inflateViewData();
    }

    private void initView() {
        titleView = findViewById(R.id.relay_title);

        tvCacel = (TextView) findViewById(R.id.tv_cancel);
        tvComplete = (TextView) findViewById(R.id.tv_complete);
        tvPicker = (TextView) findViewById(R.id.tv_picker);

        gvPhotoWall = (GridView) findViewById(R.id.gv_photo_wall);
    }

    private void setViewListener() {
        tvCacel.setOnClickListener(this);
        tvComplete.setOnClickListener(this);
        tvPicker.setOnClickListener(this);
    }


    private void inflateViewData() {

        Executors.newSingleThreadExecutor().submit(new Runnable() {
            @Override
            public void run() {
                photoPathList = getLatestPhotoPaths(LATEST_PHOTO_NUM);
                latestPhotoPathList = new ArrayList<>(photoPathList);
                photoPackList = getAllPhotoPaths();

                PhotoPack LatestPhotoPack = new PhotoPack();
                LatestPhotoPack.setFileCount(photoPathList.size());
                LatestPhotoPack.setPathName(LATEST_PHOTO_STR);
                LatestPhotoPack.setTitle(LATEST_PHOTO_STR);
                LatestPhotoPack.setFirstPhotoPath(photoPathList.get(0));

                photoPackList.add(0, LatestPhotoPack);
                handler.sendEmptyMessage(0);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel:
                finish();
                break;

            case R.id.tv_complete:
                Intent dataIntent = new Intent();
                dataIntent.putExtra(INTENT_PHOTO_PATHS, photoWallAdapter.getSelectPhotoPathArray());
                setResult(RESULT_OK, dataIntent);
                finish();
                break;

            case R.id.tv_picker:
                tvPicker.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_arrow_up, 0);
                if (photoPackSelectPopup == null) {
                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT);
                    ListView photoPackListView = new ListView(this);
                    photoPackListView.setLayoutParams(layoutParams);
                    photoPackListView.setDivider(getResources().getDrawable(R.color.photoPackDivider));
                    photoPackListView.setDividerHeight(1);

                    photoPackSelectPopup = new SelectPopupWindow(photoPackListView,
                            DensityUtil.getScreenWidth(this),
                            (int) (DensityUtil.getScreenHeight(this) * .5f), photoPackList);

                    photoPackSelectPopup.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            photoPackSelectPopup.transformWindowNormal(PhotoPickerActivity.this);
                            tvPicker.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_arrow_down, 0);
                        }
                    });
                }

                photoPackSelectPopup.showDropDownAsView(titleView, new SelectPopupWindow.OnPhotoPackSelectListener() {
                    @Override
                    public void photoPackSelected(PhotoPack photoPack) {
                        tvPicker.setText(photoPack.getTitle());
                        tvPicker.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_arrow_down, 0);
                        if (LATEST_PHOTO_STR.equals(photoPack.getPathName())) { // ζθΏη§η
                            photoPathList = latestPhotoPathList;
                        } else {
                            photoPathList = getPhotosByFolder(photoPack.getPathName());
                        }

                        photoWallAdapter.cutoverSelectArray(photoPack);
                        photoWallAdapter.setDataList(photoPathList);
                        photoWallAdapter.notifyDataSetChanged();
                        gvPhotoWall.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                gvPhotoWall.setSelection(0);
                            }
                        }, 200);
                    }
                });
                break;
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            photoWallAdapter = new PhotoWallAdapter(PhotoPickerActivity.this, photoPathList,
                    R.layout.item_photo_picker, photoPackList.get(0));
            gvPhotoWall.setAdapter(photoWallAdapter);

            tvPicker.setText(photoPackList.get(0).getTitle());
        }
    };

    /**
     * δ½Ώη¨ContentProviderθ―»εSDε‘ζθΏεΎη
     * @param maxCount θ―»εηζε€§εΌ ζ°
     * @return
     */
    private List<String> getLatestPhotoPaths(int maxCount) {
        Uri mImageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String key_MIME_TYPE = MediaStore.Images.Media.MIME_TYPE;
        String key_DATA = MediaStore.Images.Media.DATA;

        ContentResolver mContentResolver = getContentResolver();

        // εͺζ₯θ―’jpgεpngηεΎη,ζζζ°δΏ?ζΉζεΊ
        Cursor cursor = mContentResolver.query(mImageUri, new String[]{key_DATA},
                key_MIME_TYPE + "=? or " + key_MIME_TYPE + "=? or " + key_MIME_TYPE + "=?",
                new String[]{"image/jpg", "image/jpeg", "image/png"},
                MediaStore.Images.Media.DATE_MODIFIED);

        List<String> latestImagePaths = null;
        if (cursor != null) {
            //δ»ζζ°ηεΎηεΌε§θ―»ε.
            //ε½cursorδΈ­ζ²‘ζζ°ζ?ζΆοΌcursor.moveToLast()ε°θΏεfalse
            if (cursor.moveToLast()) {
                latestImagePaths = new ArrayList<String>();

                while (true) {
                    // θ·εεΎηηθ·―εΎ
                    String path = cursor.getString(0);
                    latestImagePaths.add(path);

                    if (latestImagePaths.size() >= maxCount || !cursor.moveToPrevious()) {
                        break;
                    }
                }
            }
            cursor.close();
        }

        return latestImagePaths;
    }

    /**
     * θ·εζε?θ·―εΎδΈηζζεΎηζδ»Ά
     * @param folderPath
     * @return
     */
    private List<String> getPhotosByFolder(String folderPath) {
        File folder = new File(folderPath);
        String[] allFileNames = folder.list();
        if (allFileNames == null || allFileNames.length == 0) {
            return null;
        }

        List<String> photoFilePaths = new ArrayList<String>();
        for (int i = allFileNames.length - 1; i >= 0; i--) {
            if (isImage(allFileNames[i])) {
                photoFilePaths.add(folderPath + File.separator + allFileNames[i]);
            }
        }

        return photoFilePaths;
    }

    /**
     * δ½Ώη¨ContentProviderθ―»εSDε‘ζζεΎηγ
     */
    private List<PhotoPack> getAllPhotoPaths() {
        Uri mImageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String key_MIME_TYPE = MediaStore.Images.Media.MIME_TYPE;
        String key_DATA = MediaStore.Images.Media.DATA;

        ContentResolver mContentResolver = getContentResolver();

        // εͺζ₯θ―’jpgεpngηεΎη
        Cursor cursor = mContentResolver.query(mImageUri, new String[]{key_DATA},
                key_MIME_TYPE + "=? or " + key_MIME_TYPE + "=? or " + key_MIME_TYPE + "=?",
                new String[]{"image/jpg", "image/jpeg", "image/png"},
                MediaStore.Images.Media.DATE_MODIFIED);

        ArrayList<PhotoPack> list = null;
        if (cursor != null) {
            if (cursor.moveToLast()) {
                //θ·―εΎηΌε­οΌι²ζ­’ε€ζ¬‘ζ«ζεδΈη?ε½
                HashSet<String> cachePath = new HashSet<String>();
                list = new ArrayList<PhotoPack>();
                PhotoPack photoPack;
                while (true) {
                    // θ·εεΎηηθ·―εΎ
                    String imagePath = cursor.getString(0);

                    File parentFile = new File(imagePath).getParentFile();
                    String parentPath = parentFile.getAbsolutePath();

                    //δΈζ«ζιε€θ·―εΎ
                    if (!cachePath.contains(parentPath)) {
                        photoPack = new PhotoPack();
                        photoPack.setFileCount(getPhotoCount(parentFile));
                        photoPack.setFirstPhotoPath(getCoverPhotoPath(parentFile));
                        photoPack.setPathName(parentPath);
                        photoPack.setTitle(getPhotoPackTitle(parentPath));
                        list.add(photoPack);
                        cachePath.add(parentPath);
                    }

                    if (!cursor.moveToPrevious()) {
                        break;
                    }
                }
            }

            cursor.close();
        }

        return list;
    }

    private String getPhotoPackTitle(String parentPath) {
        int lastSeparator = parentPath.lastIndexOf(File.separator);
        return parentPath.substring(lastSeparator + 1);
    }

    /**
     * θ·εη?ε½δΈ­εΎηηδΈͺζ°γ
     */
    private int getPhotoCount(File folder) {
        int count = 0;
        File[] files = folder.listFiles();
        for (File file : files) {
            if (isImage(file.getName())) {
                count++;
            }
        }

        return count;
    }

    /**
     * θ·εη?ε½δΈ­ζζ°ηδΈεΌ εΎηηη»ε―Ήθ·―εΎ
     * @param folder
     * @return
     */
    private String getCoverPhotoPath(File folder) {
        File[] files = folder.listFiles();
        for (int i = files.length - 1; i >= 0; i--) {
            File file = files[i];
            if (isImage(file.getName())) {
                return file.getAbsolutePath();
            }
        }

        return null;
    }

    /**
     * ε€ζ­θ―₯ζδ»Άζ―ε¦ζ―δΈδΈͺεΎη
     * @param fileName
     * @return
     */
    private boolean isImage(String fileName) {
        return fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".png");
    }
}

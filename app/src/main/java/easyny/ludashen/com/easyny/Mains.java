package easyny.ludashen.com.easyny;

import android.Manifest;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.AlarmClock;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.yalantis.pulltomakesoup.PullToRefreshView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import easyny.ludashen.com.easyny.util.NyNotice;
import easyny.ludashen.com.easyny.util.Permission;
import easyny.ludashen.com.easyny.util.ThemeUtil;
import easyny.ludashen.com.easyny.util.Tool;
import easyny.ludashen.com.easyny.view.NoticeView;


public class Mains extends Fragment implements Runnable,View.OnClickListener {
    private static List<String> data=new ArrayList<>();
    private static List<String> dis=new ArrayList<>();
    private static List<String> time=new ArrayList<>();
    private ListView kc_list;
    private PullToRefreshView mPullToRefreshView;
    private NoticeView vNotice;
    private Map<String, List<String>> notice;
    public static String[] permissionsREAD={
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE };
    private String weather;
    private TextView das;

    public static void data( List<String> datas,List<String> diss,List<String> times){
        Mains.data =datas;
        dis=diss;
        time=times;
    }

    private Handler handler=new Handler() {
        public void handleMessage(android.os.Message msg) {
            try {
                String[] we = ((String) msg.obj).split(" ");
                das.setText("??????"+((Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1) + "")+"????????????????????????"+we[3]+we[4]+we[5]);
                try {
                    vNotice.start(notice.get("context"));
                    vNotice.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Uri uri = Uri.parse(notice.get("url").get(vNotice.getIndex()));
                            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                            startActivity(intent);
                        }
                    });
                } catch (Exception e) {
                    Toast.makeText(getContext(),"????????????????????????", Toast.LENGTH_SHORT).show();
                }
            }catch (Exception e){

            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main, container, false);
        ThemeUtil.setBackgroud(getContext(),view);
        TextView jw = (TextView) view.findViewById(R.id.jw);
        jw.setOnClickListener(this);
        das = (TextView) view.findViewById(R.id.main_data);
        das.setOnClickListener(this);
        vNotice = (NoticeView)view.findViewById(R.id.notice);
        kc_list=(ListView)view.findViewById(R.id.ck_list) ;
        TextView banshi= (TextView) view.findViewById(R.id.banshi);
        banshi.setOnClickListener(this);
        TextView chaoxing = (TextView) view.findViewById(R.id.chaoxing);
        chaoxing.setOnClickListener(this);
        TextView fudong = (TextView) view.findViewById(R.id.fudong);
        fudong.setOnClickListener(this);
        TextView yule = (TextView) view.findViewById(R.id.yule);
        yule.setOnClickListener(this);
        TextView ai = (TextView) view.findViewById(R.id.ai);
        ai.setOnClickListener(this);


        kc_list.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return data.size();
            }
            @Override
            public Object getItem(int position) {
//    			??????????????????????????????
                return data.get(position);
            }
            @Override
            public long getItemId(int position) {
                return position;
            }
            @Override
            public View getView(final int position, View convertView, ViewGroup parent) {
                View view = null;
                if(convertView == null)
                    view = View.inflate(getContext(), R.layout.list_text, null);
                else
                    view = convertView;
                TextView tv_name = (TextView) view.findViewById(R.id.kc);
                TextView t_details= (TextView) view.findViewById(R.id.details);
                Button alarm=(Button) view.findViewById(R.id.button);
                tv_name.setText(data.get(position));
                t_details.setText(dis.get(position));
                alarm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                            builder.setTitle("????????????");
                            builder.setMessage("???????????????????????????????????????????????????15????????????????????????????????????");
                            builder.setPositiveButton("??????", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {
                                    String[] tim = time.get(position).split(":");
                                    createAlarm(data.get(position)+dis.get(position),Integer.parseInt(tim[0]),Integer.parseInt(tim[1])-15,position);
                                    Toast.makeText(getContext(),"????????????????????????????????????????????????????????????",Toast.LENGTH_SHORT).show();
                                }
                            });
                            builder.setNegativeButton("??????", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {
                                    Toast.makeText(getContext(),"??????????????????",Toast.LENGTH_SHORT).show();
                                }
                            });
                            builder.show();
                        }catch (Exception e){
                            Toast.makeText(getContext(),"??????????????????",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                return view;
            }

        });
        mPullToRefreshView = (PullToRefreshView)view.findViewById(R.id.pull_to_refresh);
        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                    Toast.makeText(getContext(),"????????????",Toast.LENGTH_SHORT).show();
                    mPullToRefreshView.setRefreshing(false);
            }
        });
        new Thread(this).start();
        return view;
    }

    private void createAlarm(String message, int hour, int minutes, int resId) {

        String packageName = getActivity().getApplication().getPackageName();
        Uri ringtoneUri = Uri.parse("android.resource://" + packageName + "/" + resId);
        //action???AlarmClock.ACTION_SET_ALARM
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                //???????????????
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                //???????????????
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes)
                //????????????????????????
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                //??????????????????????????????????????????
                .putExtra(AlarmClock.EXTRA_VIBRATE, true)
                //?????? content: URI??????????????????????????????????????????????????? VALUE_RINGTONE_SILENT ?????????????????????
                //????????????????????????????????????????????? extra???
                .putExtra(AlarmClock.EXTRA_RINGTONE, ringtoneUri)
                //?????????true????????????startActivity()???????????????????????????????????????
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }}

    @Override
    public void run() {
        try {
            weather = NyNotice.weather();
            notice = NyNotice.notice();
            Message message = new Message();
            message.obj =weather;
            handler.sendMessage(message);
        } catch (IOException e) {
        }
    }

    @Override
    public void onClick(View v) {
        Intent mainIntent = new Intent(getContext(), NyWeb.class);
        switch (v.getId()) {
            case R.id.jw:
                mainIntent.putExtra("url", "http://jw.nnxy.cn/jsxsd/");
                String js="";
                if (Tool.fileExists(getContext(),"info.txt")) {
                    String readinfo = Tool.readinfo(getContext(), "info.txt");
                    String[] result = readinfo.split("##");
                    js = "javascript:document.getElementById('userAccount').value = '" + result[0] + "';document.getElementById('userPassword').value='" + result[1] + "';" +
                            "document.getElementsByTagName(\"span\")[0].innerHTML=\"<a style='color: blue;text-decoration:underline' href='mailto:ludagewudi@gmail.com?subject=?????????????????????&body=???????????????????????????app????????????????????????????????????????????????'>??????????????????  ??????:ludagewudi@gmail.com</a>\";";
                } else {
                    js = "javascript:document.getElementById('userAccount').value = '" + "" + "';document.getElementById('userPassword').value='" + "" + "';" +
                            "document.getElementsByTagName(\"span\")[0].innerHTML=\"<a style='color: blue;text-decoration:underline' href='mailto:ludagewudi@gmail.com?subject=?????????????????????&body=???????????????????????????app????????????????????????????????????????????????'>??????????????????  ??????:ludagewudi@gmail.com</a>\";";
                }
                mainIntent.putExtra("url", "http://jw.nnxy.cn/jsxsd/");
                mainIntent.putExtra("js",js);
                startActivity(mainIntent);
                break;
            case R.id.main_data:
                mainIntent.putExtra("url", "https://m.tianqi.com/yongningqu/");
                startActivity(mainIntent);
                break;
            case R.id.banshi:
                if (Permission.lacksPermissions(getActivity(),permissionsREAD)){
                    ActivityCompat.requestPermissions(getActivity(),permissionsREAD,0);
                    Toast.makeText(getContext(),"??????????????????????????????????????????????????????????????????",Toast.LENGTH_SHORT).show();
                }else {
                    Intent rl = new Intent(getContext(), DiaryList.class);
                    getActivity().startActivity(rl);
                }
            break;
            case R.id.chaoxing:
                mainIntent.putExtra("url","https://www.baidu.com/");
                mainIntent.putExtra("search",true);
                startActivity(mainIntent);
            break;
            case R.id.fudong:
                startActivy(Nnxy.class);
            break;
            case R.id.yule:
                startActivy(Yule.class);
            break;
            case R.id.ai:
                startActivy(Ai.class);
            break;
        }
    }
    private void startActivy(Class<?> cls){
        Intent mainIntent = new Intent(getContext(),cls);
        getActivity().startActivity(mainIntent);
    }
}
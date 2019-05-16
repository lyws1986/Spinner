package com.example.android_text001;



import java.util.ArrayList;
import java.util.List;
import org.gaochun.adapter.SpinerAdapter;
import org.gaochun.widget.SpinerPopWindow;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener,SpinerAdapter.IOnItemSelectListener{

    private List<String>  mListType = new ArrayList<String>();  //类型列表
    private TextView mTView;
    private SpinerAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTView = (TextView) findViewById(R.id.tv_value);


        //初始化数据
        String[] names = {"水果","水果","水果","水果","水果","水果","水果","水果","水果","水果","水果","水果","水果",};
        for(int i = 0; i < names.length; i++){
            mListType.add(names[i]);
        }

        mAdapter = new SpinerAdapter(this,mListType);
        mAdapter.refreshData(mListType,0);

        //显示第一条数据
        //mTView.setText(names[0]);

        //初始化PopWindow
        mSpinerPopWindow = new SpinerPopWindow(this);
        mSpinerPopWindow.setAdatper(mAdapter);
        mSpinerPopWindow.setItemListener(this);

    }


    //设置PopWindow
    private SpinerPopWindow mSpinerPopWindow;
    private void showSpinWindow(){
        Log.e("", "showSpinWindow");
        mSpinerPopWindow.setWidth(mTView.getWidth());
        mSpinerPopWindow.showAsDropDown(mTView);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_dropdown:
                showSpinWindow();
                break;
        }
    }


    /* (non-Javadoc)
     * @see org.gaochun.adapter.SpinerAdapter.IOnItemSelectListener#onItemClick(int)
     */
    @Override
    public void onItemClick(int pos) {
        // TODO Auto-generated method stub
        if (pos >= 0 && pos <= mListType.size()){
            String value = mListType.get(pos);
            mTView.setText(value.toString());
        }
    }

}

package com.canplay.milk.mvp.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.canplay.medical.R;
import com.canplay.milk.base.BaseActivity;
import com.canplay.milk.bean.Milk;
import com.canplay.milk.mvp.adapter.MilkAdapter;
import com.canplay.milk.view.ClearEditText;
import com.canplay.milk.view.NavigationBar;
import com.canplay.milk.view.SideLetterBars;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 奶粉列表
 */
public class SearchMilkActivity extends BaseActivity implements NavigationBar.NavigationBarListener {

    public static final String KEY_PICKED_CITY = "picked_city";
    @BindView(R.id.navigationBar)
    NavigationBar navigationBar;
    @BindView(R.id.et_search)
    ClearEditText etSearch;
    @BindView(R.id.ll_bg)
    LinearLayout llBg;
    @BindView(R.id.listview_all_city)
    ListView listviewAllCity;
    @BindView(R.id.side_letter_bars)
    SideLetterBars mLetterBar;
    @BindView(R.id.tv_letter_overlay)
    TextView overlay;
    @BindView(R.id.tv_add)
    TextView tvAdd;
    @BindView(R.id.ll_add)
    LinearLayout llAdd;

    private ListView mListView;
    //  private ListView mResultListView;

    private EditText searchBox;
    private ImageView clearBtn;

    private ViewGroup emptyView;
    private MilkAdapter mCityAdapter;

    private List<Milk> mAllCities;


    @Override
    public void initViews() {
        setContentView(R.layout.activity_city_list);
        navigationBar.setNavigationBarListener(this);
        mLetterBar = (SideLetterBars) findViewById(R.id.side_letter_bars);
        mLetterBar.setOverlay(overlay);
        mLetterBar.setOnLetterChangedListener(new SideLetterBars.OnLetterChangedListener() {
            @Override
            public void onLetterChanged(String letter) {
                int position = mCityAdapter.getLetterPosition(letter);
                mListView.setSelection(position);
            }
        });

    }

    @Override
    public void bindEvents() {
         tvAdd.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

             }
         });
    }

    @Override
    public void initData() {

    }


    private List<Milk> list;


    private void back(String city) {
        // ToastUtils.showToast(this, "点击的城市：" + city);
        Intent data = new Intent();
        data.putExtra(KEY_PICKED_CITY, city);
        setResult(RESULT_OK, data);
        finish();
    }


    public void getConturySuccess(List<Milk> prefices) {
//        if(prefices.size()!=0){
//            ShareDataManager.getInstance().Save(CityPickerActivity.this,ShareDataManager.PERFIX_DATA, new Gson().toJson(prefices));
//        }
        if (prefices != null && prefices.size() > 0) {
            emptyView.setVisibility(View.GONE);
            mCityAdapter = new MilkAdapter(this, prefices, 0);
            mListView.setAdapter(mCityAdapter);
            mCityAdapter.setOnCityClickListener(new MilkAdapter.OnCityClickListener() {
                @Override
                public void onCityClick(String name) {
                    back(name);
                }

                @Override
                public void onLocateClick() {

                }
            });
        } else {
            emptyView.setVisibility(View.VISIBLE);
        }


    }


    @Override
    public void navigationLeft() {
        finish();
    }

    @Override
    public void navigationRight() {

    }

    @Override
    public void navigationimg() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}

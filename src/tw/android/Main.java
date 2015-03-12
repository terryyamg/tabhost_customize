package tw.android;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Main extends Activity {
	private TabHost mTabHost;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		mTabHost = (TabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup();
		
		LinearLayout tv1 = (LinearLayout) findViewById(R.id.tab1);	//頁籤1內容
		LinearLayout tv2 = (LinearLayout) findViewById(R.id.tab2);	//頁籤2內容
		LinearLayout tv3 = (LinearLayout) findViewById(R.id.tab3);	//頁籤3內容
		
	    setupTab(tv1, "Tab 1",1);	//頁籤 (內容，標籤，圖id)
	    setupTab(tv2, "Tab 2",1);
	    setupTab(tv3, "Tab 3",1);
	    
	    mTabHost.setCurrentTab(2);	//點選頁籤3
	    mTabHost.setCurrentTab(1);	//點選頁籤2
	    mTabHost.setCurrentTab(0);	//點選頁籤1
	}
	
	private void setupTab(final View view, final String tag,final Integer iconId) {
	    View tabview = createTabView(mTabHost.getContext(), tag, iconId); //設定頁籤
	    TabSpec setContent = mTabHost.newTabSpec(tag).setIndicator(tabview).setContent(new TabContentFactory() {
	        public View createTabContent(String tag) {
	            return view;
	        }
	    });
	    mTabHost.addTab(setContent);
	}

	@SuppressLint("InflateParams")
	private static View createTabView(final Context context, final String text,final Integer iconId) {
	    View view = LayoutInflater.from(context).inflate(R.layout.tabs_bg, null);
	    ImageView iv = (ImageView) view.findViewById(R.id.icon);	//顯示icon圖示
	    TextView tv = (TextView) view.findViewById(R.id.tabsText);	//顯示文字
        iv.setImageResource(iconId); //設定圖示
	    tv.setText(text); //設定文字
	    return view;
	}
}
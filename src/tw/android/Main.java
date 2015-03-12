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
		
		LinearLayout tv1 = (LinearLayout) findViewById(R.id.tab1);	//����1���e
		LinearLayout tv2 = (LinearLayout) findViewById(R.id.tab2);	//����2���e
		LinearLayout tv3 = (LinearLayout) findViewById(R.id.tab3);	//����3���e
		
	    setupTab(tv1, "Tab 1",1);	//���� (���e�A���ҡA��id)
	    setupTab(tv2, "Tab 2",1);
	    setupTab(tv3, "Tab 3",1);
	    
	    mTabHost.setCurrentTab(2);	//�I�ﭶ��3
	    mTabHost.setCurrentTab(1);	//�I�ﭶ��2
	    mTabHost.setCurrentTab(0);	//�I�ﭶ��1
	}
	
	private void setupTab(final View view, final String tag,final Integer iconId) {
	    View tabview = createTabView(mTabHost.getContext(), tag, iconId); //�]�w����
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
	    ImageView iv = (ImageView) view.findViewById(R.id.icon);	//���icon�ϥ�
	    TextView tv = (TextView) view.findViewById(R.id.tabsText);	//��ܤ�r
        iv.setImageResource(iconId); //�]�w�ϥ�
	    tv.setText(text); //�]�w��r
	    return view;
	}
}
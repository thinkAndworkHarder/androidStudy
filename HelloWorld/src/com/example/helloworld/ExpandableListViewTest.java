package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 学习ExpandableListAdapter的应用
 * 通过该类应该学习到如下内容：
 * 1、可以通过新建BaseExpandableListAdapter得到ExpandableListAdapter；
 * 2、ExpandableListView和ExpandableListAdater结合使用
 * @author bingbingjian
 * @creation 2015年8月23日
 */
public class ExpandableListViewTest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expandable_list_view_test);
		
		ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
			int[] logos = new int[]{
					R.drawable.p,
					R.drawable.t,
					R.drawable.z
			};
			private String[] armTypes = new String[]{
					"神族兵种", "虫族兵种", "人族兵种"
			};
			private String[][] arms = new String[][]{
					{"狂战士", "龙骑士", "黑暗圣堂", "电兵"},
					{"小狗", "刺蛇", "飞龙", "自爆飞机"},
					{"机枪兵", "护士MM", "幽灵"}
			};
			
			@Override
			public boolean isChildSelectable(int groupPosition, int childPosition) {
				return true;
			}
			
			@Override
			public boolean hasStableIds() {
				return true;
			}
			
			@Override
			public View getGroupView(int groupPosition, boolean isExpanded,
					View convertView, ViewGroup parent) {
				LinearLayout l1 = new LinearLayout(ExpandableListViewTest.this);
				l1.setOrientation(0);
				ImageView logo = new ImageView(ExpandableListViewTest.this);
				logo.setImageResource(logos[groupPosition]);
				l1.addView(logo);
				TextView textView = new TextView(ExpandableListViewTest.this);
				textView.setText(getGroup(groupPosition).toString());
				l1.addView(textView);
				return l1;
			}
			
			@Override
			public long getGroupId(int groupPosition) {
				return groupPosition;
			}
			
			@Override
			public int getGroupCount() {
				return armTypes.length;
			}
			
			@Override
			public Object getGroup(int groupPosition) {
				return armTypes[groupPosition];
			}
			
			@Override
			public int getChildrenCount(int groupPosition) {
				return arms[groupPosition].length;
			}
			
			@Override
			public View getChildView(int groupPosition, int childPosition,
					boolean isLastChild, View convertView, ViewGroup parent) {
				TextView textView = new TextView(ExpandableListViewTest.this);
				textView.setText(getChild(groupPosition, childPosition).toString());
				return textView;
			}
			
			@Override
			public long getChildId(int groupPosition, int childPosition) {
				return childPosition;
			}
			
			@Override
			public Object getChild(int groupPosition, int childPosition) {
				return arms[groupPosition][childPosition];
			}
		};
		
		ExpandableListView list = (ExpandableListView) findViewById(R.id.list);
		list.setAdapter(adapter);
	}
}

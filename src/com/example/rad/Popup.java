package com.example.rad;

import com.example.pleaseganana.R;
import com.example.rad.OnPopupItemClickListener;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class Popup {
	 
	private PopupWindow popupWindow;
	private OnPopupItemClickListener onPopupItemClickListener;
	private LinearLayout rootView;
	private LayoutInflater lInf;
	
	public Popup(Context context) {
		super();
		this.popupWindow = new PopupWindow(context);
		lInf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		rootView = (LinearLayout) lInf.inflate(R.layout.popup_view, null);
	}
	
	public void addItem(final PopUpItem item)	{
		TextView tv = (TextView) lInf.inflate(R.layout.popup_item, null);
		tv.setText(item.getTitleText());
		rootView.addView(tv);
		tv.setOnClickListener(new View.OnClickListener() {
			/*
			 * We basically intercept the click on this textview
			 * and pass it to the callback interface. So the end
			 * user will get this event as a click on an action item
			 * And finally close this popup
			 */
			@Override
			public void onClick(View v) {
				onPopupItemClickListener.onItemClick(item.getActivityClassName(), item.getItemId());
				popupWindow.dismiss();
			}
		});
	}
	
	/*
	 * This method calculates the centre of the view and displays the
	 * popup there. By default a popup is shown at (0, 0) with referring
	 * the bottom left corner of the view as origin.
	 */
	public void show(View v)	{
		popupWindow.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
		popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
		popupWindow.setContentView(rootView);
 
		int[] location = new int[2];
		v.getLocationOnScreen(location);
		rootView.measure(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
		
		/*
		 * Since the anchor position for a popup is the left top of the anchor view,
		 * calculate the x position and y position and override the location manually
		 */
		int xPos = location[0] + v.getWidth() / 2 - rootView.getMeasuredWidth() / 2;
		int yPos = location[1] - rootView.getMeasuredHeight();
		
		popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, xPos, yPos);
	}
	
	public void setOnItemClickListener(OnPopupItemClickListener onPopupItemClickListener)	{
		this.onPopupItemClickListener = onPopupItemClickListener;
	}
}
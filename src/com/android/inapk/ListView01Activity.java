package com.android.inapk;

  
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class ListView01Activity extends Activity 
{
	int[] NameId={R.string.name1,R.string.name2 };
	int[] SexId={R.string.sex1,R.string.sex2 };
	int[] AgeId={R.string.age1,R.string.age2 };
    ListView lv;
    BaseAdapter ba;
    int  [] A = {R.raw.xiaobeilou, R.raw.aiwozhonghua};
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        lv=(ListView)findViewById(R.id.ListView01);
        
        ba=new BaseAdapter()
        {
			@Override
			public int getCount() 
			{
				return 2;
			}
			@Override
			public Object getItem(int position) 
			{
				return null;
			}
			@Override
			public long getItemId(int position) 
			{
				return 0;
			}
			@Override
			public View getView(int arg0, View arg1, ViewGroup arg2) 
			{
				 
				LinearLayout ll=new LinearLayout(ListView01Activity.this);
				ll.setOrientation(LinearLayout.HORIZONTAL);		//���ó���	
				ll.setPadding(5,5,5,5);//������������			


				//��ʼ��TextView
				TextView tv=new TextView(ListView01Activity.this);
				
				tv.setText(getResources().getText(NameId[arg0]));//��������
				tv.setTextSize(24);//���������С
				tv.setTextColor(ListView01Activity.this.getResources().getColor(R.color.white));//����������ɫ
				tv.setPadding(5,5,5,5);//������������
			    tv.setGravity(Gravity.LEFT);
				ll.addView(tv);//��ӵ�LinearLayout��				

				TextView tv1=new TextView(ListView01Activity.this);
				tv1.setText(getResources().getText(SexId[arg0]));//��������
				tv1.setTextSize(24);//���������С
				tv1.setTextColor(ListView01Activity.this.getResources().getColor(R.color.white));//����������ɫ
				tv1.setPadding(5,5,5,5);//������������
			    tv1.setGravity(Gravity.LEFT);
				ll.addView(tv1);//��ӵ�LinearLayout��				

				TextView tv2=new TextView(ListView01Activity.this);
				tv2.setText(getResources().getText(AgeId[arg0]));//��������
				tv2.setTextSize(24);//���������С
				tv2.setTextColor(ListView01Activity.this.getResources().getColor(R.color.white));//����������ɫ
				tv2.setPadding(5,5,5,5);//������������
			    tv2.setGravity(Gravity.LEFT);
				ll.addView(tv2);//��ӵ�LinearLayout��				

				
				return ll;
			}        	
        };
        lv.setAdapter(ba);//ΪListView��������������

         
        lv.setOnItemClickListener(
           new OnItemClickListener()
           {
			//@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {//��дѡ������¼��Ĵ�����
				Integer iarg2=new Integer(arg2);
				Long  iarg3=new Long(arg3);
				Toast.makeText(ListView01Activity.this,"arg2:"+iarg2.toString()+"  arg3:"+iarg3.toString(),Toast.LENGTH_LONG).show();
				TextView tv=(TextView)findViewById(R.id.TextView01);//��ȡ������TextView
				LinearLayout ll=(LinearLayout)arg1;//��ȡ��ǰѡ��ѡ���Ӧ��LinearLayout
				TextView tvn=(TextView)ll.getChildAt(0);//��ȡ���е�TextView 
				TextView tvn1=(TextView)ll.getChildAt(1);//��ȡ���е�TextView 
				TextView tvn2=(TextView)ll.getChildAt(2);//��ȡ���е�TextView 
				StringBuilder sb=new StringBuilder();//��StringBuilder��̬������Ϣ
				sb.append(getResources().getText(R.string.ys));//���"��ѡ�����ַ���"
				sb.append(":");//���":"
				sb.append(tvn.getText());//���TextView��ֵ
				sb.append(" ");//���":"
				sb.append(tvn1.getText());//���TextView��ֵ
				sb.append(" ");//���":"
				sb.append(tvn2.getText());//���TextView��ֵ
				String stemp=sb.toString();//��StringBuilderת����String����					
				tv.setText(stemp.split("\\n")[0]);//��Ϣ���ý�������TextView
				//tv.getText()
				
				Intent intent=new Intent(ListView01Activity.this,PlayAudioInapkActivity.class);
				 Bundle bundle = new Bundle();
				 bundle.putInt("id", A[arg2]);
				 intent.putExtras(bundle);
				   startActivityForResult(intent,1);	
	        	Toast.makeText(ListView01Activity.this,"OnClick",Toast.LENGTH_SHORT).show();
				
			
			}        	   
           }
        );        
        
     }
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) 
	{
		 
		super.onActivityResult(requestCode, resultCode, data);
	}  
	
}
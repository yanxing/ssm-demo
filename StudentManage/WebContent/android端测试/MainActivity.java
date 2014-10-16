package com.sisv.json2;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

/**
 * android-async-http这里用的1.4.5版本，用JsonHttpResponseHandler获取返回的json数据，
 * 但是1.4.4有个bug，http://www.2cto.com/kf/201403/287457.html，所以用1.4.5
 * 
 * @author Administrator
 */
public class MainActivity extends Activity {

	public static final String HTTPCustomer = "http://10.255.92.152:8080/StudentManage/android/loginAction";
	private Button loginButton;
	private EditText tv_username;
	private EditText tv_password;
	private ListView lv_users;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv_users = (ListView) findViewById(R.id.lv_users);
		loginButton = (Button) findViewById(R.id.loginButton);

		loginButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				tv_username = (EditText) findViewById(R.id.tv_username);
				String username = tv_username.getText().toString().trim();
				tv_password = (EditText) findViewById(R.id.tv_password);
				String password = tv_password.getText().toString().trim();

				if (!username.equals("") && !password.equals("")) {
					initData(username, password);
				}
			}
		});
	}

	private void initData(String name, String password) {
		// 访问服务器端 获取json数据
		// 创建客户端对象
		AsyncHttpClient client = new AsyncHttpClient();
		Toast.makeText(this, "发送请求到服务器", Toast.LENGTH_LONG).show();
		RequestParams params = new RequestParams();
		params.put("student.username", name);
		params.put("student.password", password);
		client.post(HTTPCustomer, params, new JsonHttpResponseHandler() {
			/**
			 * 第三个参数类型是json对象，服务器返回的是json对象，如果第三个参数类型是json数组，
			 * 则获取不到值，猜测是android-async-http做了判断,服务端返回的json数据：
			 * {"loginResult":"successLogin"
			 * ,"student":{"birthday":null,"classGrade":
			 * {"name":"计科1班","pro":{"dep"
			 * :{"name":"计算机与信息工程学院"},"name":"计算机科学与技术"}},
			 * "number":" 33","phone":"18255032152","sex":"男","username":"1"}}
			 */
			@Override
			public void onSuccess(int statusCode, Header[] headers,
					JSONObject response) {
				super.onSuccess(statusCode, headers, response);
				Toast.makeText(getApplicationContext(),
						"请求成功" + new String(response.toString()),
						Toast.LENGTH_LONG).show();
				List<String> objects = new ArrayList<String>();
				try {
					objects.add(response.getString("loginResult"));
					Log.i("TAG", response.getString("student"));
					// 把student字符串转化为json对象，这里得到的student已经是json格式的了
					JSONObject a = new JSONObject(response.getString("student"));
					objects.add(a.getString("username"));
					objects.add(a.getString("sex"));
				} catch (JSONException e) {
					e.printStackTrace();
				}
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(
						MainActivity.this, android.R.layout.simple_list_item_1,
						objects);
				// 设置显示的内容
				lv_users.setAdapter(adapter);
			}
		});
	}
}

package jp.ac.gifu_u.edu.z3033903.western_calendar_conversion_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.CollationElementIterator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button ok=(Button) findViewById(R.id.button);
        ok.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        showToast("計算しました");
        TextView textView=(TextView) findViewById(R.id.result);
        //入力された西暦取得
        EditText et_w_year=(EditText) findViewById(R.id.TextNumber_year);
        SpannableStringBuilder sb_w_year=(SpannableStringBuilder) et_w_year.getText();
        String str_w_year=sb_w_year.toString();

        //文字列のint変換
        int int_w_year= Integer.parseInt(str_w_year);

        //西暦和暦変換
        if(int_w_year>=2019){
            int int_j_year = int_w_year - 2018;
            textView.setText("令和"+int_j_year+"年");
        }else if(int_w_year>=1989){
            int int_j_year = int_w_year - 1988;
            textView.setText("平成"+int_j_year+"年");
        }else if(int_w_year>=1926){
            int int_j_year = int_w_year - 1925;
            textView.setText("昭和"+int_j_year+"年");
        }else if(int_w_year>=1912){
            int int_j_year = int_w_year - 1911;
            textView.setText("大正"+int_j_year+"年");
        }else if(int_w_year>=1868){
            int int_j_year = int_w_year - 1867;
            textView.setText("明治"+int_j_year+"年");
        }else{
            textView.setText("計算対象外です");
        }
    }

    public void showToast(String str){
        Toast t =Toast.makeText(this,str,Toast.LENGTH_SHORT);
        t.show();
    }
}
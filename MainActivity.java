package com.example.ykai.dialogstudy;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Context self;
    private String TAG="_tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        self = this;
        setClick();
    }

    private void setClick() {
        //默认样式 1
        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(self)
                        .setTitle("标题")
                        .setMessage("简单消息框")
                        .setPositiveButton("确定", null)
                        .show();
            }
        });

        //默认带取消 2
        findViewById(R.id.btn_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(self)
                        .setTitle("确认")
                        .setMessage("确定吗？")
                        .setPositiveButton("是", null)
                        .setNegativeButton("否", null)
                        .show();
            }
        });

        //默认可输入文字 3
        findViewById(R.id.btn_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(self)
                        .setTitle("请输入")
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .setView(new EditText(self))
                        .setPositiveButton("确定", null)
                        .setNegativeButton("取消", null)
                        .show();
            }
        });

        //单选框 4
        findViewById(R.id.btn_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(self)
                        .setTitle("请选择")
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .setSingleChoiceItems(new String[]{"选项1", "选项2", "选项3", "选项4"}, 0,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                }
                        )
                        .setNegativeButton("取消", null)
                        .show();
            }
        });

        //多选框 5
        findViewById(R.id.btn_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new  AlertDialog.Builder(self)
                        .setTitle("多选框" )
                        .setMultiChoiceItems(new  String[] {"选项1", "选项2", "选项3" , "选项4" },  null ,  null )
                        .setPositiveButton("确定" , null)
                        .setNegativeButton("取消" ,  null )
                        .show();
            }
        });

        //列表对话框 6
        findViewById(R.id.btn_6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(self)
                        .setTitle("列表框")
                        .setItems(new String[]{"列表项1", "列表项2", "列表项3"}, null)
                        .setNegativeButton("确定", null)
                        .show();
            }
        });

        //对话框显示图片 7
        findViewById(R.id.btn_7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView img = new ImageView(self);
                img.setImageResource(R.mipmap.ic_launcher);
                new AlertDialog.Builder(self)
                        .setTitle("图片框")
                        .setView(img)
                        .setPositiveButton("确定", null)
                        .show();
            }
        });

        //对话框显示图片 7
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater l= LayoutInflater.from(self);
                View customView=l.inflate(R.layout.test_1,null);
                ImageView img = new ImageView(self);
                img.setImageResource(R.mipmap.ic_launcher);
                AlertDialog.Builder builder = new AlertDialog.Builder(self);
                builder.setView(customView);
                final AlertDialog alert = builder.create();
                alert.show();
//                a.Builder(self)
//                        .setView(customView);
//                        .setTitle("Title")
//                        .setMessage("Message")
//                        .setView(img)
//                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                Log.e(TAG, "onClick: "+i);
//
//                            }
//                        })
// ;


                customView.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.e(TAG, "onClick: cus" );
                        alert.cancel();
                    }
                });
            }
        });

    }
}

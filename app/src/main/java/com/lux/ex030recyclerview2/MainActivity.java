package com.lux.ex030recyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //대량의 데이터
    ArrayList<Item> items= new ArrayList<>();

    RecyclerView recyclerView;
    MyAdapter adapter;
    Button btn_linear, btn_grid,btn_add,btn_delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //대량의 데이터 추가 - 실무에서는 서버나 db에서 읽어옴
        //테스트 목적으로 직접 추가
        items.add(new Item("쵸파","의사",R.drawable.one_chopa,R.drawable.bg_one01));
        items.add(new Item("루피","선장",R.drawable.one_luffy,R.drawable.bg_one02));
        items.add(new Item("조로","부선장",R.drawable.one_zoro,R.drawable.bg_one03));
        items.add(new Item("나미","항해사",R.drawable.one_nami5,R.drawable.bg_one04));
        items.add(new Item("상디","요리사",R.drawable.one_sandi,R.drawable.bg_one05));
        items.add(new Item("우솝","저격수",R.drawable.one_usoup,R.drawable.bg_one06));
        items.add(new Item("로빈","고고학자",R.drawable.one_nicorobin,R.drawable.bg_one07));

        recyclerView=findViewById(R.id.recycler);
        adapter = new MyAdapter(this,items);
        recyclerView.setAdapter(adapter);

        //선형배치 버튼 클릭
        btn_linear=findViewById(R.id.btn_linear);
        btn_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //recyclerView의 배치관리자를 변경
                LinearLayoutManager layoutManager=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(layoutManager);
            }
        });
        //격자배치 버튼 클릭
        btn_grid=findViewById(R.id.btn_grid);
        btn_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GridLayoutManager gridLayoutManager=new GridLayoutManager(MainActivity.this,2);//옆으로2칸짜리격자
                recyclerView.setLayoutManager(gridLayoutManager);
            }
        });

        //항목추가버튼
        btn_add=findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //리사이클러 뷰에 아이템을 직접 추가하는 것이 아님!!!!
                Item item = new Item("new","해적단",R.drawable.bg_one10,R.drawable.bg_one09);
                items.add(0,item); //새로운 Item을 무조건 첫번째 요소로 추가

                //데이터의 변경이 생기면 반드시 어댑터엥게 변경사실을 공지(notify)해야 화면이 갱신됨
                adapter.notifyItemInserted(0);
                //리사이클러뷰의 스크롤을 첫번째 위치로 이동
                recyclerView.scrollToPosition(0);
            }
        });
        //항목삭제버튼
        btn_delete=findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //리사이클러뷰의 아이템 뷰를 삭제하는 것이 아니라, List에서 Item을 제거
                items.remove(0);
                adapter.notifyItemRemoved(0);
            }
        });

        //리사이클러뷰의 아이템뷰를 클릭할때 반응하는 리스너는 없음
        //아이템뷰에 직접 클릭리스너를 설정
        //MyAdapter.java에서 아이템 뷰가 만들어 지기에 그 곳에서 코딩itad
    }
}
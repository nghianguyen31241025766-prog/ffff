package com.example.ffff;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    // Button btnLoad;
    List<Article> articleList =
            new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {

                    Insets systemBars =
                            insets.getInsets(
                                    WindowInsetsCompat.Type.systemBars()
                            );

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );

        Intent intent = getIntent();

        if (intent != null && intent.hasExtra("articleList")) {
            articleList = (ArrayList<Article>) intent.getSerializableExtra("articleList");
        } else {

            articleList.add(new Article(
                    "Việt Nam - Đất nước hình chữ S",
                    "Việt Nam là một quốc gia nằm ở khu vực Đông Nam Á, có đường bờ biển dài và nền văn hóa đa dạng. Thủ đô của Việt Nam là Hà Nội. Thành phố Hồ Chí Minh là một trong những trung tâm kinh tế lớn của cả nước. Việt Nam nổi tiếng với nhiều danh lam thắng cảnh, ẩm thực phong phú và lịch sử lâu đời.",
                    R.drawable.vietnam,
                    0
            ));

            articleList.add(new Article(
                    "Nhật Bản - Đất nước mặt trời mọc",
                    "Nhật Bản là một quốc đảo nằm ở khu vực Đông Á. Thủ đô là Tokyo, một trong những đô thị lớn và hiện đại trên thế giới. Nhật Bản nổi tiếng với nền văn hóa truyền thống, công nghệ phát triển, hoa anh đào và núi Phú Sĩ.",
                    R.drawable.japan,
                    0
            ));

            articleList.add(new Article(
                    "Trung Quốc - Quốc gia rộng lớn ở Đông Á",
                    "Trung Quốc là một quốc gia nằm ở khu vực Đông Á và có diện tích rất lớn. Thủ đô của Trung Quốc là Bắc Kinh. Quốc gia này có lịch sử lâu đời, nền văn hóa phong phú và nhiều địa danh nổi tiếng như Vạn Lý Trường Thành, Tử Cấm Thành và sông Dương Tử.",
                    R.drawable.china,
                    0
            ));

            articleList.add(new Article(
                    "Pháp - Quốc gia nổi tiếng tại châu Âu",
                    "Pháp nằm ở khu vực Tây Âu và có thủ đô là Paris. Đây là một quốc gia có lịch sử lâu đời, nổi tiếng về nghệ thuật, thời trang, kiến trúc và ẩm thực. Tháp Eiffel là một trong những biểu tượng nổi tiếng nhất của nước Pháp.",
                    R.drawable.france,
                    0
            ));

            articleList.add(new Article(
                    "Hoa Kỳ - Quốc gia rộng lớn ở Bắc Mỹ",
                    "Hoa Kỳ nằm ở Bắc Mỹ và có diện tích lớn. Thủ đô là Washington, D.C. Quốc gia này có nhiều thành phố nổi tiếng như New York, Los Angeles và San Francisco. Hoa Kỳ có nền kinh tế lớn và có sự đa dạng về văn hóa, địa lý và thiên nhiên.",
                    R.drawable.usa,
                    0
            ));
        }

        recyclerView = findViewById(R.id.recyclerView);
        // btnLoad = findViewById(R.id.btnLoad);

        recyclerView.addItemDecoration(
                new DividerItemDecoration(
                        this,
                        DividerItemDecoration.VERTICAL
                )
        );
            // btnLoad.setOnClickListener(view -> {
            //     MyAdapter myAdapter = new MyAdapter(view.getContext(), articleList);
            //     recyclerView.setLayoutManager(
            //             new LinearLayoutManager(this)
            //     );
            //     recyclerView.setAdapter(myAdapter);
            // });

        MyAdapter myAdapter =
                new MyAdapter(
                        this,
                        articleList
                );

        recyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );

        recyclerView.setAdapter(myAdapter);
    }
}
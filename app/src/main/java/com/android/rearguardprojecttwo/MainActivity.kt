package com.android.rearguardprojecttwo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.rearguardprojecttwo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 더미데이터 구역
        val dataList = mutableListOf<Items>()
        dataList.add(Items("제목1", "시험용 내용1번", "테스트신문사1", "시험날짜1", "테스트기자1"))
        dataList.add(Items("제목2", "시험용 내용2번", "테스트신문사2", "시험날짜2", "테스트기자2"))
        dataList.add(Items("제목3", "시험용 내용3번", "테스트신문사3", "시험날짜3", "테스트기자3"))
        dataList.add(Items("제목4", "시험용 내용4번", "테스트신문사4", "시험날짜4", "테스트기자4"))
        dataList.add(Items("제목5", "시험용 내용5번", "테스트신문사5", "시험날짜5", "테스트기자5"))
        dataList.add(Items("제목6", "시험용 내용6번", "테스트신문사6", "시험날짜6", "테스트기자6"))
        dataList.add(Items("제목7", "시험용 내용7번", "테스트신문사7", "시험날짜7", "테스트기자7"))
        dataList.add(Items("제목8", "시험용 내용8번", "테스트신문사8", "시험날짜8", "테스트기자8"))
        dataList.add(Items("제목9", "시험용 내용9번", "테스트신문사9", "시험날짜9", "테스트기자9"))

        // 어댑터 생성 및 연결
        binding.listView.adapter = Adapter(this, dataList)

        //프래그먼트 사용시 아래 코드 필요
        //binding.apply{
        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val Title = (binding.listView.adapter.getItem(position) as Items).aTitle
            val Desc = (binding.listView.adapter.getItem(position) as Items).aDesc
            val Comamy = (binding.listView.adapter.getItem(position) as Items).aCompany
            val Date = (binding.listView.adapter.getItem(position) as Items).aDate
            val Name = (binding.listView.adapter.getItem(position) as Items).aName

            Toast.makeText(this, "Testarea", Toast.LENGTH_SHORT).show()
            val PassToDetail = Intent(this, DetailFragment::class.java)
            PassToDetail.putExtra("Title", Title)
            PassToDetail.putExtra("Desc", Desc)
            PassToDetail.putExtra("Company", Comamy)
            PassToDetail.putExtra("Date", Date)
            PassToDetail.putExtra("Name", Name)

            startActivity(PassToDetail)
            //프래그먼트 구문
            //setFragment(DetailFragment())
        }
    }
        
    //}

//    private fun setFragment(frag : Fragment) {
//        supportFragmentManager.commit {
//            replace(R.id.frameLayout, frag)
//            setReorderingAllowed(true)
//            addToBackStack("")
//        }
//    }
}
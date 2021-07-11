package team.JZY.DocManager.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;


import team.JZY.DocManager.interfaces.DocInfoProvider;
import team.JZY.DocManager.model.DocInfo;
@Dao
public interface DocInfoDao  {


    //要继承provider
    @Insert
    public List<Long> insert(List<DocInfo> docsInfo);

    @Query("select  * from DocInfo order by random() limit :amount")
    public List<DocInfo>request(long amount);

    @Query("select * from docinfo where classification = :classification order by random() limit :amount")
    public List<DocInfo> request(long amount, int classification);

    @Query("update DocInfo set visits = :docVisits where id = :docId")
    public void update(long docId,long docVisits);

    @Query("select id from docinfo order by id desc limit 1")
    public long getSize();

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    public Single<List<Long>> insert(List<DocInfo>docsInfo);
//
//    @Query("select  * from DocInfo order by random() limit :amount")
//    public Single<List<DocInfo>>request(long amount);
//
//    @Query("select * from docinfo where classification = :classification order by random() limit :amount")
//    public Single<List<DocInfo>> request(long amount, int classification);
//
//    @Query("update DocInfo set visits = :docVisits where id = :docId")
//    public Completable update(long docId,int docVisits);
//
//    @Query("select id from docinfo order by id desc limit 1")
//    public Single<Long> getSize();


//        @Insert//
//        long[] insert(DocInfo...docInfos);//返回id
//
//
//        @Query("update DocInfo set visits = :docVisits where id = :docId")
//        void update(Long docId,int docVisits);
//
//
//        @Query("select  * from DocInfo order by random() limit :amount")
//        List<DocInfo> request(int amount);//
//
//
//    @Query("select * from docinfo where classification = :classification order by random() limit :amount")
//    List<DocInfo> request(int amount, int classification);
//
//    @Query("select id from docinfo order by id desc limit 1")
//    long getSize();
////    @Override
////    ---------------
////    List<DocInfo> request(String searchKeyWord);
//
//        @Delete//
//        void deleteDocInfo(DocInfo...docInfos);
//
//        @Query("delete from docinfo")//
//        void deleteAllDocInfo();
//
//
//        @Query("select  * from DocInfo order by id desc")//
//        List<DocInfo> getAllDocInfo();//获得全部的数据

}

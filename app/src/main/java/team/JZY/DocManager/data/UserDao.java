package team.JZY.DocManager.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import team.JZY.DocManager.model.User;

@Dao
public interface UserDao {
    @Insert
    public void insert(User...users);
    @Query("select *from User where name=:username and password=:password")
    public User request(String username,String password);
    @Delete
    public void delete(User...users);
}
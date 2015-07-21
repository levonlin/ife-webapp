package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;

/**
 *
 *用户表
 *
 * Created by G-bgyl on 2015/7/19.
 */


@Entity
@Table(name="User")
public class User extends Model {
	/**
	 *用户密码
	 */
	@column(name = "password")
    @Required
    public String password;
	/**
	 *昵称
	 */
	@column(name = "nickname")
    @Required
    public String nickname;

    public User(){

    }
    public User(String password,String nickname){
        this.password = password;
        this.nickname = nickname;
    }
    public static User connect(String userId,String password){
        return find("byUseridAndPassword",userId,password).first();
    }
    public static User findById(String userId){
        return find("byUserid",userId).first();
    }
}

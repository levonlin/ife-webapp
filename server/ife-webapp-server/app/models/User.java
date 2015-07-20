package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;

@Entity
@Table(name="User")
public class User extends Model {
    @Required
    public String password;
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

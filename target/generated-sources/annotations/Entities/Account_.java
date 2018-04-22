package Entities;

import Entities.Account;
import Entities.UserRole;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-22T12:48:26")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, Date> lastLogin;
    public static volatile ListAttribute<Account, Account> followers;
    public static volatile SingularAttribute<Account, UserRole> role;
    public static volatile ListAttribute<Account, Account> following;
    public static volatile SingularAttribute<Account, String> location;
    public static volatile SingularAttribute<Account, Integer> id;
    public static volatile SingularAttribute<Account, String> biography;
    public static volatile SingularAttribute<Account, String> passwordHash;
    public static volatile SingularAttribute<Account, String> email;
    public static volatile SingularAttribute<Account, String> username;

}
package Entities;

import Entities.Account;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-18T16:46:47")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile ListAttribute<Account, Account> followers;
    public static volatile ListAttribute<Account, Account> follwing;
    public static volatile SingularAttribute<Account, Date> LastLogin;
    public static volatile SingularAttribute<Account, String> Biography;
    public static volatile SingularAttribute<Account, Integer> id;
    public static volatile SingularAttribute<Account, String> passwordHash;
    public static volatile SingularAttribute<Account, String> email;
    public static volatile SingularAttribute<Account, String> username;
    public static volatile SingularAttribute<Account, String> Location;

}
package Entities;

import Entities.Account;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-18T17:08:13")
@StaticMetamodel(Kweet.class)
public class Kweet_ { 

    public static volatile SingularAttribute<Kweet, Account> owner;
    public static volatile SingularAttribute<Kweet, String> messageContents;
    public static volatile ListAttribute<Kweet, Account> mentions;
    public static volatile SingularAttribute<Kweet, Integer> id;

}
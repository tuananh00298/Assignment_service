package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-23T11:02:22")
@StaticMetamodel(Transaction.class)
public class Transaction_ { 

    public static volatile SingularAttribute<Transaction, Integer> receiveAmount;
    public static volatile SingularAttribute<Transaction, Integer> senderId;
    public static volatile SingularAttribute<Transaction, Integer> receiverId;
    public static volatile SingularAttribute<Transaction, Integer> transactionFee;
    public static volatile SingularAttribute<Transaction, Integer> transactionAmount;
    public static volatile SingularAttribute<Transaction, Integer> id;
    public static volatile SingularAttribute<Transaction, String> transactionName;
    public static volatile SingularAttribute<Transaction, Date> transactionDate;
    public static volatile SingularAttribute<Transaction, Integer> sendAmount;

}
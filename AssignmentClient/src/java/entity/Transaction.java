/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tuan Anh
 */
@Entity
@Table(name = "transaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t")
    , @NamedQuery(name = "Transaction.findById", query = "SELECT t FROM Transaction t WHERE t.id = :id")
    , @NamedQuery(name = "Transaction.findByTransactionName", query = "SELECT t FROM Transaction t WHERE t.transactionName = :transactionName")
    , @NamedQuery(name = "Transaction.findByTransactionAmount", query = "SELECT t FROM Transaction t WHERE t.transactionAmount = :transactionAmount")
    , @NamedQuery(name = "Transaction.findByReceiverId", query = "SELECT t FROM Transaction t WHERE t.receiverId = :receiverId")
    , @NamedQuery(name = "Transaction.findBySenderId", query = "SELECT t FROM Transaction t WHERE t.senderId = :senderId")
    , @NamedQuery(name = "Transaction.findByTransactionFee", query = "SELECT t FROM Transaction t WHERE t.transactionFee = :transactionFee")
    , @NamedQuery(name = "Transaction.findByTransactionDate", query = "SELECT t FROM Transaction t WHERE t.transactionDate = :transactionDate")
    , @NamedQuery(name = "Transaction.findByReceiveAmount", query = "SELECT t FROM Transaction t WHERE t.receiveAmount = :receiveAmount")
    , @NamedQuery(name = "Transaction.findBySendAmount", query = "SELECT t FROM Transaction t WHERE t.sendAmount = :sendAmount")
    , @NamedQuery(name = "Transaction.findByBillId", query = "SELECT t FROM Transaction t WHERE t.billId = :billId")})
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "TRANSACTION_NAME")
    private String transactionName;
    @Column(name = "TRANSACTION_AMOUNT")
    private Integer transactionAmount;
    @Column(name = "RECEIVER_ID")
    private Integer receiverId;
    @Column(name = "SENDER_ID")
    private Integer senderId;
    @Column(name = "TRANSACTION_FEE")
    private Integer transactionFee;
    @Column(name = "TRANSACTION_DATE")
    @Temporal(TemporalType.DATE)
    private Date transactionDate;
    @Column(name = "RECEIVE_AMOUNT")
    private Integer receiveAmount;
    @Column(name = "SEND_AMOUNT")
    private Integer sendAmount;
    @Size(max = 50)
    @Column(name = "BILL_ID")
    private String billId;

    public Transaction() {
    }

    public Transaction(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public Integer getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Integer transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(Integer transactionFee) {
        this.transactionFee = transactionFee;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Integer getReceiveAmount() {
        return receiveAmount;
    }

    public void setReceiveAmount(Integer receiveAmount) {
        this.receiveAmount = receiveAmount;
    }

    public Integer getSendAmount() {
        return sendAmount;
    }

    public void setSendAmount(Integer sendAmount) {
        this.sendAmount = sendAmount;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Transaction[ id=" + id + " ]";
    }
    
}

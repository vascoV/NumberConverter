package convertions;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "CONVERTIONSERVICES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Convertionservices.findAll", query = "SELECT c FROM Convertionservices c")
    , @NamedQuery(name = "Convertionservices.findById", query = "SELECT c FROM Convertionservices c WHERE c.id = :id")
    , @NamedQuery(name = "Convertionservices.findByCustomerid", query = "SELECT c FROM Convertionservices c WHERE c.customerid = :customerid")
    , @NamedQuery(name = "Convertionservices.findByConvertionservice", query = "SELECT c FROM Convertionservices c WHERE c.convertionservice = :convertionservice")
    , @NamedQuery(name = "Convertionservices.findBySubmittednum", query = "SELECT c FROM Convertionservices c WHERE c.submittednum = :submittednum")
    , @NamedQuery(name = "Convertionservices.findByResult", query = "SELECT c FROM Convertionservices c WHERE c.result = :result")
    , @NamedQuery(name = "Convertionservices.findByDate", query = "SELECT c FROM Convertionservices c WHERE c.date = :date")
    , @NamedQuery(name = "Convertionservices.findByTime", query = "SELECT c FROM Convertionservices c WHERE c.time = :time")})
public class Convertionservices implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUSTOMERID")
    private int customerid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CONVERTIONSERVICE")
    private String convertionservice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUBMITTEDNUM")
    private int submittednum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "RESULT")
    private String result;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIME")
    @Temporal(TemporalType.TIME)
    private Date time;

    public Convertionservices() {
    }

    public Convertionservices(Long id) {
        this.id = id;
    }

    public Convertionservices(Long id, int customerid, String convertionservice, int submittednum, String result, Date date, Date time) {
        this.id = id;
        this.customerid = customerid;
        this.convertionservice = convertionservice;
        this.submittednum = submittednum;
        this.result = result;
        this.date = date;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getConvertionservice() {
        return convertionservice;
    }

    public void setConvertionservice(String convertionservice) {
        this.convertionservice = convertionservice;
    }

    public int getSubmittednum() {
        return submittednum;
    }

    public void setSubmittednum(int submittednum) {
        this.submittednum = submittednum;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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
        if (!(object instanceof Convertionservices)) {
            return false;
        }
        Convertionservices other = (Convertionservices) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "convertions.Convertionservices[ id=" + id + " ]";
    }
    
}

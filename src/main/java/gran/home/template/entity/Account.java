package gran.home.template.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "accounts")
@NamedQueries({ @NamedQuery(name = Account.QUERY_FIND_LOGIN, query = "FROM Account a WHERE a.login = ?"),
		@NamedQuery(name = Account.QUERY_UPDATE_PASSWD, query = "UPDATE Account a SET a.hashPasswd = :passwd WHERE a.id = :id ") })
public class Account implements BaseEntity {
	private static final long serialVersionUID = -6513045923584873984L;

	public static final String QUERY_FIND_LOGIN = "Account.QUERY_FIND_LOGIN";
	public static final String QUERY_UPDATE_PASSWD = "Account.QUERY_UPDATE_PASSDW";

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false, updatable = false)
	private Date created;

	@Column(name = "login", unique = true, nullable = false, length = 64)
	private String login;

	@Column(name = "passwd", length = 64)
	private String hashPasswd;
	@Transient
	private String oldPasswd = "";
	@Transient
	private String newPasswd = "";

	@Column(name = "name", length = 64)
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false, length = 10)
	private Type type;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}
	
//	private void setCreated(Date created) {
//		this.created = created;
//	}

	@PrePersist
	protected void onCreate() {
		created = new Date();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getHashPasswd() {
		return hashPasswd;
	}

	public void setHashPasswd(String hashPasswd) {
		this.hashPasswd = hashPasswd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getOldPasswd() {
		return oldPasswd;
	}

	public void setOldPasswd(String oldPasswd) {
		this.oldPasswd = oldPasswd;
	}

	public String getNewPasswd() {
		return newPasswd;
	}

	public void setNewPasswd(String newPasswd) {
		this.newPasswd = newPasswd;
	}
	
	@Override
	public String toString() {
		return "login:" + login + " oldPasswd:" + oldPasswd;
	}
	
	public void setConfirmPasswd(String passwd) {
	}

	public static enum Type {
		USER("USER"), ADMIN("ADMIN");

		private final String value;

		private Type(final String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value;
		}
	}

}

package vlado.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class Ticket {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String number;
	@Column
	private LocalDateTime date_time;
	@Column
	@NotBlank(message = "Morate da unesete naslov tiketa.")
	private String title;
	@Column
	@NotBlank(message = "Morate da unesete prijavu tiketa.")
	private String note;
	@Column
	private LocalDateTime close_date_time;

	@ManyToOne
	@JoinColumn(name = "user_id")
	
	private User user;
	@ManyToOne
	@JoinColumn(name = "client_id")
	
	private Client client;
	
	@OneToMany(mappedBy = "ticket", fetch = FetchType.EAGER)
	private List<Note> notes;
	
	@Transient
	private int noteCount;

	public Ticket() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public LocalDateTime getDate_time() {
		return date_time;
	}

	public void setDate_time(LocalDateTime date_time) {
		this.date_time = date_time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public LocalDateTime getClose_date_time() {
		return close_date_time;
	}

	public void setClose_date_time(LocalDateTime close_date_time) {
		this.close_date_time = close_date_time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}	

	public int getNoteCount() {
		return notes.size();
	}

	public String makeNumber() {

		LocalDateTime date = LocalDateTime.now();
		return "" + date.getYear() + date.getMonthValue() + date.getDayOfMonth() + date.getHour() + date.getMinute()
				+ date.getSecond();
	}
}

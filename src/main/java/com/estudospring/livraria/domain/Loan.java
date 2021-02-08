package com.estudospring.livraria.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.estudospring.livraria.domain.enums.LoanStatus;

@Entity
public class Loan implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate loanDay;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate loanReturnDay;
	private LoanStatus loanStatus;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	
	
	public Loan() {
	}
	
	public Loan(Integer id, LocalDate loanDay, LoanStatus loanStatus, Book book, Client client) {
		super();
		this.id = id;
		this.loanDay = loanDay;
		this.loanStatus = loanStatus;
		this.book = book;
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getLoanDay() {
		return loanDay;
	}

	public void setLoanDay(LocalDate loanDay) {
		this.loanDay = loanDay;
	}
/*
	public LocalDate getLoanReturnDay() {
		return loanReturnDay;
	}

	public void setLoanReturnDay(LocalDate loanReturnDay) {
		this.loanReturnDay = this.loanDay.plusDays(14);
	}
*/
	
	
	
	public Book getBook() {
		return book;
	}

	public LoanStatus getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(LoanStatus loanStatus) {
		this.loanStatus = loanStatus;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Empréstimo = ");
		builder.append(" Feito no dia: ");
		builder.append(loanDay);
		builder.append(", Status de empréstimo: ");
		builder.append(getLoanStatus());
		builder.append("| Livro = ");
		builder.append(book.getName());
		builder.append(" , Edição: ");
		builder.append(book.getEdition());
		builder.append(", Autor: ");
		builder.append(book.getAuthor());
		builder.append("| Cliente = ");
		builder.append(client.getNameClient());
		builder.append(", CPF: ");
		builder.append(client.getCpf());
		builder.append(", Estudante da instituição: ");
		builder.append(client.getInstitution());
		builder.append(", Curso: ");
		builder.append(client.getCourse());
		builder.append(" ");
		return builder.toString();
	}
	
	
	
}
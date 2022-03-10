package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;





	@Entity
	@Getter
	@Setter
	@ToString
	@AllArgsConstructor
	@NoArgsConstructor
	@Table(name = "collaboratoin")
	public class Collaboration implements Serializable{
		
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Column(name="id")
		private Long id; 
		@Column(name="nom")
		private String nom; 
		@Column(name="mail")
		private String mail; 
		@Column(name="date")
		@Temporal(TemporalType.DATE)
	    @JsonFormat(pattern="yyyy-MM-dd")
		private Date date; 
		
		
		@OneToMany(cascade = CascadeType.ALL,mappedBy="collaboration")
		private Set<Offre> offre;
		
		



}

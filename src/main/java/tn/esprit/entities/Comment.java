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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


	@Entity
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Table(name = "comment")
	public class Comment implements Serializable{

		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Column(name="id")
		private Long id; 
		@Column(name="contenu")
		private String contenu; 
		@Column(name="date")
		@Temporal(TemporalType.DATE)
	    @JsonFormat(pattern="yyyy-MM-dd")
		private Date date; 
		@Column(name="userid")
		private Long userid; 
		
		@Transient
		@JsonIgnore
		private int nbLike;
		@Transient
		@JsonIgnore
		private int nbDislike;
		
	
		@ManyToOne
		@JsonIgnore
		private Forum forum;
		
		
		@OneToMany(cascade = CascadeType.ALL,mappedBy="comment")
		private Set<Like> like;
		

		}

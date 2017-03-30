package fr.pizzeria.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Column;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Performance {

	/**
	 * // identifiant technique en base de données
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * le nom du service
	 */
	@Column(name = "service", length = 200)
	@ToString
	private String service;
	/**
	 * la date/heure de la mesure
	 */
	@Column(name = "date")
	private LocalDateTime date;
	/**
	 * le temps d’exécution en ms
	 */
	@Column(name = "temp_execution")
	private Long tempsExecution;

	public Performance(String service, LocalDateTime date, Long tempsExecution) {
		this.service = service;
		this.date = date;
		this.tempsExecution = tempsExecution;
	}

	public Performance() {
		// JPA est content
	}

	@Converter(autoApply = true)
	public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

		@Override
		public Timestamp convertToDatabaseColumn(LocalDateTime locDateTime) {
			return (locDateTime == null ? null : Timestamp.valueOf(locDateTime));
		}

		@Override
		public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
			return (sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime());
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Long getTempsExecution() {
		return tempsExecution;
	}

	public void setTempsExecution(Long tempsExecution) {
		this.tempsExecution = tempsExecution;
	}

	@Override
	public String toString() {
		return "Performance [id=" + id + ", service=" + service + ", date=" + date + ", tempsExecution="
				+ tempsExecution + "]";
	}

}

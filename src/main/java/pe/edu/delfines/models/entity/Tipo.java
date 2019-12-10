package pe.edu.delfines.models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tipos")
public class Tipo {

	@Id
	@Column(name = "tipo_id", length = 4)
	private String id;
	
	@Column(name = "nombre", length = 30)
	private String nombre;
	
	@JsonIgnoreProperties("tipo")
	@OneToMany(mappedBy = "tipo")
	private List<Habitacion> habitaciones;
	
	public Tipo() {
		this.habitaciones = new ArrayList<>();
	}
	
	public void addHabitacion( Habitacion habitacion ) {
		habitacion.setTipo( this );
		this.habitaciones.add( habitacion );
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

}